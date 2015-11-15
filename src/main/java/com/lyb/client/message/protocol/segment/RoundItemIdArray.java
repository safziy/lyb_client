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
public class RoundItemIdArray implements IMessageEncoder {
	private List<RoundItemIdArrayItem> list = new LinkedList<RoundItemIdArrayItem>();

	public List<RoundItemIdArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (RoundItemIdArrayItem item : list) {
			data.writeInt(item.getRound());
			item.getItemIdArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			RoundItemIdArrayItem item = RoundItemIdArrayItem.create();
			item.setRound(data.getInt());
			item.setItemIdArray(ItemIdArray.create());
			item.getItemIdArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (RoundItemIdArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static RoundItemIdArray create() {
		RoundItemIdArray array = new RoundItemIdArray();
		return array;
	}

	public static RoundItemIdArrayItem createItem() {
		RoundItemIdArrayItem item = new RoundItemIdArrayItem();
		return item;
	}

	public RoundItemIdArrayItem addData(int round, ItemIdArray itemIdArray) {
		RoundItemIdArrayItem item = new RoundItemIdArrayItem();
		item.setRound(round);
		item.setItemIdArray(itemIdArray);
		list.add(item);
		return item;
	}

	public void addItem(RoundItemIdArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (RoundItemIdArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class RoundItemIdArrayItem implements IMessageEncoder {
		private int round;
		private ItemIdArray itemIdArray;

		private static IntMessageParameterHandler roundHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Round");

		public static RoundItemIdArrayItem create() {
			RoundItemIdArrayItem item = new RoundItemIdArrayItem();
			return item;
		}

		/**
		 * @return the round
		 */
		public int getRound() {
			return round;
		}

		/**
		 * @param round
		 *            the round to set
		 */
		public void setRound(int round) {
			this.round = round;
		}
		/**
		 * @return the itemIdArray
		 */
		public ItemIdArray getItemIdArray() {
			return itemIdArray;
		}

		/**
		 * @param itemIdArray
		 *            the itemIdArray to set
		 */
		public void setItemIdArray(ItemIdArray itemIdArray) {
			this.itemIdArray = itemIdArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.round);
			itemIdArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.round = data.getInt();
			itemIdArray = ItemIdArray.create();
			itemIdArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!roundHandler.validate(round)) {
				return false;
			}
			if (!itemIdArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("round:").append(this.round).append(", ");
			bb.append("itemIdArray:").append(itemIdArray.toString());
			return bb.toString();	
		}
	}
}