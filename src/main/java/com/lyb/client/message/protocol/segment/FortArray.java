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
public class FortArray implements IMessageEncoder {
	private List<FortArrayItem> list = new LinkedList<FortArrayItem>();

	public List<FortArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FortArrayItem item : list) {
			data.writeInt(item.getFortId());
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
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
			FortArrayItem item = FortArrayItem.create();
			item.setFortId(data.getInt());
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setBooleanValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FortArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FortArray create() {
		FortArray array = new FortArray();
		return array;
	}

	public static FortArrayItem createItem() {
		FortArrayItem item = new FortArrayItem();
		return item;
	}

	public FortArrayItem addData(int fortId, long userId, String userName, int booleanValue) {
		FortArrayItem item = new FortArrayItem();
		item.setFortId(fortId);
		item.setUserId(userId);
		item.setUserName(userName);
		item.setBooleanValue(booleanValue);
		list.add(item);
		return item;
	}

	public void addItem(FortArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FortArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FortArrayItem implements IMessageEncoder {
		private int fortId;
		private long userId;
		private String userName;
		private int booleanValue;

		private static IntMessageParameterHandler fortIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FortId");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static FortArrayItem create() {
			FortArrayItem item = new FortArrayItem();
			return item;
		}

		/**
		 * @return the fortId
		 */
		public int getFortId() {
			return fortId;
		}

		/**
		 * @param fortId
		 *            the fortId to set
		 */
		public void setFortId(int fortId) {
			this.fortId = fortId;
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
			data.writeInt(this.fortId);
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.booleanValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.fortId = data.getInt();
			this.userId = data.getLong();
			this.userName = data.getString();
			this.booleanValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!fortIdHandler.validate(fortId)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("fortId:").append(this.fortId).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("booleanValue:").append(this.booleanValue);
			return bb.toString();	
		}
	}
}