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
public class UserItemIdArray implements IMessageEncoder {
	private List<UserItemIdArrayItem> list = new LinkedList<UserItemIdArrayItem>();

	public List<UserItemIdArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserItemIdArrayItem item : list) {
			data.writeLong(item.getUserItemId());
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
			UserItemIdArrayItem item = UserItemIdArrayItem.create();
			item.setUserItemId(data.getLong());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserItemIdArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserItemIdArray create() {
		UserItemIdArray array = new UserItemIdArray();
		return array;
	}

	public static UserItemIdArrayItem createItem() {
		UserItemIdArrayItem item = new UserItemIdArrayItem();
		return item;
	}

	public UserItemIdArrayItem addData(long userItemId, int count) {
		UserItemIdArrayItem item = new UserItemIdArrayItem();
		item.setUserItemId(userItemId);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(UserItemIdArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserItemIdArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserItemIdArrayItem implements IMessageEncoder {
		private long userItemId;
		private int count;

		private static LongMessageParameterHandler userItemIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserItemId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static UserItemIdArrayItem create() {
			UserItemIdArrayItem item = new UserItemIdArrayItem();
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
			data.writeLong(this.userItemId);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userItemId = data.getLong();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userItemIdHandler.validate(userItemId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userItemId:").append(this.userItemId).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}