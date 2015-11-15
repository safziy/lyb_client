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
public class ActivityConditionArray implements IMessageEncoder {
	private List<ActivityConditionArrayItem> list = new LinkedList<ActivityConditionArrayItem>();

	public List<ActivityConditionArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ActivityConditionArrayItem item : list) {
			data.writeInt(item.getConditionID());
			item.getItemIdArray().encode(data);
			data.writeInt(item.getCount());
			data.writeInt(item.getMaxCount());
			data.writeInt(item.getBooleanValue());
			data.writeInt(item.getType());
			data.writeInt(item.getParam1());
			data.writeInt(item.getParam2());
			data.writeInt(item.getParam3());
			data.writeInt(item.getGroup());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ActivityConditionArrayItem item = ActivityConditionArrayItem.create();
			item.setConditionID(data.getInt());
			item.setItemIdArray(ItemIdArray.create());
			item.getItemIdArray().decode(data);
			item.setCount(data.getInt());
			item.setMaxCount(data.getInt());
			item.setBooleanValue(data.getInt());
			item.setType(data.getInt());
			item.setParam1(data.getInt());
			item.setParam2(data.getInt());
			item.setParam3(data.getInt());
			item.setGroup(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ActivityConditionArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ActivityConditionArray create() {
		ActivityConditionArray array = new ActivityConditionArray();
		return array;
	}

	public static ActivityConditionArrayItem createItem() {
		ActivityConditionArrayItem item = new ActivityConditionArrayItem();
		return item;
	}

	public ActivityConditionArrayItem addData(int conditionID, ItemIdArray itemIdArray, int count, int maxCount, int booleanValue, int type, int param1, int param2, int param3, int group) {
		ActivityConditionArrayItem item = new ActivityConditionArrayItem();
		item.setConditionID(conditionID);
		item.setItemIdArray(itemIdArray);
		item.setCount(count);
		item.setMaxCount(maxCount);
		item.setBooleanValue(booleanValue);
		item.setType(type);
		item.setParam1(param1);
		item.setParam2(param2);
		item.setParam3(param3);
		item.setGroup(group);
		list.add(item);
		return item;
	}

	public void addItem(ActivityConditionArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ActivityConditionArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ActivityConditionArrayItem implements IMessageEncoder {
		private int conditionID;
		private ItemIdArray itemIdArray;
		private int count;
		private int maxCount;
		private int booleanValue;
		private int type;
		private int param1;
		private int param2;
		private int param3;
		private int group;

		private static IntMessageParameterHandler conditionIDHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConditionID");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler maxCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MaxCount");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler param1Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param1");
		private static IntMessageParameterHandler param2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param2");
		private static IntMessageParameterHandler param3Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param3");
		private static IntMessageParameterHandler groupHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Group");

		public static ActivityConditionArrayItem create() {
			ActivityConditionArrayItem item = new ActivityConditionArrayItem();
			return item;
		}

		/**
		 * @return the conditionID
		 */
		public int getConditionID() {
			return conditionID;
		}

		/**
		 * @param conditionID
		 *            the conditionID to set
		 */
		public void setConditionID(int conditionID) {
			this.conditionID = conditionID;
		}
		/**
		 * @return the itemIdArray
		 */
		public ItemIdArray getItemIdArray() {
			return itemIdArray;
		}

		/**
		 * @param itemIdArray
		 *            the itemIdArray to set
		 */
		public void setItemIdArray(ItemIdArray itemIdArray) {
			this.itemIdArray = itemIdArray;
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
		 * @return the group
		 */
		public int getGroup() {
			return group;
		}

		/**
		 * @param group
		 *            the group to set
		 */
		public void setGroup(int group) {
			this.group = group;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.conditionID);
			itemIdArray.encode(data);
			data.writeInt(this.count);
			data.writeInt(this.maxCount);
			data.writeInt(this.booleanValue);
			data.writeInt(this.type);
			data.writeInt(this.param1);
			data.writeInt(this.param2);
			data.writeInt(this.param3);
			data.writeInt(this.group);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.conditionID = data.getInt();
			itemIdArray = ItemIdArray.create();
			itemIdArray.decode(data);
			this.count = data.getInt();
			this.maxCount = data.getInt();
			this.booleanValue = data.getInt();
			this.type = data.getInt();
			this.param1 = data.getInt();
			this.param2 = data.getInt();
			this.param3 = data.getInt();
			this.group = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!conditionIDHandler.validate(conditionID)) {
				return false;
			}
			if (!itemIdArray.validate()) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!maxCountHandler.validate(maxCount)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
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
			if (!groupHandler.validate(group)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("conditionID:").append(this.conditionID).append(", ");
			bb.append("itemIdArray:").append(itemIdArray.toString()).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("maxCount:").append(this.maxCount).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("type:").append(this.type).append(", ");
			bb.append("param1:").append(this.param1).append(", ");
			bb.append("param2:").append(this.param2).append(", ");
			bb.append("param3:").append(this.param3).append(", ");
			bb.append("group:").append(this.group);
			return bb.toString();	
		}
	}
}