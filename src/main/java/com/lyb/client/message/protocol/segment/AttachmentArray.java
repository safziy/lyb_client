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
public class AttachmentArray implements IMessageEncoder {
	private List<AttachmentArrayItem> list = new LinkedList<AttachmentArrayItem>();

	public List<AttachmentArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (AttachmentArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getConfigId());
			item.getItemIdArray().encode(data);
			data.writeInt(item.getDateTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			AttachmentArrayItem item = AttachmentArrayItem.create();
			item.setID(data.getLong());
			item.setConfigId(data.getInt());
			item.setItemIdArray(ItemIdArray.create());
			item.getItemIdArray().decode(data);
			item.setDateTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (AttachmentArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static AttachmentArray create() {
		AttachmentArray array = new AttachmentArray();
		return array;
	}

	public static AttachmentArrayItem createItem() {
		AttachmentArrayItem item = new AttachmentArrayItem();
		return item;
	}

	public AttachmentArrayItem addData(long iD, int configId, ItemIdArray itemIdArray, int dateTime) {
		AttachmentArrayItem item = new AttachmentArrayItem();
		item.setID(iD);
		item.setConfigId(configId);
		item.setItemIdArray(itemIdArray);
		item.setDateTime(dateTime);
		list.add(item);
		return item;
	}

	public void addItem(AttachmentArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (AttachmentArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class AttachmentArrayItem implements IMessageEncoder {
		private long iD;
		private int configId;
		private ItemIdArray itemIdArray;
		private int dateTime;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler dateTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("DateTime");

		public static AttachmentArrayItem create() {
			AttachmentArrayItem item = new AttachmentArrayItem();
			return item;
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
		 * @return the itemIdArray
		 */
		public ItemIdArray getItemIdArray() {
			return itemIdArray;
		}

		/**
		 * @param itemIdArray
		 *            the itemIdArray to set
		 */
		public void setItemIdArray(ItemIdArray itemIdArray) {
			this.itemIdArray = itemIdArray;
		}
		/**
		 * @return the dateTime
		 */
		public int getDateTime() {
			return dateTime;
		}

		/**
		 * @param dateTime
		 *            the dateTime to set
		 */
		public void setDateTime(int dateTime) {
			this.dateTime = dateTime;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.configId);
			itemIdArray.encode(data);
			data.writeInt(this.dateTime);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.configId = data.getInt();
			itemIdArray = ItemIdArray.create();
			itemIdArray.decode(data);
			this.dateTime = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!itemIdArray.validate()) {
				return false;
			}
			if (!dateTimeHandler.validate(dateTime)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("itemIdArray:").append(itemIdArray.toString()).append(", ");
			bb.append("dateTime:").append(this.dateTime);
			return bb.toString();	
		}
	}
}