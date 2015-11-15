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
public class ActivityInfoArray implements IMessageEncoder {
	private List<ActivityInfoArrayItem> list = new LinkedList<ActivityInfoArrayItem>();

	public List<ActivityInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ActivityInfoArrayItem item : list) {
			data.writeInt(item.getConfigId());
			data.writeInt(item.getRemainSecondsBegin());
			data.writeInt(item.getRemainSecondsEnd());
			data.writeInt(item.getBooleanValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ActivityInfoArrayItem item = ActivityInfoArrayItem.create();
			item.setConfigId(data.getInt());
			item.setRemainSecondsBegin(data.getInt());
			item.setRemainSecondsEnd(data.getInt());
			item.setBooleanValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ActivityInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ActivityInfoArray create() {
		ActivityInfoArray array = new ActivityInfoArray();
		return array;
	}

	public static ActivityInfoArrayItem createItem() {
		ActivityInfoArrayItem item = new ActivityInfoArrayItem();
		return item;
	}

	public ActivityInfoArrayItem addData(int configId, int remainSecondsBegin, int remainSecondsEnd, int booleanValue) {
		ActivityInfoArrayItem item = new ActivityInfoArrayItem();
		item.setConfigId(configId);
		item.setRemainSecondsBegin(remainSecondsBegin);
		item.setRemainSecondsEnd(remainSecondsEnd);
		item.setBooleanValue(booleanValue);
		list.add(item);
		return item;
	}

	public void addItem(ActivityInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ActivityInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ActivityInfoArrayItem implements IMessageEncoder {
		private int configId;
		private int remainSecondsBegin;
		private int remainSecondsEnd;
		private int booleanValue;

		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler remainSecondsBeginHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSecondsBegin");
		private static IntMessageParameterHandler remainSecondsEndHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSecondsEnd");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static ActivityInfoArrayItem create() {
			ActivityInfoArrayItem item = new ActivityInfoArrayItem();
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
		 * @return the remainSecondsBegin
		 */
		public int getRemainSecondsBegin() {
			return remainSecondsBegin;
		}

		/**
		 * @param remainSecondsBegin
		 *            the remainSecondsBegin to set
		 */
		public void setRemainSecondsBegin(int remainSecondsBegin) {
			this.remainSecondsBegin = remainSecondsBegin;
		}
		/**
		 * @return the remainSecondsEnd
		 */
		public int getRemainSecondsEnd() {
			return remainSecondsEnd;
		}

		/**
		 * @param remainSecondsEnd
		 *            the remainSecondsEnd to set
		 */
		public void setRemainSecondsEnd(int remainSecondsEnd) {
			this.remainSecondsEnd = remainSecondsEnd;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.configId);
			data.writeInt(this.remainSecondsBegin);
			data.writeInt(this.remainSecondsEnd);
			data.writeInt(this.booleanValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.configId = data.getInt();
			this.remainSecondsBegin = data.getInt();
			this.remainSecondsEnd = data.getInt();
			this.booleanValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!remainSecondsBeginHandler.validate(remainSecondsBegin)) {
				return false;
			}
			if (!remainSecondsEndHandler.validate(remainSecondsEnd)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("remainSecondsBegin:").append(this.remainSecondsBegin).append(", ");
			bb.append("remainSecondsEnd:").append(this.remainSecondsEnd).append(", ");
			bb.append("booleanValue:").append(this.booleanValue);
			return bb.toString();	
		}
	}
}