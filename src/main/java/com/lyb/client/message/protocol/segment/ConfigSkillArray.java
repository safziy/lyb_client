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
public class ConfigSkillArray implements IMessageEncoder {
	private List<ConfigSkillArrayItem> list = new LinkedList<ConfigSkillArrayItem>();

	public List<ConfigSkillArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ConfigSkillArrayItem item : list) {
			data.writeInt(item.getSkillId());
			data.writeInt(item.getLevel());
			data.writeInt(item.getPlace());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ConfigSkillArrayItem item = ConfigSkillArrayItem.create();
			item.setSkillId(data.getInt());
			item.setLevel(data.getInt());
			item.setPlace(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ConfigSkillArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ConfigSkillArray create() {
		ConfigSkillArray array = new ConfigSkillArray();
		return array;
	}

	public static ConfigSkillArrayItem createItem() {
		ConfigSkillArrayItem item = new ConfigSkillArrayItem();
		return item;
	}

	public ConfigSkillArrayItem addData(int skillId, int level, int place) {
		ConfigSkillArrayItem item = new ConfigSkillArrayItem();
		item.setSkillId(skillId);
		item.setLevel(level);
		item.setPlace(place);
		list.add(item);
		return item;
	}

	public void addItem(ConfigSkillArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ConfigSkillArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ConfigSkillArrayItem implements IMessageEncoder {
		private int skillId;
		private int level;
		private int place;

		private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");

		public static ConfigSkillArrayItem create() {
			ConfigSkillArrayItem item = new ConfigSkillArrayItem();
			return item;
		}

		/**
		 * @return the skillId
		 */
		public int getSkillId() {
			return skillId;
		}

		/**
		 * @param skillId
		 *            the skillId to set
		 */
		public void setSkillId(int skillId) {
			this.skillId = skillId;
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
		 * @return the place
		 */
		public int getPlace() {
			return place;
		}

		/**
		 * @param place
		 *            the place to set
		 */
		public void setPlace(int place) {
			this.place = place;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.skillId);
			data.writeInt(this.level);
			data.writeInt(this.place);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.skillId = data.getInt();
			this.level = data.getInt();
			this.place = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!skillIdHandler.validate(skillId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!placeHandler.validate(place)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("skillId:").append(this.skillId).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("place:").append(this.place);
			return bb.toString();	
		}
	}
}