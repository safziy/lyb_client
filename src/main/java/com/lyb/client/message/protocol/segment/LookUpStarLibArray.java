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
public class LookUpStarLibArray implements IMessageEncoder {
	private List<LookUpStarLibArrayItem> list = new LinkedList<LookUpStarLibArrayItem>();

	public List<LookUpStarLibArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (LookUpStarLibArrayItem item : list) {
			data.writeInt(item.getConfigId());
			data.writeInt(item.getGeneralIdTable());
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
			LookUpStarLibArrayItem item = LookUpStarLibArrayItem.create();
			item.setConfigId(data.getInt());
			item.setGeneralIdTable(data.getInt());
			item.setLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (LookUpStarLibArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static LookUpStarLibArray create() {
		LookUpStarLibArray array = new LookUpStarLibArray();
		return array;
	}

	public static LookUpStarLibArrayItem createItem() {
		LookUpStarLibArrayItem item = new LookUpStarLibArrayItem();
		return item;
	}

	public LookUpStarLibArrayItem addData(int configId, int generalIdTable, int level) {
		LookUpStarLibArrayItem item = new LookUpStarLibArrayItem();
		item.setConfigId(configId);
		item.setGeneralIdTable(generalIdTable);
		item.setLevel(level);
		list.add(item);
		return item;
	}

	public void addItem(LookUpStarLibArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (LookUpStarLibArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class LookUpStarLibArrayItem implements IMessageEncoder {
		private int configId;
		private int generalIdTable;
		private int level;

		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler generalIdTableHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("GeneralIdTable");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");

		public static LookUpStarLibArrayItem create() {
			LookUpStarLibArrayItem item = new LookUpStarLibArrayItem();
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
		 * @return the generalIdTable
		 */
		public int getGeneralIdTable() {
			return generalIdTable;
		}

		/**
		 * @param generalIdTable
		 *            the generalIdTable to set
		 */
		public void setGeneralIdTable(int generalIdTable) {
			this.generalIdTable = generalIdTable;
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
			data.writeInt(this.generalIdTable);
			data.writeInt(this.level);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.configId = data.getInt();
			this.generalIdTable = data.getInt();
			this.level = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!generalIdTableHandler.validate(generalIdTable)) {
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
			bb.append("generalIdTable:").append(this.generalIdTable).append(", ");
			bb.append("level:").append(this.level);
			return bb.toString();	
		}
	}
}