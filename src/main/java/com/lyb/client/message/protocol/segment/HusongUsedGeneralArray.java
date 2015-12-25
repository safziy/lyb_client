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
public class HusongUsedGeneralArray implements IMessageEncoder {
	private List<HusongUsedGeneralArrayItem> list = new LinkedList<HusongUsedGeneralArrayItem>();

	public List<HusongUsedGeneralArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (HusongUsedGeneralArrayItem item : list) {
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
			HusongUsedGeneralArrayItem item = HusongUsedGeneralArrayItem.create();
			item.setConfigId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (HusongUsedGeneralArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static HusongUsedGeneralArray create() {
		HusongUsedGeneralArray array = new HusongUsedGeneralArray();
		return array;
	}

	public static HusongUsedGeneralArrayItem createItem() {
		HusongUsedGeneralArrayItem item = new HusongUsedGeneralArrayItem();
		return item;
	}

	public HusongUsedGeneralArrayItem addData(int configId) {
		HusongUsedGeneralArrayItem item = new HusongUsedGeneralArrayItem();
		item.setConfigId(configId);
		list.add(item);
		return item;
	}

	public void addItem(HusongUsedGeneralArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (HusongUsedGeneralArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class HusongUsedGeneralArrayItem implements IMessageEncoder {
		private int configId;

		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

		public static HusongUsedGeneralArrayItem create() {
			HusongUsedGeneralArrayItem item = new HusongUsedGeneralArrayItem();
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