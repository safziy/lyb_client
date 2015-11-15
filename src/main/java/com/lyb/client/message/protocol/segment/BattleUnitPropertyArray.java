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
public class BattleUnitPropertyArray implements IMessageEncoder {
	private List<BattleUnitPropertyArrayItem> list = new LinkedList<BattleUnitPropertyArrayItem>();

	public List<BattleUnitPropertyArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleUnitPropertyArrayItem item : list) {
			data.writeLong(item.getBattleUnitID());
			data.writeInt(item.getCurrentRage());
			data.writeInt(item.getLevel());
			item.getUnitPropertyArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleUnitPropertyArrayItem item = BattleUnitPropertyArrayItem.create();
			item.setBattleUnitID(data.getLong());
			item.setCurrentRage(data.getInt());
			item.setLevel(data.getInt());
			item.setUnitPropertyArray(UnitPropertyArray.create());
			item.getUnitPropertyArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleUnitPropertyArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleUnitPropertyArray create() {
		BattleUnitPropertyArray array = new BattleUnitPropertyArray();
		return array;
	}

	public static BattleUnitPropertyArrayItem createItem() {
		BattleUnitPropertyArrayItem item = new BattleUnitPropertyArrayItem();
		return item;
	}

	public BattleUnitPropertyArrayItem addData(long battleUnitID, int currentRage, int level, UnitPropertyArray unitPropertyArray) {
		BattleUnitPropertyArrayItem item = new BattleUnitPropertyArrayItem();
		item.setBattleUnitID(battleUnitID);
		item.setCurrentRage(currentRage);
		item.setLevel(level);
		item.setUnitPropertyArray(unitPropertyArray);
		list.add(item);
		return item;
	}

	public void addItem(BattleUnitPropertyArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleUnitPropertyArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleUnitPropertyArrayItem implements IMessageEncoder {
		private long battleUnitID;
		private int currentRage;
		private int level;
		private UnitPropertyArray unitPropertyArray;

		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static IntMessageParameterHandler currentRageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentRage");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");

		public static BattleUnitPropertyArrayItem create() {
			BattleUnitPropertyArrayItem item = new BattleUnitPropertyArrayItem();
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
		 * @return the currentRage
		 */
		public int getCurrentRage() {
			return currentRage;
		}

		/**
		 * @param currentRage
		 *            the currentRage to set
		 */
		public void setCurrentRage(int currentRage) {
			this.currentRage = currentRage;
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
		 * @return the unitPropertyArray
		 */
		public UnitPropertyArray getUnitPropertyArray() {
			return unitPropertyArray;
		}

		/**
		 * @param unitPropertyArray
		 *            the unitPropertyArray to set
		 */
		public void setUnitPropertyArray(UnitPropertyArray unitPropertyArray) {
			this.unitPropertyArray = unitPropertyArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.battleUnitID);
			data.writeInt(this.currentRage);
			data.writeInt(this.level);
			unitPropertyArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.battleUnitID = data.getLong();
			this.currentRage = data.getInt();
			this.level = data.getInt();
			unitPropertyArray = UnitPropertyArray.create();
			unitPropertyArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!battleUnitIDHandler.validate(battleUnitID)) {
				return false;
			}
			if (!currentRageHandler.validate(currentRage)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!unitPropertyArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
			bb.append("currentRage:").append(this.currentRage).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("unitPropertyArray:").append(unitPropertyArray.toString());
			return bb.toString();	
		}
	}
}