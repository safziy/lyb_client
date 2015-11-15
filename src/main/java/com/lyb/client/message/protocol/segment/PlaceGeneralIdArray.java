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
public class PlaceGeneralIdArray implements IMessageEncoder {
	private List<PlaceGeneralIdArrayItem> list = new LinkedList<PlaceGeneralIdArrayItem>();

	public List<PlaceGeneralIdArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PlaceGeneralIdArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeLong(item.getGeneralId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PlaceGeneralIdArrayItem item = PlaceGeneralIdArrayItem.create();
			item.setPlace(data.getInt());
			item.setGeneralId(data.getLong());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PlaceGeneralIdArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PlaceGeneralIdArray create() {
		PlaceGeneralIdArray array = new PlaceGeneralIdArray();
		return array;
	}

	public static PlaceGeneralIdArrayItem createItem() {
		PlaceGeneralIdArrayItem item = new PlaceGeneralIdArrayItem();
		return item;
	}

	public PlaceGeneralIdArrayItem addData(int place, long generalId) {
		PlaceGeneralIdArrayItem item = new PlaceGeneralIdArrayItem();
		item.setPlace(place);
		item.setGeneralId(generalId);
		list.add(item);
		return item;
	}

	public void addItem(PlaceGeneralIdArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PlaceGeneralIdArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PlaceGeneralIdArrayItem implements IMessageEncoder {
		private int place;
		private long generalId;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");

		public static PlaceGeneralIdArrayItem create() {
			PlaceGeneralIdArrayItem item = new PlaceGeneralIdArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeLong(this.generalId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.generalId = data.getLong();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("generalId:").append(this.generalId);
			return bb.toString();	
		}
	}
}