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
public class BingShuArray implements IMessageEncoder {
	private List<BingShuArrayItem> list = new LinkedList<BingShuArrayItem>();

	public List<BingShuArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BingShuArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getLevel());
			data.writeInt(item.getStrengthenLevel());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BingShuArrayItem item = BingShuArrayItem.create();
			item.setID(data.getLong());
			item.setLevel(data.getInt());
			item.setStrengthenLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BingShuArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BingShuArray create() {
		BingShuArray array = new BingShuArray();
		return array;
	}

	public static BingShuArrayItem createItem() {
		BingShuArrayItem item = new BingShuArrayItem();
		return item;
	}

	public BingShuArrayItem addData(long iD, int level, int strengthenLevel) {
		BingShuArrayItem item = new BingShuArrayItem();
		item.setID(iD);
		item.setLevel(level);
		item.setStrengthenLevel(strengthenLevel);
		list.add(item);
		return item;
	}

	public void addItem(BingShuArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BingShuArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BingShuArrayItem implements IMessageEncoder {
		private long iD;
		private int level;
		private int strengthenLevel;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler strengthenLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrengthenLevel");

		public static BingShuArrayItem create() {
			BingShuArrayItem item = new BingShuArrayItem();
			return item;
		}

		/**
		 * @return the iD
		 */
		public long getID() {
			return iD;
		}

		/**
		 * @param iD
		 *            the iD to set
		 */
		public void setID(long iD) {
			this.iD = iD;
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
		 * @return the strengthenLevel
		 */
		public int getStrengthenLevel() {
			return strengthenLevel;
		}

		/**
		 * @param strengthenLevel
		 *            the strengthenLevel to set
		 */
		public void setStrengthenLevel(int strengthenLevel) {
			this.strengthenLevel = strengthenLevel;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.level);
			data.writeInt(this.strengthenLevel);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.level = data.getInt();
			this.strengthenLevel = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!strengthenLevelHandler.validate(strengthenLevel)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("strengthenLevel:").append(this.strengthenLevel);
			return bb.toString();	
		}
	}
}