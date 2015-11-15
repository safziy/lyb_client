package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1001_2;
import com.lyb.client.processor.IMessageProcessor;
import com.lyb.client.utils.ValidateUtils;

/**
 * 返回 成功
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1001_2 extends IMessageProcessor<Message_1001_2> {

	@Override
	public void execute(PlayerManager playerManager, Message_1001_2 message) throws Exception {
		if (ValidateUtils.isEqual(message.getMainCommand(), 2) && ValidateUtils.isEqual(message.getSubCommand(), 13)) {
			playerManager.work();
		}
	}
}
