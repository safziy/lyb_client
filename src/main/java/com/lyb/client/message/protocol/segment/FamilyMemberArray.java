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
public class FamilyMemberArray implements IMessageEncoder {
	private List<FamilyMemberArrayItem> list = new LinkedList<FamilyMemberArrayItem>();

	public List<FamilyMemberArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FamilyMemberArrayItem item : list) {
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeLong(item.getUserId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FamilyMemberArrayItem item = FamilyMemberArrayItem.create();
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setUserId(data.getLong());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FamilyMemberArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FamilyMemberArray create() {
		FamilyMemberArray array = new FamilyMemberArray();
		return array;
	}

	public static FamilyMemberArrayItem createItem() {
		FamilyMemberArrayItem item = new FamilyMemberArrayItem();
		return item;
	}

	public FamilyMemberArrayItem addData(String userName, int level, long userId) {
		FamilyMemberArrayItem item = new FamilyMemberArrayItem();
		item.setUserName(userName);
		item.setLevel(level);
		item.setUserId(userId);
		list.add(item);
		return item;
	}

	public void addItem(FamilyMemberArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FamilyMemberArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FamilyMemberArrayItem implements IMessageEncoder {
		private String userName;
		private int level;
		private long userId;

		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");

		public static FamilyMemberArrayItem create() {
			FamilyMemberArrayItem item = new FamilyMemberArrayItem();
			return item;
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
		 * @return the level
		 */
		public int getLevel() {
			return level;
		}

		/**
		 * @param level
		 *            the level to set
		 */
		public void setLevel(int level) {
			this.level = level;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeLong(this.userId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userName = data.getString();
			this.level = data.getInt();
			this.userId = data.getLong();
		}
	
		@Override
		public boolean validate() {
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("userId:").append(this.userId);
			return bb.toString();	
		}
	}
}