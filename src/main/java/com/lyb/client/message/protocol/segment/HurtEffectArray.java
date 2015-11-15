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
public class HurtEffectArray implements IMessageEncoder {
	private List<HurtEffectArrayItem> list = new LinkedList<HurtEffectArrayItem>();

	public List<HurtEffectArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (HurtEffectArrayItem item : list) {
			data.writeInt(item.getEffectId());
			data.writeInt(item.getEffectValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			HurtEffectArrayItem item = HurtEffectArrayItem.create();
			item.setEffectId(data.getInt());
			item.setEffectValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (HurtEffectArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static HurtEffectArray create() {
		HurtEffectArray array = new HurtEffectArray();
		return array;
	}

	public static HurtEffectArrayItem createItem() {
		HurtEffectArrayItem item = new HurtEffectArrayItem();
		return item;
	}

	public HurtEffectArrayItem addData(int effectId, int effectValue) {
		HurtEffectArrayItem item = new HurtEffectArrayItem();
		item.setEffectId(effectId);
		item.setEffectValue(effectValue);
		list.add(item);
		return item;
	}

	public void addItem(HurtEffectArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (HurtEffectArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class HurtEffectArrayItem implements IMessageEncoder {
		private int effectId;
		private int effectValue;

		private static IntMessageParameterHandler effectIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EffectId");
		private static IntMessageParameterHandler effectValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EffectValue");

		public static HurtEffectArrayItem create() {
			HurtEffectArrayItem item = new HurtEffectArrayItem();
			return item;
		}

		/**
		 * @return the effectId
		 */
		public int getEffectId() {
			return effectId;
		}

		/**
		 * @param effectId
		 *            the effectId to set
		 */
		public void setEffectId(int effectId) {
			this.effectId = effectId;
		}
		/**
		 * @return the effectValue
		 */
		public int getEffectValue() {
			return effectValue;
		}

		/**
		 * @param effectValue
		 *            the effectValue to set
		 */
		public void setEffectValue(int effectValue) {
			this.effectValue = effectValue;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.effectId);
			data.writeInt(this.effectValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.effectId = data.getInt();
			this.effectValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!effectIdHandler.validate(effectId)) {
				return false;
			}
			if (!effectValueHandler.validate(effectValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("effectId:").append(this.effectId).append(", ");
			bb.append("effectValue:").append(this.effectValue);
			return bb.toString();	
		}
	}
}