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
public class FamilyPromotionArray implements IMessageEncoder {
	private List<FamilyPromotionArrayItem> list = new LinkedList<FamilyPromotionArrayItem>();

	public List<FamilyPromotionArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FamilyPromotionArrayItem item : list) {
			data.writeInt(item.getMapId());
			data.writeInt(item.getPromotionPositionId());
			data.writeLong(item.getFamilyId());
			data.writeString(item.getFamilyName());
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
			FamilyPromotionArrayItem item = FamilyPromotionArrayItem.create();
			item.setMapId(data.getInt());
			item.setPromotionPositionId(data.getInt());
			item.setFamilyId(data.getLong());
			item.setFamilyName(data.getString());
			item.setBooleanValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FamilyPromotionArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FamilyPromotionArray create() {
		FamilyPromotionArray array = new FamilyPromotionArray();
		return array;
	}

	public static FamilyPromotionArrayItem createItem() {
		FamilyPromotionArrayItem item = new FamilyPromotionArrayItem();
		return item;
	}

	public FamilyPromotionArrayItem addData(int mapId, int promotionPositionId, long familyId, String familyName, int booleanValue) {
		FamilyPromotionArrayItem item = new FamilyPromotionArrayItem();
		item.setMapId(mapId);
		item.setPromotionPositionId(promotionPositionId);
		item.setFamilyId(familyId);
		item.setFamilyName(familyName);
		item.setBooleanValue(booleanValue);
		list.add(item);
		return item;
	}

	public void addItem(FamilyPromotionArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FamilyPromotionArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FamilyPromotionArrayItem implements IMessageEncoder {
		private int mapId;
		private int promotionPositionId;
		private long familyId;
		private String familyName;
		private int booleanValue;

		private static IntMessageParameterHandler mapIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MapId");
		private static IntMessageParameterHandler promotionPositionIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PromotionPositionId");
		private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static FamilyPromotionArrayItem create() {
			FamilyPromotionArrayItem item = new FamilyPromotionArrayItem();
			return item;
		}

		/**
		 * @return the mapId
		 */
		public int getMapId() {
			return mapId;
		}

		/**
		 * @param mapId
		 *            the mapId to set
		 */
		public void setMapId(int mapId) {
			this.mapId = mapId;
		}
		/**
		 * @return the promotionPositionId
		 */
		public int getPromotionPositionId() {
			return promotionPositionId;
		}

		/**
		 * @param promotionPositionId
		 *            the promotionPositionId to set
		 */
		public void setPromotionPositionId(int promotionPositionId) {
			this.promotionPositionId = promotionPositionId;
		}
		/**
		 * @return the familyId
		 */
		public long getFamilyId() {
			return familyId;
		}

		/**
		 * @param familyId
		 *            the familyId to set
		 */
		public void setFamilyId(long familyId) {
			this.familyId = familyId;
		}
		/**
		 * @return the familyName
		 */
		public String getFamilyName() {
			return familyName;
		}

		/**
		 * @param familyName
		 *            the familyName to set
		 */
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
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
			data.writeInt(this.mapId);
			data.writeInt(this.promotionPositionId);
			data.writeLong(this.familyId);
			data.writeString(this.familyName);
			data.writeInt(this.booleanValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.mapId = data.getInt();
			this.promotionPositionId = data.getInt();
			this.familyId = data.getLong();
			this.familyName = data.getString();
			this.booleanValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!mapIdHandler.validate(mapId)) {
				return false;
			}
			if (!promotionPositionIdHandler.validate(promotionPositionId)) {
				return false;
			}
			if (!familyIdHandler.validate(familyId)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("mapId:").append(this.mapId).append(", ");
			bb.append("promotionPositionId:").append(this.promotionPositionId).append(", ");
			bb.append("familyId:").append(this.familyId).append(", ");
			bb.append("familyName:").append(this.familyName).append(", ");
			bb.append("booleanValue:").append(this.booleanValue);
			return bb.toString();	
		}
	}
}