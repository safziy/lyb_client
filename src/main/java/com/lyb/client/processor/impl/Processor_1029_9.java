package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;

/**
 * 返回 题目
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1029_9 extends IMessageProcessor<Message_1029_9> {

	@Override
	public void execute(PlayerManager playerManager, Message_1029_9 message) throws Exception {
		playerManager.getAnswerManager().answer(message.getID());
	}
}
