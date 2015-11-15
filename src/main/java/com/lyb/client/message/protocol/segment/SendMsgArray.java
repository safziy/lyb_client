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
public class SendMsgArray implements IMessageEncoder {
	private List<SendMsgArrayItem> list = new LinkedList<SendMsgArrayItem>();

	public List<SendMsgArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (SendMsgArrayItem item : list) {
			item.getChatContentArray().encode(data);
			data.writeInt(item.getDateTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			SendMsgArrayItem item = SendMsgArrayItem.create();
			item.setChatContentArray(ChatContentArray.create());
			item.getChatContentArray().decode(data);
			item.setDateTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (SendMsgArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static SendMsgArray create() {
		SendMsgArray array = new SendMsgArray();
		return array;
	}

	public static SendMsgArrayItem createItem() {
		SendMsgArrayItem item = new SendMsgArrayItem();
		return item;
	}

	public SendMsgArrayItem addData(ChatContentArray chatContentArray, int dateTime) {
		SendMsgArrayItem item = new SendMsgArrayItem();
		item.setChatContentArray(chatContentArray);
		item.setDateTime(dateTime);
		list.add(item);
		return item;
	}

	public void addItem(SendMsgArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (SendMsgArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class SendMsgArrayItem implements IMessageEncoder {
		private ChatContentArray chatContentArray;
		private int dateTime;

		private static IntMessageParameterHandler dateTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("DateTime");

		public static SendMsgArrayItem create() {
			SendMsgArrayItem item = new SendMsgArrayItem();
			return item;
		}

		/**
		 * @return the chatContentArray
		 */
		public ChatContentArray getChatContentArray() {
			return chatContentArray;
		}

		/**
		 * @param chatContentArray
		 *            the chatContentArray to set
		 */
		public void setChatContentArray(ChatContentArray chatContentArray) {
			this.chatContentArray = chatContentArray;
		}
		/**
		 * @return the dateTime
		 */
		public int getDateTime() {
			return dateTime;
		}

		/**
		 * @param dateTime
		 *            the dateTime to set
		 */
		public void setDateTime(int dateTime) {
			this.dateTime = dateTime;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			chatContentArray.encode(data);
			data.writeInt(this.dateTime);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			chatContentArray = ChatContentArray.create();
			chatContentArray.decode(data);
			this.dateTime = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!chatContentArray.validate()) {
				return false;
			}
			if (!dateTimeHandler.validate(dateTime)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("chatContentArray:").append(chatContentArray.toString()).append(", ");
			bb.append("dateTime:").append(this.dateTime);
			return bb.toString();	
		}
	}
}