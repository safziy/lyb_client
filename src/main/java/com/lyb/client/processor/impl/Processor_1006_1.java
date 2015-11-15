package com.lyb.client.processor.impl;

import java.util.HashMap;
import java.util.Map;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1006_1;
import com.lyb.client.message.protocol.segment.FateLevelArray.FateLevelArrayItem;
import com.lyb.client.message.protocol.segment.GeneralArray.GeneralArrayItem;
import com.lyb.client.message.protocol.segment.SkillArray.SkillArrayItem;
import com.lyb.client.model.HeroData;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 查看卡牌列表
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1006_1 extends IMessageProcessor<Message_1006_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1006_1 message) throws Exception {
		for (GeneralArrayItem item : message.getGeneralArray().list()) {
			HeroData heroData = new HeroData();
			heroData.setGeneralId(item.getGeneralId());
			heroData.setConfigId(item.getConfigId());
			heroData.setIsMainGeneral(item.getIsMainGeneral());
			heroData.setExperience(item.getExperience());
			heroData.setStarLevel(item.getStarLevel());
			heroData.setTime(item.getTime());
			heroData.setGrade(item.getGrade());
			heroData.setTalentLevel(item.getTalentLevel());
			heroData.setLevel(item.getLevel());
			heroData.setWuxingLevel(item.getWuxingLevel());
			Map<Long, Integer> fateMap = new HashMap<Long, Integer>();
			for (FateLevelArrayItem fateItem : item.getFateLevelArray().list()) {
				fateMap.put(fateItem.getID(), fateItem.getLevel());
			}
			heroData.setFateMap(fateMap);
			Map<Integer, Integer> skillMap = new HashMap<Integer, Integer>();
			for (SkillArrayItem skillItem : item.getSkillArray().list()) {
				skillMap.put(skillItem.getConfigId(), skillItem.getLevel());
			}
			heroData.setSkillMap(skillMap);
			playerManager.getHeroManager().getHeroDataMap().put(heroData.getGeneralId(), heroData);
		}
	}
}
