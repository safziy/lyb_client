package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1019_9;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 打开朝堂议事
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1019_9 extends IMessageProcessor<Message_1019_9> {

	@Override
	public void execute(PlayerManager playerManager, Message_1019_9 message) throws Exception {
		playerManager.getChaotangManager().checkTiAn(message.getState(), message.getIDParamArray(),
				message.getIDStateParamArray());
	}
}
