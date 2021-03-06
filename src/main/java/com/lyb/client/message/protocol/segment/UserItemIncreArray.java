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
public class UserItemIncreArray implements IMessageEncoder {
	private List<UserItemIncreArrayItem> list = new LinkedList<UserItemIncreArrayItem>();

	public List<UserItemIncreArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserItemIncreArrayItem item : list) {
			data.writeLong(item.getUserItemId());
			data.writeInt(item.getItemId());
			data.writeInt(item.getCount());
			data.writeInt(item.getIsBanding());
			data.writeInt(item.getIsUsing());
			data.writeInt(item.getPlace());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			UserItemIncreArrayItem item = UserItemIncreArrayItem.create();
			item.setUserItemId(data.getLong());
			item.setItemId(data.getInt());
			item.setCount(data.getInt());
			item.setIsBanding(data.getInt());
			item.setIsUsing(data.getInt());
			item.setPlace(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserItemIncreArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserItemIncreArray create() {
		UserItemIncreArray array = new UserItemIncreArray();
		return array;
	}

	public static UserItemIncreArrayItem createItem() {
		UserItemIncreArrayItem item = new UserItemIncreArrayItem();
		return item;
	}

	public UserItemIncreArrayItem addData(long userItemId, int itemId, int count, int isBanding, int isUsing, int place) {
		UserItemIncreArrayItem item = new UserItemIncreArrayItem();
		item.setUserItemId(userItemId);
		item.setItemId(itemId);
		item.setCount(count);
		item.setIsBanding(isBanding);
		item.setIsUsing(isUsing);
		item.setPlace(place);
		list.add(item);
		return item;
	}

	public void addItem(UserItemIncreArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserItemIncreArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserItemIncreArrayItem implements IMessageEncoder {
		private long userItemId;
		private int itemId;
		private int count;
		private int isBanding;
		private int isUsing;
		private int place;

		private static LongMessageParameterHandler userItemIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserItemId");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler isBandingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("IsBanding");
		private static IntMessageParameterHandler isUsingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("IsUsing");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");

		public static UserItemIncreArrayItem create() {
			UserItemIncreArrayItem item = new UserItemIncreArrayItem();
			return item;
		}

		/**
		 * @return the userItemId
		 */
		public long getUserItemId() {
			return userItemId;
		}

		/**
		 * @param userItemId
		 *            the userItemId to set
		 */
		public void setUserItemId(long userItemId) {
			this.userItemId = userItemId;
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
		 * @return the isBanding
		 */
		public int getIsBanding() {
			return isBanding;
		}

		/**
		 * @param isBanding
		 *            the isBanding to set
		 */
		public void setIsBanding(int isBanding) {
			this.isBanding = isBanding;
		}
		/**
		 * @return the isUsing
		 */
		public int getIsUsing() {
			return isUsing;
		}

		/**
		 * @param isUsing
		 *            the isUsing to set
		 */
		public void setIsUsing(int isUsing) {
			this.isUsing = isUsing;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userItemId);
			data.writeInt(this.itemId);
			data.writeInt(this.count);
			data.writeInt(this.isBanding);
			data.writeInt(this.isUsing);
			data.writeInt(this.place);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userItemId = data.getLong();
			this.itemId = data.getInt();
			this.count = data.getInt();
			this.isBanding = data.getInt();
			this.isUsing = data.getInt();
			this.place = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userItemIdHandler.validate(userItemId)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!isBandingHandler.validate(isBanding)) {
				return false;
			}
			if (!isUsingHandler.validate(isUsing)) {
				return false;
			}
			if (!placeHandler.validate(place)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userItemId:").append(this.userItemId).append(", ");
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("isBanding:").append(this.isBanding).append(", ");
			bb.append("isUsing:").append(this.isUsing).append(", ");
			bb.append("place:").append(this.place);
			return bb.toString();	
		}
	}
}