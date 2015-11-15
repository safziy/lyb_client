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
public class FreeItemArray implements IMessageEncoder {
	private List<FreeItemArrayItem> list = new LinkedList<FreeItemArrayItem>();

	public List<FreeItemArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FreeItemArrayItem item : list) {
			data.writeInt(item.getPosition());
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
			FreeItemArrayItem item = FreeItemArrayItem.create();
			item.setPosition(data.getInt());
			item.setItemId(data.getInt());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FreeItemArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FreeItemArray create() {
		FreeItemArray array = new FreeItemArray();
		return array;
	}

	public static FreeItemArrayItem createItem() {
		FreeItemArrayItem item = new FreeItemArrayItem();
		return item;
	}

	public FreeItemArrayItem addData(int position, int itemId, int count) {
		FreeItemArrayItem item = new FreeItemArrayItem();
		item.setPosition(position);
		item.setItemId(itemId);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(FreeItemArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FreeItemArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FreeItemArrayItem implements IMessageEncoder {
		private int position;
		private int itemId;
		private int count;

		private static IntMessageParameterHandler positionHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Position");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static FreeItemArrayItem create() {
			FreeItemArrayItem item = new FreeItemArrayItem();
			return item;
		}

		/**
		 * @return the position
		 */
		public int getPosition() {
			return position;
		}

		/**
		 * @param position
		 *            the position to set
		 */
		public void setPosition(int position) {
			this.position = position;
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
			data.writeInt(this.position);
			data.writeInt(this.itemId);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.position = data.getInt();
			this.itemId = data.getInt();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!positionHandler.validate(position)) {
				return false;
			}
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
			bb.append("position:").append(this.position).append(", ");
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}