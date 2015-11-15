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
public class CheckBattleUnitArray implements IMessageEncoder {
	private List<CheckBattleUnitArrayItem> list = new LinkedList<CheckBattleUnitArrayItem>();

	public List<CheckBattleUnitArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (CheckBattleUnitArrayItem item : list) {
			data.writeLong(item.getBattleUnitID());
			data.writeInt(item.getBaseAttack());
			data.writeInt(item.getBaseDefence());
			data.writeInt(item.getBaseHp());
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
			CheckBattleUnitArrayItem item = CheckBattleUnitArrayItem.create();
			item.setBattleUnitID(data.getLong());
			item.setBaseAttack(data.getInt());
			item.setBaseDefence(data.getInt());
			item.setBaseHp(data.getInt());
			item.setUnitPropertyArray(UnitPropertyArray.create());
			item.getUnitPropertyArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (CheckBattleUnitArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static CheckBattleUnitArray create() {
		CheckBattleUnitArray array = new CheckBattleUnitArray();
		return array;
	}

	public static CheckBattleUnitArrayItem createItem() {
		CheckBattleUnitArrayItem item = new CheckBattleUnitArrayItem();
		return item;
	}

	public CheckBattleUnitArrayItem addData(long battleUnitID, int baseAttack, int baseDefence, int baseHp, UnitPropertyArray unitPropertyArray) {
		CheckBattleUnitArrayItem item = new CheckBattleUnitArrayItem();
		item.setBattleUnitID(battleUnitID);
		item.setBaseAttack(baseAttack);
		item.setBaseDefence(baseDefence);
		item.setBaseHp(baseHp);
		item.setUnitPropertyArray(unitPropertyArray);
		list.add(item);
		return item;
	}

	public void addItem(CheckBattleUnitArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (CheckBattleUnitArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class CheckBattleUnitArrayItem implements IMessageEncoder {
		private long battleUnitID;
		private int baseAttack;
		private int baseDefence;
		private int baseHp;
		private UnitPropertyArray unitPropertyArray;

		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static IntMessageParameterHandler baseAttackHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BaseAttack");
		private static IntMessageParameterHandler baseDefenceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BaseDefence");
		private static IntMessageParameterHandler baseHpHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BaseHp");

		public static CheckBattleUnitArrayItem create() {
			CheckBattleUnitArrayItem item = new CheckBattleUnitArrayItem();
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
		 * @return the baseAttack
		 */
		public int getBaseAttack() {
			return baseAttack;
		}

		/**
		 * @param baseAttack
		 *            the baseAttack to set
		 */
		public void setBaseAttack(int baseAttack) {
			this.baseAttack = baseAttack;
		}
		/**
		 * @return the baseDefence
		 */
		public int getBaseDefence() {
			return baseDefence;
		}

		/**
		 * @param baseDefence
		 *            the baseDefence to set
		 */
		public void setBaseDefence(int baseDefence) {
			this.baseDefence = baseDefence;
		}
		/**
		 * @return the baseHp
		 */
		public int getBaseHp() {
			return baseHp;
		}

		/**
		 * @param baseHp
		 *            the baseHp to set
		 */
		public void setBaseHp(int baseHp) {
			this.baseHp = baseHp;
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
			data.writeInt(this.baseAttack);
			data.writeInt(this.baseDefence);
			data.writeInt(this.baseHp);
			unitPropertyArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.battleUnitID = data.getLong();
			this.baseAttack = data.getInt();
			this.baseDefence = data.getInt();
			this.baseHp = data.getInt();
			unitPropertyArray = UnitPropertyArray.create();
			unitPropertyArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!battleUnitIDHandler.validate(battleUnitID)) {
				return false;
			}
			if (!baseAttackHandler.validate(baseAttack)) {
				return false;
			}
			if (!baseDefenceHandler.validate(baseDefence)) {
				return false;
			}
			if (!baseHpHandler.validate(baseHp)) {
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
			bb.append("baseAttack:").append(this.baseAttack).append(", ");
			bb.append("baseDefence:").append(this.baseDefence).append(", ");
			bb.append("baseHp:").append(this.baseHp).append(", ");
			bb.append("unitPropertyArray:").append(unitPropertyArray.toString());
			return bb.toString();	
		}
	}
}