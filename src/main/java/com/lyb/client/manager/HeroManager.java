package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.model.HeroData;

public class HeroManager {
	@SuppressWarnings("unused")
	private PlayerManager playerManager;
	
	private Map<Long, HeroData> heroDataMap = new HashMap<Long, HeroData>();

	public HeroManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}
	
	public Map<Long, HeroData> getHeroDataMap() {
		return heroDataMap;
	}

}
