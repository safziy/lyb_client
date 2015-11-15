package com.lyb.client.processor.impl;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1006_13;
import com.lyb.client.message.protocol.segment.GeneralIdArray.GeneralIdArrayItem;
import com.lyb.client.model.TeamData;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 查看战队
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1006_13 extends IMessageProcessor<Message_1006_13> {

	@Override
	public void execute(PlayerManager playerManager, Message_1006_13 message) throws Exception {
		int formationId = message.getFormationId();
		Map<Long, Integer> playerGeneral = new HashMap<Long, Integer>();
		for (GeneralIdArrayItem generalItem : message.getGeneralIdArray().list()) {
			playerGeneral.put(generalItem.getGeneralId(), generalItem.getPlace());
		}
		TeamData teamData = new TeamData();
		teamData.setFormationId(formationId);
		teamData.setPlayerGeneral(playerGeneral);
		playerManager.getTeamManager().getTeamDataMap().put(message.getType(), teamData);

		playerManager.getTeamManager().checkTeam(message.getType());
	}
}
