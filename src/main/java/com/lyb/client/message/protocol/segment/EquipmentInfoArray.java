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
public class EquipmentInfoArray implements IMessageEncoder {
	private List<EquipmentInfoArrayItem> list = new LinkedList<EquipmentInfoArrayItem>();

	public List<EquipmentInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (EquipmentInfoArrayItem item : list) {
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getItemId());
			data.writeInt(item.getStrengthenLevel());
			item.getPropertyArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			EquipmentInfoArrayItem item = EquipmentInfoArrayItem.create();
			item.setGeneralId(data.getLong());
			item.setItemId(data.getInt());
			item.setStrengthenLevel(data.getInt());
			item.setPropertyArray(PropertyArray.create());
			item.getPropertyArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (EquipmentInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static EquipmentInfoArray create() {
		EquipmentInfoArray array = new EquipmentInfoArray();
		return array;
	}

	public static EquipmentInfoArrayItem createItem() {
		EquipmentInfoArrayItem item = new EquipmentInfoArrayItem();
		return item;
	}

	public EquipmentInfoArrayItem addData(long generalId, int itemId, int strengthenLevel, PropertyArray propertyArray) {
		EquipmentInfoArrayItem item = new EquipmentInfoArrayItem();
		item.setGeneralId(generalId);
		item.setItemId(itemId);
		item.setStrengthenLevel(strengthenLevel);
		item.setPropertyArray(propertyArray);
		list.add(item);
		return item;
	}

	public void addItem(EquipmentInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (EquipmentInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class EquipmentInfoArrayItem implements IMessageEncoder {
		private long generalId;
		private int itemId;
		private int strengthenLevel;
		private PropertyArray propertyArray;

		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler strengthenLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrengthenLevel");

		public static EquipmentInfoArrayItem create() {
			EquipmentInfoArrayItem item = new EquipmentInfoArrayItem();
			return item;
		}

		/**
		 * @return the generalId
		 */
		public long getGeneralId() {
			return generalId;
		}

		/**
		 * @param generalId
		 *            the generalId to set
		 */
		public void setGeneralId(long generalId) {
			this.generalId = generalId;
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
		 * @return the propertyArray
		 */
		public PropertyArray getPropertyArray() {
			return propertyArray;
		}

		/**
		 * @param propertyArray
		 *            the propertyArray to set
		 */
		public void setPropertyArray(PropertyArray propertyArray) {
			this.propertyArray = propertyArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.generalId);
			data.writeInt(this.itemId);
			data.writeInt(this.strengthenLevel);
			propertyArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalId = data.getLong();
			this.itemId = data.getInt();
			this.strengthenLevel = data.getInt();
			propertyArray = PropertyArray.create();
			propertyArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!strengthenLevelHandler.validate(strengthenLevel)) {
				return false;
			}
			if (!propertyArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("strengthenLevel:").append(this.strengthenLevel).append(", ");
			bb.append("propertyArray:").append(propertyArray.toString());
			return bb.toString();	
		}
	}
}