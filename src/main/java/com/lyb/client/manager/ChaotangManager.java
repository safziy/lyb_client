package com.lyb.client.manager;

import com.lyb.client.config.ConfigContainer;
import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.protocol.Message_19_10;
import com.lyb.client.message.protocol.Message_19_11;
import com.lyb.client.message.protocol.Message_19_12;
import com.lyb.client.message.protocol.Message_19_19;
import com.lyb.client.message.protocol.Message_19_22;
import com.lyb.client.message.protocol.Message_19_9;
import com.lyb.client.message.protocol.segment.ChancellorArray;
import com.lyb.client.message.protocol.segment.ChancellorArray.ChancellorArrayItem;
import com.lyb.client.message.protocol.segment.IDParamArray;
import com.lyb.client.message.protocol.segment.IDParamArray.IDParamArrayItem;
import com.lyb.client.message.protocol.segment.IDStateParamArray;
import com.lyb.client.message.protocol.segment.IDStateParamArray.IDStateParamArrayItem;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.utils.ValidateUtils;

public class ChaotangManager {
	private PlayerManager playerManager;

	public ChaotangManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	private int state;

	public void initWork() {
		if (ConfigContainer.getInstance().getConfig().isAutoChaotang()) {
			openView();
		}
	}

	public void openView() {
		PlayerWork work = new PlayerWork();
		work.getMessages().add(new Message_19_19());
		work.setDesc("打开朝堂界面");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void viewResult(int state, ChancellorArray chancellorArray) {
		this.state = state;
		openTiAn();
		for (ChancellorArrayItem item : chancellorArray.list()) {
			// LogUtil.info("朝堂上" + item.getID() + "号位置站着的是" +
			// item.getUserName() + ",等级" + item.getLevel() + "UserId"
			// + item.getUserId());
			if (ValidateUtils.isEqual(item.getBooleanValue(), 0) && ValidateUtils.isNotEqual(item.getUserId(), 0)
					&& ValidateUtils.isNotEqual(item.getUserId(), playerManager.getPlayerData().getUserId())) {
				// 如果没有膜拜的话 就膜拜
				Message_19_22 message_19_22 = new Message_19_22();
				message_19_22.setID(item.getID());
				PlayerWork mobaiWork = new PlayerWork();
				mobaiWork.getMessages().add(message_19_22);
				mobaiWork.setDesc("开始膜拜玩家");
				mobaiWork.setMicroseconds(1000);
				playerManager.getWorkQueue().offerFirst(mobaiWork);
			}
		}
	}

	public void openTiAn() {
		PlayerWork work = new PlayerWork();
		work.getMessages().add(new Message_19_9());
		work.setDesc("打开朝堂提案界面");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void checkTiAn(int state, IDParamArray idParamArray, IDStateParamArray idStateParamArray) {
		this.state = state;
		switch (this.state) {
		case 1:
			long id = 0;
			for (IDParamArrayItem item1 : idParamArray.list()) {
				long tid = item1.getID();
				if (ValidateUtils.isEqual(id, 0)) {
					id = tid;
				}
				String color = ConfigContext.getInstance().getFileValue("Shili_Chaotangzhengbiantian.lua",
						String.valueOf(id), "coloer");
				String tcolor = ConfigContext.getInstance().getFileValue("Shili_Chaotangzhengbiantian.lua",
						String.valueOf(tid), "coloer");
				if (Integer.valueOf(tcolor) > Integer.valueOf(color)) {
					id = tid;
				}
			}
			Message_19_10 message_19_10 = new Message_19_10();
			message_19_10.setID(id);
			PlayerWork tianWork = new PlayerWork();
			tianWork.getMessages().add(message_19_10);
			tianWork.setDesc("选择朝堂的提案");
			playerManager.getWorkQueue().offerFirst(tianWork);
			break;
		case 2:
			for (IDStateParamArrayItem item2 : idStateParamArray.list()) {
				if (ValidateUtils.isEqual(item2.getState(), 2) || ValidateUtils.isEqual(item2.getState(), 3)) {
					fight(item2.getID());
					return;
				}
			}
			PlayerWork bWork = new PlayerWork();
			bWork.getMessages().add(new Message_19_12());
			bWork.setDesc("朝堂提案开始表决");
			playerManager.getWorkQueue().offerFirst(bWork);
			break;
		case 3:
		case 4:
			int remainCount = playerManager.getCountControlManager().getRemainCount(
					ApplicationConstants.COUNTCONTROL_TYPE_5, 0);
			if (remainCount > 0) {
				openTiAn();
			} else {
				LogUtil.info("朝堂提案的次数今天用完了");
			}
			break;
		default:
			break;
		}
	}

	public void fight(long id) {
		Message_19_11 message_19_11 = new Message_19_11();
		message_19_11.setID(id);
		message_19_11.setType(2);
		PlayerWork tianWork = new PlayerWork();
		tianWork.getMessages().add(message_19_11);
		tianWork.setDesc("朝堂提案开始战斗");
		tianWork.setMicroseconds(ConfigContainer.getInstance().getBattleTime());
		playerManager.getWorkQueue().offerFirst(tianWork);

		playerManager.getTeamManager().viewTeam(ApplicationConstants.TEAM_TYPE_9);
	}

	public void battleOver() {
		// openView();
	}
}
