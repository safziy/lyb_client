package com.lyb.client.manager;

import java.util.HashSet;
import java.util.Set;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.protocol.Message_7_1;
import com.lyb.client.model.InnerWork;
import com.lyb.client.model.PlayerWork;
import com.safziy.commom.utils.TimeUtils;

public class StrongPointManager {
	private PlayerManager playerManager;

	// 没有打到3星的关卡
	private Set<Integer> nfsSet = new HashSet<Integer>();

	public StrongPointManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		checkAndFight();
	}

	public void checkAndFight() {
		if (nfsSet.size() <= 0) {
			return;
		}
		if (playerManager.getPlayerData().getPhysicalPower() >= 6) {
			fight();
			return;
		} else {
			LogUtil.info("体力不够,等待体力恢复再打关卡");
			int needPhysicalPower = 6 - playerManager.getPlayerData().getPhysicalPower();
			PlayerWork waitWork = new PlayerWork(new InnerWork() {
				@Override
				public void work() {
					checkAndFight();
				}
			});
			waitWork.setActivateTime(System.currentTimeMillis() + needPhysicalPower * 6
					* TimeUtils.ONE_MINUTE_MICROSECONDS);
			waitWork.setState(ApplicationConstants.WORK_STATE_2);
			playerManager.getWorkQueue().offerLast(waitWork);
		}
	}

	public void checkAndPreFight() {
		PlayerWork waitWork = new PlayerWork(new InnerWork() {
			@Override
			public void work() {
				checkAndFight();
			}
		});
		waitWork.setActivateTime(System.currentTimeMillis());
		waitWork.setState(ApplicationConstants.WORK_STATE_2);
		playerManager.getWorkQueue().offerFirst(waitWork);
	}

	public void fight() {
		if (nfsSet.size() <= 0 || playerManager.getPlayerData().getPhysicalPower() < 6) {
			return;
		}
		int strongPointId = nfsSet.iterator().next();
		Message_7_1 message_7_1 = new Message_7_1();
		message_7_1.setStrongPointId(strongPointId);

		PlayerWork plaWork = new PlayerWork();
		plaWork.getMessages().add(message_7_1);
		plaWork.setDesc("开始挑战关卡  strongPointId=" + strongPointId);
		plaWork.setMicroseconds(10000);
		playerManager.getWorkQueue().offerFirst(plaWork);
	}

	public Set<Integer> getNfsSet() {
		return nfsSet;
	}
}
