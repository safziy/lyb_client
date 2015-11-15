package com.lyb.client.model;

import java.util.HashMap;
import java.util.Map;

public class HeroData {
	// {generalId:2003100062074, configId:22,
	// skillArray:[{configId:10002230, level:43}, {configId:10002240, level:43},
	// {configId:10002210, level:45},
	// {configId:10002220, level:43}, {configId:10002250, level:43}], level:45,
	// grade:8,
	// time:1443787575, isMainGeneral:0, talentLevel:1, wuxingLevel:0,
	// starLevel:3, experience:452, fateLevelArray:[]},

	private long generalId;
	private int configId;
	private Map<Integer, Integer> skillMap = new HashMap<Integer, Integer>();
	private int level;
	private int grade;
	private long time;
	private int isMainGeneral;
	private int talentLevel;
	private int wuxingLevel;
	private int starLevel;
	private int experience;
	private Map<Long, Integer> fateMap = new HashMap<Long, Integer>();

	public long getGeneralId() {
		return generalId;
	}

	public void setGeneralId(long generalId) {
		this.generalId = generalId;
	}

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public Map<Integer, Integer> getSkillMap() {
		return skillMap;
	}

	public void setSkillMap(Map<Integer, Integer> skillMap) {
		this.skillMap = skillMap;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getIsMainGeneral() {
		return isMainGeneral;
	}

	public void setIsMainGeneral(int isMainGeneral) {
		this.isMainGeneral = isMainGeneral;
	}

	public int getTalentLevel() {
		return talentLevel;
	}

	public void setTalentLevel(int talentLevel) {
		this.talentLevel = talentLevel;
	}

	public int getWuxingLevel() {
		return wuxingLevel;
	}

	public void setWuxingLevel(int wuxingLevel) {
		this.wuxingLevel = wuxingLevel;
	}

	public int getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Map<Long, Integer> getFateMap() {
		return fateMap;
	}

	public void setFateMap(Map<Long, Integer> fateMap) {
		this.fateMap = fateMap;
	}

}
