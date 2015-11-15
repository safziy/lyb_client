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
public class SlavePrincessArray implements IMessageEncoder {
	private List<SlavePrincessArrayItem> list = new LinkedList<SlavePrincessArrayItem>();

	public List<SlavePrincessArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (SlavePrincessArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getUserName());
			data.writeLong(item.getUserId());
			data.writeString(item.getPrincessName());
			data.writeInt(item.getFavors());
			data.writeInt(item.getEscapeCDTime());
			data.writeInt(item.getIsLock());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			SlavePrincessArrayItem item = SlavePrincessArrayItem.create();
			item.setID(data.getLong());
			item.setUserName(data.getString());
			item.setUserId(data.getLong());
			item.setPrincessName(data.getString());
			item.setFavors(data.getInt());
			item.setEscapeCDTime(data.getInt());
			item.setIsLock(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (SlavePrincessArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static SlavePrincessArray create() {
		SlavePrincessArray array = new SlavePrincessArray();
		return array;
	}

	public static SlavePrincessArrayItem createItem() {
		SlavePrincessArrayItem item = new SlavePrincessArrayItem();
		return item;
	}

	public SlavePrincessArrayItem addData(long iD, String userName, long userId, String princessName, int favors, int escapeCDTime, int isLock) {
		SlavePrincessArrayItem item = new SlavePrincessArrayItem();
		item.setID(iD);
		item.setUserName(userName);
		item.setUserId(userId);
		item.setPrincessName(princessName);
		item.setFavors(favors);
		item.setEscapeCDTime(escapeCDTime);
		item.setIsLock(isLock);
		list.add(item);
		return item;
	}

	public void addItem(SlavePrincessArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (SlavePrincessArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class SlavePrincessArrayItem implements IMessageEncoder {
		private long iD;
		private String userName;
		private long userId;
		private String princessName;
		private int favors;
		private int escapeCDTime;
		private int isLock;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler favorsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Favors");
		private static IntMessageParameterHandler escapeCDTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EscapeCDTime");
		private static IntMessageParameterHandler isLockHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("IsLock");

		public static SlavePrincessArrayItem create() {
			SlavePrincessArrayItem item = new SlavePrincessArrayItem();
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
		 * @return the princessName
		 */
		public String getPrincessName() {
			return princessName;
		}

		/**
		 * @param princessName
		 *            the princessName to set
		 */
		public void setPrincessName(String princessName) {
			this.princessName = princessName;
		}
		/**
		 * @return the favors
		 */
		public int getFavors() {
			return favors;
		}

		/**
		 * @param favors
		 *            the favors to set
		 */
		public void setFavors(int favors) {
			this.favors = favors;
		}
		/**
		 * @return the escapeCDTime
		 */
		public int getEscapeCDTime() {
			return escapeCDTime;
		}

		/**
		 * @param escapeCDTime
		 *            the escapeCDTime to set
		 */
		public void setEscapeCDTime(int escapeCDTime) {
			this.escapeCDTime = escapeCDTime;
		}
		/**
		 * @return the isLock
		 */
		public int getIsLock() {
			return isLock;
		}

		/**
		 * @param isLock
		 *            the isLock to set
		 */
		public void setIsLock(int isLock) {
			this.isLock = isLock;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeString(this.userName);
			data.writeLong(this.userId);
			data.writeString(this.princessName);
			data.writeInt(this.favors);
			data.writeInt(this.escapeCDTime);
			data.writeInt(this.isLock);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.userName = data.getString();
			this.userId = data.getLong();
			this.princessName = data.getString();
			this.favors = data.getInt();
			this.escapeCDTime = data.getInt();
			this.isLock = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!favorsHandler.validate(favors)) {
				return false;
			}
			if (!escapeCDTimeHandler.validate(escapeCDTime)) {
				return false;
			}
			if (!isLockHandler.validate(isLock)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("princessName:").append(this.princessName).append(", ");
			bb.append("favors:").append(this.favors).append(", ");
			bb.append("escapeCDTime:").append(this.escapeCDTime).append(", ");
			bb.append("isLock:").append(this.isLock);
			return bb.toString();	
		}
	}
}