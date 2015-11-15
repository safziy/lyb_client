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
public class NoticeArray implements IMessageEncoder {
	private List<NoticeArrayItem> list = new LinkedList<NoticeArrayItem>();

	public List<NoticeArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (NoticeArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getTitle());
			data.writeInt(item.getSort());
			data.writeInt(item.getBooleanValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			NoticeArrayItem item = NoticeArrayItem.create();
			item.setID(data.getLong());
			item.setTitle(data.getString());
			item.setSort(data.getInt());
			item.setBooleanValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (NoticeArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static NoticeArray create() {
		NoticeArray array = new NoticeArray();
		return array;
	}

	public static NoticeArrayItem createItem() {
		NoticeArrayItem item = new NoticeArrayItem();
		return item;
	}

	public NoticeArrayItem addData(long iD, String title, int sort, int booleanValue) {
		NoticeArrayItem item = new NoticeArrayItem();
		item.setID(iD);
		item.setTitle(title);
		item.setSort(sort);
		item.setBooleanValue(booleanValue);
		list.add(item);
		return item;
	}

	public void addItem(NoticeArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (NoticeArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class NoticeArrayItem implements IMessageEncoder {
		private long iD;
		private String title;
		private int sort;
		private int booleanValue;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler sortHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Sort");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static NoticeArrayItem create() {
			NoticeArrayItem item = new NoticeArrayItem();
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
		 * @return the sort
		 */
		public int getSort() {
			return sort;
		}

		/**
		 * @param sort
		 *            the sort to set
		 */
		public void setSort(int sort) {
			this.sort = sort;
		}
		/**
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeString(this.title);
			data.writeInt(this.sort);
			data.writeInt(this.booleanValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.title = data.getString();
			this.sort = data.getInt();
			this.booleanValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!sortHandler.validate(sort)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("title:").append(this.title).append(", ");
			bb.append("sort:").append(this.sort).append(", ");
			bb.append("booleanValue:").append(this.booleanValue);
			return bb.toString();	
		}
	}
}