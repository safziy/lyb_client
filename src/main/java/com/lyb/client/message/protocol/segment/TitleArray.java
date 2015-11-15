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
public class TitleArray implements IMessageEncoder {
	private List<TitleArrayItem> list = new LinkedList<TitleArrayItem>();

	public List<TitleArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TitleArrayItem item : list) {
			data.writeInt(item.getTitleId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			TitleArrayItem item = TitleArrayItem.create();
			item.setTitleId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TitleArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TitleArray create() {
		TitleArray array = new TitleArray();
		return array;
	}

	public static TitleArrayItem createItem() {
		TitleArrayItem item = new TitleArrayItem();
		return item;
	}

	public TitleArrayItem addData(int titleId) {
		TitleArrayItem item = new TitleArrayItem();
		item.setTitleId(titleId);
		list.add(item);
		return item;
	}

	public void addItem(TitleArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TitleArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TitleArrayItem implements IMessageEncoder {
		private int titleId;

		private static IntMessageParameterHandler titleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TitleId");

		public static TitleArrayItem create() {
			TitleArrayItem item = new TitleArrayItem();
			return item;
		}

		/**
		 * @return the titleId
		 */
		public int getTitleId() {
			return titleId;
		}

		/**
		 * @param titleId
		 *            the titleId to set
		 */
		public void setTitleId(int titleId) {
			this.titleId = titleId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.titleId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.titleId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!titleIdHandler.validate(titleId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("titleId:").append(this.titleId);
			return bb.toString();	
		}
	}
}