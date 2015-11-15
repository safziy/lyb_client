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
public class PetPassiveSkillArray implements IMessageEncoder {
	private List<PetPassiveSkillArrayItem> list = new LinkedList<PetPassiveSkillArrayItem>();

	public List<PetPassiveSkillArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PetPassiveSkillArrayItem item : list) {
			data.writeLong(item.getID());
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
			PetPassiveSkillArrayItem item = PetPassiveSkillArrayItem.create();
			item.setID(data.getLong());
			item.setLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PetPassiveSkillArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PetPassiveSkillArray create() {
		PetPassiveSkillArray array = new PetPassiveSkillArray();
		return array;
	}

	public static PetPassiveSkillArrayItem createItem() {
		PetPassiveSkillArrayItem item = new PetPassiveSkillArrayItem();
		return item;
	}

	public PetPassiveSkillArrayItem addData(long iD, int level) {
		PetPassiveSkillArrayItem item = new PetPassiveSkillArrayItem();
		item.setID(iD);
		item.setLevel(level);
		list.add(item);
		return item;
	}

	public void addItem(PetPassiveSkillArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PetPassiveSkillArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PetPassiveSkillArrayItem implements IMessageEncoder {
		private long iD;
		private int level;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");

		public static PetPassiveSkillArrayItem create() {
			PetPassiveSkillArrayItem item = new PetPassiveSkillArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.level);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.level = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("level:").append(this.level);
			return bb.toString();	
		}
	}
}