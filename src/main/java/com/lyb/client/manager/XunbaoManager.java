package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.config.ConfigContainer;
import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.protocol.Message_7_1;
import com.lyb.client.message.protocol.Message_8_11;
import com.lyb.client.message.protocol.Message_8_14;
import com.lyb.client.message.protocol.Message_8_6;
import com.lyb.client.message.protocol.Message_8_7;
import com.lyb.client.message.protocol.Message_8_8;
import com.lyb.client.message.protocol.Message_8_9;
import com.lyb.client.message.protocol.segment.HunkTaskArray;
import com.lyb.client.message.protocol.segment.HunkTaskArray.HunkTaskArrayItem;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.utils.ValidateUtils;

public class XunbaoManager {
	private PlayerManager playerManager;

	private int place;
	private int state;
	@SuppressWarnings("unused")
	private int count;
	private Map<Integer, Grid> gridMap = new HashMap<Integer, Grid>();

	private boolean isFight = false;

	public XunbaoManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		if (ConfigContainer.getInstance().getConfig().isAutoXunbao()) {
			openView();
		}
	}

	public void openView() {
		isFight = false;

		PlayerWork work = new PlayerWork();
		work.setDesc("打开寻宝界面");
		work.getMessages().add(new Message_8_6());

		playerManager.getWorkQueue().offerFirst(work);
	}

	public void state(int place, int state, int count, HunkTaskArray hunkTaskArray) {
		this.place = place;
		this.state = state;
		this.count = count;
		for (HunkTaskArrayItem item : hunkTaskArray.list()) {
			Grid grid = new Grid();
			grid.configId = item.getID();
			grid.param = item.getParam();
			grid.place = item.getPlace();
			gridMap.put(grid.place, grid);
		}
		check();
	}

	public void check() {
		// State 0:任务已完成未开始摇骰子 1:摇骰子了但没有确认 2:任务未完成 3:任务完成未领奖励 4:寻宝完成
		switch (state) {
		case 0:
			shakeDice();
			break;
		case 1:
			confirmDice();
			break;
		case 2:
			finishTask();
			break;
		case 3:
			takeAward();
			break;
		case 4:
			LogUtil.info("本轮寻宝已完成");
			if (ConfigContainer.getInstance().getConfig().isXunbaoReset()) {
				int canBuyCount = playerManager.getCountControlManager().getBuyCount(
						ApplicationConstants.COUNTCONTROL_TYPE_11, 0);
				int needGold = playerManager.getCountControlManager().getNeedGold(
						ApplicationConstants.COUNTCONTROL_TYPE_11, 0);
				if (canBuyCount > 0 && playerManager.getPlayerData().getGold() >= needGold) {
					PlayerWork work = new PlayerWork();
					work.setDesc("开始重置寻宝");
					work.getMessages().add(new Message_8_14());
					playerManager.getWorkQueue().offerFirst(work);
				}
			}
			break;
		default:
			break;
		}
	}

	public void shakeDice() {
		PlayerWork work = new PlayerWork();
		work.setDesc("开始摇骰子");
		work.getMessages().add(new Message_8_7());
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void confirmDice() {
		PlayerWork work = new PlayerWork();
		work.setDesc("确认骰子点数");
		work.getMessages().add(new Message_8_8());
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void finishTask() {
		Grid grid = gridMap.get(place);
		String value = ConfigContext.getInstance().getFileValue("Xunbao_Renwushuaxin.lua",
				String.valueOf(grid.configId), "type");
		int type = Integer.parseInt(value);
		if (ValidateUtils.isEqual(type, 2) || ValidateUtils.isEqual(type, 9)) {
			if (playerManager.getPlayerData().getPhysicalPower() < 12) {
				return;
			}

			Message_7_1 message_7_1 = new Message_7_1();
			message_7_1.setStrongPointId(grid.param);

			PlayerWork plaWork = new PlayerWork();
			plaWork.getMessages().add(message_7_1);
			plaWork.setDesc("开始挑战关卡  strongPointId=" + grid.param);
			plaWork.setMicroseconds(ConfigContainer.getInstance().getBattleTime());
			playerManager.getWorkQueue().offerFirst(plaWork);

			isFight = true;

			return;
		}

		PlayerWork work = new PlayerWork();
		work.setDesc("请求完成寻宝事件");
		work.getMessages().add(new Message_8_9());
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void takeAward() {
		PlayerWork work = new PlayerWork();
		work.setDesc("请求领取寻宝奖励");
		work.getMessages().add(new Message_8_11());
		playerManager.getWorkQueue().offerFirst(work);
	}

	public boolean isFighting() {
		return isFight;
	}

	public void battleOver() {
		openView();
	}

	class Grid {
		public int place;
		public long configId;
		public int param;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
