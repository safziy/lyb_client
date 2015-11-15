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
public class GoldItemArray implements IMessageEncoder {
	private List<GoldItemArrayItem> list = new LinkedList<GoldItemArrayItem>();

	public List<GoldItemArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (GoldItemArrayItem item : list) {
			data.writeInt(item.getPosition());
			data.writeInt(item.getItemId());
			data.writeInt(item.getCount());
			data.writeInt(item.getCostType());
			data.writeInt(item.getCostValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			GoldItemArrayItem item = GoldItemArrayItem.create();
			item.setPosition(data.getInt());
			item.setItemId(data.getInt());
			item.setCount(data.getInt());
			item.setCostType(data.getInt());
			item.setCostValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (GoldItemArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static GoldItemArray create() {
		GoldItemArray array = new GoldItemArray();
		return array;
	}

	public static GoldItemArrayItem createItem() {
		GoldItemArrayItem item = new GoldItemArrayItem();
		return item;
	}

	public GoldItemArrayItem addData(int position, int itemId, int count, int costType, int costValue) {
		GoldItemArrayItem item = new GoldItemArrayItem();
		item.setPosition(position);
		item.setItemId(itemId);
		item.setCount(count);
		item.setCostType(costType);
		item.setCostValue(costValue);
		list.add(item);
		return item;
	}

	public void addItem(GoldItemArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (GoldItemArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class GoldItemArrayItem implements IMessageEncoder {
		private int position;
		private int itemId;
		private int count;
		private int costType;
		private int costValue;

		private static IntMessageParameterHandler positionHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Position");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler costTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CostType");
		private static IntMessageParameterHandler costValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CostValue");

		public static GoldItemArrayItem create() {
			GoldItemArrayItem item = new GoldItemArrayItem();
			return item;
		}

		/**
		 * @return the position
		 */
		public int getPosition() {
			return position;
		}

		/**
		 * @param position
		 *            the position to set
		 */
		public void setPosition(int position) {
			this.position = position;
		}
		/**
		 * @return the itemId
		 */
		public int getItemId() {
			return itemId;
		}

		/**
		 * @param itemId
		 *            the itemId to set
		 */
		public void setItemId(int itemId) {
			this.itemId = itemId;
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
		 * @return the costType
		 */
		public int getCostType() {
			return costType;
		}

		/**
		 * @param costType
		 *            the costType to set
		 */
		public void setCostType(int costType) {
			this.costType = costType;
		}
		/**
		 * @return the costValue
		 */
		public int getCostValue() {
			return costValue;
		}

		/**
		 * @param costValue
		 *            the costValue to set
		 */
		public void setCostValue(int costValue) {
			this.costValue = costValue;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.position);
			data.writeInt(this.itemId);
			data.writeInt(this.count);
			data.writeInt(this.costType);
			data.writeInt(this.costValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.position = data.getInt();
			this.itemId = data.getInt();
			this.count = data.getInt();
			this.costType = data.getInt();
			this.costValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!positionHandler.validate(position)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!costTypeHandler.validate(costType)) {
				return false;
			}
			if (!costValueHandler.validate(costValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("position:").append(this.position).append(", ");
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("costType:").append(this.costType).append(", ");
			bb.append("costValue:").append(this.costValue);
			return bb.toString();	
		}
	}
}