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
public class RoomMemberArray implements IMessageEncoder {
	private List<RoomMemberArrayItem> list = new LinkedList<RoomMemberArrayItem>();

	public List<RoomMemberArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (RoomMemberArrayItem item : list) {
			data.writeInt(item.getBooleanValue());
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getCareer());
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
			RoomMemberArrayItem item = RoomMemberArrayItem.create();
			item.setBooleanValue(data.getInt());
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setCareer(data.getInt());
			item.setUserId(data.getLong());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (RoomMemberArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static RoomMemberArray create() {
		RoomMemberArray array = new RoomMemberArray();
		return array;
	}

	public static RoomMemberArrayItem createItem() {
		RoomMemberArrayItem item = new RoomMemberArrayItem();
		return item;
	}

	public RoomMemberArrayItem addData(int booleanValue, String userName, int level, int career, long userId) {
		RoomMemberArrayItem item = new RoomMemberArrayItem();
		item.setBooleanValue(booleanValue);
		item.setUserName(userName);
		item.setLevel(level);
		item.setCareer(career);
		item.setUserId(userId);
		list.add(item);
		return item;
	}

	public void addItem(RoomMemberArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (RoomMemberArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class RoomMemberArrayItem implements IMessageEncoder {
		private int booleanValue;
		private String userName;
		private int level;
		private int career;
		private long userId;

		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");

		public static RoomMemberArrayItem create() {
			RoomMemberArrayItem item = new RoomMemberArrayItem();
			return item;
		}

		/**
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
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
		 * @return the career
		 */
		public int getCareer() {
			return career;
		}

		/**
		 * @param career
		 *            the career to set
		 */
		public void setCareer(int career) {
			this.career = career;
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
			data.writeInt(this.booleanValue);
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.career);
			data.writeLong(this.userId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.booleanValue = data.getInt();
			this.userName = data.getString();
			this.level = data.getInt();
			this.career = data.getInt();
			this.userId = data.getLong();
		}
	
		@Override
		public boolean validate() {
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("userId:").append(this.userId);
			return bb.toString();	
		}
	}
}