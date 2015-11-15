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
public class ShareEquipArray implements IMessageEncoder {
	private List<ShareEquipArrayItem> list = new LinkedList<ShareEquipArrayItem>();

	public List<ShareEquipArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ShareEquipArrayItem item : list) {
			data.writeLong(item.getGeneralId());
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
			ShareEquipArrayItem item = ShareEquipArrayItem.create();
			item.setGeneralId(data.getLong());
			item.setItemId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ShareEquipArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ShareEquipArray create() {
		ShareEquipArray array = new ShareEquipArray();
		return array;
	}

	public static ShareEquipArrayItem createItem() {
		ShareEquipArrayItem item = new ShareEquipArrayItem();
		return item;
	}

	public ShareEquipArrayItem addData(long generalId, int itemId) {
		ShareEquipArrayItem item = new ShareEquipArrayItem();
		item.setGeneralId(generalId);
		item.setItemId(itemId);
		list.add(item);
		return item;
	}

	public void addItem(ShareEquipArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ShareEquipArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ShareEquipArrayItem implements IMessageEncoder {
		private long generalId;
		private int itemId;

		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");

		public static ShareEquipArrayItem create() {
			ShareEquipArrayItem item = new ShareEquipArrayItem();
			return item;
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
			data.writeLong(this.generalId);
			data.writeInt(this.itemId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalId = data.getLong();
			this.itemId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("itemId:").append(this.itemId);
			return bb.toString();	
		}
	}
}