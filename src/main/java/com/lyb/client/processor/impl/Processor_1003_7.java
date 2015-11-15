package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;
import com.lyb.client.message.protocol.segment.TimerArray.TimerArrayItem;

/**
 * 返回 冷却时间
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1003_7 extends IMessageProcessor<Message_1003_7> {

	@Override
	public void execute(PlayerManager playerManager, Message_1003_7 message) throws Exception {
		for (TimerArrayItem item : message.getTimerArray().list()) {
			playerManager.getTimeManager().getTimeMap().put(item.getTimerType(), item.getValue());
		}
	}
}
