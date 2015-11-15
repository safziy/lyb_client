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
public class MailArray implements IMessageEncoder {
	private List<MailArrayItem> list = new LinkedList<MailArrayItem>();

	public List<MailArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (MailArrayItem item : list) {
			data.writeLong(item.getMailId());
			data.writeInt(item.getConfigId());
			data.writeString(item.getParamStr1());
			data.writeString(item.getTitle());
			data.writeString(item.getFromUserName());
			data.writeInt(item.getDateTime());
			data.writeString(item.getContent());
			data.writeInt(item.getByteState());
			item.getItemIdArray().encode(data);
			data.writeInt(item.getByteType());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			MailArrayItem item = MailArrayItem.create();
			item.setMailId(data.getLong());
			item.setConfigId(data.getInt());
			item.setParamStr1(data.getString());
			item.setTitle(data.getString());
			item.setFromUserName(data.getString());
			item.setDateTime(data.getInt());
			item.setContent(data.getString());
			item.setByteState(data.getInt());
			item.setItemIdArray(ItemIdArray.create());
			item.getItemIdArray().decode(data);
			item.setByteType(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (MailArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static MailArray create() {
		MailArray array = new MailArray();
		return array;
	}

	public static MailArrayItem createItem() {
		MailArrayItem item = new MailArrayItem();
		return item;
	}

	public MailArrayItem addData(long mailId, int configId, String paramStr1, String title, String fromUserName, int dateTime, String content, int byteState, ItemIdArray itemIdArray, int byteType) {
		MailArrayItem item = new MailArrayItem();
		item.setMailId(mailId);
		item.setConfigId(configId);
		item.setParamStr1(paramStr1);
		item.setTitle(title);
		item.setFromUserName(fromUserName);
		item.setDateTime(dateTime);
		item.setContent(content);
		item.setByteState(byteState);
		item.setItemIdArray(itemIdArray);
		item.setByteType(byteType);
		list.add(item);
		return item;
	}

	public void addItem(MailArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (MailArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class MailArrayItem implements IMessageEncoder {
		private long mailId;
		private int configId;
		private String paramStr1;
		private String title;
		private String fromUserName;
		private int dateTime;
		private String content;
		private int byteState;
		private ItemIdArray itemIdArray;
		private int byteType;

		private static LongMessageParameterHandler mailIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("MailId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler dateTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("DateTime");
		private static IntMessageParameterHandler byteStateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ByteState");
		private static IntMessageParameterHandler byteTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ByteType");

		public static MailArrayItem create() {
			MailArrayItem item = new MailArrayItem();
			return item;
		}

		/**
		 * @return the mailId
		 */
		public long getMailId() {
			return mailId;
		}

		/**
		 * @param mailId
		 *            the mailId to set
		 */
		public void setMailId(long mailId) {
			this.mailId = mailId;
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
		 * @return the paramStr1
		 */
		public String getParamStr1() {
			return paramStr1;
		}

		/**
		 * @param paramStr1
		 *            the paramStr1 to set
		 */
		public void setParamStr1(String paramStr1) {
			this.paramStr1 = paramStr1;
		}
		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		/**
		 * @return the fromUserName
		 */
		public String getFromUserName() {
			return fromUserName;
		}

		/**
		 * @param fromUserName
		 *            the fromUserName to set
		 */
		public void setFromUserName(String fromUserName) {
			this.fromUserName = fromUserName;
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
		 * @return the content
		 */
		public String getContent() {
			return content;
		}

		/**
		 * @param content
		 *            the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}
		/**
		 * @return the byteState
		 */
		public int getByteState() {
			return byteState;
		}

		/**
		 * @param byteState
		 *            the byteState to set
		 */
		public void setByteState(int byteState) {
			this.byteState = byteState;
		}
		/**
		 * @return the itemIdArray
		 */
		public ItemIdArray getItemIdArray() {
			return itemIdArray;
		}

		/**
		 * @param itemIdArray
		 *            the itemIdArray to set
		 */
		public void setItemIdArray(ItemIdArray itemIdArray) {
			this.itemIdArray = itemIdArray;
		}
		/**
		 * @return the byteType
		 */
		public int getByteType() {
			return byteType;
		}

		/**
		 * @param byteType
		 *            the byteType to set
		 */
		public void setByteType(int byteType) {
			this.byteType = byteType;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.mailId);
			data.writeInt(this.configId);
			data.writeString(this.paramStr1);
			data.writeString(this.title);
			data.writeString(this.fromUserName);
			data.writeInt(this.dateTime);
			data.writeString(this.content);
			data.writeInt(this.byteState);
			itemIdArray.encode(data);
			data.writeInt(this.byteType);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.mailId = data.getLong();
			this.configId = data.getInt();
			this.paramStr1 = data.getString();
			this.title = data.getString();
			this.fromUserName = data.getString();
			this.dateTime = data.getInt();
			this.content = data.getString();
			this.byteState = data.getInt();
			itemIdArray = ItemIdArray.create();
			itemIdArray.decode(data);
			this.byteType = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!mailIdHandler.validate(mailId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!dateTimeHandler.validate(dateTime)) {
				return false;
			}
			if (!byteStateHandler.validate(byteState)) {
				return false;
			}
			if (!itemIdArray.validate()) {
				return false;
			}
			if (!byteTypeHandler.validate(byteType)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("mailId:").append(this.mailId).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("paramStr1:").append(this.paramStr1).append(", ");
			bb.append("title:").append(this.title).append(", ");
			bb.append("fromUserName:").append(this.fromUserName).append(", ");
			bb.append("dateTime:").append(this.dateTime).append(", ");
			bb.append("content:").append(this.content).append(", ");
			bb.append("byteState:").append(this.byteState).append(", ");
			bb.append("itemIdArray:").append(itemIdArray.toString()).append(", ");
			bb.append("byteType:").append(this.byteType);
			return bb.toString();	
		}
	}
}