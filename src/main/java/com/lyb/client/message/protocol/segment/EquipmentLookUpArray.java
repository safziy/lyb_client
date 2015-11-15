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
public class EquipmentLookUpArray implements IMessageEncoder {
	private List<EquipmentLookUpArrayItem> list = new LinkedList<EquipmentLookUpArrayItem>();

	public List<EquipmentLookUpArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (EquipmentLookUpArrayItem item : list) {
			data.writeInt(item.getItemId());
			data.writeInt(item.getStarLevel());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			EquipmentLookUpArrayItem item = EquipmentLookUpArrayItem.create();
			item.setItemId(data.getInt());
			item.setStarLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (EquipmentLookUpArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static EquipmentLookUpArray create() {
		EquipmentLookUpArray array = new EquipmentLookUpArray();
		return array;
	}

	public static EquipmentLookUpArrayItem createItem() {
		EquipmentLookUpArrayItem item = new EquipmentLookUpArrayItem();
		return item;
	}

	public EquipmentLookUpArrayItem addData(int itemId, int starLevel) {
		EquipmentLookUpArrayItem item = new EquipmentLookUpArrayItem();
		item.setItemId(itemId);
		item.setStarLevel(starLevel);
		list.add(item);
		return item;
	}

	public void addItem(EquipmentLookUpArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (EquipmentLookUpArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class EquipmentLookUpArrayItem implements IMessageEncoder {
		private int itemId;
		private int starLevel;

		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");

		public static EquipmentLookUpArrayItem create() {
			EquipmentLookUpArrayItem item = new EquipmentLookUpArrayItem();
			return item;
		}

		/**
		 * @return the itemId
		 */
		public int getItemId() {
			return itemId;
		}

		/**
		 * @param itemId
		 *            the itemId to set
		 */
		public void setItemId(int itemId) {
			this.itemId = itemId;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.itemId);
			data.writeInt(this.starLevel);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.itemId = data.getInt();
			this.starLevel = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!starLevelHandler.validate(starLevel)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("starLevel:").append(this.starLevel);
			return bb.toString();	
		}
	}
}