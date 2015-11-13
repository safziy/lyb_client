package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.message.protocol.Message_7_1;
import com.lyb.client.model.InnerWork;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.model.YXZData;

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
		initCheck();
	}

	public void initCheck() {
		PlayerWork work = new PlayerWork(new InnerWork() {
			@Override
			public void work() {
				checkCountAndFight();
			}
		});
		work.setDesc("开始检查是否有可打的YXZ");
		work.setActivateTime(System.currentTimeMillis());
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void checkCountAndFight() {
		for (YXZData yxzData : yxzDataMap.values()) {
			Map<String, String> map = ConfigContext.getInstance().getFileRow("Juqing_Guanka.lua",
					String.valueOf(yxzData.getStrongPointId()));
			if (yxzData.getCount() < Integer.valueOf(map.get("cishu"))
					&& playerManager.getPlayerData().getPhysicalPower() >= Integer.valueOf(map.get("depletion"))) {
				Message_7_1 message_7_1 = new Message_7_1();
				message_7_1.setStrongPointId(yxzData.getStrongPointId());

				PlayerWork work = new PlayerWork();
				work.getMessages().add(message_7_1);
				work.setDesc("开始挑战YXZ  strongPointId=" + yxzData.getStrongPointId());
				work.setMicroseconds(ApplicationConstants.FIGHT_SLEEP_TIME);
				playerManager.getWorkQueue().offerFirst(work);

				playerManager.getTeamManager().viewTeam(ApplicationConstants.TEAM_TYPE_7);
				break;
			}
		}
	}

	public void battleOver() {
		checkCountAndFight();
	}

}
