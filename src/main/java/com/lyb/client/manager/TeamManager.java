package com.lyb.client.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.message.protocol.Message_6_12;
import com.lyb.client.message.protocol.Message_6_13;
import com.lyb.client.message.protocol.segment.GeneralIdArray;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.model.HeroData;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.model.TeamData;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.utils.ValidateUtils;

public class TeamManager {
	private PlayerManager playerManager;

	private Map<Long, Integer> formationMap = new HashMap<Long, Integer>();
	private Map<Integer, TeamData> teamDataMap = new HashMap<Integer, TeamData>();

	public TeamManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public Map<Long, Integer> getTeam(int type) {
		if (teamDataMap.containsKey(type)) {
			return teamDataMap.get(type).getPlayerGeneral();
		}
		return new HashMap<Long, Integer>();
	}

	public void viewTeam(int type) {
		if (playerManager.getTeamManager().getTeam(type).size() > 0) {
			return;
		}
		Message_6_13 message_6_13 = new Message_6_13();
		message_6_13.setType(type);
		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_6_13);
		work.setDesc("请求查看战队 teamType=" + type);
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void checkTeam(int type) {
		if (ValidateUtils.isEqual(type, ApplicationConstants.TEAM_TYPE_2)) {
			// 十国的战队不在这里设置
			return;
		}
		if (playerManager.getTeamManager().getTeam(type).size() <= 0) {
			playerManager.getTeamManager().playTeam(type);
		}
	}

	public void playTeam(int type) {
		Message_6_12 message_6_12 = new Message_6_12();
		message_6_12.setType(type);
		// 暂不支持佣兵
		message_6_12.setPlace(0);
		message_6_12.setGeneralId(0);
		message_6_12.setIDArray(new IDArray());
		List<HeroData> heros = new LinkedList<HeroData>();
		if (ValidateUtils.isEqual(type, ApplicationConstants.TEAM_TYPE_2)) {
			heros.addAll(playerManager.getTenCountryManager().getAliveHero());
		} else {
			heros.addAll(playerManager.getHeroManager().getHeroDataMap().values());
		}
		Collections.sort(heros, new Comparator<HeroData>() {
			@Override
			public int compare(HeroData o1, HeroData o2) {
				return o2.getLevel() - o1.getLevel();
			}
		});
		int highFormationLevel = 0;
		long formationId = 0;
		for (Entry<Long, Integer> entry : formationMap.entrySet()) {
			if (entry.getValue() > highFormationLevel) {
				highFormationLevel = entry.getValue();
				formationId = entry.getKey();
			}
		}
		String famationPlace = ConfigContext.getInstance().getFileValue("Zhenfa_Zhenfa.lua",
				String.valueOf(formationId), "position");
		List<Integer> placeList = DummyUtils.convertContentToList(Integer.class, famationPlace);
		GeneralIdArray generalIdArray = new GeneralIdArray();
		int teamSize = Math.min(heros.size(), 5);
		for (int i = 0; i < teamSize; i++) {
			int place = placeList.get(i);
			long generalId = heros.get(i).getGeneralId();
			generalIdArray.addData(place, generalId);
		}
		message_6_12.setFormationId((int) formationId);
		message_6_12.setGeneralIdArray(generalIdArray);

		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_6_12);
		work.setDesc("请求设置战队 teamType=" + type);
		playerManager.getWorkQueue().offerFirst(work);
	}

	public Map<Integer, TeamData> getTeamDataMap() {
		return teamDataMap;
	}

	public Map<Long, Integer> getFormationMap() {
		return formationMap;
	}

}
