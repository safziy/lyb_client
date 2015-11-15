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
public class BeInvitedArray implements IMessageEncoder {
	private List<BeInvitedArrayItem> list = new LinkedList<BeInvitedArrayItem>();

	public List<BeInvitedArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BeInvitedArrayItem item : list) {
			data.writeInt(item.getCount());
			data.writeInt(item.getLevel());
			data.writeInt(item.getBooleanValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BeInvitedArrayItem item = BeInvitedArrayItem.create();
			item.setCount(data.getInt());
			item.setLevel(data.getInt());
			item.setBooleanValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BeInvitedArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BeInvitedArray create() {
		BeInvitedArray array = new BeInvitedArray();
		return array;
	}

	public static BeInvitedArrayItem createItem() {
		BeInvitedArrayItem item = new BeInvitedArrayItem();
		return item;
	}

	public BeInvitedArrayItem addData(int count, int level, int booleanValue) {
		BeInvitedArrayItem item = new BeInvitedArrayItem();
		item.setCount(count);
		item.setLevel(level);
		item.setBooleanValue(booleanValue);
		list.add(item);
		return item;
	}

	public void addItem(BeInvitedArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BeInvitedArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BeInvitedArrayItem implements IMessageEncoder {
		private int count;
		private int level;
		private int booleanValue;

		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static BeInvitedArrayItem create() {
			BeInvitedArrayItem item = new BeInvitedArrayItem();
			return item;
		}

		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}

		/**
		 * @param count
		 *            the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}
		/**
		 * @return the level
		 */
		public int getLevel() {
			return level;
		}

		/**
		 * @param level
		 *            the level to set
		 */
		public void setLevel(int level) {
			this.level = level;
		}
		/**
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.count);
			data.writeInt(this.level);
			data.writeInt(this.booleanValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.count = data.getInt();
			this.level = data.getInt();
			this.booleanValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("count:").append(this.count).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("booleanValue:").append(this.booleanValue);
			return bb.toString();	
		}
	}
}