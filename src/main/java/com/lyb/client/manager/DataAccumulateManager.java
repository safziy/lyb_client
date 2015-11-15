package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.model.DataAccumulateData;

public class DataAccumulateManager {
	@SuppressWarnings("unused")
	private PlayerManager playerManager;

	Map<String, DataAccumulateData> dataAccumulateMap = new HashMap<String, DataAccumulateData>();

	public DataAccumulateManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public Map<String, DataAccumulateData> getDataAccumulateMap() {
		return dataAccumulateMap;
	}
}
