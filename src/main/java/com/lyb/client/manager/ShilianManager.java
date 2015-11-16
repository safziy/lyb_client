package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.message.protocol.Message_19_1;
import com.lyb.client.message.protocol.Message_19_2;
import com.lyb.client.model.InnerWork;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.utils.ValidateUtils;

public class ShilianManager {
	private PlayerManager playerManager;

	private Map<Integer, Integer> cdTimeMap = new HashMap<Integer, Integer>();

	public ShilianManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		openView();
	}

	public void openView() {
		PlayerWork work = new PlayerWork();
		work.getMessages().add(new Message_19_1());
		work.setDesc("打开势力界面");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void checkFight() {
		int count1 = playerManager.getCountControlManager().getRemainCount(ApplicationConstants.COUNTCONTROL_TYPE_3, 1);
		if (count1 > 0 && cdTimeMap.get(1) <= 0) {
			fight(1);
			return;
		}
		int count2 = playerManager.getCountControlManager().getRemainCount(ApplicationConstants.COUNTCONTROL_TYPE_3, 2);
		if (count2 > 0 && cdTimeMap.get(2) <= 0) {
			fight(2);
			return;
		}
		if (count1 > 0 && count2 > 0) {
			int cdTime = Math.max(cdTimeMap.get(1), cdTimeMap.get(2));
			PlayerWork work = new PlayerWork(new InnerWork() {
				@Override
				public void work() {
					openView();
				}
			});
			work.setState(ApplicationConstants.WORK_STATE_2);
			work.setActivateTime(System.currentTimeMillis() + cdTime * 1000);
			playerManager.getWorkQueue().offerLast(work);
		}
	}

	public void fight(int type) {
		int fightId = 0;
		Map<String, Map<String, String>> map = ConfigContext.getInstance().getFileMap("Shili_Langyashilian.lua");
		for (Map<String, String> row : map.values()) {
			int id = Integer.valueOf(row.get("id"));
			int rowType = Integer.valueOf(row.get("type"));
			int rowLevel = Integer.valueOf(row.get("level"));
			if (ValidateUtils.isEqual(rowType, type) && playerManager.getPlayerData().getLevel() > rowLevel
					&& id > fightId) {
				fightId = id;
			}
		}
		if (fightId <= 0) {
			return;
		}

		Message_19_2 message_19_2 = new Message_19_2();
		message_19_2.setID(fightId);

		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_19_2);
		work.setDesc("请求挑战试练  ID=" + fightId);
		work.setMicroseconds(ApplicationConstants.FIGHT_SLEEP_TIME);
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void battleOver() {
		openView();
	}

	public Map<Integer, Integer> getCdTimeMap() {
		return cdTimeMap;
	}

}
