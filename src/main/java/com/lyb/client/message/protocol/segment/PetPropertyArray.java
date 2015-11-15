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
public class PetPropertyArray implements IMessageEncoder {
	private List<PetPropertyArrayItem> list = new LinkedList<PetPropertyArrayItem>();

	public List<PetPropertyArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PetPropertyArrayItem item : list) {
			data.writeInt(item.getPropertyKey());
			data.writeInt(item.getPropertyValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PetPropertyArrayItem item = PetPropertyArrayItem.create();
			item.setPropertyKey(data.getInt());
			item.setPropertyValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PetPropertyArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PetPropertyArray create() {
		PetPropertyArray array = new PetPropertyArray();
		return array;
	}

	public static PetPropertyArrayItem createItem() {
		PetPropertyArrayItem item = new PetPropertyArrayItem();
		return item;
	}

	public PetPropertyArrayItem addData(int propertyKey, int propertyValue) {
		PetPropertyArrayItem item = new PetPropertyArrayItem();
		item.setPropertyKey(propertyKey);
		item.setPropertyValue(propertyValue);
		list.add(item);
		return item;
	}

	public void addItem(PetPropertyArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PetPropertyArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PetPropertyArrayItem implements IMessageEncoder {
		private int propertyKey;
		private int propertyValue;

		private static IntMessageParameterHandler propertyKeyHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PropertyKey");
		private static IntMessageParameterHandler propertyValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PropertyValue");

		public static PetPropertyArrayItem create() {
			PetPropertyArrayItem item = new PetPropertyArrayItem();
			return item;
		}

		/**
		 * @return the propertyKey
		 */
		public int getPropertyKey() {
			return propertyKey;
		}

		/**
		 * @param propertyKey
		 *            the propertyKey to set
		 */
		public void setPropertyKey(int propertyKey) {
			this.propertyKey = propertyKey;
		}
		/**
		 * @return the propertyValue
		 */
		public int getPropertyValue() {
			return propertyValue;
		}

		/**
		 * @param propertyValue
		 *            the propertyValue to set
		 */
		public void setPropertyValue(int propertyValue) {
			this.propertyValue = propertyValue;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.propertyKey);
			data.writeInt(this.propertyValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.propertyKey = data.getInt();
			this.propertyValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!propertyKeyHandler.validate(propertyKey)) {
				return false;
			}
			if (!propertyValueHandler.validate(propertyValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("propertyKey:").append(this.propertyKey).append(", ");
			bb.append("propertyValue:").append(this.propertyValue);
			return bb.toString();	
		}
	}
}