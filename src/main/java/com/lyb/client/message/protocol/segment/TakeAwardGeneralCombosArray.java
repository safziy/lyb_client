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
public class TakeAwardGeneralCombosArray implements IMessageEncoder {
	private List<TakeAwardGeneralCombosArrayItem> list = new LinkedList<TakeAwardGeneralCombosArrayItem>();

	public List<TakeAwardGeneralCombosArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TakeAwardGeneralCombosArrayItem item : list) {
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
			TakeAwardGeneralCombosArrayItem item = TakeAwardGeneralCombosArrayItem.create();
			item.setConfigId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TakeAwardGeneralCombosArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TakeAwardGeneralCombosArray create() {
		TakeAwardGeneralCombosArray array = new TakeAwardGeneralCombosArray();
		return array;
	}

	public static TakeAwardGeneralCombosArrayItem createItem() {
		TakeAwardGeneralCombosArrayItem item = new TakeAwardGeneralCombosArrayItem();
		return item;
	}

	public TakeAwardGeneralCombosArrayItem addData(int configId) {
		TakeAwardGeneralCombosArrayItem item = new TakeAwardGeneralCombosArrayItem();
		item.setConfigId(configId);
		list.add(item);
		return item;
	}

	public void addItem(TakeAwardGeneralCombosArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TakeAwardGeneralCombosArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TakeAwardGeneralCombosArrayItem implements IMessageEncoder {
		private int configId;

		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

		public static TakeAwardGeneralCombosArrayItem create() {
			TakeAwardGeneralCombosArrayItem item = new TakeAwardGeneralCombosArrayItem();
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