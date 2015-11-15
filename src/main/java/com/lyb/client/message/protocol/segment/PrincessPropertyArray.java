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
public class PrincessPropertyArray implements IMessageEncoder {
	private List<PrincessPropertyArrayItem> list = new LinkedList<PrincessPropertyArrayItem>();

	public List<PrincessPropertyArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PrincessPropertyArrayItem item : list) {
			data.writeInt(item.getPropertyKey());
			data.writeInt(item.getLevel());
			data.writeInt(item.getExperience());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PrincessPropertyArrayItem item = PrincessPropertyArrayItem.create();
			item.setPropertyKey(data.getInt());
			item.setLevel(data.getInt());
			item.setExperience(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PrincessPropertyArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PrincessPropertyArray create() {
		PrincessPropertyArray array = new PrincessPropertyArray();
		return array;
	}

	public static PrincessPropertyArrayItem createItem() {
		PrincessPropertyArrayItem item = new PrincessPropertyArrayItem();
		return item;
	}

	public PrincessPropertyArrayItem addData(int propertyKey, int level, int experience) {
		PrincessPropertyArrayItem item = new PrincessPropertyArrayItem();
		item.setPropertyKey(propertyKey);
		item.setLevel(level);
		item.setExperience(experience);
		list.add(item);
		return item;
	}

	public void addItem(PrincessPropertyArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PrincessPropertyArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PrincessPropertyArrayItem implements IMessageEncoder {
		private int propertyKey;
		private int level;
		private int experience;

		private static IntMessageParameterHandler propertyKeyHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PropertyKey");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");

		public static PrincessPropertyArrayItem create() {
			PrincessPropertyArrayItem item = new PrincessPropertyArrayItem();
			return item;
		}

		/**
		 * @return the propertyKey
		 */
		public int getPropertyKey() {
			return propertyKey;
		}

		/**
		 * @param propertyKey
		 *            the propertyKey to set
		 */
		public void setPropertyKey(int propertyKey) {
			this.propertyKey = propertyKey;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.propertyKey);
			data.writeInt(this.level);
			data.writeInt(this.experience);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.propertyKey = data.getInt();
			this.level = data.getInt();
			this.experience = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!propertyKeyHandler.validate(propertyKey)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!experienceHandler.validate(experience)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("propertyKey:").append(this.propertyKey).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("experience:").append(this.experience);
			return bb.toString();	
		}
	}
}