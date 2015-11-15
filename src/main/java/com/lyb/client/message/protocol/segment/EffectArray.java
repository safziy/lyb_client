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
public class EffectArray implements IMessageEncoder {
	private List<EffectArrayItem> list = new LinkedList<EffectArrayItem>();

	public List<EffectArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (EffectArrayItem item : list) {
			data.writeLong(item.getAttackterBattleUnitId());
			data.writeInt(item.getSkillId());
			data.writeInt(item.getPriority());
			data.writeInt(item.getEffectId());
			data.writeInt(item.getEffectValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			EffectArrayItem item = EffectArrayItem.create();
			item.setAttackterBattleUnitId(data.getLong());
			item.setSkillId(data.getInt());
			item.setPriority(data.getInt());
			item.setEffectId(data.getInt());
			item.setEffectValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (EffectArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static EffectArray create() {
		EffectArray array = new EffectArray();
		return array;
	}

	public static EffectArrayItem createItem() {
		EffectArrayItem item = new EffectArrayItem();
		return item;
	}

	public EffectArrayItem addData(long attackterBattleUnitId, int skillId, int priority, int effectId, int effectValue) {
		EffectArrayItem item = new EffectArrayItem();
		item.setAttackterBattleUnitId(attackterBattleUnitId);
		item.setSkillId(skillId);
		item.setPriority(priority);
		item.setEffectId(effectId);
		item.setEffectValue(effectValue);
		list.add(item);
		return item;
	}

	public void addItem(EffectArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (EffectArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class EffectArrayItem implements IMessageEncoder {
		private long attackterBattleUnitId;
		private int skillId;
		private int priority;
		private int effectId;
		private int effectValue;

		private static LongMessageParameterHandler attackterBattleUnitIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("AttackterBattleUnitId");
		private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
		private static IntMessageParameterHandler priorityHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Priority");
		private static IntMessageParameterHandler effectIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EffectId");
		private static IntMessageParameterHandler effectValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EffectValue");

		public static EffectArrayItem create() {
			EffectArrayItem item = new EffectArrayItem();
			return item;
		}

		/**
		 * @return the attackterBattleUnitId
		 */
		public long getAttackterBattleUnitId() {
			return attackterBattleUnitId;
		}

		/**
		 * @param attackterBattleUnitId
		 *            the attackterBattleUnitId to set
		 */
		public void setAttackterBattleUnitId(long attackterBattleUnitId) {
			this.attackterBattleUnitId = attackterBattleUnitId;
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
		 * @return the priority
		 */
		public int getPriority() {
			return priority;
		}

		/**
		 * @param priority
		 *            the priority to set
		 */
		public void setPriority(int priority) {
			this.priority = priority;
		}
		/**
		 * @return the effectId
		 */
		public int getEffectId() {
			return effectId;
		}

		/**
		 * @param effectId
		 *            the effectId to set
		 */
		public void setEffectId(int effectId) {
			this.effectId = effectId;
		}
		/**
		 * @return the effectValue
		 */
		public int getEffectValue() {
			return effectValue;
		}

		/**
		 * @param effectValue
		 *            the effectValue to set
		 */
		public void setEffectValue(int effectValue) {
			this.effectValue = effectValue;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.attackterBattleUnitId);
			data.writeInt(this.skillId);
			data.writeInt(this.priority);
			data.writeInt(this.effectId);
			data.writeInt(this.effectValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.attackterBattleUnitId = data.getLong();
			this.skillId = data.getInt();
			this.priority = data.getInt();
			this.effectId = data.getInt();
			this.effectValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!attackterBattleUnitIdHandler.validate(attackterBattleUnitId)) {
				return false;
			}
			if (!skillIdHandler.validate(skillId)) {
				return false;
			}
			if (!priorityHandler.validate(priority)) {
				return false;
			}
			if (!effectIdHandler.validate(effectId)) {
				return false;
			}
			if (!effectValueHandler.validate(effectValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("attackterBattleUnitId:").append(this.attackterBattleUnitId).append(", ");
			bb.append("skillId:").append(this.skillId).append(", ");
			bb.append("priority:").append(this.priority).append(", ");
			bb.append("effectId:").append(this.effectId).append(", ");
			bb.append("effectValue:").append(this.effectValue);
			return bb.toString();	
		}
	}
}