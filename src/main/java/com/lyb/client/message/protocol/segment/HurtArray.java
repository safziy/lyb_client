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
public class HurtArray implements IMessageEncoder {
	private List<HurtArrayItem> list = new LinkedList<HurtArrayItem>();

	public List<HurtArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (HurtArrayItem item : list) {
			data.writeLong(item.getBattleUnitID());
			data.writeInt(item.getChangeValue());
			data.writeInt(item.getAttackStage());
			item.getHurtEffectArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			HurtArrayItem item = HurtArrayItem.create();
			item.setBattleUnitID(data.getLong());
			item.setChangeValue(data.getInt());
			item.setAttackStage(data.getInt());
			item.setHurtEffectArray(HurtEffectArray.create());
			item.getHurtEffectArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (HurtArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static HurtArray create() {
		HurtArray array = new HurtArray();
		return array;
	}

	public static HurtArrayItem createItem() {
		HurtArrayItem item = new HurtArrayItem();
		return item;
	}

	public HurtArrayItem addData(long battleUnitID, int changeValue, int attackStage, HurtEffectArray hurtEffectArray) {
		HurtArrayItem item = new HurtArrayItem();
		item.setBattleUnitID(battleUnitID);
		item.setChangeValue(changeValue);
		item.setAttackStage(attackStage);
		item.setHurtEffectArray(hurtEffectArray);
		list.add(item);
		return item;
	}

	public void addItem(HurtArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (HurtArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class HurtArrayItem implements IMessageEncoder {
		private long battleUnitID;
		private int changeValue;
		private int attackStage;
		private HurtEffectArray hurtEffectArray;

		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static IntMessageParameterHandler changeValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ChangeValue");
		private static IntMessageParameterHandler attackStageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackStage");

		public static HurtArrayItem create() {
			HurtArrayItem item = new HurtArrayItem();
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
		 * @return the changeValue
		 */
		public int getChangeValue() {
			return changeValue;
		}

		/**
		 * @param changeValue
		 *            the changeValue to set
		 */
		public void setChangeValue(int changeValue) {
			this.changeValue = changeValue;
		}
		/**
		 * @return the attackStage
		 */
		public int getAttackStage() {
			return attackStage;
		}

		/**
		 * @param attackStage
		 *            the attackStage to set
		 */
		public void setAttackStage(int attackStage) {
			this.attackStage = attackStage;
		}
		/**
		 * @return the hurtEffectArray
		 */
		public HurtEffectArray getHurtEffectArray() {
			return hurtEffectArray;
		}

		/**
		 * @param hurtEffectArray
		 *            the hurtEffectArray to set
		 */
		public void setHurtEffectArray(HurtEffectArray hurtEffectArray) {
			this.hurtEffectArray = hurtEffectArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.battleUnitID);
			data.writeInt(this.changeValue);
			data.writeInt(this.attackStage);
			hurtEffectArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.battleUnitID = data.getLong();
			this.changeValue = data.getInt();
			this.attackStage = data.getInt();
			hurtEffectArray = HurtEffectArray.create();
			hurtEffectArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!battleUnitIDHandler.validate(battleUnitID)) {
				return false;
			}
			if (!changeValueHandler.validate(changeValue)) {
				return false;
			}
			if (!attackStageHandler.validate(attackStage)) {
				return false;
			}
			if (!hurtEffectArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
			bb.append("changeValue:").append(this.changeValue).append(", ");
			bb.append("attackStage:").append(this.attackStage).append(", ");
			bb.append("hurtEffectArray:").append(hurtEffectArray.toString());
			return bb.toString();	
		}
	}
}