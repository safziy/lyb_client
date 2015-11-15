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
public class WuShuangSkillArray implements IMessageEncoder {
	private List<WuShuangSkillArrayItem> list = new LinkedList<WuShuangSkillArrayItem>();

	public List<WuShuangSkillArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (WuShuangSkillArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeInt(item.getSkillId());
			data.writeInt(item.getConfigId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			WuShuangSkillArrayItem item = WuShuangSkillArrayItem.create();
			item.setPlace(data.getInt());
			item.setSkillId(data.getInt());
			item.setConfigId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (WuShuangSkillArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static WuShuangSkillArray create() {
		WuShuangSkillArray array = new WuShuangSkillArray();
		return array;
	}

	public static WuShuangSkillArrayItem createItem() {
		WuShuangSkillArrayItem item = new WuShuangSkillArrayItem();
		return item;
	}

	public WuShuangSkillArrayItem addData(int place, int skillId, int configId) {
		WuShuangSkillArrayItem item = new WuShuangSkillArrayItem();
		item.setPlace(place);
		item.setSkillId(skillId);
		item.setConfigId(configId);
		list.add(item);
		return item;
	}

	public void addItem(WuShuangSkillArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (WuShuangSkillArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class WuShuangSkillArrayItem implements IMessageEncoder {
		private int place;
		private int skillId;
		private int configId;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

		public static WuShuangSkillArrayItem create() {
			WuShuangSkillArrayItem item = new WuShuangSkillArrayItem();
			return item;
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
		 * @return the configId
		 */
		public int getConfigId() {
			return configId;
		}

		/**
		 * @param configId
		 *            the configId to set
		 */
		public void setConfigId(int configId) {
			this.configId = configId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeInt(this.skillId);
			data.writeInt(this.configId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.skillId = data.getInt();
			this.configId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!skillIdHandler.validate(skillId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("skillId:").append(this.skillId).append(", ");
			bb.append("configId:").append(this.configId);
			return bb.toString();	
		}
	}
}