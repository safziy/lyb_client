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
public class RecommendPrincessArray implements IMessageEncoder {
	private List<RecommendPrincessArrayItem> list = new LinkedList<RecommendPrincessArrayItem>();

	public List<RecommendPrincessArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (RecommendPrincessArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getUserName());
			data.writeLong(item.getUserId());
			data.writeString(item.getPrincessName());
			data.writeInt(item.getState());
			data.writeInt(item.getFavors());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			RecommendPrincessArrayItem item = RecommendPrincessArrayItem.create();
			item.setID(data.getLong());
			item.setUserName(data.getString());
			item.setUserId(data.getLong());
			item.setPrincessName(data.getString());
			item.setState(data.getInt());
			item.setFavors(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (RecommendPrincessArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static RecommendPrincessArray create() {
		RecommendPrincessArray array = new RecommendPrincessArray();
		return array;
	}

	public static RecommendPrincessArrayItem createItem() {
		RecommendPrincessArrayItem item = new RecommendPrincessArrayItem();
		return item;
	}

	public RecommendPrincessArrayItem addData(long iD, String userName, long userId, String princessName, int state, int favors) {
		RecommendPrincessArrayItem item = new RecommendPrincessArrayItem();
		item.setID(iD);
		item.setUserName(userName);
		item.setUserId(userId);
		item.setPrincessName(princessName);
		item.setState(state);
		item.setFavors(favors);
		list.add(item);
		return item;
	}

	public void addItem(RecommendPrincessArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (RecommendPrincessArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class RecommendPrincessArrayItem implements IMessageEncoder {
		private long iD;
		private String userName;
		private long userId;
		private String princessName;
		private int state;
		private int favors;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
		private static IntMessageParameterHandler favorsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Favors");

		public static RecommendPrincessArrayItem create() {
			RecommendPrincessArrayItem item = new RecommendPrincessArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeString(this.userName);
			data.writeLong(this.userId);
			data.writeString(this.princessName);
			data.writeInt(this.state);
			data.writeInt(this.favors);
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
			this.state = data.getInt();
			this.favors = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			if (!favorsHandler.validate(favors)) {
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
			bb.append("state:").append(this.state).append(", ");
			bb.append("favors:").append(this.favors);
			return bb.toString();	
		}
	}
}