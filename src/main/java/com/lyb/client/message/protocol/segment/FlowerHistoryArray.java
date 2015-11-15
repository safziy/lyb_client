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
public class FlowerHistoryArray implements IMessageEncoder {
	private List<FlowerHistoryArrayItem> list = new LinkedList<FlowerHistoryArrayItem>();

	public List<FlowerHistoryArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FlowerHistoryArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeLong(item.getTargetUserId());
			data.writeString(item.getTargetUserName());
			data.writeInt(item.getType());
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
			FlowerHistoryArrayItem item = FlowerHistoryArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setTargetUserId(data.getLong());
			item.setTargetUserName(data.getString());
			item.setType(data.getInt());
			item.setTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FlowerHistoryArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FlowerHistoryArray create() {
		FlowerHistoryArray array = new FlowerHistoryArray();
		return array;
	}

	public static FlowerHistoryArrayItem createItem() {
		FlowerHistoryArrayItem item = new FlowerHistoryArrayItem();
		return item;
	}

	public FlowerHistoryArrayItem addData(long userId, String userName, long targetUserId, String targetUserName, int type, int time) {
		FlowerHistoryArrayItem item = new FlowerHistoryArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setTargetUserId(targetUserId);
		item.setTargetUserName(targetUserName);
		item.setType(type);
		item.setTime(time);
		list.add(item);
		return item;
	}

	public void addItem(FlowerHistoryArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FlowerHistoryArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FlowerHistoryArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private long targetUserId;
		private String targetUserName;
		private int type;
		private int time;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static LongMessageParameterHandler targetUserIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("TargetUserId");
		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

		public static FlowerHistoryArrayItem create() {
			FlowerHistoryArrayItem item = new FlowerHistoryArrayItem();
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
		 * @return the targetUserId
		 */
		public long getTargetUserId() {
			return targetUserId;
		}

		/**
		 * @param targetUserId
		 *            the targetUserId to set
		 */
		public void setTargetUserId(long targetUserId) {
			this.targetUserId = targetUserId;
		}
		/**
		 * @return the targetUserName
		 */
		public String getTargetUserName() {
			return targetUserName;
		}

		/**
		 * @param targetUserName
		 *            the targetUserName to set
		 */
		public void setTargetUserName(String targetUserName) {
			this.targetUserName = targetUserName;
		}
		/**
		 * @return the type
		 */
		public int getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(int type) {
			this.type = type;
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
			data.writeLong(this.targetUserId);
			data.writeString(this.targetUserName);
			data.writeInt(this.type);
			data.writeInt(this.time);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.targetUserId = data.getLong();
			this.targetUserName = data.getString();
			this.type = data.getInt();
			this.time = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!targetUserIdHandler.validate(targetUserId)) {
				return false;
			}
			if (!typeHandler.validate(type)) {
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
			bb.append("targetUserId:").append(this.targetUserId).append(", ");
			bb.append("targetUserName:").append(this.targetUserName).append(", ");
			bb.append("type:").append(this.type).append(", ");
			bb.append("time:").append(this.time);
			return bb.toString();	
		}
	}
}