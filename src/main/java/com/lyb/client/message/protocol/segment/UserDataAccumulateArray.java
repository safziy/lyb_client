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
public class UserDataAccumulateArray implements IMessageEncoder {
	private List<UserDataAccumulateArrayItem> list = new LinkedList<UserDataAccumulateArrayItem>();

	public List<UserDataAccumulateArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserDataAccumulateArrayItem item : list) {
			data.writeInt(item.getType());
			data.writeInt(item.getParam());
			data.writeInt(item.getValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			UserDataAccumulateArrayItem item = UserDataAccumulateArrayItem.create();
			item.setType(data.getInt());
			item.setParam(data.getInt());
			item.setValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserDataAccumulateArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserDataAccumulateArray create() {
		UserDataAccumulateArray array = new UserDataAccumulateArray();
		return array;
	}

	public static UserDataAccumulateArrayItem createItem() {
		UserDataAccumulateArrayItem item = new UserDataAccumulateArrayItem();
		return item;
	}

	public UserDataAccumulateArrayItem addData(int type, int param, int value) {
		UserDataAccumulateArrayItem item = new UserDataAccumulateArrayItem();
		item.setType(type);
		item.setParam(param);
		item.setValue(value);
		list.add(item);
		return item;
	}

	public void addItem(UserDataAccumulateArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserDataAccumulateArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserDataAccumulateArrayItem implements IMessageEncoder {
		private int type;
		private int param;
		private int value;

		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler paramHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param");
		private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");

		public static UserDataAccumulateArrayItem create() {
			UserDataAccumulateArrayItem item = new UserDataAccumulateArrayItem();
			return item;
		}

		/**
		 * @return the type
		 */
		public int getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(int type) {
			this.type = type;
		}
		/**
		 * @return the param
		 */
		public int getParam() {
			return param;
		}

		/**
		 * @param param
		 *            the param to set
		 */
		public void setParam(int param) {
			this.param = param;
		}
		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.type);
			data.writeInt(this.param);
			data.writeInt(this.value);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.type = data.getInt();
			this.param = data.getInt();
			this.value = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!typeHandler.validate(type)) {
				return false;
			}
			if (!paramHandler.validate(param)) {
				return false;
			}
			if (!valueHandler.validate(value)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("type:").append(this.type).append(", ");
			bb.append("param:").append(this.param).append(", ");
			bb.append("value:").append(this.value);
			return bb.toString();	
		}
	}
}