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
public class TargetStateArray implements IMessageEncoder {
	private List<TargetStateArrayItem> list = new LinkedList<TargetStateArrayItem>();

	public List<TargetStateArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TargetStateArrayItem item : list) {
			data.writeLong(item.getBattleUnitID());
			data.writeInt(item.getCurrentHP());
			data.writeInt(item.getCurrentMP());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			TargetStateArrayItem item = TargetStateArrayItem.create();
			item.setBattleUnitID(data.getLong());
			item.setCurrentHP(data.getInt());
			item.setCurrentMP(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TargetStateArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TargetStateArray create() {
		TargetStateArray array = new TargetStateArray();
		return array;
	}

	public static TargetStateArrayItem createItem() {
		TargetStateArrayItem item = new TargetStateArrayItem();
		return item;
	}

	public TargetStateArrayItem addData(long battleUnitID, int currentHP, int currentMP) {
		TargetStateArrayItem item = new TargetStateArrayItem();
		item.setBattleUnitID(battleUnitID);
		item.setCurrentHP(currentHP);
		item.setCurrentMP(currentMP);
		list.add(item);
		return item;
	}

	public void addItem(TargetStateArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TargetStateArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TargetStateArrayItem implements IMessageEncoder {
		private long battleUnitID;
		private int currentHP;
		private int currentMP;

		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static IntMessageParameterHandler currentHPHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentHP");
		private static IntMessageParameterHandler currentMPHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentMP");

		public static TargetStateArrayItem create() {
			TargetStateArrayItem item = new TargetStateArrayItem();
			return item;
		}

		/**
		 * @return the battleUnitID
		 */
		public long getBattleUnitID() {
			return battleUnitID;
		}

		/**
		 * @param battleUnitID
		 *            the battleUnitID to set
		 */
		public void setBattleUnitID(long battleUnitID) {
			this.battleUnitID = battleUnitID;
		}
		/**
		 * @return the currentHP
		 */
		public int getCurrentHP() {
			return currentHP;
		}

		/**
		 * @param currentHP
		 *            the currentHP to set
		 */
		public void setCurrentHP(int currentHP) {
			this.currentHP = currentHP;
		}
		/**
		 * @return the currentMP
		 */
		public int getCurrentMP() {
			return currentMP;
		}

		/**
		 * @param currentMP
		 *            the currentMP to set
		 */
		public void setCurrentMP(int currentMP) {
			this.currentMP = currentMP;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.battleUnitID);
			data.writeInt(this.currentHP);
			data.writeInt(this.currentMP);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.battleUnitID = data.getLong();
			this.currentHP = data.getInt();
			this.currentMP = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!battleUnitIDHandler.validate(battleUnitID)) {
				return false;
			}
			if (!currentHPHandler.validate(currentHP)) {
				return false;
			}
			if (!currentMPHandler.validate(currentMP)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
			bb.append("currentHP:").append(this.currentHP).append(", ");
			bb.append("currentMP:").append(this.currentMP);
			return bb.toString();	
		}
	}
}