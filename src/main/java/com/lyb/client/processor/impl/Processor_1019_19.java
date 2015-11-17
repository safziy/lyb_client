package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1019_19;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 打开朝堂界面
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1019_19 extends IMessageProcessor<Message_1019_19> {

	@Override
	public void execute(PlayerManager playerManager, Message_1019_19 message) throws Exception {
		playerManager.getChaotangManager().viewResult(message.getState(), message.getChancellorArray());
	}
}
