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
public class StrengthenHistoryArray implements IMessageEncoder {
	private List<StrengthenHistoryArrayItem> list = new LinkedList<StrengthenHistoryArrayItem>();

	public List<StrengthenHistoryArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (StrengthenHistoryArrayItem item : list) {
			data.writeInt(item.getStrengthenLevel());
			item.getStrengthenPropertyArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			StrengthenHistoryArrayItem item = StrengthenHistoryArrayItem.create();
			item.setStrengthenLevel(data.getInt());
			item.setStrengthenPropertyArray(StrengthenPropertyArray.create());
			item.getStrengthenPropertyArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (StrengthenHistoryArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static StrengthenHistoryArray create() {
		StrengthenHistoryArray array = new StrengthenHistoryArray();
		return array;
	}

	public static StrengthenHistoryArrayItem createItem() {
		StrengthenHistoryArrayItem item = new StrengthenHistoryArrayItem();
		return item;
	}

	public StrengthenHistoryArrayItem addData(int strengthenLevel, StrengthenPropertyArray strengthenPropertyArray) {
		StrengthenHistoryArrayItem item = new StrengthenHistoryArrayItem();
		item.setStrengthenLevel(strengthenLevel);
		item.setStrengthenPropertyArray(strengthenPropertyArray);
		list.add(item);
		return item;
	}

	public void addItem(StrengthenHistoryArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (StrengthenHistoryArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class StrengthenHistoryArrayItem implements IMessageEncoder {
		private int strengthenLevel;
		private StrengthenPropertyArray strengthenPropertyArray;

		private static IntMessageParameterHandler strengthenLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrengthenLevel");

		public static StrengthenHistoryArrayItem create() {
			StrengthenHistoryArrayItem item = new StrengthenHistoryArrayItem();
			return item;
		}

		/**
		 * @return the strengthenLevel
		 */
		public int getStrengthenLevel() {
			return strengthenLevel;
		}

		/**
		 * @param strengthenLevel
		 *            the strengthenLevel to set
		 */
		public void setStrengthenLevel(int strengthenLevel) {
			this.strengthenLevel = strengthenLevel;
		}
		/**
		 * @return the strengthenPropertyArray
		 */
		public StrengthenPropertyArray getStrengthenPropertyArray() {
			return strengthenPropertyArray;
		}

		/**
		 * @param strengthenPropertyArray
		 *            the strengthenPropertyArray to set
		 */
		public void setStrengthenPropertyArray(StrengthenPropertyArray strengthenPropertyArray) {
			this.strengthenPropertyArray = strengthenPropertyArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.strengthenLevel);
			strengthenPropertyArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.strengthenLevel = data.getInt();
			strengthenPropertyArray = StrengthenPropertyArray.create();
			strengthenPropertyArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!strengthenLevelHandler.validate(strengthenLevel)) {
				return false;
			}
			if (!strengthenPropertyArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("strengthenLevel:").append(this.strengthenLevel).append(", ");
			bb.append("strengthenPropertyArray:").append(strengthenPropertyArray.toString());
			return bb.toString();	
		}
	}
}