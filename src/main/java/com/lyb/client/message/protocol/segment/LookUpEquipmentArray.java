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
public class LookUpEquipmentArray implements IMessageEncoder {
	private List<LookUpEquipmentArrayItem> list = new LinkedList<LookUpEquipmentArrayItem>();

	public List<LookUpEquipmentArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (LookUpEquipmentArrayItem item : list) {
			data.writeInt(item.getEquipmentPlaceId());
			data.writeInt(item.getItemId());
			data.writeInt(item.getUserEquipmentId());
			data.writeInt(item.getStarLevel());
			data.writeInt(item.getZhanli());
			item.getPropertyArray().encode(data);
			data.writeInt(item.getStrengthenLevel());
			data.writeInt(item.getStrengthenValue());
			data.writeInt(item.getPreStrengthenValue());
			item.getHoleArray().encode(data);
			item.getLineArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			LookUpEquipmentArrayItem item = LookUpEquipmentArrayItem.create();
			item.setEquipmentPlaceId(data.getInt());
			item.setItemId(data.getInt());
			item.setUserEquipmentId(data.getInt());
			item.setStarLevel(data.getInt());
			item.setZhanli(data.getInt());
			item.setPropertyArray(PropertyArray.create());
			item.getPropertyArray().decode(data);
			item.setStrengthenLevel(data.getInt());
			item.setStrengthenValue(data.getInt());
			item.setPreStrengthenValue(data.getInt());
			item.setHoleArray(HoleArray.create());
			item.getHoleArray().decode(data);
			item.setLineArray(LineArray.create());
			item.getLineArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (LookUpEquipmentArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static LookUpEquipmentArray create() {
		LookUpEquipmentArray array = new LookUpEquipmentArray();
		return array;
	}

	public static LookUpEquipmentArrayItem createItem() {
		LookUpEquipmentArrayItem item = new LookUpEquipmentArrayItem();
		return item;
	}

	public LookUpEquipmentArrayItem addData(int equipmentPlaceId, int itemId, int userEquipmentId, int starLevel, int zhanli, PropertyArray propertyArray, int strengthenLevel, int strengthenValue, int preStrengthenValue, HoleArray holeArray, LineArray lineArray) {
		LookUpEquipmentArrayItem item = new LookUpEquipmentArrayItem();
		item.setEquipmentPlaceId(equipmentPlaceId);
		item.setItemId(itemId);
		item.setUserEquipmentId(userEquipmentId);
		item.setStarLevel(starLevel);
		item.setZhanli(zhanli);
		item.setPropertyArray(propertyArray);
		item.setStrengthenLevel(strengthenLevel);
		item.setStrengthenValue(strengthenValue);
		item.setPreStrengthenValue(preStrengthenValue);
		item.setHoleArray(holeArray);
		item.setLineArray(lineArray);
		list.add(item);
		return item;
	}

	public void addItem(LookUpEquipmentArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (LookUpEquipmentArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class LookUpEquipmentArrayItem implements IMessageEncoder {
		private int equipmentPlaceId;
		private int itemId;
		private int userEquipmentId;
		private int starLevel;
		private int zhanli;
		private PropertyArray propertyArray;
		private int strengthenLevel;
		private int strengthenValue;
		private int preStrengthenValue;
		private HoleArray holeArray;
		private LineArray lineArray;

		private static IntMessageParameterHandler equipmentPlaceIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EquipmentPlaceId");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler userEquipmentIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("UserEquipmentId");
		private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
		private static IntMessageParameterHandler strengthenLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrengthenLevel");
		private static IntMessageParameterHandler strengthenValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrengthenValue");
		private static IntMessageParameterHandler preStrengthenValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PreStrengthenValue");

		public static LookUpEquipmentArrayItem create() {
			LookUpEquipmentArrayItem item = new LookUpEquipmentArrayItem();
			return item;
		}

		/**
		 * @return the equipmentPlaceId
		 */
		public int getEquipmentPlaceId() {
			return equipmentPlaceId;
		}

		/**
		 * @param equipmentPlaceId
		 *            the equipmentPlaceId to set
		 */
		public void setEquipmentPlaceId(int equipmentPlaceId) {
			this.equipmentPlaceId = equipmentPlaceId;
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
		 * @return the userEquipmentId
		 */
		public int getUserEquipmentId() {
			return userEquipmentId;
		}

		/**
		 * @param userEquipmentId
		 *            the userEquipmentId to set
		 */
		public void setUserEquipmentId(int userEquipmentId) {
			this.userEquipmentId = userEquipmentId;
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
		 * @return the zhanli
		 */
		public int getZhanli() {
			return zhanli;
		}

		/**
		 * @param zhanli
		 *            the zhanli to set
		 */
		public void setZhanli(int zhanli) {
			this.zhanli = zhanli;
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
		 * @return the strengthenValue
		 */
		public int getStrengthenValue() {
			return strengthenValue;
		}

		/**
		 * @param strengthenValue
		 *            the strengthenValue to set
		 */
		public void setStrengthenValue(int strengthenValue) {
			this.strengthenValue = strengthenValue;
		}
		/**
		 * @return the preStrengthenValue
		 */
		public int getPreStrengthenValue() {
			return preStrengthenValue;
		}

		/**
		 * @param preStrengthenValue
		 *            the preStrengthenValue to set
		 */
		public void setPreStrengthenValue(int preStrengthenValue) {
			this.preStrengthenValue = preStrengthenValue;
		}
		/**
		 * @return the holeArray
		 */
		public HoleArray getHoleArray() {
			return holeArray;
		}

		/**
		 * @param holeArray
		 *            the holeArray to set
		 */
		public void setHoleArray(HoleArray holeArray) {
			this.holeArray = holeArray;
		}
		/**
		 * @return the lineArray
		 */
		public LineArray getLineArray() {
			return lineArray;
		}

		/**
		 * @param lineArray
		 *            the lineArray to set
		 */
		public void setLineArray(LineArray lineArray) {
			this.lineArray = lineArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.equipmentPlaceId);
			data.writeInt(this.itemId);
			data.writeInt(this.userEquipmentId);
			data.writeInt(this.starLevel);
			data.writeInt(this.zhanli);
			propertyArray.encode(data);
			data.writeInt(this.strengthenLevel);
			data.writeInt(this.strengthenValue);
			data.writeInt(this.preStrengthenValue);
			holeArray.encode(data);
			lineArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.equipmentPlaceId = data.getInt();
			this.itemId = data.getInt();
			this.userEquipmentId = data.getInt();
			this.starLevel = data.getInt();
			this.zhanli = data.getInt();
			propertyArray = PropertyArray.create();
			propertyArray.decode(data);
			this.strengthenLevel = data.getInt();
			this.strengthenValue = data.getInt();
			this.preStrengthenValue = data.getInt();
			holeArray = HoleArray.create();
			holeArray.decode(data);
			lineArray = LineArray.create();
			lineArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!equipmentPlaceIdHandler.validate(equipmentPlaceId)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!userEquipmentIdHandler.validate(userEquipmentId)) {
				return false;
			}
			if (!starLevelHandler.validate(starLevel)) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			if (!propertyArray.validate()) {
				return false;
			}
			if (!strengthenLevelHandler.validate(strengthenLevel)) {
				return false;
			}
			if (!strengthenValueHandler.validate(strengthenValue)) {
				return false;
			}
			if (!preStrengthenValueHandler.validate(preStrengthenValue)) {
				return false;
			}
			if (!holeArray.validate()) {
				return false;
			}
			if (!lineArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("equipmentPlaceId:").append(this.equipmentPlaceId).append(", ");
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("userEquipmentId:").append(this.userEquipmentId).append(", ");
			bb.append("starLevel:").append(this.starLevel).append(", ");
			bb.append("zhanli:").append(this.zhanli).append(", ");
			bb.append("propertyArray:").append(propertyArray.toString()).append(", ");
			bb.append("strengthenLevel:").append(this.strengthenLevel).append(", ");
			bb.append("strengthenValue:").append(this.strengthenValue).append(", ");
			bb.append("preStrengthenValue:").append(this.preStrengthenValue).append(", ");
			bb.append("holeArray:").append(holeArray.toString()).append(", ");
			bb.append("lineArray:").append(lineArray.toString());
			return bb.toString();	
		}
	}
}