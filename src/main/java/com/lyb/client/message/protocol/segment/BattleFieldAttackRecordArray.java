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
public class BattleFieldAttackRecordArray implements IMessageEncoder {
	private List<BattleFieldAttackRecordArrayItem> list = new LinkedList<BattleFieldAttackRecordArrayItem>();

	public List<BattleFieldAttackRecordArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleFieldAttackRecordArrayItem item : list) {
			data.writeInt(item.getTime());
			data.writeInt(item.getIndex());
			data.writeLong(item.getBattleUnitID());
			data.writeInt(item.getSkillId());
			data.writeInt(item.getCount());
			item.getHurtEffectArray().encode(data);
			item.getHurtArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleFieldAttackRecordArrayItem item = BattleFieldAttackRecordArrayItem.create();
			item.setTime(data.getInt());
			item.setIndex(data.getInt());
			item.setBattleUnitID(data.getLong());
			item.setSkillId(data.getInt());
			item.setCount(data.getInt());
			item.setHurtEffectArray(HurtEffectArray.create());
			item.getHurtEffectArray().decode(data);
			item.setHurtArray(HurtArray.create());
			item.getHurtArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleFieldAttackRecordArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleFieldAttackRecordArray create() {
		BattleFieldAttackRecordArray array = new BattleFieldAttackRecordArray();
		return array;
	}

	public static BattleFieldAttackRecordArrayItem createItem() {
		BattleFieldAttackRecordArrayItem item = new BattleFieldAttackRecordArrayItem();
		return item;
	}

	public BattleFieldAttackRecordArrayItem addData(int time, int index, long battleUnitID, int skillId, int count, HurtEffectArray hurtEffectArray, HurtArray hurtArray) {
		BattleFieldAttackRecordArrayItem item = new BattleFieldAttackRecordArrayItem();
		item.setTime(time);
		item.setIndex(index);
		item.setBattleUnitID(battleUnitID);
		item.setSkillId(skillId);
		item.setCount(count);
		item.setHurtEffectArray(hurtEffectArray);
		item.setHurtArray(hurtArray);
		list.add(item);
		return item;
	}

	public void addItem(BattleFieldAttackRecordArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleFieldAttackRecordArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleFieldAttackRecordArrayItem implements IMessageEncoder {
		private int time;
		private int index;
		private long battleUnitID;
		private int skillId;
		private int count;
		private HurtEffectArray hurtEffectArray;
		private HurtArray hurtArray;

		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");
		private static IntMessageParameterHandler indexHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Index");
		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static BattleFieldAttackRecordArrayItem create() {
			BattleFieldAttackRecordArrayItem item = new BattleFieldAttackRecordArrayItem();
			return item;
		}

		/**
		 * @return the time
		 */
		public int getTime() {
			return time;
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(int time) {
			this.time = time;
		}
		/**
		 * @return the index
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * @param index
		 *            the index to set
		 */
		public void setIndex(int index) {
			this.index = index;
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
		 * @return the skillId
		 */
		public int getSkillId() {
			return skillId;
		}

		/**
		 * @param skillId
		 *            the skillId to set
		 */
		public void setSkillId(int skillId) {
			this.skillId = skillId;
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
		 * @return the hurtArray
		 */
		public HurtArray getHurtArray() {
			return hurtArray;
		}

		/**
		 * @param hurtArray
		 *            the hurtArray to set
		 */
		public void setHurtArray(HurtArray hurtArray) {
			this.hurtArray = hurtArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.time);
			data.writeInt(this.index);
			data.writeLong(this.battleUnitID);
			data.writeInt(this.skillId);
			data.writeInt(this.count);
			hurtEffectArray.encode(data);
			hurtArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.time = data.getInt();
			this.index = data.getInt();
			this.battleUnitID = data.getLong();
			this.skillId = data.getInt();
			this.count = data.getInt();
			hurtEffectArray = HurtEffectArray.create();
			hurtEffectArray.decode(data);
			hurtArray = HurtArray.create();
			hurtArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!timeHandler.validate(time)) {
				return false;
			}
			if (!indexHandler.validate(index)) {
				return false;
			}
			if (!battleUnitIDHandler.validate(battleUnitID)) {
				return false;
			}
			if (!skillIdHandler.validate(skillId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!hurtEffectArray.validate()) {
				return false;
			}
			if (!hurtArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("time:").append(this.time).append(", ");
			bb.append("index:").append(this.index).append(", ");
			bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
			bb.append("skillId:").append(this.skillId).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("hurtEffectArray:").append(hurtEffectArray.toString()).append(", ");
			bb.append("hurtArray:").append(hurtArray.toString());
			return bb.toString();	
		}
	}
}