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
public class TakeBoxArray implements IMessageEncoder {
	private List<TakeBoxArrayItem> list = new LinkedList<TakeBoxArrayItem>();

	public List<TakeBoxArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TakeBoxArrayItem item : list) {
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
			TakeBoxArrayItem item = TakeBoxArrayItem.create();
			item.setPlace(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TakeBoxArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TakeBoxArray create() {
		TakeBoxArray array = new TakeBoxArray();
		return array;
	}

	public static TakeBoxArrayItem createItem() {
		TakeBoxArrayItem item = new TakeBoxArrayItem();
		return item;
	}

	public TakeBoxArrayItem addData(int place) {
		TakeBoxArrayItem item = new TakeBoxArrayItem();
		item.setPlace(place);
		list.add(item);
		return item;
	}

	public void addItem(TakeBoxArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TakeBoxArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TakeBoxArrayItem implements IMessageEncoder {
		private int place;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");

		public static TakeBoxArrayItem create() {
			TakeBoxArrayItem item = new TakeBoxArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place);
			return bb.toString();	
		}
	}
}