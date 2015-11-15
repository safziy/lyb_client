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
public class SceneMemberArray implements IMessageEncoder {
	private List<SceneMemberArrayItem> list = new LinkedList<SceneMemberArrayItem>();

	public List<SceneMemberArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (SceneMemberArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getVip());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			SceneMemberArrayItem item = SceneMemberArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setConfigId(data.getInt());
			item.setVip(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (SceneMemberArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static SceneMemberArray create() {
		SceneMemberArray array = new SceneMemberArray();
		return array;
	}

	public static SceneMemberArrayItem createItem() {
		SceneMemberArrayItem item = new SceneMemberArrayItem();
		return item;
	}

	public SceneMemberArrayItem addData(long userId, String userName, int configId, int vip) {
		SceneMemberArrayItem item = new SceneMemberArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setConfigId(configId);
		item.setVip(vip);
		list.add(item);
		return item;
	}

	public void addItem(SceneMemberArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (SceneMemberArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class SceneMemberArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int configId;
		private int vip;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");

		public static SceneMemberArrayItem create() {
			SceneMemberArrayItem item = new SceneMemberArrayItem();
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
		 * @return the vip
		 */
		public int getVip() {
			return vip;
		}

		/**
		 * @param vip
		 *            the vip to set
		 */
		public void setVip(int vip) {
			this.vip = vip;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.configId);
			data.writeInt(this.vip);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.configId = data.getInt();
			this.vip = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!vipHandler.validate(vip)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("vip:").append(this.vip);
			return bb.toString();	
		}
	}
}