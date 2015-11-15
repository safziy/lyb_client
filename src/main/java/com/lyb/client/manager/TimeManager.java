package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.utils.DummyUtils;

public class TimeManager {
	@SuppressWarnings("unused")
	private PlayerManager playerManager;

	private Map<String, Integer> timeMap = new HashMap<String, Integer>();

	public TimeManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public int getIntervalTime(int mainType, int subType) {
		String key = DummyUtils.getCompositeKey(mainType, subType);
		if (timeMap.containsKey(key)) {
			return timeMap.get(key);
		}
		return 0;
	}

	public Map<String, Integer> getTimeMap() {
		return timeMap;
	}
}
