package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1019_1;
import com.lyb.client.message.protocol.segment.CDTimeArray.CDTimeArrayItem;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 打开琅琊试炼
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1019_1 extends IMessageProcessor<Message_1019_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1019_1 message) throws Exception {
		for (CDTimeArrayItem item : message.getCDTimeArray().list()) {
			playerManager.getShilianManager().getCdTimeMap().put(item.getType(), item.getTime());
		}
		playerManager.getShilianManager().checkFight();
	}
}
