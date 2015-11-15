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
public class FamilyTaskCountArray implements IMessageEncoder {
	private List<FamilyTaskCountArrayItem> list = new LinkedList<FamilyTaskCountArrayItem>();

	public List<FamilyTaskCountArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FamilyTaskCountArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeInt(item.getTaskId());
			data.writeInt(item.getCurrentCount());
			data.writeInt(item.getMaxCount());
			data.writeInt(item.getCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FamilyTaskCountArrayItem item = FamilyTaskCountArrayItem.create();
			item.setPlace(data.getInt());
			item.setTaskId(data.getInt());
			item.setCurrentCount(data.getInt());
			item.setMaxCount(data.getInt());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FamilyTaskCountArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FamilyTaskCountArray create() {
		FamilyTaskCountArray array = new FamilyTaskCountArray();
		return array;
	}

	public static FamilyTaskCountArrayItem createItem() {
		FamilyTaskCountArrayItem item = new FamilyTaskCountArrayItem();
		return item;
	}

	public FamilyTaskCountArrayItem addData(int place, int taskId, int currentCount, int maxCount, int count) {
		FamilyTaskCountArrayItem item = new FamilyTaskCountArrayItem();
		item.setPlace(place);
		item.setTaskId(taskId);
		item.setCurrentCount(currentCount);
		item.setMaxCount(maxCount);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(FamilyTaskCountArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FamilyTaskCountArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FamilyTaskCountArrayItem implements IMessageEncoder {
		private int place;
		private int taskId;
		private int currentCount;
		private int maxCount;
		private int count;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler taskIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TaskId");
		private static IntMessageParameterHandler currentCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentCount");
		private static IntMessageParameterHandler maxCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MaxCount");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static FamilyTaskCountArrayItem create() {
			FamilyTaskCountArrayItem item = new FamilyTaskCountArrayItem();
			return item;
		}

		/**
		 * @return the place
		 */
		public int getPlace() {
			return place;
		}

		/**
		 * @param place
		 *            the place to set
		 */
		public void setPlace(int place) {
			this.place = place;
		}
		/**
		 * @return the taskId
		 */
		public int getTaskId() {
			return taskId;
		}

		/**
		 * @param taskId
		 *            the taskId to set
		 */
		public void setTaskId(int taskId) {
			this.taskId = taskId;
		}
		/**
		 * @return the currentCount
		 */
		public int getCurrentCount() {
			return currentCount;
		}

		/**
		 * @param currentCount
		 *            the currentCount to set
		 */
		public void setCurrentCount(int currentCount) {
			this.currentCount = currentCount;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeInt(this.taskId);
			data.writeInt(this.currentCount);
			data.writeInt(this.maxCount);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.taskId = data.getInt();
			this.currentCount = data.getInt();
			this.maxCount = data.getInt();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!taskIdHandler.validate(taskId)) {
				return false;
			}
			if (!currentCountHandler.validate(currentCount)) {
				return false;
			}
			if (!maxCountHandler.validate(maxCount)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("taskId:").append(this.taskId).append(", ");
			bb.append("currentCount:").append(this.currentCount).append(", ");
			bb.append("maxCount:").append(this.maxCount).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}