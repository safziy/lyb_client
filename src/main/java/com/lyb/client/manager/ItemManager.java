package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.model.ItemData;
import com.lyb.client.utils.ValidateUtils;

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

	public int getItemCountByItemId(int itemId) {
		int count = 0;
		for (ItemData itemData : itemDataMap.values()) {
			if (ValidateUtils.isEqual(itemData.getItemId(), itemId)) {
				count += itemData.getCount();
			}
		}
		return count;
	}

}
