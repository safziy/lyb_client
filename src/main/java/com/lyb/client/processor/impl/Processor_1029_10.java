package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;

/**
 * 返回 答题结果
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1029_10 extends IMessageProcessor<Message_1029_10> {

	@Override
	public void execute(PlayerManager playerManager, Message_1029_10 message) throws Exception {
		playerManager.getAnswerManager().answerResult(message.getScore(),message.getValue());
	}
}
