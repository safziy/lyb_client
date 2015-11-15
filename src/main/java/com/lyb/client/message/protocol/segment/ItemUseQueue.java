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
public class ItemUseQueue implements IMessageEncoder {
	private List<ItemUseQueueItem> list = new LinkedList<ItemUseQueueItem>();

	public List<ItemUseQueueItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ItemUseQueueItem item : list) {
			data.writeLong(item.getTriggerId());
			data.writeInt(item.getItemId());
			data.writeInt(item.getRemainSeconds());
			data.writeInt(item.getItemEffectId());
			data.writeInt(item.getItemEffectValue());
			data.writeString(item.getParamStr1());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ItemUseQueueItem item = ItemUseQueueItem.create();
			item.setTriggerId(data.getLong());
			item.setItemId(data.getInt());
			item.setRemainSeconds(data.getInt());
			item.setItemEffectId(data.getInt());
			item.setItemEffectValue(data.getInt());
			item.setParamStr1(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ItemUseQueueItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ItemUseQueue create() {
		ItemUseQueue array = new ItemUseQueue();
		return array;
	}

	public static ItemUseQueueItem createItem() {
		ItemUseQueueItem item = new ItemUseQueueItem();
		return item;
	}

	public ItemUseQueueItem addData(long triggerId, int itemId, int remainSeconds, int itemEffectId, int itemEffectValue, String paramStr1) {
		ItemUseQueueItem item = new ItemUseQueueItem();
		item.setTriggerId(triggerId);
		item.setItemId(itemId);
		item.setRemainSeconds(remainSeconds);
		item.setItemEffectId(itemEffectId);
		item.setItemEffectValue(itemEffectValue);
		item.setParamStr1(paramStr1);
		list.add(item);
		return item;
	}

	public void addItem(ItemUseQueueItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ItemUseQueueItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ItemUseQueueItem implements IMessageEncoder {
		private long triggerId;
		private int itemId;
		private int remainSeconds;
		private int itemEffectId;
		private int itemEffectValue;
		private String paramStr1;

		private static LongMessageParameterHandler triggerIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("TriggerId");
		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler remainSecondsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSeconds");
		private static IntMessageParameterHandler itemEffectIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemEffectId");
		private static IntMessageParameterHandler itemEffectValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemEffectValue");

		public static ItemUseQueueItem create() {
			ItemUseQueueItem item = new ItemUseQueueItem();
			return item;
		}

		/**
		 * @return the triggerId
		 */
		public long getTriggerId() {
			return triggerId;
		}

		/**
		 * @param triggerId
		 *            the triggerId to set
		 */
		public void setTriggerId(long triggerId) {
			this.triggerId = triggerId;
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
		 * @return the remainSeconds
		 */
		public int getRemainSeconds() {
			return remainSeconds;
		}

		/**
		 * @param remainSeconds
		 *            the remainSeconds to set
		 */
		public void setRemainSeconds(int remainSeconds) {
			this.remainSeconds = remainSeconds;
		}
		/**
		 * @return the itemEffectId
		 */
		public int getItemEffectId() {
			return itemEffectId;
		}

		/**
		 * @param itemEffectId
		 *            the itemEffectId to set
		 */
		public void setItemEffectId(int itemEffectId) {
			this.itemEffectId = itemEffectId;
		}
		/**
		 * @return the itemEffectValue
		 */
		public int getItemEffectValue() {
			return itemEffectValue;
		}

		/**
		 * @param itemEffectValue
		 *            the itemEffectValue to set
		 */
		public void setItemEffectValue(int itemEffectValue) {
			this.itemEffectValue = itemEffectValue;
		}
		/**
		 * @return the paramStr1
		 */
		public String getParamStr1() {
			return paramStr1;
		}

		/**
		 * @param paramStr1
		 *            the paramStr1 to set
		 */
		public void setParamStr1(String paramStr1) {
			this.paramStr1 = paramStr1;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.triggerId);
			data.writeInt(this.itemId);
			data.writeInt(this.remainSeconds);
			data.writeInt(this.itemEffectId);
			data.writeInt(this.itemEffectValue);
			data.writeString(this.paramStr1);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.triggerId = data.getLong();
			this.itemId = data.getInt();
			this.remainSeconds = data.getInt();
			this.itemEffectId = data.getInt();
			this.itemEffectValue = data.getInt();
			this.paramStr1 = data.getString();
		}
	
		@Override
		public boolean validate() {
			if (!triggerIdHandler.validate(triggerId)) {
				return false;
			}
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!remainSecondsHandler.validate(remainSeconds)) {
				return false;
			}
			if (!itemEffectIdHandler.validate(itemEffectId)) {
				return false;
			}
			if (!itemEffectValueHandler.validate(itemEffectValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("triggerId:").append(this.triggerId).append(", ");
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("remainSeconds:").append(this.remainSeconds).append(", ");
			bb.append("itemEffectId:").append(this.itemEffectId).append(", ");
			bb.append("itemEffectValue:").append(this.itemEffectValue).append(", ");
			bb.append("paramStr1:").append(this.paramStr1);
			return bb.toString();	
		}
	}
}