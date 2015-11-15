package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1004_5;
import com.lyb.client.message.protocol.segment.YXZStrongPointArray.YXZStrongPointArrayItem;
import com.lyb.client.model.YXZData;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 英雄志
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1004_5 extends IMessageProcessor<Message_1004_5> {

	@Override
	public void execute(PlayerManager playerManager, Message_1004_5 message) throws Exception {

		for (YXZStrongPointArrayItem item : message.getYXZStrongPointArray().list()) {
			YXZData yxzData = new YXZData();
			yxzData.setId(item.getID());
			yxzData.setStrongPointId(item.getStrongPointId());
			yxzData.setCount(item.getCount());
			yxzData.setTotalCount(item.getTotalCount());
			yxzData.setStarLevel(item.getStarLevel());
			yxzData.setState(item.getState());
			playerManager.getYXZManager().getYxzDataMap().put(item.getID(), yxzData);
		}
	}
}
