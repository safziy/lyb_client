package com.lyb.client.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lyb.client.config.ConfigContainer;
import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.protocol.Message_19_18;
import com.lyb.client.message.protocol.Message_19_3;
import com.lyb.client.message.protocol.Message_19_6;
import com.lyb.client.message.protocol.Message_19_7;
import com.lyb.client.message.protocol.Message_19_8;
import com.lyb.client.model.HeroData;
import com.lyb.client.model.PlayerWork;

public class TenCountryManager {
	private PlayerManager playerManager;

	private int curCountry;
	private Map<Long, Integer> heroStateMap = new HashMap<Long, Integer>();

	public TenCountryManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		if (ConfigContainer.getInstance().getConfig().isAutoShiguo()) {
			PlayerWork work = new PlayerWork();
			work.getMessages().add(new Message_19_3());
			work.setDesc("打开十国界面");
			playerManager.getWorkQueue().offerFirst(work);
		}
	}

	public void state(long id, int state, Map<Long, Integer> heroStateMap) {
		this.heroStateMap = heroStateMap;
		if (id > 10) {
			return;
		}
		curCountry = (int) id;
		switch (state) {
		case 0:
		case 1:
			PlayerWork work = new PlayerWork();
			work.getMessages().add(new Message_19_18());
			work.setDesc("请求十国对手信息  curCountry=" + curCountry);
			playerManager.getWorkQueue().offerFirst(work);
			break;
		case 2:
			PlayerWork work2 = new PlayerWork();
			work2.getMessages().add(new Message_19_7());
			work2.setDesc("开始领取十国奖励  curCountry=" + curCountry);
			playerManager.getWorkQueue().offerFirst(work2);
			break;
		case 3:
			// 已完成
			int remainCount = playerManager.getCountControlManager().getRemainCount(
					ApplicationConstants.COUNTCONTROL_TYPE_4, 0);
			if (remainCount > 0) {
				PlayerWork refresh = new PlayerWork();
				refresh.getMessages().add(new Message_19_8());
				refresh.setDesc("请求重置十国  remainCount=" + remainCount);
				playerManager.getWorkQueue().offerFirst(refresh);
			} else {
				LogUtil.info("十国的次数今天已经用完!");
			}
			break;
		default:
			break;
		}
	}

	public void fight() {
		PlayerWork fight = new PlayerWork();
		fight.getMessages().add(new Message_19_6());
		fight.setDesc("开始挑战十国  curCountry=" + curCountry);
		fight.setMicroseconds(ConfigContainer.getInstance().getBattleTime());
		playerManager.getWorkQueue().offerFirst(fight);

		if (playerManager.getTeamManager().getTeam(ApplicationConstants.TEAM_TYPE_2).size() <= 0) {
			playerManager.getTeamManager().playTeam(ApplicationConstants.TEAM_TYPE_2);
		}
	}

	public Collection<HeroData> getAliveHero() {
		Set<HeroData> heroSet = new HashSet<HeroData>();
		for (HeroData hero : playerManager.getHeroManager().getHeroDataMap().values()) {
			if (heroStateMap.containsKey(hero.getGeneralId()) && heroStateMap.get(hero.getGeneralId()) <= 0) {
				continue;
			}
			heroSet.add(hero);
		}
		return heroSet;
	}

	public void battleOver() {
		PlayerWork afterFight = new PlayerWork();
		afterFight.getMessages().add(new Message_19_3());
		afterFight.setDesc("打开十国界面");
		playerManager.getWorkQueue().offerFirst(afterFight);
	}
}
