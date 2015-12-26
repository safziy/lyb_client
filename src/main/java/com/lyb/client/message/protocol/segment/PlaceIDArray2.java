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
public class PlaceIDArray2 implements IMessageEncoder {
	private List<PlaceIDArray2Item> list = new LinkedList<PlaceIDArray2Item>();

	public List<PlaceIDArray2Item> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PlaceIDArray2Item item : list) {
			data.writeInt(item.getPlace());
			data.writeLong(item.getID());
			data.writeInt(item.getBodyId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PlaceIDArray2Item item = PlaceIDArray2Item.create();
			item.setPlace(data.getInt());
			item.setID(data.getLong());
			item.setBodyId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PlaceIDArray2Item item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PlaceIDArray2 create() {
		PlaceIDArray2 array = new PlaceIDArray2();
		return array;
	}

	public static PlaceIDArray2Item createItem() {
		PlaceIDArray2Item item = new PlaceIDArray2Item();
		return item;
	}

	public PlaceIDArray2Item addData(int place, long iD, int bodyId) {
		PlaceIDArray2Item item = new PlaceIDArray2Item();
		item.setPlace(place);
		item.setID(iD);
		item.setBodyId(bodyId);
		list.add(item);
		return item;
	}

	public void addItem(PlaceIDArray2Item item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PlaceIDArray2Item item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PlaceIDArray2Item implements IMessageEncoder {
		private int place;
		private long iD;
		private int bodyId;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler bodyIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BodyId");

		public static PlaceIDArray2Item create() {
			PlaceIDArray2Item item = new PlaceIDArray2Item();
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
		 * @return the bodyId
		 */
		public int getBodyId() {
			return bodyId;
		}

		/**
		 * @param bodyId
		 *            the bodyId to set
		 */
		public void setBodyId(int bodyId) {
			this.bodyId = bodyId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeLong(this.iD);
			data.writeInt(this.bodyId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.iD = data.getLong();
			this.bodyId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!bodyIdHandler.validate(bodyId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("bodyId:").append(this.bodyId);
			return bb.toString();	
		}
	}
}