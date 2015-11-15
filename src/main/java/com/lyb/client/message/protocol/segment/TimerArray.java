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
public class TimerArray implements IMessageEncoder {
	private List<TimerArrayItem> list = new LinkedList<TimerArrayItem>();

	public List<TimerArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TimerArrayItem item : list) {
			data.writeString(item.getTimerType());
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
			TimerArrayItem item = TimerArrayItem.create();
			item.setTimerType(data.getString());
			item.setValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TimerArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TimerArray create() {
		TimerArray array = new TimerArray();
		return array;
	}

	public static TimerArrayItem createItem() {
		TimerArrayItem item = new TimerArrayItem();
		return item;
	}

	public TimerArrayItem addData(String timerType, int value) {
		TimerArrayItem item = new TimerArrayItem();
		item.setTimerType(timerType);
		item.setValue(value);
		list.add(item);
		return item;
	}

	public void addItem(TimerArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TimerArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TimerArrayItem implements IMessageEncoder {
		private String timerType;
		private int value;

		private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");

		public static TimerArrayItem create() {
			TimerArrayItem item = new TimerArrayItem();
			return item;
		}

		/**
		 * @return the timerType
		 */
		public String getTimerType() {
			return timerType;
		}

		/**
		 * @param timerType
		 *            the timerType to set
		 */
		public void setTimerType(String timerType) {
			this.timerType = timerType;
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
			data.writeString(this.timerType);
			data.writeInt(this.value);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.timerType = data.getString();
			this.value = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!valueHandler.validate(value)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("timerType:").append(this.timerType).append(", ");
			bb.append("value:").append(this.value);
			return bb.toString();	
		}
	}
}