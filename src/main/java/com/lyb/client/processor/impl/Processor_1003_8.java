package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;

/**
 * 返回 用户货币
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1003_8 extends IMessageProcessor<Message_1003_8> {

	@Override
	public void execute(PlayerManager playerManager, Message_1003_8 message) throws Exception {
		playerManager.getPlayerData().setPhysicalPower(message.getPhysicalPower());
		playerManager.getPlayerData().setFamilyContribute(message.getFamilyContribute());
		playerManager.getPlayerData().setStoryLineStar(message.getStoryLineStar());
		playerManager.getPlayerData().setPrestige(message.getPrestige());
		playerManager.getPlayerData().setGold(message.getGold());
		playerManager.getPlayerData().setScore(message.getScore());
		playerManager.getPlayerData().setSilver(message.getSilver());
	}
}
