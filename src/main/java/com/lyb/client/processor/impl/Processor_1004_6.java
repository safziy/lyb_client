package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;
import com.lyb.client.message.protocol.segment.StrongPointIdCountArray.StrongPointIdCountArrayItem;

/**
 * 返回 剧情宝箱关卡信息
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1004_6 extends IMessageProcessor<Message_1004_6> {

	@Override
	public void execute(PlayerManager playerManager, Message_1004_6 message) throws Exception {
		playerManager.getStrongPointManager().getNfsSet().clear();
		for (StrongPointIdCountArrayItem item : message.getStrongPointIdCountArray().list()) {
			playerManager.getStrongPointManager().getNfsSet().add(item.getStrongPointId());
		}
	}
}
