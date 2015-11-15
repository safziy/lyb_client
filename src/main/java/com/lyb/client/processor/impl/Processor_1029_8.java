package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;

/**
 * 返回 答题数量分数
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1029_8 extends IMessageProcessor<Message_1029_8> {

	@Override
	public void execute(PlayerManager playerManager, Message_1029_8 message) throws Exception {
		playerManager.getAnswerManager().setCurrentCount(message.getCount2());
		playerManager.getAnswerManager().setTotalCount(message.getCount());
		playerManager.getAnswerManager().setScore(message.getScore());
		playerManager.getAnswerManager().setIsAward(message.getBooleanValue());
		
		playerManager.getAnswerManager().beginAnswer();
	}
}
