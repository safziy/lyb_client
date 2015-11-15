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
public class MapInfoArray implements IMessageEncoder {
	private List<MapInfoArrayItem> list = new LinkedList<MapInfoArrayItem>();

	public List<MapInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (MapInfoArrayItem item : list) {
			data.writeInt(item.getMapId());
			data.writeInt(item.getCount());
			data.writeInt(item.getBooleanValue());
			data.writeInt(item.getBooleanValue2());
			data.writeLong(item.getFamilyId());
			data.writeString(item.getFamilyName());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			MapInfoArrayItem item = MapInfoArrayItem.create();
			item.setMapId(data.getInt());
			item.setCount(data.getInt());
			item.setBooleanValue(data.getInt());
			item.setBooleanValue2(data.getInt());
			item.setFamilyId(data.getLong());
			item.setFamilyName(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (MapInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static MapInfoArray create() {
		MapInfoArray array = new MapInfoArray();
		return array;
	}

	public static MapInfoArrayItem createItem() {
		MapInfoArrayItem item = new MapInfoArrayItem();
		return item;
	}

	public MapInfoArrayItem addData(int mapId, int count, int booleanValue, int booleanValue2, long familyId, String familyName) {
		MapInfoArrayItem item = new MapInfoArrayItem();
		item.setMapId(mapId);
		item.setCount(count);
		item.setBooleanValue(booleanValue);
		item.setBooleanValue2(booleanValue2);
		item.setFamilyId(familyId);
		item.setFamilyName(familyName);
		list.add(item);
		return item;
	}

	public void addItem(MapInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (MapInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class MapInfoArrayItem implements IMessageEncoder {
		private int mapId;
		private int count;
		private int booleanValue;
		private int booleanValue2;
		private long familyId;
		private String familyName;

		private static IntMessageParameterHandler mapIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MapId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler booleanValue2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue2");
		private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");

		public static MapInfoArrayItem create() {
			MapInfoArrayItem item = new MapInfoArrayItem();
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
		 * @return the booleanValue2
		 */
		public int getBooleanValue2() {
			return booleanValue2;
		}

		/**
		 * @param booleanValue2
		 *            the booleanValue2 to set
		 */
		public void setBooleanValue2(int booleanValue2) {
			this.booleanValue2 = booleanValue2;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.mapId);
			data.writeInt(this.count);
			data.writeInt(this.booleanValue);
			data.writeInt(this.booleanValue2);
			data.writeLong(this.familyId);
			data.writeString(this.familyName);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.mapId = data.getInt();
			this.count = data.getInt();
			this.booleanValue = data.getInt();
			this.booleanValue2 = data.getInt();
			this.familyId = data.getLong();
			this.familyName = data.getString();
		}
	
		@Override
		public boolean validate() {
			if (!mapIdHandler.validate(mapId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			if (!booleanValue2Handler.validate(booleanValue2)) {
				return false;
			}
			if (!familyIdHandler.validate(familyId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("mapId:").append(this.mapId).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("booleanValue2:").append(this.booleanValue2).append(", ");
			bb.append("familyId:").append(this.familyId).append(", ");
			bb.append("familyName:").append(this.familyName);
			return bb.toString();	
		}
	}
}