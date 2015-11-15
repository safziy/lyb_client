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
public class PrincessInfoArray implements IMessageEncoder {
	private List<PrincessInfoArrayItem> list = new LinkedList<PrincessInfoArrayItem>();

	public List<PrincessInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PrincessInfoArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getPrincessName());
			data.writeInt(item.getFavors());
			data.writeString(item.getUserName());
			data.writeLong(item.getUserId());
			data.writeInt(item.getEscapeCDTime());
			data.writeInt(item.getState());
			data.writeInt(item.getProtectedCDTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PrincessInfoArrayItem item = PrincessInfoArrayItem.create();
			item.setID(data.getLong());
			item.setPrincessName(data.getString());
			item.setFavors(data.getInt());
			item.setUserName(data.getString());
			item.setUserId(data.getLong());
			item.setEscapeCDTime(data.getInt());
			item.setState(data.getInt());
			item.setProtectedCDTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PrincessInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PrincessInfoArray create() {
		PrincessInfoArray array = new PrincessInfoArray();
		return array;
	}

	public static PrincessInfoArrayItem createItem() {
		PrincessInfoArrayItem item = new PrincessInfoArrayItem();
		return item;
	}

	public PrincessInfoArrayItem addData(long iD, String princessName, int favors, String userName, long userId, int escapeCDTime, int state, int protectedCDTime) {
		PrincessInfoArrayItem item = new PrincessInfoArrayItem();
		item.setID(iD);
		item.setPrincessName(princessName);
		item.setFavors(favors);
		item.setUserName(userName);
		item.setUserId(userId);
		item.setEscapeCDTime(escapeCDTime);
		item.setState(state);
		item.setProtectedCDTime(protectedCDTime);
		list.add(item);
		return item;
	}

	public void addItem(PrincessInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PrincessInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PrincessInfoArrayItem implements IMessageEncoder {
		private long iD;
		private String princessName;
		private int favors;
		private String userName;
		private long userId;
		private int escapeCDTime;
		private int state;
		private int protectedCDTime;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler favorsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Favors");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler escapeCDTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EscapeCDTime");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
		private static IntMessageParameterHandler protectedCDTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ProtectedCDTime");

		public static PrincessInfoArrayItem create() {
			PrincessInfoArrayItem item = new PrincessInfoArrayItem();
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
		 * @return the state
		 */
		public int getState() {
			return state;
		}

		/**
		 * @param state
		 *            the state to set
		 */
		public void setState(int state) {
			this.state = state;
		}
		/**
		 * @return the protectedCDTime
		 */
		public int getProtectedCDTime() {
			return protectedCDTime;
		}

		/**
		 * @param protectedCDTime
		 *            the protectedCDTime to set
		 */
		public void setProtectedCDTime(int protectedCDTime) {
			this.protectedCDTime = protectedCDTime;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeString(this.princessName);
			data.writeInt(this.favors);
			data.writeString(this.userName);
			data.writeLong(this.userId);
			data.writeInt(this.escapeCDTime);
			data.writeInt(this.state);
			data.writeInt(this.protectedCDTime);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.princessName = data.getString();
			this.favors = data.getInt();
			this.userName = data.getString();
			this.userId = data.getLong();
			this.escapeCDTime = data.getInt();
			this.state = data.getInt();
			this.protectedCDTime = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!favorsHandler.validate(favors)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!escapeCDTimeHandler.validate(escapeCDTime)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			if (!protectedCDTimeHandler.validate(protectedCDTime)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("princessName:").append(this.princessName).append(", ");
			bb.append("favors:").append(this.favors).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("escapeCDTime:").append(this.escapeCDTime).append(", ");
			bb.append("state:").append(this.state).append(", ");
			bb.append("protectedCDTime:").append(this.protectedCDTime);
			return bb.toString();	
		}
	}
}