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
public class GeneralIdTableArray implements IMessageEncoder {
	private List<GeneralIdTableArrayItem> list = new LinkedList<GeneralIdTableArrayItem>();

	public List<GeneralIdTableArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (GeneralIdTableArrayItem item : list) {
			data.writeInt(item.getConfigId());
			data.writeInt(item.getBodyId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			GeneralIdTableArrayItem item = GeneralIdTableArrayItem.create();
			item.setConfigId(data.getInt());
			item.setBodyId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (GeneralIdTableArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static GeneralIdTableArray create() {
		GeneralIdTableArray array = new GeneralIdTableArray();
		return array;
	}

	public static GeneralIdTableArrayItem createItem() {
		GeneralIdTableArrayItem item = new GeneralIdTableArrayItem();
		return item;
	}

	public GeneralIdTableArrayItem addData(int configId, int bodyId) {
		GeneralIdTableArrayItem item = new GeneralIdTableArrayItem();
		item.setConfigId(configId);
		item.setBodyId(bodyId);
		list.add(item);
		return item;
	}

	public void addItem(GeneralIdTableArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (GeneralIdTableArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class GeneralIdTableArrayItem implements IMessageEncoder {
		private int configId;
		private int bodyId;

		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler bodyIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BodyId");

		public static GeneralIdTableArrayItem create() {
			GeneralIdTableArrayItem item = new GeneralIdTableArrayItem();
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
		 * @return the bodyId
		 */
		public int getBodyId() {
			return bodyId;
		}

		/**
		 * @param bodyId
		 *            the bodyId to set
		 */
		public void setBodyId(int bodyId) {
			this.bodyId = bodyId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.configId);
			data.writeInt(this.bodyId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.configId = data.getInt();
			this.bodyId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!bodyIdHandler.validate(bodyId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("bodyId:").append(this.bodyId);
			return bb.toString();	
		}
	}
}