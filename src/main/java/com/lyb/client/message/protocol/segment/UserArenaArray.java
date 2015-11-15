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
public class UserArenaArray implements IMessageEncoder {
	private List<UserArenaArrayItem> list = new LinkedList<UserArenaArrayItem>();

	public List<UserArenaArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserArenaArrayItem item : list) {
			data.writeInt(item.getTransforId());
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getScore());
			data.writeInt(item.getBooleanValue());
			data.writeInt(item.getZhanli());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			UserArenaArrayItem item = UserArenaArrayItem.create();
			item.setTransforId(data.getInt());
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setScore(data.getInt());
			item.setBooleanValue(data.getInt());
			item.setZhanli(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserArenaArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserArenaArray create() {
		UserArenaArray array = new UserArenaArray();
		return array;
	}

	public static UserArenaArrayItem createItem() {
		UserArenaArrayItem item = new UserArenaArrayItem();
		return item;
	}

	public UserArenaArrayItem addData(int transforId, long userId, String userName, int level, int score, int booleanValue, int zhanli) {
		UserArenaArrayItem item = new UserArenaArrayItem();
		item.setTransforId(transforId);
		item.setUserId(userId);
		item.setUserName(userName);
		item.setLevel(level);
		item.setScore(score);
		item.setBooleanValue(booleanValue);
		item.setZhanli(zhanli);
		list.add(item);
		return item;
	}

	public void addItem(UserArenaArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserArenaArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserArenaArrayItem implements IMessageEncoder {
		private int transforId;
		private long userId;
		private String userName;
		private int level;
		private int score;
		private int booleanValue;
		private int zhanli;

		private static IntMessageParameterHandler transforIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TransforId");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler scoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Score");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");

		public static UserArenaArrayItem create() {
			UserArenaArrayItem item = new UserArenaArrayItem();
			return item;
		}

		/**
		 * @return the transforId
		 */
		public int getTransforId() {
			return transforId;
		}

		/**
		 * @param transforId
		 *            the transforId to set
		 */
		public void setTransforId(int transforId) {
			this.transforId = transforId;
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
		 * @return the score
		 */
		public int getScore() {
			return score;
		}

		/**
		 * @param score
		 *            the score to set
		 */
		public void setScore(int score) {
			this.score = score;
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
		 * @return the zhanli
		 */
		public int getZhanli() {
			return zhanli;
		}

		/**
		 * @param zhanli
		 *            the zhanli to set
		 */
		public void setZhanli(int zhanli) {
			this.zhanli = zhanli;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.transforId);
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.score);
			data.writeInt(this.booleanValue);
			data.writeInt(this.zhanli);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.transforId = data.getInt();
			this.userId = data.getLong();
			this.userName = data.getString();
			this.level = data.getInt();
			this.score = data.getInt();
			this.booleanValue = data.getInt();
			this.zhanli = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!transforIdHandler.validate(transforId)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!scoreHandler.validate(score)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("transforId:").append(this.transforId).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("score:").append(this.score).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("zhanli:").append(this.zhanli);
			return bb.toString();	
		}
	}
}