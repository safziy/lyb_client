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
public class HeatWineArray implements IMessageEncoder {
	private List<HeatWineArrayItem> list = new LinkedList<HeatWineArrayItem>();

	public List<HeatWineArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (HeatWineArrayItem item : list) {
			data.writeString(item.getUserName());
			data.writeInt(item.getCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			HeatWineArrayItem item = HeatWineArrayItem.create();
			item.setUserName(data.getString());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (HeatWineArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static HeatWineArray create() {
		HeatWineArray array = new HeatWineArray();
		return array;
	}

	public static HeatWineArrayItem createItem() {
		HeatWineArrayItem item = new HeatWineArrayItem();
		return item;
	}

	public HeatWineArrayItem addData(String userName, int count) {
		HeatWineArrayItem item = new HeatWineArrayItem();
		item.setUserName(userName);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(HeatWineArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (HeatWineArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class HeatWineArrayItem implements IMessageEncoder {
		private String userName;
		private int count;

		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static HeatWineArrayItem create() {
			HeatWineArrayItem item = new HeatWineArrayItem();
			return item;
		}

		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName
		 *            the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.userName);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userName = data.getString();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!countHandler.validate(count)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}