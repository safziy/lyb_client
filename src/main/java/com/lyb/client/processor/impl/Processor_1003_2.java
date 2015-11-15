package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1003_2;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 登陆结束
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1003_2 extends IMessageProcessor<Message_1003_2> {

	@Override
	public void execute(PlayerManager playerManager, Message_1003_2 message) throws Exception {
		playerManager.initClientComplete();
	}
}
