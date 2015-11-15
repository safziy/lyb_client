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
public class ReplaceEquipmentArray implements IMessageEncoder {
	private List<ReplaceEquipmentArrayItem> list = new LinkedList<ReplaceEquipmentArrayItem>();

	public List<ReplaceEquipmentArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ReplaceEquipmentArrayItem item : list) {
			data.writeInt(item.getEquipmentPlaceId());
			data.writeInt(item.getUserEquipmentId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ReplaceEquipmentArrayItem item = ReplaceEquipmentArrayItem.create();
			item.setEquipmentPlaceId(data.getInt());
			item.setUserEquipmentId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ReplaceEquipmentArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ReplaceEquipmentArray create() {
		ReplaceEquipmentArray array = new ReplaceEquipmentArray();
		return array;
	}

	public static ReplaceEquipmentArrayItem createItem() {
		ReplaceEquipmentArrayItem item = new ReplaceEquipmentArrayItem();
		return item;
	}

	public ReplaceEquipmentArrayItem addData(int equipmentPlaceId, int userEquipmentId) {
		ReplaceEquipmentArrayItem item = new ReplaceEquipmentArrayItem();
		item.setEquipmentPlaceId(equipmentPlaceId);
		item.setUserEquipmentId(userEquipmentId);
		list.add(item);
		return item;
	}

	public void addItem(ReplaceEquipmentArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ReplaceEquipmentArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ReplaceEquipmentArrayItem implements IMessageEncoder {
		private int equipmentPlaceId;
		private int userEquipmentId;

		private static IntMessageParameterHandler equipmentPlaceIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EquipmentPlaceId");
		private static IntMessageParameterHandler userEquipmentIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("UserEquipmentId");

		public static ReplaceEquipmentArrayItem create() {
			ReplaceEquipmentArrayItem item = new ReplaceEquipmentArrayItem();
			return item;
		}

		/**
		 * @return the equipmentPlaceId
		 */
		public int getEquipmentPlaceId() {
			return equipmentPlaceId;
		}

		/**
		 * @param equipmentPlaceId
		 *            the equipmentPlaceId to set
		 */
		public void setEquipmentPlaceId(int equipmentPlaceId) {
			this.equipmentPlaceId = equipmentPlaceId;
		}
		/**
		 * @return the userEquipmentId
		 */
		public int getUserEquipmentId() {
			return userEquipmentId;
		}

		/**
		 * @param userEquipmentId
		 *            the userEquipmentId to set
		 */
		public void setUserEquipmentId(int userEquipmentId) {
			this.userEquipmentId = userEquipmentId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.equipmentPlaceId);
			data.writeInt(this.userEquipmentId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.equipmentPlaceId = data.getInt();
			this.userEquipmentId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!equipmentPlaceIdHandler.validate(equipmentPlaceId)) {
				return false;
			}
			if (!userEquipmentIdHandler.validate(userEquipmentId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("equipmentPlaceId:").append(this.equipmentPlaceId).append(", ");
			bb.append("userEquipmentId:").append(this.userEquipmentId);
			return bb.toString();	
		}
	}
}