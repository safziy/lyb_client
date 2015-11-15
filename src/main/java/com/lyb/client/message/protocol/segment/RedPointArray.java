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
public class RedPointArray implements IMessageEncoder {
	private List<RedPointArrayItem> list = new LinkedList<RedPointArrayItem>();

	public List<RedPointArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (RedPointArrayItem item : list) {
			data.writeLong(item.getID());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			RedPointArrayItem item = RedPointArrayItem.create();
			item.setID(data.getLong());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (RedPointArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static RedPointArray create() {
		RedPointArray array = new RedPointArray();
		return array;
	}

	public static RedPointArrayItem createItem() {
		RedPointArrayItem item = new RedPointArrayItem();
		return item;
	}

	public RedPointArrayItem addData(long iD) {
		RedPointArrayItem item = new RedPointArrayItem();
		item.setID(iD);
		list.add(item);
		return item;
	}

	public void addItem(RedPointArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (RedPointArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class RedPointArrayItem implements IMessageEncoder {
		private long iD;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");

		public static RedPointArrayItem create() {
			RedPointArrayItem item = new RedPointArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD);
			return bb.toString();	
		}
	}
}