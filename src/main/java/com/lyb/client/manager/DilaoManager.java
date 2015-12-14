package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.lyb.client.config.ConfigContainer;
import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.message.protocol.Message_30_1;
import com.lyb.client.message.protocol.Message_30_2;
import com.lyb.client.message.protocol.Message_30_4;
import com.lyb.client.message.protocol.Message_30_5;
import com.lyb.client.message.protocol.segment.UserDungeonArray;
import com.lyb.client.message.protocol.segment.UserDungeonArray.UserDungeonArrayItem;
import com.lyb.client.model.InnerWork;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.utils.ValidateUtils;
import com.safziy.commom.service.log.LogUtil;

public class DilaoManager {
	private PlayerManager playerManager;

	@SuppressWarnings("unused")
	private int floor;
	private int isFinish;
	@SuppressWarnings("unused")
	private int isFirst;
	@SuppressWarnings("unused")
	private int score;
	@SuppressWarnings("unused")
	private int remainSeconds;
	private Map<Long, Integer> map = new HashMap<Long, Integer>();

	private int refreshCount = 0;

	public DilaoManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		if (ConfigContainer.getInstance().getConfig().isAutoDilao()) {
			openView();
		}
	}

	public void openView() {
		PlayerWork work = new PlayerWork();
		work.getMessages().add(new Message_30_1());
		work.setDesc("打开地牢界面");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void openViewResult(int floor, int isFinish, int isFirst, int score, int remainSeconds,
			UserDungeonArray userDungeonArray) {
		this.floor = floor;
		this.isFinish = isFinish;
		this.isFirst = isFirst;
		this.score = score;
		this.remainSeconds = remainSeconds;
		map.clear();
		for (UserDungeonArrayItem item : userDungeonArray.list()) {
			map.put(item.getID(), item.getParam());
			LogUtil.info("地牢随机到的boss id=" + item.getID() + "  param=" + item.getParam());
		}
		innerCheck();
	}

	public void innerCheck() {
		PlayerWork work = new PlayerWork(new InnerWork() {
			@Override
			public void work() {
				check();
			}
		});
		work.setDesc("检查地牢是否可以挑战");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void check() {
		if (ValidateUtils.isEqual(isFinish, 1)) {
			if (ConfigContainer.getInstance().getConfig().isDilaoReset()) {
				int remainCount = playerManager.getCountControlManager().getRemainCount(
						ApplicationConstants.COUNTCONTROL_TYPE_15, 0);
				if (remainCount > 0) {
					reset();
					return;
				}
				int buyCount = playerManager.getCountControlManager().getBuyCount(
						ApplicationConstants.COUNTCONTROL_TYPE_15, 0);
				int needGold = playerManager.getCountControlManager().getNeedGold(
						ApplicationConstants.COUNTCONTROL_TYPE_15, 0);
				if (buyCount > 0 && playerManager.getPlayerData().getGold() >= needGold) {
					reset();
					return;
				}
			}
			LogUtil.info("地牢今天的次数用完了");
			return;
		}
		long hID = 0;
		long lID = 0;
		int hQuality = 0;
		for (Entry<Long, Integer> entry : map.entrySet()) {
			int param = entry.getValue();
			int quality = Integer.valueOf(ConfigContext.getInstance().getFileValue("Dilao_Dilaopinzhi.lua",
					String.valueOf(param), "quality"));
			if (ValidateUtils.isEqual(quality, 9)) {
				fight(entry.getKey());
				return;
			}
			if (quality > hQuality) {
				hID = entry.getKey();
				hQuality = quality;
			}
		}
		for (Entry<Long, Integer> entry : map.entrySet()) {
			if (ValidateUtils.isNotEqual(entry.getKey(), hID)) {
				lID = entry.getKey();
			}
		}
		if (playerManager.getPlayerData().getGold() >= 30
				&& refreshCount < ConfigContainer.getInstance().getConfig().getDilaoRefreshCount()) {
			refresh(lID);
		} else {

		}
		if (playerManager.getPlayerData().getGold() >= 30 && refreshCount <= 6) {
			refresh(lID);
		} else {
			if (ConfigContainer.getInstance().getConfig().isDilaoDiff()) {
				fight(hID);
			} else {
				fight(lID);
			}
		}
	}

	private void reset() {
		PlayerWork work = new PlayerWork();
		work.getMessages().add(new Message_30_5());
		work.setDesc("开始重置地牢");
		playerManager.getWorkQueue().offerFirst(work);
	}

	// 刷新品质
	private void refresh(long lID) {
		refreshCount++;

		Message_30_4 message_30_4 = new Message_30_4();
		message_30_4.setID(lID);

		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_30_4);
		work.setDesc("刷新地牢品质 id=" + lID);
		playerManager.getWorkQueue().offerFirst(work);
	}

	// 战斗
	private void fight(long id) {
		refreshCount = 0;

		Message_30_2 message_30_2 = new Message_30_2();
		message_30_2.setID(id);

		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_30_2);
		work.setDesc("开始挑战地牢");
		work.setMicroseconds(ApplicationConstants.FIGHT_SLEEP_TIME);
		playerManager.getWorkQueue().offerFirst(work);

		playerManager.getTeamManager().viewTeam(ApplicationConstants.TEAM_TYPE_14);
	}

	public void battleOver() {
		openView();
	}

}
