package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1019_18;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 十国征战对手信息
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1019_18 extends IMessageProcessor<Message_1019_18> {

	@Override
	public void execute(PlayerManager playerManager, Message_1019_18 message) throws Exception {
		playerManager.getTenCountryManager().fight();
	}
}
