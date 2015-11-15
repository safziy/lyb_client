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
public class ExtraPropertyArray implements IMessageEncoder {
	private List<ExtraPropertyArrayItem> list = new LinkedList<ExtraPropertyArrayItem>();

	public List<ExtraPropertyArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ExtraPropertyArrayItem item : list) {
			data.writeLong(item.getID());
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
			ExtraPropertyArrayItem item = ExtraPropertyArrayItem.create();
			item.setID(data.getLong());
			item.setPropertyKey(data.getInt());
			item.setPropertyValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ExtraPropertyArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ExtraPropertyArray create() {
		ExtraPropertyArray array = new ExtraPropertyArray();
		return array;
	}

	public static ExtraPropertyArrayItem createItem() {
		ExtraPropertyArrayItem item = new ExtraPropertyArrayItem();
		return item;
	}

	public ExtraPropertyArrayItem addData(long iD, int propertyKey, int propertyValue) {
		ExtraPropertyArrayItem item = new ExtraPropertyArrayItem();
		item.setID(iD);
		item.setPropertyKey(propertyKey);
		item.setPropertyValue(propertyValue);
		list.add(item);
		return item;
	}

	public void addItem(ExtraPropertyArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ExtraPropertyArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ExtraPropertyArrayItem implements IMessageEncoder {
		private long iD;
		private int propertyKey;
		private int propertyValue;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler propertyKeyHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PropertyKey");
		private static IntMessageParameterHandler propertyValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PropertyValue");

		public static ExtraPropertyArrayItem create() {
			ExtraPropertyArrayItem item = new ExtraPropertyArrayItem();
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
			data.writeLong(this.iD);
			data.writeInt(this.propertyKey);
			data.writeInt(this.propertyValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.propertyKey = data.getInt();
			this.propertyValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
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
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("propertyKey:").append(this.propertyKey).append(", ");
			bb.append("propertyValue:").append(this.propertyValue);
			return bb.toString();	
		}
	}
}