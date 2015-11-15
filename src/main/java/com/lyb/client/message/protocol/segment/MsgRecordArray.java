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
public class MsgRecordArray implements IMessageEncoder {
	private List<MsgRecordArrayItem> list = new LinkedList<MsgRecordArrayItem>();

	public List<MsgRecordArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (MsgRecordArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getState());
			item.getSendMsgArray().encode(data);
			item.getRevMsgArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			MsgRecordArrayItem item = MsgRecordArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setState(data.getInt());
			item.setSendMsgArray(SendMsgArray.create());
			item.getSendMsgArray().decode(data);
			item.setRevMsgArray(RevMsgArray.create());
			item.getRevMsgArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (MsgRecordArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static MsgRecordArray create() {
		MsgRecordArray array = new MsgRecordArray();
		return array;
	}

	public static MsgRecordArrayItem createItem() {
		MsgRecordArrayItem item = new MsgRecordArrayItem();
		return item;
	}

	public MsgRecordArrayItem addData(long userId, String userName, int state, SendMsgArray sendMsgArray, RevMsgArray revMsgArray) {
		MsgRecordArrayItem item = new MsgRecordArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setState(state);
		item.setSendMsgArray(sendMsgArray);
		item.setRevMsgArray(revMsgArray);
		list.add(item);
		return item;
	}

	public void addItem(MsgRecordArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (MsgRecordArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class MsgRecordArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int state;
		private SendMsgArray sendMsgArray;
		private RevMsgArray revMsgArray;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

		public static MsgRecordArrayItem create() {
			MsgRecordArrayItem item = new MsgRecordArrayItem();
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
		 * @return the sendMsgArray
		 */
		public SendMsgArray getSendMsgArray() {
			return sendMsgArray;
		}

		/**
		 * @param sendMsgArray
		 *            the sendMsgArray to set
		 */
		public void setSendMsgArray(SendMsgArray sendMsgArray) {
			this.sendMsgArray = sendMsgArray;
		}
		/**
		 * @return the revMsgArray
		 */
		public RevMsgArray getRevMsgArray() {
			return revMsgArray;
		}

		/**
		 * @param revMsgArray
		 *            the revMsgArray to set
		 */
		public void setRevMsgArray(RevMsgArray revMsgArray) {
			this.revMsgArray = revMsgArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.state);
			sendMsgArray.encode(data);
			revMsgArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.state = data.getInt();
			sendMsgArray = SendMsgArray.create();
			sendMsgArray.decode(data);
			revMsgArray = RevMsgArray.create();
			revMsgArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			if (!sendMsgArray.validate()) {
				return false;
			}
			if (!revMsgArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("state:").append(this.state).append(", ");
			bb.append("sendMsgArray:").append(sendMsgArray.toString()).append(", ");
			bb.append("revMsgArray:").append(revMsgArray.toString());
			return bb.toString();	
		}
	}
}