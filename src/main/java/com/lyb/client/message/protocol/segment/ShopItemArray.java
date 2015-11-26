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
public class ShopItemArray implements IMessageEncoder {
	private List<ShopItemArrayItem> list = new LinkedList<ShopItemArrayItem>();

	public List<ShopItemArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ShopItemArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getType());
			data.writeInt(item.getTag());
			data.writeInt(item.getItemId());
			data.writeInt(item.getCount());
			data.writeInt(item.getSort());
			data.writeInt(item.getCurrencyType());
			data.writeInt(item.getPrice());
			data.writeInt(item.getParam1());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ShopItemArrayItem item = ShopItemArrayItem.create();
			item.setID(data.getLong());
			item.setType(data.getInt());
			item.setTag(data.getInt());
			item.setItemId(data.getInt());
			item.setCount(data.getInt());
			item.setSort(data.getInt());
			item.setCurrencyType(data.getInt());
			item.setPrice(data.getInt());
			item.setParam1(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ShopItemArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ShopItemArray create() {
		ShopItemArray array = new ShopItemArray();
		return array;
	}

	public static ShopItemArrayItem createItem() {
		ShopItemArrayItem item = new ShopItemArrayItem();
		return item;
	}

	public ShopItemArrayItem addData(long iD, int type, int tag, int itemId, int count, int sort, int currencyType, int price, int param1) {
		ShopItemArrayItem item = new ShopItemArrayItem();
		item.setID(iD);
		item.setType(type);
		item.setTag(tag);
		item.setItemId(itemId);
		item.setCount(count);
		item.setSort(sort);
		item.setCurrencyType(currencyType);
		item.setPrice(price);
		item.setParam1(param1);
		list.add(item);
		return item;
	}

	public void addItem(ShopItemArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ShopItemArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ShopItemArrayItem implements IMessageEncoder {
		private long iD;
		private int type;
		private int tag;
		private int itemId;
		private int count;
		private int sort;
		private int currencyType;
		private int price;
		private int param1;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler tagHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Tag");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler sortHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Sort");
		private static IntMessageParameterHandler currencyTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrencyType");
		private static IntMessageParameterHandler priceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Price");
		private static IntMessageParameterHandler param1Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param1");

		public static ShopItemArrayItem create() {
			ShopItemArrayItem item = new ShopItemArrayItem();
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
		 * @return the type
		 */
		public int getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(int type) {
			this.type = type;
		}
		/**
		 * @return the tag
		 */
		public int getTag() {
			return tag;
		}

		/**
		 * @param tag
		 *            the tag to set
		 */
		public void setTag(int tag) {
			this.tag = tag;
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
		 * @return the sort
		 */
		public int getSort() {
			return sort;
		}

		/**
		 * @param sort
		 *            the sort to set
		 */
		public void setSort(int sort) {
			this.sort = sort;
		}
		/**
		 * @return the currencyType
		 */
		public int getCurrencyType() {
			return currencyType;
		}

		/**
		 * @param currencyType
		 *            the currencyType to set
		 */
		public void setCurrencyType(int currencyType) {
			this.currencyType = currencyType;
		}
		/**
		 * @return the price
		 */
		public int getPrice() {
			return price;
		}

		/**
		 * @param price
		 *            the price to set
		 */
		public void setPrice(int price) {
			this.price = price;
		}
		/**
		 * @return the param1
		 */
		public int getParam1() {
			return param1;
		}

		/**
		 * @param param1
		 *            the param1 to set
		 */
		public void setParam1(int param1) {
			this.param1 = param1;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.type);
			data.writeInt(this.tag);
			data.writeInt(this.itemId);
			data.writeInt(this.count);
			data.writeInt(this.sort);
			data.writeInt(this.currencyType);
			data.writeInt(this.price);
			data.writeInt(this.param1);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.type = data.getInt();
			this.tag = data.getInt();
			this.itemId = data.getInt();
			this.count = data.getInt();
			this.sort = data.getInt();
			this.currencyType = data.getInt();
			this.price = data.getInt();
			this.param1 = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!typeHandler.validate(type)) {
				return false;
			}
			if (!tagHandler.validate(tag)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!sortHandler.validate(sort)) {
				return false;
			}
			if (!currencyTypeHandler.validate(currencyType)) {
				return false;
			}
			if (!priceHandler.validate(price)) {
				return false;
			}
			if (!param1Handler.validate(param1)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("type:").append(this.type).append(", ");
			bb.append("tag:").append(this.tag).append(", ");
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("sort:").append(this.sort).append(", ");
			bb.append("currencyType:").append(this.currencyType).append(", ");
			bb.append("price:").append(this.price).append(", ");
			bb.append("param1:").append(this.param1);
			return bb.toString();	
		}
	}
}