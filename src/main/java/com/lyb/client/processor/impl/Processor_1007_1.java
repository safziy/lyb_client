package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1007_1;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 初始化战场数据
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1007_1 extends IMessageProcessor<Message_1007_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1007_1 message) throws Exception {
		int battleId = message.getBattleId();
		int battleFieldId = message.getBattleFieldId();
		long randomSeed = Long.parseLong(message.getRandomSeed());
		playerManager.getBattleManager().battle(battleId, battleFieldId, randomSeed, message.getBattleGeneralArray());
	}
}
