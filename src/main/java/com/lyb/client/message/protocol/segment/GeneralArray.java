package com.lyb.client.message.protocol.segment;

import java.util.LinkedList;
import java.util.List;

import com.lyb.client.message.IMessageEncoder;
import com.lyb.client.message.handler.IMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.*;

/**
 * ${desc}
 * 
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class GeneralArray implements IMessageEncoder {
	private List<GeneralArrayItem> list = new LinkedList<GeneralArrayItem>();

	public List<GeneralArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (GeneralArrayItem item : list) {
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getConfigId());
			item.getSkillArray().encode(data);
			data.writeInt(item.getLevel());
			data.writeInt(item.getGrade());
			data.writeInt(item.getTime());
			data.writeInt(item.getIsMainGeneral());
			data.writeInt(item.getTalentLevel());
			data.writeInt(item.getWuxingLevel());
			data.writeInt(item.getStarLevel());
			data.writeInt(item.getExperience());
			item.getFateLevelArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			GeneralArrayItem item = GeneralArrayItem.create();
			item.setGeneralId(data.getLong());
			item.setConfigId(data.getInt());
			item.setSkillArray(SkillArray.create());
			item.getSkillArray().decode(data);
			item.setLevel(data.getInt());
			item.setGrade(data.getInt());
			item.setTime(data.getInt());
			item.setIsMainGeneral(data.getInt());
			item.setTalentLevel(data.getInt());
			item.setWuxingLevel(data.getInt());
			item.setStarLevel(data.getInt());
			item.setExperience(data.getInt());
			item.setFateLevelArray(FateLevelArray.create());
			item.getFateLevelArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (GeneralArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static GeneralArray create() {
		GeneralArray array = new GeneralArray();
		return array;
	}

	public static GeneralArrayItem createItem() {
		GeneralArrayItem item = new GeneralArrayItem();
		return item;
	}

	public GeneralArrayItem addData(long generalId, int configId, SkillArray skillArray, int level, int grade, int time, int isMainGeneral, int talentLevel, int wuxingLevel, int starLevel, int experience, FateLevelArray fateLevelArray) {
		GeneralArrayItem item = new GeneralArrayItem();
		item.setGeneralId(generalId);
		item.setConfigId(configId);
		item.setSkillArray(skillArray);
		item.setLevel(level);
		item.setGrade(grade);
		item.setTime(time);
		item.setIsMainGeneral(isMainGeneral);
		item.setTalentLevel(talentLevel);
		item.setWuxingLevel(wuxingLevel);
		item.setStarLevel(starLevel);
		item.setExperience(experience);
		item.setFateLevelArray(fateLevelArray);
		list.add(item);
		return item;
	}

	public void addItem(GeneralArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (GeneralArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class GeneralArrayItem implements IMessageEncoder {
		private long generalId;
		private int configId;
		private SkillArray skillArray;
		private int level;
		private int grade;
		private int time;
		private int isMainGeneral;
		private int talentLevel;
		private int wuxingLevel;
		private int starLevel;
		private int experience;
		private FateLevelArray fateLevelArray;

		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler gradeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Grade");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");
		private static IntMessageParameterHandler isMainGeneralHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("IsMainGeneral");
		private static IntMessageParameterHandler talentLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TalentLevel");
		private static IntMessageParameterHandler wuxingLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("WuxingLevel");
		private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");
		private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");

		public static GeneralArrayItem create() {
			GeneralArrayItem item = new GeneralArrayItem();
			return item;
		}

		/**
		 * @return the generalId
		 */
		public long getGeneralId() {
			return generalId;
		}

		/**
		 * @param generalId
		 *            the generalId to set
		 */
		public void setGeneralId(long generalId) {
			this.generalId = generalId;
		}
		/**
		 * @return the configId
		 */
		public int getConfigId() {
			return configId;
		}

		/**
		 * @param configId
		 *            the configId to set
		 */
		public void setConfigId(int configId) {
			this.configId = configId;
		}
		/**
		 * @return the skillArray
		 */
		public SkillArray getSkillArray() {
			return skillArray;
		}

		/**
		 * @param skillArray
		 *            the skillArray to set
		 */
		public void setSkillArray(SkillArray skillArray) {
			this.skillArray = skillArray;
		}
		/**
		 * @return the level
		 */
		public int getLevel() {
			return level;
		}

		/**
		 * @param level
		 *            the level to set
		 */
		public void setLevel(int level) {
			this.level = level;
		}
		/**
		 * @return the grade
		 */
		public int getGrade() {
			return grade;
		}

		/**
		 * @param grade
		 *            the grade to set
		 */
		public void setGrade(int grade) {
			this.grade = grade;
		}
		/**
		 * @return the time
		 */
		public int getTime() {
			return time;
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(int time) {
			this.time = time;
		}
		/**
		 * @return the isMainGeneral
		 */
		public int getIsMainGeneral() {
			return isMainGeneral;
		}

		/**
		 * @param isMainGeneral
		 *            the isMainGeneral to set
		 */
		public void setIsMainGeneral(int isMainGeneral) {
			this.isMainGeneral = isMainGeneral;
		}
		/**
		 * @return the talentLevel
		 */
		public int getTalentLevel() {
			return talentLevel;
		}

		/**
		 * @param talentLevel
		 *            the talentLevel to set
		 */
		public void setTalentLevel(int talentLevel) {
			this.talentLevel = talentLevel;
		}
		/**
		 * @return the wuxingLevel
		 */
		public int getWuxingLevel() {
			return wuxingLevel;
		}

		/**
		 * @param wuxingLevel
		 *            the wuxingLevel to set
		 */
		public void setWuxingLevel(int wuxingLevel) {
			this.wuxingLevel = wuxingLevel;
		}
		/**
		 * @return the starLevel
		 */
		public int getStarLevel() {
			return starLevel;
		}

		/**
		 * @param starLevel
		 *            the starLevel to set
		 */
		public void setStarLevel(int starLevel) {
			this.starLevel = starLevel;
		}
		/**
		 * @return the experience
		 */
		public int getExperience() {
			return experience;
		}

		/**
		 * @param experience
		 *            the experience to set
		 */
		public void setExperience(int experience) {
			this.experience = experience;
		}
		/**
		 * @return the fateLevelArray
		 */
		public FateLevelArray getFateLevelArray() {
			return fateLevelArray;
		}

		/**
		 * @param fateLevelArray
		 *            the fateLevelArray to set
		 */
		public void setFateLevelArray(FateLevelArray fateLevelArray) {
			this.fateLevelArray = fateLevelArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.generalId);
			data.writeInt(this.configId);
			skillArray.encode(data);
			data.writeInt(this.level);
			data.writeInt(this.grade);
			data.writeInt(this.time);
			data.writeInt(this.isMainGeneral);
			data.writeInt(this.talentLevel);
			data.writeInt(this.wuxingLevel);
			data.writeInt(this.starLevel);
			data.writeInt(this.experience);
			fateLevelArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalId = data.getLong();
			this.configId = data.getInt();
			skillArray = SkillArray.create();
			skillArray.decode(data);
			this.level = data.getInt();
			this.grade = data.getInt();
			this.time = data.getInt();
			this.isMainGeneral = data.getInt();
			this.talentLevel = data.getInt();
			this.wuxingLevel = data.getInt();
			this.starLevel = data.getInt();
			this.experience = data.getInt();
			fateLevelArray = FateLevelArray.create();
			fateLevelArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!skillArray.validate()) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!gradeHandler.validate(grade)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
				return false;
			}
			if (!isMainGeneralHandler.validate(isMainGeneral)) {
				return false;
			}
			if (!talentLevelHandler.validate(talentLevel)) {
				return false;
			}
			if (!wuxingLevelHandler.validate(wuxingLevel)) {
				return false;
			}
			if (!starLevelHandler.validate(starLevel)) {
				return false;
			}
			if (!experienceHandler.validate(experience)) {
				return false;
			}
			if (!fateLevelArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("skillArray:").append(skillArray.toString()).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("grade:").append(this.grade).append(", ");
			bb.append("time:").append(this.time).append(", ");
			bb.append("isMainGeneral:").append(this.isMainGeneral).append(", ");
			bb.append("talentLevel:").append(this.talentLevel).append(", ");
			bb.append("wuxingLevel:").append(this.wuxingLevel).append(", ");
			bb.append("starLevel:").append(this.starLevel).append(", ");
			bb.append("experience:").append(this.experience).append(", ");
			bb.append("fateLevelArray:").append(fateLevelArray.toString());
			return bb.toString();	
		}
	}
}