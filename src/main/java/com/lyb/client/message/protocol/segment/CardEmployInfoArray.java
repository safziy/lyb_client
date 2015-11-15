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
public class CardEmployInfoArray implements IMessageEncoder {
	private List<CardEmployInfoArrayItem> list = new LinkedList<CardEmployInfoArrayItem>();

	public List<CardEmployInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (CardEmployInfoArrayItem item : list) {
			data.writeInt(item.getConfigId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			CardEmployInfoArrayItem item = CardEmployInfoArrayItem.create();
			item.setConfigId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (CardEmployInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static CardEmployInfoArray create() {
		CardEmployInfoArray array = new CardEmployInfoArray();
		return array;
	}

	public static CardEmployInfoArrayItem createItem() {
		CardEmployInfoArrayItem item = new CardEmployInfoArrayItem();
		return item;
	}

	public CardEmployInfoArrayItem addData(int configId) {
		CardEmployInfoArrayItem item = new CardEmployInfoArrayItem();
		item.setConfigId(configId);
		list.add(item);
		return item;
	}

	public void addItem(CardEmployInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (CardEmployInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class CardEmployInfoArrayItem implements IMessageEncoder {
		private int configId;

		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

		public static CardEmployInfoArrayItem create() {
			CardEmployInfoArrayItem item = new CardEmployInfoArrayItem();
			return item;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.configId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.configId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("configId:").append(this.configId);
			return bb.toString();	
		}
	}
}