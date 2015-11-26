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
public class ActivityArray implements IMessageEncoder {
	private List<ActivityArrayItem> list = new LinkedList<ActivityArrayItem>();

	public List<ActivityArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ActivityArrayItem item : list) {
			data.writeInt(item.getType());
			data.writeInt(item.getParam1());
			data.writeInt(item.getParam2());
			data.writeInt(item.getParam3());
			data.writeInt(item.getValue());
			data.writeInt(item.getBeginTime());
			data.writeInt(item.getEndTime());
			data.writeInt(item.getRemainSeconds());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ActivityArrayItem item = ActivityArrayItem.create();
			item.setType(data.getInt());
			item.setParam1(data.getInt());
			item.setParam2(data.getInt());
			item.setParam3(data.getInt());
			item.setValue(data.getInt());
			item.setBeginTime(data.getInt());
			item.setEndTime(data.getInt());
			item.setRemainSeconds(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ActivityArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ActivityArray create() {
		ActivityArray array = new ActivityArray();
		return array;
	}

	public static ActivityArrayItem createItem() {
		ActivityArrayItem item = new ActivityArrayItem();
		return item;
	}

	public ActivityArrayItem addData(int type, int param1, int param2, int param3, int value, int beginTime, int endTime, int remainSeconds) {
		ActivityArrayItem item = new ActivityArrayItem();
		item.setType(type);
		item.setParam1(param1);
		item.setParam2(param2);
		item.setParam3(param3);
		item.setValue(value);
		item.setBeginTime(beginTime);
		item.setEndTime(endTime);
		item.setRemainSeconds(remainSeconds);
		list.add(item);
		return item;
	}

	public void addItem(ActivityArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ActivityArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ActivityArrayItem implements IMessageEncoder {
		private int type;
		private int param1;
		private int param2;
		private int param3;
		private int value;
		private int beginTime;
		private int endTime;
		private int remainSeconds;

		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler param1Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param1");
		private static IntMessageParameterHandler param2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param2");
		private static IntMessageParameterHandler param3Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param3");
		private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");
		private static IntMessageParameterHandler beginTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BeginTime");
		private static IntMessageParameterHandler endTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EndTime");
		private static IntMessageParameterHandler remainSecondsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSeconds");

		public static ActivityArrayItem create() {
			ActivityArrayItem item = new ActivityArrayItem();
			return item;
		}

		/**
		 * @return the type
		 */
		public int getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(int type) {
			this.type = type;
		}
		/**
		 * @return the param1
		 */
		public int getParam1() {
			return param1;
		}

		/**
		 * @param param1
		 *            the param1 to set
		 */
		public void setParam1(int param1) {
			this.param1 = param1;
		}
		/**
		 * @return the param2
		 */
		public int getParam2() {
			return param2;
		}

		/**
		 * @param param2
		 *            the param2 to set
		 */
		public void setParam2(int param2) {
			this.param2 = param2;
		}
		/**
		 * @return the param3
		 */
		public int getParam3() {
			return param3;
		}

		/**
		 * @param param3
		 *            the param3 to set
		 */
		public void setParam3(int param3) {
			this.param3 = param3;
		}
		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}
		/**
		 * @return the beginTime
		 */
		public int getBeginTime() {
			return beginTime;
		}

		/**
		 * @param beginTime
		 *            the beginTime to set
		 */
		public void setBeginTime(int beginTime) {
			this.beginTime = beginTime;
		}
		/**
		 * @return the endTime
		 */
		public int getEndTime() {
			return endTime;
		}

		/**
		 * @param endTime
		 *            the endTime to set
		 */
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		/**
		 * @return the remainSeconds
		 */
		public int getRemainSeconds() {
			return remainSeconds;
		}

		/**
		 * @param remainSeconds
		 *            the remainSeconds to set
		 */
		public void setRemainSeconds(int remainSeconds) {
			this.remainSeconds = remainSeconds;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.type);
			data.writeInt(this.param1);
			data.writeInt(this.param2);
			data.writeInt(this.param3);
			data.writeInt(this.value);
			data.writeInt(this.beginTime);
			data.writeInt(this.endTime);
			data.writeInt(this.remainSeconds);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.type = data.getInt();
			this.param1 = data.getInt();
			this.param2 = data.getInt();
			this.param3 = data.getInt();
			this.value = data.getInt();
			this.beginTime = data.getInt();
			this.endTime = data.getInt();
			this.remainSeconds = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!typeHandler.validate(type)) {
				return false;
			}
			if (!param1Handler.validate(param1)) {
				return false;
			}
			if (!param2Handler.validate(param2)) {
				return false;
			}
			if (!param3Handler.validate(param3)) {
				return false;
			}
			if (!valueHandler.validate(value)) {
				return false;
			}
			if (!beginTimeHandler.validate(beginTime)) {
				return false;
			}
			if (!endTimeHandler.validate(endTime)) {
				return false;
			}
			if (!remainSecondsHandler.validate(remainSeconds)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("type:").append(this.type).append(", ");
			bb.append("param1:").append(this.param1).append(", ");
			bb.append("param2:").append(this.param2).append(", ");
			bb.append("param3:").append(this.param3).append(", ");
			bb.append("value:").append(this.value).append(", ");
			bb.append("beginTime:").append(this.beginTime).append(", ");
			bb.append("endTime:").append(this.endTime).append(", ");
			bb.append("remainSeconds:").append(this.remainSeconds);
			return bb.toString();	
		}
	}
}