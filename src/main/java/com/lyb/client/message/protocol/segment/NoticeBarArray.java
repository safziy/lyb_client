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
public class NoticeBarArray implements IMessageEncoder {
	private List<NoticeBarArrayItem> list = new LinkedList<NoticeBarArrayItem>();

	public List<NoticeBarArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (NoticeBarArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getContent());
			data.writeInt(item.getTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			NoticeBarArrayItem item = NoticeBarArrayItem.create();
			item.setID(data.getLong());
			item.setContent(data.getString());
			item.setTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (NoticeBarArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static NoticeBarArray create() {
		NoticeBarArray array = new NoticeBarArray();
		return array;
	}

	public static NoticeBarArrayItem createItem() {
		NoticeBarArrayItem item = new NoticeBarArrayItem();
		return item;
	}

	public NoticeBarArrayItem addData(long iD, String content, int time) {
		NoticeBarArrayItem item = new NoticeBarArrayItem();
		item.setID(iD);
		item.setContent(content);
		item.setTime(time);
		list.add(item);
		return item;
	}

	public void addItem(NoticeBarArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (NoticeBarArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class NoticeBarArrayItem implements IMessageEncoder {
		private long iD;
		private String content;
		private int time;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

		public static NoticeBarArrayItem create() {
			NoticeBarArrayItem item = new NoticeBarArrayItem();
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
		 * @return the time
		 */
		public int getTime() {
			return time;
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(int time) {
			this.time = time;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeString(this.content);
			data.writeInt(this.time);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.content = data.getString();
			this.time = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("content:").append(this.content).append(", ");
			bb.append("time:").append(this.time);
			return bb.toString();	
		}
	}
}