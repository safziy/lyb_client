package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;
import com.lyb.client.message.protocol.segment.FormationArray.FormationArrayItem;

/**
 * 返回 阵法信息
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1006_20 extends IMessageProcessor<Message_1006_20> {

	@Override
	public void execute(PlayerManager playerManager, Message_1006_20 message) throws Exception {
		for (FormationArrayItem item : message.getFormationArray().list()) {
			playerManager.getTeamManager().getFormationMap().put(item.getID(), item.getLevel());
		}
	}
}
