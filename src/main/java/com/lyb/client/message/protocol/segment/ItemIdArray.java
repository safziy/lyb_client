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
public class ItemIdArray implements IMessageEncoder {
	private List<ItemIdArrayItem> list = new LinkedList<ItemIdArrayItem>();

	public List<ItemIdArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ItemIdArrayItem item : list) {
			data.writeInt(item.getItemId());
			data.writeInt(item.getCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ItemIdArrayItem item = ItemIdArrayItem.create();
			item.setItemId(data.getInt());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ItemIdArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ItemIdArray create() {
		ItemIdArray array = new ItemIdArray();
		return array;
	}

	public static ItemIdArrayItem createItem() {
		ItemIdArrayItem item = new ItemIdArrayItem();
		return item;
	}

	public ItemIdArrayItem addData(int itemId, int count) {
		ItemIdArrayItem item = new ItemIdArrayItem();
		item.setItemId(itemId);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(ItemIdArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ItemIdArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ItemIdArrayItem implements IMessageEncoder {
		private int itemId;
		private int count;

		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static ItemIdArrayItem create() {
			ItemIdArrayItem item = new ItemIdArrayItem();
			return item;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.itemId);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.itemId = data.getInt();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}