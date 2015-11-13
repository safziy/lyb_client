package com.lyb.client.manager;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.protocol.Message_16_1;
import com.lyb.client.message.protocol.Message_16_2;
import com.lyb.client.message.protocol.Message_16_4;
import com.lyb.client.message.protocol.Message_16_6;
import com.lyb.client.message.protocol.segment.PlaceIDArray;
import com.lyb.client.model.ArenaData;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.model.TargetArenaPlayer;
import com.lyb.client.utils.ValidateUtils;

public class ArenaManager {
	private PlayerManager playerManager;

	private ArenaData arenaData;

	public ArenaManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		openArena();
	}

	public void openArena() {
		PlayerWork work = new PlayerWork();
		work.setDesc("打开竞技场界面");
		work.getMessages().add(new Message_16_1());
		playerManager.getWorkQueue().offerFirst(work);

		playerManager.getTeamManager().viewTeam(ApplicationConstants.TEAM_TYPE_6);
	}

	public void viewTarget() {
		// 验证次数
		int remainCount = playerManager.getCountControlManager().getRemainCount(
				ApplicationConstants.COUNTCONTROL_TYPE_2, 1);
		if (remainCount <= 0) {
			LogUtil.info("竞技场今日的次数已经用完!");
			return;
		}
		for (TargetArenaPlayer targetPlayer : arenaData.getTargetPlayers()) {
			if (ValidateUtils.isEqual(targetPlayer.getBooleanValue(), 0)) {
				Message_16_6 message_16_6 = new Message_16_6();
				message_16_6.setUserId(targetPlayer.getUserId());

				PlayerWork virwTarget = new PlayerWork();
				virwTarget.setDesc("请求竞技场对手信息");
				virwTarget.getMessages().add(message_16_6);
				playerManager.getWorkQueue().offerFirst(virwTarget);
				return;
			}
		}
		// 都已经挑战过了 需要请求刷新
		int intervalTime = playerManager.getTimeManager().getIntervalTime(ApplicationConstants.TIME_TYPE_1, 0);
		PlayerWork refresh = new PlayerWork();
		refresh.setDesc("请求竞技场刷新对手");
		if (intervalTime > 0) {
			refresh.setState(ApplicationConstants.WORK_STATE_2);
			refresh.setActivateTime(System.currentTimeMillis() + intervalTime * 1000);
			refresh.getMessages().add(new Message_16_1());
			playerManager.getWorkQueue().offerLast(refresh);
		} else {
			refresh.getMessages().add(new Message_16_4());
			playerManager.getWorkQueue().offerFirst(refresh);
		}
	}

	public void fight(long userId, int formationId, PlaceIDArray placeIDArray) {
		Message_16_2 message_16_2 = new Message_16_2();
		message_16_2.setUserId(userId);
		message_16_2.setFormationId(formationId);
		message_16_2.setPlaceIDArray(placeIDArray);

		PlayerWork fight = new PlayerWork();
		fight.setDesc("竞技场开始挑战对手");
		fight.getMessages().add(message_16_2);
		fight.setMicroseconds(ApplicationConstants.FIGHT_SLEEP_TIME);
		playerManager.getWorkQueue().offerFirst(fight);
	}

	public void battleOver() {
		openArena();
	}

	public ArenaData getArenaData() {
		return arenaData;
	}

	public void setArenaData(ArenaData arenaData) {
		this.arenaData = arenaData;
	}

}
