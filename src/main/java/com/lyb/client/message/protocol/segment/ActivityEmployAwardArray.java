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
public class ActivityEmployAwardArray implements IMessageEncoder {
	private List<ActivityEmployAwardArrayItem> list = new LinkedList<ActivityEmployAwardArrayItem>();

	public List<ActivityEmployAwardArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ActivityEmployAwardArrayItem item : list) {
			data.writeString(item.getParamStr1());
			item.getItemIdArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ActivityEmployAwardArrayItem item = ActivityEmployAwardArrayItem.create();
			item.setParamStr1(data.getString());
			item.setItemIdArray(ItemIdArray.create());
			item.getItemIdArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ActivityEmployAwardArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ActivityEmployAwardArray create() {
		ActivityEmployAwardArray array = new ActivityEmployAwardArray();
		return array;
	}

	public static ActivityEmployAwardArrayItem createItem() {
		ActivityEmployAwardArrayItem item = new ActivityEmployAwardArrayItem();
		return item;
	}

	public ActivityEmployAwardArrayItem addData(String paramStr1, ItemIdArray itemIdArray) {
		ActivityEmployAwardArrayItem item = new ActivityEmployAwardArrayItem();
		item.setParamStr1(paramStr1);
		item.setItemIdArray(itemIdArray);
		list.add(item);
		return item;
	}

	public void addItem(ActivityEmployAwardArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ActivityEmployAwardArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ActivityEmployAwardArrayItem implements IMessageEncoder {
		private String paramStr1;
		private ItemIdArray itemIdArray;


		public static ActivityEmployAwardArrayItem create() {
			ActivityEmployAwardArrayItem item = new ActivityEmployAwardArrayItem();
			return item;
		}

		/**
		 * @return the paramStr1
		 */
		public String getParamStr1() {
			return paramStr1;
		}

		/**
		 * @param paramStr1
		 *            the paramStr1 to set
		 */
		public void setParamStr1(String paramStr1) {
			this.paramStr1 = paramStr1;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.paramStr1);
			itemIdArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.paramStr1 = data.getString();
			itemIdArray = ItemIdArray.create();
			itemIdArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!itemIdArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("paramStr1:").append(this.paramStr1).append(", ");
			bb.append("itemIdArray:").append(itemIdArray.toString());
			return bb.toString();	
		}
	}
}