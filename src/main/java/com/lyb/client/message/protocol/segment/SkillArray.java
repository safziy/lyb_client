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
public class SkillArray implements IMessageEncoder {
	private List<SkillArrayItem> list = new LinkedList<SkillArrayItem>();

	public List<SkillArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (SkillArrayItem item : list) {
			data.writeInt(item.getConfigId());
			data.writeInt(item.getLevel());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			SkillArrayItem item = SkillArrayItem.create();
			item.setConfigId(data.getInt());
			item.setLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (SkillArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static SkillArray create() {
		SkillArray array = new SkillArray();
		return array;
	}

	public static SkillArrayItem createItem() {
		SkillArrayItem item = new SkillArrayItem();
		return item;
	}

	public SkillArrayItem addData(int configId, int level) {
		SkillArrayItem item = new SkillArrayItem();
		item.setConfigId(configId);
		item.setLevel(level);
		list.add(item);
		return item;
	}

	public void addItem(SkillArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (SkillArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class SkillArrayItem implements IMessageEncoder {
		private int configId;
		private int level;

		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");

		public static SkillArrayItem create() {
			SkillArrayItem item = new SkillArrayItem();
			return item;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.configId);
			data.writeInt(this.level);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.configId = data.getInt();
			this.level = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("level:").append(this.level);
			return bb.toString();	
		}
	}
}