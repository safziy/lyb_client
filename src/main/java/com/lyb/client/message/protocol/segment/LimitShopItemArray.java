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
public class LimitShopItemArray implements IMessageEncoder {
	private List<LimitShopItemArrayItem> list = new LinkedList<LimitShopItemArrayItem>();

	public List<LimitShopItemArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (LimitShopItemArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getItemId());
			data.writeInt(item.getSort());
			data.writeInt(item.getCurrencyType());
			data.writeInt(item.getPrice());
			data.writeInt(item.getUserCount());
			data.writeInt(item.getUserMaxCount());
			data.writeInt(item.getCount());
			data.writeInt(item.getMaxCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			LimitShopItemArrayItem item = LimitShopItemArrayItem.create();
			item.setID(data.getLong());
			item.setItemId(data.getInt());
			item.setSort(data.getInt());
			item.setCurrencyType(data.getInt());
			item.setPrice(data.getInt());
			item.setUserCount(data.getInt());
			item.setUserMaxCount(data.getInt());
			item.setCount(data.getInt());
			item.setMaxCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (LimitShopItemArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static LimitShopItemArray create() {
		LimitShopItemArray array = new LimitShopItemArray();
		return array;
	}

	public static LimitShopItemArrayItem createItem() {
		LimitShopItemArrayItem item = new LimitShopItemArrayItem();
		return item;
	}

	public LimitShopItemArrayItem addData(long iD, int itemId, int sort, int currencyType, int price, int userCount, int userMaxCount, int count, int maxCount) {
		LimitShopItemArrayItem item = new LimitShopItemArrayItem();
		item.setID(iD);
		item.setItemId(itemId);
		item.setSort(sort);
		item.setCurrencyType(currencyType);
		item.setPrice(price);
		item.setUserCount(userCount);
		item.setUserMaxCount(userMaxCount);
		item.setCount(count);
		item.setMaxCount(maxCount);
		list.add(item);
		return item;
	}

	public void addItem(LimitShopItemArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (LimitShopItemArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class LimitShopItemArrayItem implements IMessageEncoder {
		private long iD;
		private int itemId;
		private int sort;
		private int currencyType;
		private int price;
		private int userCount;
		private int userMaxCount;
		private int count;
		private int maxCount;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler sortHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Sort");
		private static IntMessageParameterHandler currencyTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrencyType");
		private static IntMessageParameterHandler priceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Price");
		private static IntMessageParameterHandler userCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("UserCount");
		private static IntMessageParameterHandler userMaxCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("UserMaxCount");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler maxCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MaxCount");

		public static LimitShopItemArrayItem create() {
			LimitShopItemArrayItem item = new LimitShopItemArrayItem();
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
		 * @return the userCount
		 */
		public int getUserCount() {
			return userCount;
		}

		/**
		 * @param userCount
		 *            the userCount to set
		 */
		public void setUserCount(int userCount) {
			this.userCount = userCount;
		}
		/**
		 * @return the userMaxCount
		 */
		public int getUserMaxCount() {
			return userMaxCount;
		}

		/**
		 * @param userMaxCount
		 *            the userMaxCount to set
		 */
		public void setUserMaxCount(int userMaxCount) {
			this.userMaxCount = userMaxCount;
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
		 * @return the maxCount
		 */
		public int getMaxCount() {
			return maxCount;
		}

		/**
		 * @param maxCount
		 *            the maxCount to set
		 */
		public void setMaxCount(int maxCount) {
			this.maxCount = maxCount;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.itemId);
			data.writeInt(this.sort);
			data.writeInt(this.currencyType);
			data.writeInt(this.price);
			data.writeInt(this.userCount);
			data.writeInt(this.userMaxCount);
			data.writeInt(this.count);
			data.writeInt(this.maxCount);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.itemId = data.getInt();
			this.sort = data.getInt();
			this.currencyType = data.getInt();
			this.price = data.getInt();
			this.userCount = data.getInt();
			this.userMaxCount = data.getInt();
			this.count = data.getInt();
			this.maxCount = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
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
			if (!userCountHandler.validate(userCount)) {
				return false;
			}
			if (!userMaxCountHandler.validate(userMaxCount)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!maxCountHandler.validate(maxCount)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("sort:").append(this.sort).append(", ");
			bb.append("currencyType:").append(this.currencyType).append(", ");
			bb.append("price:").append(this.price).append(", ");
			bb.append("userCount:").append(this.userCount).append(", ");
			bb.append("userMaxCount:").append(this.userMaxCount).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("maxCount:").append(this.maxCount);
			return bb.toString();	
		}
	}
}