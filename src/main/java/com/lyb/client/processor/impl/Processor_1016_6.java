package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1016_6;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 比武大会英雄信息
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1016_6 extends IMessageProcessor<Message_1016_6> {

	@Override
	public void execute(PlayerManager playerManager, Message_1016_6 message) throws Exception {
		playerManager.getArenaManager().fight(message.getUserId(), message.getFormationId(), message.getPlaceIDArray());
	}
}
