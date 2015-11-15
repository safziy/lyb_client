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
public class PlaceGeneralIdMap implements IMessageEncoder {
	private List<PlaceGeneralIdMapItem> list = new LinkedList<PlaceGeneralIdMapItem>();

	public List<PlaceGeneralIdMapItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PlaceGeneralIdMapItem item : list) {
			data.writeInt(item.getPlace());
			data.writeLong(item.getGeneralId());
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
			PlaceGeneralIdMapItem item = PlaceGeneralIdMapItem.create();
			item.setPlace(data.getInt());
			item.setGeneralId(data.getLong());
			item.setBooleanValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PlaceGeneralIdMapItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PlaceGeneralIdMap create() {
		PlaceGeneralIdMap array = new PlaceGeneralIdMap();
		return array;
	}

	public static PlaceGeneralIdMapItem createItem() {
		PlaceGeneralIdMapItem item = new PlaceGeneralIdMapItem();
		return item;
	}

	public PlaceGeneralIdMapItem addData(int place, long generalId, int booleanValue) {
		PlaceGeneralIdMapItem item = new PlaceGeneralIdMapItem();
		item.setPlace(place);
		item.setGeneralId(generalId);
		item.setBooleanValue(booleanValue);
		list.add(item);
		return item;
	}

	public void addItem(PlaceGeneralIdMapItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PlaceGeneralIdMapItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PlaceGeneralIdMapItem implements IMessageEncoder {
		private int place;
		private long generalId;
		private int booleanValue;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static PlaceGeneralIdMapItem create() {
			PlaceGeneralIdMapItem item = new PlaceGeneralIdMapItem();
			return item;
		}

		/**
		 * @return the place
		 */
		public int getPlace() {
			return place;
		}

		/**
		 * @param place
		 *            the place to set
		 */
		public void setPlace(int place) {
			this.place = place;
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
			data.writeInt(this.place);
			data.writeLong(this.generalId);
			data.writeInt(this.booleanValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.generalId = data.getLong();
			this.booleanValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("booleanValue:").append(this.booleanValue);
			return bb.toString();	
		}
	}
}