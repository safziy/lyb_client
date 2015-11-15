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
public class TopKillerArray implements IMessageEncoder {
	private List<TopKillerArrayItem> list = new LinkedList<TopKillerArrayItem>();

	public List<TopKillerArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TopKillerArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeString(item.getTopKillerUserName());
			data.writeInt(item.getCount());
			data.writeInt(item.getTopKillerFaction());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			TopKillerArrayItem item = TopKillerArrayItem.create();
			item.setPlace(data.getInt());
			item.setTopKillerUserName(data.getString());
			item.setCount(data.getInt());
			item.setTopKillerFaction(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TopKillerArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TopKillerArray create() {
		TopKillerArray array = new TopKillerArray();
		return array;
	}

	public static TopKillerArrayItem createItem() {
		TopKillerArrayItem item = new TopKillerArrayItem();
		return item;
	}

	public TopKillerArrayItem addData(int place, String topKillerUserName, int count, int topKillerFaction) {
		TopKillerArrayItem item = new TopKillerArrayItem();
		item.setPlace(place);
		item.setTopKillerUserName(topKillerUserName);
		item.setCount(count);
		item.setTopKillerFaction(topKillerFaction);
		list.add(item);
		return item;
	}

	public void addItem(TopKillerArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TopKillerArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TopKillerArrayItem implements IMessageEncoder {
		private int place;
		private String topKillerUserName;
		private int count;
		private int topKillerFaction;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler topKillerFactionHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TopKillerFaction");

		public static TopKillerArrayItem create() {
			TopKillerArrayItem item = new TopKillerArrayItem();
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
		 * @return the topKillerUserName
		 */
		public String getTopKillerUserName() {
			return topKillerUserName;
		}

		/**
		 * @param topKillerUserName
		 *            the topKillerUserName to set
		 */
		public void setTopKillerUserName(String topKillerUserName) {
			this.topKillerUserName = topKillerUserName;
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
		 * @return the topKillerFaction
		 */
		public int getTopKillerFaction() {
			return topKillerFaction;
		}

		/**
		 * @param topKillerFaction
		 *            the topKillerFaction to set
		 */
		public void setTopKillerFaction(int topKillerFaction) {
			this.topKillerFaction = topKillerFaction;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeString(this.topKillerUserName);
			data.writeInt(this.count);
			data.writeInt(this.topKillerFaction);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.topKillerUserName = data.getString();
			this.count = data.getInt();
			this.topKillerFaction = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!topKillerFactionHandler.validate(topKillerFaction)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("topKillerUserName:").append(this.topKillerUserName).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("topKillerFaction:").append(this.topKillerFaction);
			return bb.toString();	
		}
	}
}