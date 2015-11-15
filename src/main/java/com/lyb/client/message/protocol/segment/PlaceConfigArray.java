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
public class PlaceConfigArray implements IMessageEncoder {
	private List<PlaceConfigArrayItem> list = new LinkedList<PlaceConfigArrayItem>();

	public List<PlaceConfigArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PlaceConfigArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeInt(item.getConfigId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PlaceConfigArrayItem item = PlaceConfigArrayItem.create();
			item.setPlace(data.getInt());
			item.setConfigId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PlaceConfigArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PlaceConfigArray create() {
		PlaceConfigArray array = new PlaceConfigArray();
		return array;
	}

	public static PlaceConfigArrayItem createItem() {
		PlaceConfigArrayItem item = new PlaceConfigArrayItem();
		return item;
	}

	public PlaceConfigArrayItem addData(int place, int configId) {
		PlaceConfigArrayItem item = new PlaceConfigArrayItem();
		item.setPlace(place);
		item.setConfigId(configId);
		list.add(item);
		return item;
	}

	public void addItem(PlaceConfigArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PlaceConfigArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PlaceConfigArrayItem implements IMessageEncoder {
		private int place;
		private int configId;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

		public static PlaceConfigArrayItem create() {
			PlaceConfigArrayItem item = new PlaceConfigArrayItem();
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
		 * @return the configId
		 */
		public int getConfigId() {
			return configId;
		}

		/**
		 * @param configId
		 *            the configId to set
		 */
		public void setConfigId(int configId) {
			this.configId = configId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeInt(this.configId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.configId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("configId:").append(this.configId);
			return bb.toString();	
		}
	}
}