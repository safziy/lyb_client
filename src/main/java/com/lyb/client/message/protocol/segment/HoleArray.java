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
public class HoleArray implements IMessageEncoder {
	private List<HoleArrayItem> list = new LinkedList<HoleArrayItem>();

	public List<HoleArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (HoleArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeInt(item.getItemId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			HoleArrayItem item = HoleArrayItem.create();
			item.setPlace(data.getInt());
			item.setItemId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (HoleArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static HoleArray create() {
		HoleArray array = new HoleArray();
		return array;
	}

	public static HoleArrayItem createItem() {
		HoleArrayItem item = new HoleArrayItem();
		return item;
	}

	public HoleArrayItem addData(int place, int itemId) {
		HoleArrayItem item = new HoleArrayItem();
		item.setPlace(place);
		item.setItemId(itemId);
		list.add(item);
		return item;
	}

	public void addItem(HoleArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (HoleArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class HoleArrayItem implements IMessageEncoder {
		private int place;
		private int itemId;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");

		public static HoleArrayItem create() {
			HoleArrayItem item = new HoleArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeInt(this.itemId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.itemId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("itemId:").append(this.itemId);
			return bb.toString();	
		}
	}
}