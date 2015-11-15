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
public class RankGeneralArray implements IMessageEncoder {
	private List<RankGeneralArrayItem> list = new LinkedList<RankGeneralArrayItem>();

	public List<RankGeneralArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (RankGeneralArrayItem item : list) {
			data.writeInt(item.getConfigId());
			data.writeInt(item.getGrade());
			data.writeInt(item.getStarLevel());
			data.writeInt(item.getLevel());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			RankGeneralArrayItem item = RankGeneralArrayItem.create();
			item.setConfigId(data.getInt());
			item.setGrade(data.getInt());
			item.setStarLevel(data.getInt());
			item.setLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (RankGeneralArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static RankGeneralArray create() {
		RankGeneralArray array = new RankGeneralArray();
		return array;
	}

	public static RankGeneralArrayItem createItem() {
		RankGeneralArrayItem item = new RankGeneralArrayItem();
		return item;
	}

	public RankGeneralArrayItem addData(int configId, int grade, int starLevel, int level) {
		RankGeneralArrayItem item = new RankGeneralArrayItem();
		item.setConfigId(configId);
		item.setGrade(grade);
		item.setStarLevel(starLevel);
		item.setLevel(level);
		list.add(item);
		return item;
	}

	public void addItem(RankGeneralArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (RankGeneralArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class RankGeneralArrayItem implements IMessageEncoder {
		private int configId;
		private int grade;
		private int starLevel;
		private int level;

		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler gradeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Grade");
		private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");

		public static RankGeneralArrayItem create() {
			RankGeneralArrayItem item = new RankGeneralArrayItem();
			return item;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.configId);
			data.writeInt(this.grade);
			data.writeInt(this.starLevel);
			data.writeInt(this.level);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.configId = data.getInt();
			this.grade = data.getInt();
			this.starLevel = data.getInt();
			this.level = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!gradeHandler.validate(grade)) {
				return false;
			}
			if (!starLevelHandler.validate(starLevel)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("grade:").append(this.grade).append(", ");
			bb.append("starLevel:").append(this.starLevel).append(", ");
			bb.append("level:").append(this.level);
			return bb.toString();	
		}
	}
}