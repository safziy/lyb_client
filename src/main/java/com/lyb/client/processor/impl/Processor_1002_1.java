package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1002_1;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 登录认证
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1002_1 extends IMessageProcessor<Message_1002_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1002_1 message) throws Exception {
		int loginState = message.getLoginState();
		switch (loginState) {
		case 2:
			playerManager.initClient();
			break;
		default:
			break;
		}
	}
}
