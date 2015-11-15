package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1007_6;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 战斗结束
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1007_6 extends IMessageProcessor<Message_1007_6> {

	@Override
	public void execute(PlayerManager playerManager, Message_1007_6 message) throws Exception {
		playerManager.getBattleManager().battleOver();
	}
}
