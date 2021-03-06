package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1008_6;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 同步寻宝任务
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1008_6 extends IMessageProcessor<Message_1008_6> {

	@Override
	public void execute(PlayerManager playerManager, Message_1008_6 message) throws Exception {
		playerManager.getXunbaoManager().state(message.getPlace(), message.getState(), message.getCount(),
				message.getHunkTaskArray());
	}
}
