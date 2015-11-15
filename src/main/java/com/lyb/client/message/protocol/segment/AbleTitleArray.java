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
public class AbleTitleArray implements IMessageEncoder {
	private List<AbleTitleArrayItem> list = new LinkedList<AbleTitleArrayItem>();

	public List<AbleTitleArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (AbleTitleArrayItem item : list) {
			data.writeInt(item.getEnableTitleId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			AbleTitleArrayItem item = AbleTitleArrayItem.create();
			item.setEnableTitleId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (AbleTitleArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static AbleTitleArray create() {
		AbleTitleArray array = new AbleTitleArray();
		return array;
	}

	public static AbleTitleArrayItem createItem() {
		AbleTitleArrayItem item = new AbleTitleArrayItem();
		return item;
	}

	public AbleTitleArrayItem addData(int enableTitleId) {
		AbleTitleArrayItem item = new AbleTitleArrayItem();
		item.setEnableTitleId(enableTitleId);
		list.add(item);
		return item;
	}

	public void addItem(AbleTitleArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (AbleTitleArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class AbleTitleArrayItem implements IMessageEncoder {
		private int enableTitleId;

		private static IntMessageParameterHandler enableTitleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EnableTitleId");

		public static AbleTitleArrayItem create() {
			AbleTitleArrayItem item = new AbleTitleArrayItem();
			return item;
		}

		/**
		 * @return the enableTitleId
		 */
		public int getEnableTitleId() {
			return enableTitleId;
		}

		/**
		 * @param enableTitleId
		 *            the enableTitleId to set
		 */
		public void setEnableTitleId(int enableTitleId) {
			this.enableTitleId = enableTitleId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.enableTitleId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.enableTitleId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!enableTitleIdHandler.validate(enableTitleId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("enableTitleId:").append(this.enableTitleId);
			return bb.toString();	
		}
	}
}