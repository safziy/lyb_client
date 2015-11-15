package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;
import com.lyb.client.message.protocol.segment.UserArenaArray.UserArenaArrayItem;
import com.lyb.client.model.ArenaData;

/**
 * 返回 刷新刷新对手
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1016_4 extends IMessageProcessor<Message_1016_4> {

	@Override
	public void execute(PlayerManager playerManager, Message_1016_4 message) throws Exception {
		ArenaData arenaData = playerManager.getArenaManager().getArenaData();
		arenaData.getTargetPlayers().clear();
		for (UserArenaArrayItem item : message.getUserArenaArray().list()) {
			arenaData.addTargetPlayer(item.getUserId(), item.getUserName(), item.getLevel(), item.getTransforId(),
					item.getScore(), item.getZhanli(), item.getBooleanValue());
		}
		playerManager.getArenaManager().viewTarget();
	}
}
