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
public class DelStarArray implements IMessageEncoder {
	private List<DelStarArrayItem> list = new LinkedList<DelStarArrayItem>();

	public List<DelStarArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (DelStarArrayItem item : list) {
			data.writeInt(item.getStarId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			DelStarArrayItem item = DelStarArrayItem.create();
			item.setStarId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (DelStarArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static DelStarArray create() {
		DelStarArray array = new DelStarArray();
		return array;
	}

	public static DelStarArrayItem createItem() {
		DelStarArrayItem item = new DelStarArrayItem();
		return item;
	}

	public DelStarArrayItem addData(int starId) {
		DelStarArrayItem item = new DelStarArrayItem();
		item.setStarId(starId);
		list.add(item);
		return item;
	}

	public void addItem(DelStarArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (DelStarArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class DelStarArrayItem implements IMessageEncoder {
		private int starId;

		private static IntMessageParameterHandler starIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarId");

		public static DelStarArrayItem create() {
			DelStarArrayItem item = new DelStarArrayItem();
			return item;
		}

		/**
		 * @return the starId
		 */
		public int getStarId() {
			return starId;
		}

		/**
		 * @param starId
		 *            the starId to set
		 */
		public void setStarId(int starId) {
			this.starId = starId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.starId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.starId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!starIdHandler.validate(starId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("starId:").append(this.starId);
			return bb.toString();	
		}
	}
}