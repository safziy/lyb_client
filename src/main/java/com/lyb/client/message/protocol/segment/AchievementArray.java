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
public class AchievementArray implements IMessageEncoder {
	private List<AchievementArrayItem> list = new LinkedList<AchievementArrayItem>();

	public List<AchievementArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (AchievementArrayItem item : list) {
			data.writeInt(item.getAchievementId());
			item.getTaskConditionArray().encode(data);
			data.writeInt(item.getBooleanValue());
			data.writeInt(item.getTakeAwardCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			AchievementArrayItem item = AchievementArrayItem.create();
			item.setAchievementId(data.getInt());
			item.setTaskConditionArray(TaskConditionArray.create());
			item.getTaskConditionArray().decode(data);
			item.setBooleanValue(data.getInt());
			item.setTakeAwardCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (AchievementArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static AchievementArray create() {
		AchievementArray array = new AchievementArray();
		return array;
	}

	public static AchievementArrayItem createItem() {
		AchievementArrayItem item = new AchievementArrayItem();
		return item;
	}

	public AchievementArrayItem addData(int achievementId, TaskConditionArray taskConditionArray, int booleanValue, int takeAwardCount) {
		AchievementArrayItem item = new AchievementArrayItem();
		item.setAchievementId(achievementId);
		item.setTaskConditionArray(taskConditionArray);
		item.setBooleanValue(booleanValue);
		item.setTakeAwardCount(takeAwardCount);
		list.add(item);
		return item;
	}

	public void addItem(AchievementArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (AchievementArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class AchievementArrayItem implements IMessageEncoder {
		private int achievementId;
		private TaskConditionArray taskConditionArray;
		private int booleanValue;
		private int takeAwardCount;

		private static IntMessageParameterHandler achievementIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AchievementId");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler takeAwardCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TakeAwardCount");

		public static AchievementArrayItem create() {
			AchievementArrayItem item = new AchievementArrayItem();
			return item;
		}

		/**
		 * @return the achievementId
		 */
		public int getAchievementId() {
			return achievementId;
		}

		/**
		 * @param achievementId
		 *            the achievementId to set
		 */
		public void setAchievementId(int achievementId) {
			this.achievementId = achievementId;
		}
		/**
		 * @return the taskConditionArray
		 */
		public TaskConditionArray getTaskConditionArray() {
			return taskConditionArray;
		}

		/**
		 * @param taskConditionArray
		 *            the taskConditionArray to set
		 */
		public void setTaskConditionArray(TaskConditionArray taskConditionArray) {
			this.taskConditionArray = taskConditionArray;
		}
		/**
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
		}
		/**
		 * @return the takeAwardCount
		 */
		public int getTakeAwardCount() {
			return takeAwardCount;
		}

		/**
		 * @param takeAwardCount
		 *            the takeAwardCount to set
		 */
		public void setTakeAwardCount(int takeAwardCount) {
			this.takeAwardCount = takeAwardCount;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.achievementId);
			taskConditionArray.encode(data);
			data.writeInt(this.booleanValue);
			data.writeInt(this.takeAwardCount);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.achievementId = data.getInt();
			taskConditionArray = TaskConditionArray.create();
			taskConditionArray.decode(data);
			this.booleanValue = data.getInt();
			this.takeAwardCount = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!achievementIdHandler.validate(achievementId)) {
				return false;
			}
			if (!taskConditionArray.validate()) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			if (!takeAwardCountHandler.validate(takeAwardCount)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("achievementId:").append(this.achievementId).append(", ");
			bb.append("taskConditionArray:").append(taskConditionArray.toString()).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("takeAwardCount:").append(this.takeAwardCount);
			return bb.toString();	
		}
	}
}