package com.lyb.client.processor.impl;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1019_3;
import com.lyb.client.message.protocol.segment.GeneralStateArray.GeneralStateArrayItem;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 打开十国征战
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1019_3 extends IMessageProcessor<Message_1019_3> {

	@Override
	public void execute(PlayerManager playerManager, Message_1019_3 message) throws Exception {
		long id = message.getID();
		int state = message.getState();
		Map<Long, Integer> heroStateMap = new HashMap<Long, Integer>();
		for (GeneralStateArrayItem item : message.getGeneralStateArray().list()) {
			heroStateMap.put(item.getBattleUnitID(), item.getCurrentHP());
		}
		playerManager.getTenCountryManager().state(id, state, heroStateMap, message.getBooleanValue());
	}
}
