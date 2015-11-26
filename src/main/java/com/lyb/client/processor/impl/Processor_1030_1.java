package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1030_1;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 地牢数据
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1030_1 extends IMessageProcessor<Message_1030_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1030_1 message) throws Exception {
		playerManager.getDilaoManager().openViewResult(message.getCount(), message.getBooleanValue(),
				message.getBooleanValue2(), message.getScore(), message.getRemainSeconds(),
				message.getUserDungeonArray());
	}
}
