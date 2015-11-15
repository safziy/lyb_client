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
public class FriendArray implements IMessageEncoder {
	private List<FriendArrayItem> list = new LinkedList<FriendArrayItem>();

	public List<FriendArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FriendArrayItem item : list) {
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getVip());
			data.writeLong(item.getUserId());
			data.writeInt(item.getCareer());
			data.writeInt(item.getTransforId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FriendArrayItem item = FriendArrayItem.create();
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setVip(data.getInt());
			item.setUserId(data.getLong());
			item.setCareer(data.getInt());
			item.setTransforId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FriendArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FriendArray create() {
		FriendArray array = new FriendArray();
		return array;
	}

	public static FriendArrayItem createItem() {
		FriendArrayItem item = new FriendArrayItem();
		return item;
	}

	public FriendArrayItem addData(String userName, int level, int vip, long userId, int career, int transforId) {
		FriendArrayItem item = new FriendArrayItem();
		item.setUserName(userName);
		item.setLevel(level);
		item.setVip(vip);
		item.setUserId(userId);
		item.setCareer(career);
		item.setTransforId(transforId);
		list.add(item);
		return item;
	}

	public void addItem(FriendArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FriendArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FriendArrayItem implements IMessageEncoder {
		private String userName;
		private int level;
		private int vip;
		private long userId;
		private int career;
		private int transforId;

		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler transforIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TransforId");

		public static FriendArrayItem create() {
			FriendArrayItem item = new FriendArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.vip);
			data.writeLong(this.userId);
			data.writeInt(this.career);
			data.writeInt(this.transforId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userName = data.getString();
			this.level = data.getInt();
			this.vip = data.getInt();
			this.userId = data.getLong();
			this.career = data.getInt();
			this.transforId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!vipHandler.validate(vip)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!transforIdHandler.validate(transforId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("vip:").append(this.vip).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("transforId:").append(this.transforId);
			return bb.toString();	
		}
	}
}