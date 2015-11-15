package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.model.CountControlData;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.utils.ValidateUtils;

public class CountControlManager {
	@SuppressWarnings("unused")
	private PlayerManager playerManager;

	Map<String, CountControlData> countControlMap = new HashMap<String, CountControlData>();

	public CountControlManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public Map<String, CountControlData> getCountControlMap() {
		return countControlMap;
	}

	public int getRemainCount(int type, int param) {
		String key = DummyUtils.getCompositeKey(type, param);
		if (ValidateUtils.isFalse(countControlMap.containsKey(key))) {
			return 0;
		}
		CountControlData countControlData = countControlMap.get(key);
		return countControlData.getTotalCount() - countControlData.getCurrentCount();
	}
}
