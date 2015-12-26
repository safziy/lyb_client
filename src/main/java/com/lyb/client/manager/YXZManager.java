package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.config.ConfigContainer;
import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.protocol.Message_7_1;
import com.lyb.client.message.protocol.Message_7_58;
import com.lyb.client.model.InnerWork;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.model.YXZData;
import com.safziy.commom.utils.TimeUtils;

public class YXZManager {
	private PlayerManager playerManager;

	private Map<Long, YXZData> yxzDataMap = new HashMap<Long, YXZData>();

	public YXZManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public Map<Long, YXZData> getYxzDataMap() {
		return yxzDataMap;
	}

	public void initWork() {
		// 开启了自动XYZ 才会检查英雄志
		if (ConfigContainer.getInstance().getConfig().isAutoXYZ()) {
			initCheck();
		}
	}

	public void initCheck() {
		PlayerWork work = new PlayerWork(new InnerWork() {
			@Override
			public void work() {
				checkCountAndFight();
			}
		});
		work.setDesc("开始检查是否有可打的YXZ");
		work.setState(ApplicationConstants.WORK_STATE_2);
		work.setActivateTime(System.currentTimeMillis());
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void checkCountAndFight() {
		for (YXZData yxzData : yxzDataMap.values()) {
			Map<String, String> map = ConfigContext.getInstance().getFileRow("Juqing_Guanka.lua",
					String.valueOf(yxzData.getStrongPointId()));
			// 次数不够了 检查下一个
			if (yxzData.getCount() >= Integer.valueOf(map.get("cishu"))) {
				continue;
			}

			int needPhysicalPower = Integer.valueOf(map.get("depletion"));
			// 体力满足要求 直接战斗
			if (playerManager.getPlayerData().getPhysicalPower() >= needPhysicalPower) {
				fight(yxzData.getId());
				return;
			}

			// 可以购买体力的话 就购买体力并重新检查是否有可以打的英雄志
			if (playerManager.checkCanBuyTili()) {
				initCheck();
				playerManager.buyTili();
				return;
			}

			// 等待体力恢复 再重新检查英雄志
			PlayerWork work = new PlayerWork(new InnerWork() {
				@Override
				public void work() {
					initCheck();
				}
			});
			work.setDesc("等待体力恢复再来重新检查英雄志");
			work.setActivateTime(System.currentTimeMillis()
					+ (needPhysicalPower - playerManager.getPlayerData().getPhysicalPower()) * 6
					* TimeUtils.ONE_MINUTE_MICROSECONDS);
			playerManager.getWorkQueue().offerLast(work);
			return;
		}
		LogUtil.info("今天的英雄志都已经打完了");
	}

	private void fight(long id) {
		final YXZData yxzData = yxzDataMap.get(id);
		int count = playerManager.getItemManager().getItemCountByItemId(ApplicationConstants.ITEM_ID_1015003);
		if (ConfigContainer.getInstance().getConfig().isXyzQuickBattle() && count > 0 && yxzData.getStarLevel() >= 3) {
			Message_7_58 message_7_58 = new Message_7_58();
			message_7_58.setCount(1);
			message_7_58.setStrongPointId(yxzData.getStrongPointId());
			PlayerWork work = new PlayerWork(new InnerWork() {
				@Override
				public void work() {
					yxzData.setCount(yxzData.getCount() + 1);
				}
			});
			work.getMessages().add(message_7_58);
			work.setDesc("开始扫荡YXZ  strongPointId=" + yxzData.getStrongPointId());
			playerManager.getWorkQueue().offerFirst(work);
		} else {
			Message_7_1 message_7_1 = new Message_7_1();
			message_7_1.setStrongPointId(yxzData.getStrongPointId());
			PlayerWork work = new PlayerWork();
			work.getMessages().add(message_7_1);
			work.setDesc("开始挑战YXZ  strongPointId=" + yxzData.getStrongPointId());
			work.setMicroseconds(ConfigContainer.getInstance().getBattleTime());
			playerManager.getWorkQueue().offerFirst(work);
		}
		playerManager.getTeamManager().viewTeam(ApplicationConstants.TEAM_TYPE_7);
	}

	public void battleOver() {
		initCheck();
	}

}
