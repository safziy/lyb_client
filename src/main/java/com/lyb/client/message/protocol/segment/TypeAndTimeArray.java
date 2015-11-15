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
public class TypeAndTimeArray implements IMessageEncoder {
	private List<TypeAndTimeArrayItem> list = new LinkedList<TypeAndTimeArrayItem>();

	public List<TypeAndTimeArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TypeAndTimeArrayItem item : list) {
			data.writeInt(item.getByteType());
			data.writeInt(item.getTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			TypeAndTimeArrayItem item = TypeAndTimeArrayItem.create();
			item.setByteType(data.getInt());
			item.setTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TypeAndTimeArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TypeAndTimeArray create() {
		TypeAndTimeArray array = new TypeAndTimeArray();
		return array;
	}

	public static TypeAndTimeArrayItem createItem() {
		TypeAndTimeArrayItem item = new TypeAndTimeArrayItem();
		return item;
	}

	public TypeAndTimeArrayItem addData(int byteType, int time) {
		TypeAndTimeArrayItem item = new TypeAndTimeArrayItem();
		item.setByteType(byteType);
		item.setTime(time);
		list.add(item);
		return item;
	}

	public void addItem(TypeAndTimeArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TypeAndTimeArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TypeAndTimeArrayItem implements IMessageEncoder {
		private int byteType;
		private int time;

		private static IntMessageParameterHandler byteTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ByteType");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

		public static TypeAndTimeArrayItem create() {
			TypeAndTimeArrayItem item = new TypeAndTimeArrayItem();
			return item;
		}

		/**
		 * @return the byteType
		 */
		public int getByteType() {
			return byteType;
		}

		/**
		 * @param byteType
		 *            the byteType to set
		 */
		public void setByteType(int byteType) {
			this.byteType = byteType;
		}
		/**
		 * @return the time
		 */
		public int getTime() {
			return time;
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(int time) {
			this.time = time;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.byteType);
			data.writeInt(this.time);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.byteType = data.getInt();
			this.time = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!byteTypeHandler.validate(byteType)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("byteType:").append(this.byteType).append(", ");
			bb.append("time:").append(this.time);
			return bb.toString();	
		}
	}
}