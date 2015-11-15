package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1016_1;
import com.lyb.client.message.protocol.segment.UserArenaArray.UserArenaArrayItem;
import com.lyb.client.model.ArenaData;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回决战巅峰面板信息
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1016_1 extends IMessageProcessor<Message_1016_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1016_1 message) throws Exception {
		ArenaData arenaData = new ArenaData();
		arenaData.setSeason(message.getSeason());
		arenaData.setRemainSeconds(message.getRemainSeconds());
		arenaData.setCount(message.getCount());
		arenaData.setRanking(message.getRanking());
		arenaData.setScore(message.getScore());
		for (UserArenaArrayItem item : message.getUserArenaArray().list()) {
			arenaData.addTargetPlayer(item.getUserId(), item.getUserName(), item.getLevel(), item.getTransforId(),
					item.getScore(), item.getZhanli(), item.getBooleanValue());
		}
		playerManager.getArenaManager().setArenaData(arenaData);
		
		playerManager.getArenaManager().viewTarget();
	}
}
