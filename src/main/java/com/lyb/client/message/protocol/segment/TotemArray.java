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
public class TotemArray implements IMessageEncoder {
	private List<TotemArrayItem> list = new LinkedList<TotemArrayItem>();

	public List<TotemArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TotemArrayItem item : list) {
			data.writeInt(item.getTotemId());
			data.writeInt(item.getExperience());
			data.writeInt(item.getLevel());
			data.writeInt(item.getIsEnableWithCurrency());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			TotemArrayItem item = TotemArrayItem.create();
			item.setTotemId(data.getInt());
			item.setExperience(data.getInt());
			item.setLevel(data.getInt());
			item.setIsEnableWithCurrency(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TotemArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TotemArray create() {
		TotemArray array = new TotemArray();
		return array;
	}

	public static TotemArrayItem createItem() {
		TotemArrayItem item = new TotemArrayItem();
		return item;
	}

	public TotemArrayItem addData(int totemId, int experience, int level, int isEnableWithCurrency) {
		TotemArrayItem item = new TotemArrayItem();
		item.setTotemId(totemId);
		item.setExperience(experience);
		item.setLevel(level);
		item.setIsEnableWithCurrency(isEnableWithCurrency);
		list.add(item);
		return item;
	}

	public void addItem(TotemArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TotemArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TotemArrayItem implements IMessageEncoder {
		private int totemId;
		private int experience;
		private int level;
		private int isEnableWithCurrency;

		private static IntMessageParameterHandler totemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TotemId");
		private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler isEnableWithCurrencyHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("IsEnableWithCurrency");

		public static TotemArrayItem create() {
			TotemArrayItem item = new TotemArrayItem();
			return item;
		}

		/**
		 * @return the totemId
		 */
		public int getTotemId() {
			return totemId;
		}

		/**
		 * @param totemId
		 *            the totemId to set
		 */
		public void setTotemId(int totemId) {
			this.totemId = totemId;
		}
		/**
		 * @return the experience
		 */
		public int getExperience() {
			return experience;
		}

		/**
		 * @param experience
		 *            the experience to set
		 */
		public void setExperience(int experience) {
			this.experience = experience;
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
		 * @return the isEnableWithCurrency
		 */
		public int getIsEnableWithCurrency() {
			return isEnableWithCurrency;
		}

		/**
		 * @param isEnableWithCurrency
		 *            the isEnableWithCurrency to set
		 */
		public void setIsEnableWithCurrency(int isEnableWithCurrency) {
			this.isEnableWithCurrency = isEnableWithCurrency;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.totemId);
			data.writeInt(this.experience);
			data.writeInt(this.level);
			data.writeInt(this.isEnableWithCurrency);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.totemId = data.getInt();
			this.experience = data.getInt();
			this.level = data.getInt();
			this.isEnableWithCurrency = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!totemIdHandler.validate(totemId)) {
				return false;
			}
			if (!experienceHandler.validate(experience)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!isEnableWithCurrencyHandler.validate(isEnableWithCurrency)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("totemId:").append(this.totemId).append(", ");
			bb.append("experience:").append(this.experience).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("isEnableWithCurrency:").append(this.isEnableWithCurrency);
			return bb.toString();	
		}
	}
}