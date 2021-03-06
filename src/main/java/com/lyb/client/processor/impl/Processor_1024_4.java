package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1024_4;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 签到奖励
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1024_4 extends IMessageProcessor<Message_1024_4> {

	@Override
	public void execute(PlayerManager playerManager, Message_1024_4 message) throws Exception {
		playerManager.getActivityManager().setHasSign(message.getBooleanValue());
	}
}
