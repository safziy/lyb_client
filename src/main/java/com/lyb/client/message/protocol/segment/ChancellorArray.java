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
public class ChancellorArray implements IMessageEncoder {
	private List<ChancellorArrayItem> list = new LinkedList<ChancellorArrayItem>();

	public List<ChancellorArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ChancellorArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getTransforId());
			data.writeInt(item.getBooleanValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ChancellorArrayItem item = ChancellorArrayItem.create();
			item.setID(data.getLong());
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setTransforId(data.getInt());
			item.setBooleanValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ChancellorArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ChancellorArray create() {
		ChancellorArray array = new ChancellorArray();
		return array;
	}

	public static ChancellorArrayItem createItem() {
		ChancellorArrayItem item = new ChancellorArrayItem();
		return item;
	}

	public ChancellorArrayItem addData(long iD, long userId, String userName, int level, int transforId, int booleanValue) {
		ChancellorArrayItem item = new ChancellorArrayItem();
		item.setID(iD);
		item.setUserId(userId);
		item.setUserName(userName);
		item.setLevel(level);
		item.setTransforId(transforId);
		item.setBooleanValue(booleanValue);
		list.add(item);
		return item;
	}

	public void addItem(ChancellorArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ChancellorArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ChancellorArrayItem implements IMessageEncoder {
		private long iD;
		private long userId;
		private String userName;
		private int level;
		private int transforId;
		private int booleanValue;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler transforIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TransforId");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static ChancellorArrayItem create() {
			ChancellorArrayItem item = new ChancellorArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.transforId);
			data.writeInt(this.booleanValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.userId = data.getLong();
			this.userName = data.getString();
			this.level = data.getInt();
			this.transforId = data.getInt();
			this.booleanValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!transforIdHandler.validate(transforId)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("transforId:").append(this.transforId).append(", ");
			bb.append("booleanValue:").append(this.booleanValue);
			return bb.toString();	
		}
	}
}