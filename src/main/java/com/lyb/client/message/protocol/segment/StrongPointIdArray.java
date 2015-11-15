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
public class StrongPointIdArray implements IMessageEncoder {
	private List<StrongPointIdArrayItem> list = new LinkedList<StrongPointIdArrayItem>();

	public List<StrongPointIdArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (StrongPointIdArrayItem item : list) {
			data.writeInt(item.getStrongPointId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			StrongPointIdArrayItem item = StrongPointIdArrayItem.create();
			item.setStrongPointId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (StrongPointIdArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static StrongPointIdArray create() {
		StrongPointIdArray array = new StrongPointIdArray();
		return array;
	}

	public static StrongPointIdArrayItem createItem() {
		StrongPointIdArrayItem item = new StrongPointIdArrayItem();
		return item;
	}

	public StrongPointIdArrayItem addData(int strongPointId) {
		StrongPointIdArrayItem item = new StrongPointIdArrayItem();
		item.setStrongPointId(strongPointId);
		list.add(item);
		return item;
	}

	public void addItem(StrongPointIdArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (StrongPointIdArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class StrongPointIdArrayItem implements IMessageEncoder {
		private int strongPointId;

		private static IntMessageParameterHandler strongPointIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrongPointId");

		public static StrongPointIdArrayItem create() {
			StrongPointIdArrayItem item = new StrongPointIdArrayItem();
			return item;
		}

		/**
		 * @return the strongPointId
		 */
		public int getStrongPointId() {
			return strongPointId;
		}

		/**
		 * @param strongPointId
		 *            the strongPointId to set
		 */
		public void setStrongPointId(int strongPointId) {
			this.strongPointId = strongPointId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.strongPointId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.strongPointId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!strongPointIdHandler.validate(strongPointId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("strongPointId:").append(this.strongPointId);
			return bb.toString();	
		}
	}
}