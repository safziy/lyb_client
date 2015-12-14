package com.lyb.client.manager;

import com.lyb.client.message.protocol.Message_24_5;
import com.lyb.client.message.protocol.Message_24_7;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.utils.ValidateUtils;

public class ActivityManager {
	private PlayerManager playerManager;

	public ActivityManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	// 是否签到
	private int hasSign;

	// 月卡
	private int yuekaCount;
	private int hasYueka;

	public void initWork() {
		// 检查是否可以领取月卡
		if (ValidateUtils.isEqual(hasYueka, 0) && yuekaCount > 0) {
			takeYueka();
		}
		// 检查签到
		if (ValidateUtils.isEqual(hasSign, 0)) {
			sign();
		}
	}

	public void takeYueka() {
		PlayerWork work = new PlayerWork();
		work.getMessages().add(new Message_24_7());
		work.setDesc("开始领取月卡");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void sign() {
		PlayerWork work = new PlayerWork();
		work.getMessages().add(new Message_24_5());
		work.setDesc("开始签到");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void setHasSign(int hasSign) {
		this.hasSign = hasSign;
	}

	public void setYueka(int count, int booleanValue) {
		this.yuekaCount = count;
		this.hasYueka = booleanValue;

	}

}
