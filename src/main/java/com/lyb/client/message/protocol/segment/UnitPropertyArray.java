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
public class UnitPropertyArray implements IMessageEncoder {
	private List<UnitPropertyArrayItem> list = new LinkedList<UnitPropertyArrayItem>();

	public List<UnitPropertyArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UnitPropertyArrayItem item : list) {
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
			UnitPropertyArrayItem item = UnitPropertyArrayItem.create();
			item.setPropertyKey(data.getInt());
			item.setPropertyValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UnitPropertyArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UnitPropertyArray create() {
		UnitPropertyArray array = new UnitPropertyArray();
		return array;
	}

	public static UnitPropertyArrayItem createItem() {
		UnitPropertyArrayItem item = new UnitPropertyArrayItem();
		return item;
	}

	public UnitPropertyArrayItem addData(int propertyKey, int propertyValue) {
		UnitPropertyArrayItem item = new UnitPropertyArrayItem();
		item.setPropertyKey(propertyKey);
		item.setPropertyValue(propertyValue);
		list.add(item);
		return item;
	}

	public void addItem(UnitPropertyArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UnitPropertyArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UnitPropertyArrayItem implements IMessageEncoder {
		private int propertyKey;
		private int propertyValue;

		private static IntMessageParameterHandler propertyKeyHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PropertyKey");
		private static IntMessageParameterHandler propertyValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PropertyValue");

		public static UnitPropertyArrayItem create() {
			UnitPropertyArrayItem item = new UnitPropertyArrayItem();
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