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
public class CarriageArray implements IMessageEncoder {
	private List<CarriageArrayItem> list = new LinkedList<CarriageArrayItem>();

	public List<CarriageArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (CarriageArrayItem item : list) {
			data.writeInt(item.getCarriageId());
			data.writeInt(item.getPlace());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			CarriageArrayItem item = CarriageArrayItem.create();
			item.setCarriageId(data.getInt());
			item.setPlace(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (CarriageArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static CarriageArray create() {
		CarriageArray array = new CarriageArray();
		return array;
	}

	public static CarriageArrayItem createItem() {
		CarriageArrayItem item = new CarriageArrayItem();
		return item;
	}

	public CarriageArrayItem addData(int carriageId, int place) {
		CarriageArrayItem item = new CarriageArrayItem();
		item.setCarriageId(carriageId);
		item.setPlace(place);
		list.add(item);
		return item;
	}

	public void addItem(CarriageArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (CarriageArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class CarriageArrayItem implements IMessageEncoder {
		private int carriageId;
		private int place;

		private static IntMessageParameterHandler carriageIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CarriageId");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");

		public static CarriageArrayItem create() {
			CarriageArrayItem item = new CarriageArrayItem();
			return item;
		}

		/**
		 * @return the carriageId
		 */
		public int getCarriageId() {
			return carriageId;
		}

		/**
		 * @param carriageId
		 *            the carriageId to set
		 */
		public void setCarriageId(int carriageId) {
			this.carriageId = carriageId;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.carriageId);
			data.writeInt(this.place);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.carriageId = data.getInt();
			this.place = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!carriageIdHandler.validate(carriageId)) {
				return false;
			}
			if (!placeHandler.validate(place)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("carriageId:").append(this.carriageId).append(", ");
			bb.append("place:").append(this.place);
			return bb.toString();	
		}
	}
}