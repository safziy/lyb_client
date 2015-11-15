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
public class EnemyPrincessArray implements IMessageEncoder {
	private List<EnemyPrincessArrayItem> list = new LinkedList<EnemyPrincessArrayItem>();

	public List<EnemyPrincessArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (EnemyPrincessArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getUserName());
			data.writeString(item.getPrincessName());
			data.writeInt(item.getState());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			EnemyPrincessArrayItem item = EnemyPrincessArrayItem.create();
			item.setID(data.getLong());
			item.setUserName(data.getString());
			item.setPrincessName(data.getString());
			item.setState(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (EnemyPrincessArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static EnemyPrincessArray create() {
		EnemyPrincessArray array = new EnemyPrincessArray();
		return array;
	}

	public static EnemyPrincessArrayItem createItem() {
		EnemyPrincessArrayItem item = new EnemyPrincessArrayItem();
		return item;
	}

	public EnemyPrincessArrayItem addData(long iD, String userName, String princessName, int state) {
		EnemyPrincessArrayItem item = new EnemyPrincessArrayItem();
		item.setID(iD);
		item.setUserName(userName);
		item.setPrincessName(princessName);
		item.setState(state);
		list.add(item);
		return item;
	}

	public void addItem(EnemyPrincessArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (EnemyPrincessArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class EnemyPrincessArrayItem implements IMessageEncoder {
		private long iD;
		private String userName;
		private String princessName;
		private int state;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

		public static EnemyPrincessArrayItem create() {
			EnemyPrincessArrayItem item = new EnemyPrincessArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeString(this.userName);
			data.writeString(this.princessName);
			data.writeInt(this.state);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.userName = data.getString();
			this.princessName = data.getString();
			this.state = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("princessName:").append(this.princessName).append(", ");
			bb.append("state:").append(this.state);
			return bb.toString();	
		}
	}
}