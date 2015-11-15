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
public class ChangeMemberArray implements IMessageEncoder {
	private List<ChangeMemberArrayItem> list = new LinkedList<ChangeMemberArrayItem>();

	public List<ChangeMemberArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ChangeMemberArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getFamilyPositionId());
			data.writeInt(item.getConfigId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ChangeMemberArrayItem item = ChangeMemberArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setFamilyPositionId(data.getInt());
			item.setConfigId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ChangeMemberArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ChangeMemberArray create() {
		ChangeMemberArray array = new ChangeMemberArray();
		return array;
	}

	public static ChangeMemberArrayItem createItem() {
		ChangeMemberArrayItem item = new ChangeMemberArrayItem();
		return item;
	}

	public ChangeMemberArrayItem addData(long userId, String userName, int familyPositionId, int configId) {
		ChangeMemberArrayItem item = new ChangeMemberArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setFamilyPositionId(familyPositionId);
		item.setConfigId(configId);
		list.add(item);
		return item;
	}

	public void addItem(ChangeMemberArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ChangeMemberArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ChangeMemberArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int familyPositionId;
		private int configId;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler familyPositionIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyPositionId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

		public static ChangeMemberArrayItem create() {
			ChangeMemberArrayItem item = new ChangeMemberArrayItem();
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
		 * @return the familyPositionId
		 */
		public int getFamilyPositionId() {
			return familyPositionId;
		}

		/**
		 * @param familyPositionId
		 *            the familyPositionId to set
		 */
		public void setFamilyPositionId(int familyPositionId) {
			this.familyPositionId = familyPositionId;
		}
		/**
		 * @return the configId
		 */
		public int getConfigId() {
			return configId;
		}

		/**
		 * @param configId
		 *            the configId to set
		 */
		public void setConfigId(int configId) {
			this.configId = configId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.familyPositionId);
			data.writeInt(this.configId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.familyPositionId = data.getInt();
			this.configId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!familyPositionIdHandler.validate(familyPositionId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("familyPositionId:").append(this.familyPositionId).append(", ");
			bb.append("configId:").append(this.configId);
			return bb.toString();	
		}
	}
}