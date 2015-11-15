package com.lyb.client.model;

import java.util.Map;

public class TeamData {
	private int formationId;
	private Map<Long, Integer> playerGeneral;

	public int getFormationId() {
		return formationId;
	}

	public void setFormationId(int formationId) {
		this.formationId = formationId;
	}

	public Map<Long, Integer> getPlayerGeneral() {
		return playerGeneral;
	}

	public void setPlayerGeneral(Map<Long, Integer> playerGeneral) {
		this.playerGeneral = playerGeneral;
	}

}
