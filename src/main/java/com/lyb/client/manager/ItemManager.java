package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.model.ItemData;

public class ItemManager {
	@SuppressWarnings("unused")
	private PlayerManager playerManager;

	private Map<Long, ItemData> itemDataMap = new HashMap<Long, ItemData>();

	public ItemManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public Map<Long, ItemData> getItemDataMap() {
		return itemDataMap;
	}

}
