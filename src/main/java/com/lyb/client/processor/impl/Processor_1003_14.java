package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1003_14;
import com.lyb.client.message.protocol.segment.UserDataAccumulateArray.UserDataAccumulateArrayItem;
import com.lyb.client.model.DataAccumulateData;
import com.lyb.client.processor.IMessageProcessor;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 数据累积
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1003_14 extends IMessageProcessor<Message_1003_14> {

	@Override
	public void execute(PlayerManager playerManager, Message_1003_14 message) throws Exception {
		for (UserDataAccumulateArrayItem item : message.getUserDataAccumulateArray().list()) {
			String key = DummyUtils.getCompositeKey(item.getType(), item.getParam());
			DataAccumulateData dataAccumulateData = new DataAccumulateData();
			dataAccumulateData.setType(item.getType());
			dataAccumulateData.setParam(item.getParam());
			dataAccumulateData.setValue(item.getValue());
			playerManager.getDataAccumulateManager().getDataAccumulateMap().put(key, dataAccumulateData);
		}
	}
}
