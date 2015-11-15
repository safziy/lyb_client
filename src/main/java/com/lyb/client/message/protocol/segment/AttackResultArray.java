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
public class AttackResultArray implements IMessageEncoder {
	private List<AttackResultArrayItem> list = new LinkedList<AttackResultArrayItem>();

	public List<AttackResultArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (AttackResultArrayItem item : list) {
			data.writeLong(item.getTargetBattleUnitId());
			data.writeInt(item.getAttackResult());
			data.writeInt(item.getCurrentHP());
			data.writeInt(item.getChangeValue());
			data.writeInt(item.getTargetCoordinateX());
			data.writeInt(item.getTargetCoordinateY());
			data.writeInt(item.getBooleanValue());
			data.writeInt(item.getBooleanValue2());
			data.writeInt(item.getCurrentRage());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			AttackResultArrayItem item = AttackResultArrayItem.create();
			item.setTargetBattleUnitId(data.getLong());
			item.setAttackResult(data.getInt());
			item.setCurrentHP(data.getInt());
			item.setChangeValue(data.getInt());
			item.setTargetCoordinateX(data.getInt());
			item.setTargetCoordinateY(data.getInt());
			item.setBooleanValue(data.getInt());
			item.setBooleanValue2(data.getInt());
			item.setCurrentRage(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (AttackResultArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static AttackResultArray create() {
		AttackResultArray array = new AttackResultArray();
		return array;
	}

	public static AttackResultArrayItem createItem() {
		AttackResultArrayItem item = new AttackResultArrayItem();
		return item;
	}

	public AttackResultArrayItem addData(long targetBattleUnitId, int attackResult, int currentHP, int changeValue, int targetCoordinateX, int targetCoordinateY, int booleanValue, int booleanValue2, int currentRage) {
		AttackResultArrayItem item = new AttackResultArrayItem();
		item.setTargetBattleUnitId(targetBattleUnitId);
		item.setAttackResult(attackResult);
		item.setCurrentHP(currentHP);
		item.setChangeValue(changeValue);
		item.setTargetCoordinateX(targetCoordinateX);
		item.setTargetCoordinateY(targetCoordinateY);
		item.setBooleanValue(booleanValue);
		item.setBooleanValue2(booleanValue2);
		item.setCurrentRage(currentRage);
		list.add(item);
		return item;
	}

	public void addItem(AttackResultArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (AttackResultArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class AttackResultArrayItem implements IMessageEncoder {
		private long targetBattleUnitId;
		private int attackResult;
		private int currentHP;
		private int changeValue;
		private int targetCoordinateX;
		private int targetCoordinateY;
		private int booleanValue;
		private int booleanValue2;
		private int currentRage;

		private static LongMessageParameterHandler targetBattleUnitIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("TargetBattleUnitId");
		private static IntMessageParameterHandler attackResultHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackResult");
		private static IntMessageParameterHandler currentHPHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentHP");
		private static IntMessageParameterHandler changeValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ChangeValue");
		private static IntMessageParameterHandler targetCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateX");
		private static IntMessageParameterHandler targetCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateY");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler booleanValue2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue2");
		private static IntMessageParameterHandler currentRageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentRage");

		public static AttackResultArrayItem create() {
			AttackResultArrayItem item = new AttackResultArrayItem();
			return item;
		}

		/**
		 * @return the targetBattleUnitId
		 */
		public long getTargetBattleUnitId() {
			return targetBattleUnitId;
		}

		/**
		 * @param targetBattleUnitId
		 *            the targetBattleUnitId to set
		 */
		public void setTargetBattleUnitId(long targetBattleUnitId) {
			this.targetBattleUnitId = targetBattleUnitId;
		}
		/**
		 * @return the attackResult
		 */
		public int getAttackResult() {
			return attackResult;
		}

		/**
		 * @param attackResult
		 *            the attackResult to set
		 */
		public void setAttackResult(int attackResult) {
			this.attackResult = attackResult;
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
		 * @return the targetCoordinateX
		 */
		public int getTargetCoordinateX() {
			return targetCoordinateX;
		}

		/**
		 * @param targetCoordinateX
		 *            the targetCoordinateX to set
		 */
		public void setTargetCoordinateX(int targetCoordinateX) {
			this.targetCoordinateX = targetCoordinateX;
		}
		/**
		 * @return the targetCoordinateY
		 */
		public int getTargetCoordinateY() {
			return targetCoordinateY;
		}

		/**
		 * @param targetCoordinateY
		 *            the targetCoordinateY to set
		 */
		public void setTargetCoordinateY(int targetCoordinateY) {
			this.targetCoordinateY = targetCoordinateY;
		}
		/**
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
		}
		/**
		 * @return the booleanValue2
		 */
		public int getBooleanValue2() {
			return booleanValue2;
		}

		/**
		 * @param booleanValue2
		 *            the booleanValue2 to set
		 */
		public void setBooleanValue2(int booleanValue2) {
			this.booleanValue2 = booleanValue2;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.targetBattleUnitId);
			data.writeInt(this.attackResult);
			data.writeInt(this.currentHP);
			data.writeInt(this.changeValue);
			data.writeInt(this.targetCoordinateX);
			data.writeInt(this.targetCoordinateY);
			data.writeInt(this.booleanValue);
			data.writeInt(this.booleanValue2);
			data.writeInt(this.currentRage);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.targetBattleUnitId = data.getLong();
			this.attackResult = data.getInt();
			this.currentHP = data.getInt();
			this.changeValue = data.getInt();
			this.targetCoordinateX = data.getInt();
			this.targetCoordinateY = data.getInt();
			this.booleanValue = data.getInt();
			this.booleanValue2 = data.getInt();
			this.currentRage = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!targetBattleUnitIdHandler.validate(targetBattleUnitId)) {
				return false;
			}
			if (!attackResultHandler.validate(attackResult)) {
				return false;
			}
			if (!currentHPHandler.validate(currentHP)) {
				return false;
			}
			if (!changeValueHandler.validate(changeValue)) {
				return false;
			}
			if (!targetCoordinateXHandler.validate(targetCoordinateX)) {
				return false;
			}
			if (!targetCoordinateYHandler.validate(targetCoordinateY)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			if (!booleanValue2Handler.validate(booleanValue2)) {
				return false;
			}
			if (!currentRageHandler.validate(currentRage)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("targetBattleUnitId:").append(this.targetBattleUnitId).append(", ");
			bb.append("attackResult:").append(this.attackResult).append(", ");
			bb.append("currentHP:").append(this.currentHP).append(", ");
			bb.append("changeValue:").append(this.changeValue).append(", ");
			bb.append("targetCoordinateX:").append(this.targetCoordinateX).append(", ");
			bb.append("targetCoordinateY:").append(this.targetCoordinateY).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("booleanValue2:").append(this.booleanValue2).append(", ");
			bb.append("currentRage:").append(this.currentRage);
			return bb.toString();	
		}
	}
}