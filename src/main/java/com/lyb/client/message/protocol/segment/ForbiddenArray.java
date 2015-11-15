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
public class ForbiddenArray implements IMessageEncoder {
	private List<ForbiddenArrayItem> list = new LinkedList<ForbiddenArrayItem>();

	public List<ForbiddenArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ForbiddenArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ForbiddenArrayItem item = ForbiddenArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ForbiddenArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ForbiddenArray create() {
		ForbiddenArray array = new ForbiddenArray();
		return array;
	}

	public static ForbiddenArrayItem createItem() {
		ForbiddenArrayItem item = new ForbiddenArrayItem();
		return item;
	}

	public ForbiddenArrayItem addData(long userId, String userName) {
		ForbiddenArrayItem item = new ForbiddenArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		list.add(item);
		return item;
	}

	public void addItem(ForbiddenArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ForbiddenArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ForbiddenArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");

		public static ForbiddenArrayItem create() {
			ForbiddenArrayItem item = new ForbiddenArrayItem();
			return item;
		}

		/**
		 * @return the userId
		 */
		public long getUserId() {
			return userId;
		}

		/**
		 * @param userId
		 *            the userId to set
		 */
		public void setUserId(long userId) {
			this.userId = userId;
		}
		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName
		 *            the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName);
			return bb.toString();	
		}
	}
}