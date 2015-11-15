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
public class TaskConditionArray implements IMessageEncoder {
	private List<TaskConditionArrayItem> list = new LinkedList<TaskConditionArrayItem>();

	public List<TaskConditionArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TaskConditionArrayItem item : list) {
			data.writeString(item.getConditionUUID());
			data.writeInt(item.getCount());
			data.writeInt(item.getMaxCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			TaskConditionArrayItem item = TaskConditionArrayItem.create();
			item.setConditionUUID(data.getString());
			item.setCount(data.getInt());
			item.setMaxCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TaskConditionArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TaskConditionArray create() {
		TaskConditionArray array = new TaskConditionArray();
		return array;
	}

	public static TaskConditionArrayItem createItem() {
		TaskConditionArrayItem item = new TaskConditionArrayItem();
		return item;
	}

	public TaskConditionArrayItem addData(String conditionUUID, int count, int maxCount) {
		TaskConditionArrayItem item = new TaskConditionArrayItem();
		item.setConditionUUID(conditionUUID);
		item.setCount(count);
		item.setMaxCount(maxCount);
		list.add(item);
		return item;
	}

	public void addItem(TaskConditionArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TaskConditionArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TaskConditionArrayItem implements IMessageEncoder {
		private String conditionUUID;
		private int count;
		private int maxCount;

		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler maxCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MaxCount");

		public static TaskConditionArrayItem create() {
			TaskConditionArrayItem item = new TaskConditionArrayItem();
			return item;
		}

		/**
		 * @return the conditionUUID
		 */
		public String getConditionUUID() {
			return conditionUUID;
		}

		/**
		 * @param conditionUUID
		 *            the conditionUUID to set
		 */
		public void setConditionUUID(String conditionUUID) {
			this.conditionUUID = conditionUUID;
		}
		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}

		/**
		 * @param count
		 *            the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}
		/**
		 * @return the maxCount
		 */
		public int getMaxCount() {
			return maxCount;
		}

		/**
		 * @param maxCount
		 *            the maxCount to set
		 */
		public void setMaxCount(int maxCount) {
			this.maxCount = maxCount;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.conditionUUID);
			data.writeInt(this.count);
			data.writeInt(this.maxCount);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.conditionUUID = data.getString();
			this.count = data.getInt();
			this.maxCount = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!maxCountHandler.validate(maxCount)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("conditionUUID:").append(this.conditionUUID).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("maxCount:").append(this.maxCount);
			return bb.toString();	
		}
	}
}