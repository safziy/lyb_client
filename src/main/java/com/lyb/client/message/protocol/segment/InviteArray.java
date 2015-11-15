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
public class InviteArray implements IMessageEncoder {
	private List<InviteArrayItem> list = new LinkedList<InviteArrayItem>();

	public List<InviteArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (InviteArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getCareer());
			data.writeInt(item.getCount());
			data.writeInt(item.getBooleanValue());
			data.writeInt(item.getBooleanValue2());
			data.writeInt(item.getTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			InviteArrayItem item = InviteArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setCareer(data.getInt());
			item.setCount(data.getInt());
			item.setBooleanValue(data.getInt());
			item.setBooleanValue2(data.getInt());
			item.setTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (InviteArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static InviteArray create() {
		InviteArray array = new InviteArray();
		return array;
	}

	public static InviteArrayItem createItem() {
		InviteArrayItem item = new InviteArrayItem();
		return item;
	}

	public InviteArrayItem addData(long userId, String userName, int level, int career, int count, int booleanValue, int booleanValue2, int time) {
		InviteArrayItem item = new InviteArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setLevel(level);
		item.setCareer(career);
		item.setCount(count);
		item.setBooleanValue(booleanValue);
		item.setBooleanValue2(booleanValue2);
		item.setTime(time);
		list.add(item);
		return item;
	}

	public void addItem(InviteArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (InviteArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class InviteArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int level;
		private int career;
		private int count;
		private int booleanValue;
		private int booleanValue2;
		private int time;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler booleanValue2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue2");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

		public static InviteArrayItem create() {
			InviteArrayItem item = new InviteArrayItem();
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
		 * @return the booleanValue2
		 */
		public int getBooleanValue2() {
			return booleanValue2;
		}

		/**
		 * @param booleanValue2
		 *            the booleanValue2 to set
		 */
		public void setBooleanValue2(int booleanValue2) {
			this.booleanValue2 = booleanValue2;
		}
		/**
		 * @return the time
		 */
		public int getTime() {
			return time;
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(int time) {
			this.time = time;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.career);
			data.writeInt(this.count);
			data.writeInt(this.booleanValue);
			data.writeInt(this.booleanValue2);
			data.writeInt(this.time);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.level = data.getInt();
			this.career = data.getInt();
			this.count = data.getInt();
			this.booleanValue = data.getInt();
			this.booleanValue2 = data.getInt();
			this.time = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			if (!booleanValue2Handler.validate(booleanValue2)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("booleanValue2:").append(this.booleanValue2).append(", ");
			bb.append("time:").append(this.time);
			return bb.toString();	
		}
	}
}