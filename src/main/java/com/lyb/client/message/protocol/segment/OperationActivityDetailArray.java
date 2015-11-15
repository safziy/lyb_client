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
public class OperationActivityDetailArray implements IMessageEncoder {
	private List<OperationActivityDetailArrayItem> list = new LinkedList<OperationActivityDetailArrayItem>();

	public List<OperationActivityDetailArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (OperationActivityDetailArrayItem item : list) {
			data.writeLong(item.getID());
			item.getActivityConditionArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			OperationActivityDetailArrayItem item = OperationActivityDetailArrayItem.create();
			item.setID(data.getLong());
			item.setActivityConditionArray(ActivityConditionArray.create());
			item.getActivityConditionArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (OperationActivityDetailArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static OperationActivityDetailArray create() {
		OperationActivityDetailArray array = new OperationActivityDetailArray();
		return array;
	}

	public static OperationActivityDetailArrayItem createItem() {
		OperationActivityDetailArrayItem item = new OperationActivityDetailArrayItem();
		return item;
	}

	public OperationActivityDetailArrayItem addData(long iD, ActivityConditionArray activityConditionArray) {
		OperationActivityDetailArrayItem item = new OperationActivityDetailArrayItem();
		item.setID(iD);
		item.setActivityConditionArray(activityConditionArray);
		list.add(item);
		return item;
	}

	public void addItem(OperationActivityDetailArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (OperationActivityDetailArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class OperationActivityDetailArrayItem implements IMessageEncoder {
		private long iD;
		private ActivityConditionArray activityConditionArray;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");

		public static OperationActivityDetailArrayItem create() {
			OperationActivityDetailArrayItem item = new OperationActivityDetailArrayItem();
			return item;
		}

		/**
		 * @return the iD
		 */
		public long getID() {
			return iD;
		}

		/**
		 * @param iD
		 *            the iD to set
		 */
		public void setID(long iD) {
			this.iD = iD;
		}
		/**
		 * @return the activityConditionArray
		 */
		public ActivityConditionArray getActivityConditionArray() {
			return activityConditionArray;
		}

		/**
		 * @param activityConditionArray
		 *            the activityConditionArray to set
		 */
		public void setActivityConditionArray(ActivityConditionArray activityConditionArray) {
			this.activityConditionArray = activityConditionArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			activityConditionArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			activityConditionArray = ActivityConditionArray.create();
			activityConditionArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!activityConditionArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("activityConditionArray:").append(activityConditionArray.toString());
			return bb.toString();	
		}
	}
}