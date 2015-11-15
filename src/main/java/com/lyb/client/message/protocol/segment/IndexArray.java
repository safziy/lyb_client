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
public class IndexArray implements IMessageEncoder {
	private List<IndexArrayItem> list = new LinkedList<IndexArrayItem>();

	public List<IndexArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (IndexArrayItem item : list) {
			data.writeInt(item.getIndex());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			IndexArrayItem item = IndexArrayItem.create();
			item.setIndex(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (IndexArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static IndexArray create() {
		IndexArray array = new IndexArray();
		return array;
	}

	public static IndexArrayItem createItem() {
		IndexArrayItem item = new IndexArrayItem();
		return item;
	}

	public IndexArrayItem addData(int index) {
		IndexArrayItem item = new IndexArrayItem();
		item.setIndex(index);
		list.add(item);
		return item;
	}

	public void addItem(IndexArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (IndexArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class IndexArrayItem implements IMessageEncoder {
		private int index;

		private static IntMessageParameterHandler indexHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Index");

		public static IndexArrayItem create() {
			IndexArrayItem item = new IndexArrayItem();
			return item;
		}

		/**
		 * @return the index
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * @param index
		 *            the index to set
		 */
		public void setIndex(int index) {
			this.index = index;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.index);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.index = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!indexHandler.validate(index)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("index:").append(this.index);
			return bb.toString();	
		}
	}
}