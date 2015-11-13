package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;

/**
 * 返回 筛子点数
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1008_7 extends IMessageProcessor<Message_1008_7> {

	@Override
	public void execute(PlayerManager playerManager, Message_1008_7 message) throws Exception {
		playerManager.getXunbaoManager().setCount(message.getCount());
		playerManager.getXunbaoManager().setState(1);
		playerManager.getXunbaoManager().check();
	}
}
