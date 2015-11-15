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
public class GeneralComboBufArray implements IMessageEncoder {
	private List<GeneralComboBufArrayItem> list = new LinkedList<GeneralComboBufArrayItem>();

	public List<GeneralComboBufArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (GeneralComboBufArrayItem item : list) {
			data.writeInt(item.getGeneralIdTable());
			data.writeInt(item.getCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			GeneralComboBufArrayItem item = GeneralComboBufArrayItem.create();
			item.setGeneralIdTable(data.getInt());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (GeneralComboBufArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static GeneralComboBufArray create() {
		GeneralComboBufArray array = new GeneralComboBufArray();
		return array;
	}

	public static GeneralComboBufArrayItem createItem() {
		GeneralComboBufArrayItem item = new GeneralComboBufArrayItem();
		return item;
	}

	public GeneralComboBufArrayItem addData(int generalIdTable, int count) {
		GeneralComboBufArrayItem item = new GeneralComboBufArrayItem();
		item.setGeneralIdTable(generalIdTable);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(GeneralComboBufArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (GeneralComboBufArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class GeneralComboBufArrayItem implements IMessageEncoder {
		private int generalIdTable;
		private int count;

		private static IntMessageParameterHandler generalIdTableHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("GeneralIdTable");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static GeneralComboBufArrayItem create() {
			GeneralComboBufArrayItem item = new GeneralComboBufArrayItem();
			return item;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.generalIdTable);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalIdTable = data.getInt();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!generalIdTableHandler.validate(generalIdTable)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalIdTable:").append(this.generalIdTable).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}