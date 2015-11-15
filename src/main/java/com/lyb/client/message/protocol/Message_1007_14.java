package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 释放技能
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_14 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 14;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 14);

	private long attackterBattleUnitId;
	private long targetBattleUnitId;
	private int skillId;
	private int targetCoordinateX;
	private int targetCoordinateY;
	private int attackterCoordinateX;
	private int attackterCoordinateY;
	private int currentRage;

	private static LongMessageParameterHandler attackterBattleUnitIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("AttackterBattleUnitId");
	private static LongMessageParameterHandler targetBattleUnitIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("TargetBattleUnitId");
	private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
	private static IntMessageParameterHandler targetCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateX");
	private static IntMessageParameterHandler targetCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateY");
	private static IntMessageParameterHandler attackterCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackterCoordinateX");
	private static IntMessageParameterHandler attackterCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackterCoordinateY");
	private static IntMessageParameterHandler currentRageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentRage");

	public static Message_1007_14 create() {
		return new Message_1007_14();
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
	 * @return the attackterCoordinateX
	 */
	public int getAttackterCoordinateX() {
		return attackterCoordinateX;
	}

	/**
	 * @param attackterCoordinateX
	 *            the attackterCoordinateX to set
	 */
	public void setAttackterCoordinateX(int attackterCoordinateX) {
		this.attackterCoordinateX = attackterCoordinateX;
	}

	/**
	 * @return the attackterCoordinateY
	 */
	public int getAttackterCoordinateY() {
		return attackterCoordinateY;
	}

	/**
	 * @param attackterCoordinateY
	 *            the attackterCoordinateY to set
	 */
	public void setAttackterCoordinateY(int attackterCoordinateY) {
		this.attackterCoordinateY = attackterCoordinateY;
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
		data.writeLong(this.attackterBattleUnitId);
		data.writeLong(this.targetBattleUnitId);
		data.writeInt(this.skillId);
		data.writeInt(this.targetCoordinateX);
		data.writeInt(this.targetCoordinateY);
		data.writeInt(this.attackterCoordinateX);
		data.writeInt(this.attackterCoordinateY);
		data.writeInt(this.currentRage);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.attackterBattleUnitId = data.getLong();
		this.targetBattleUnitId = data.getLong();
		this.skillId = data.getInt();
		this.targetCoordinateX = data.getInt();
		this.targetCoordinateY = data.getInt();
		this.attackterCoordinateX = data.getInt();
		this.attackterCoordinateY = data.getInt();
		this.currentRage = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!attackterBattleUnitIdHandler.validate(attackterBattleUnitId)) {
			return false;
		}
		if (!targetBattleUnitIdHandler.validate(targetBattleUnitId)) {
			return false;
		}
		if (!skillIdHandler.validate(skillId)) {
			return false;
		}
		if (!targetCoordinateXHandler.validate(targetCoordinateX)) {
			return false;
		}
		if (!targetCoordinateYHandler.validate(targetCoordinateY)) {
			return false;
		}
		if (!attackterCoordinateXHandler.validate(attackterCoordinateX)) {
			return false;
		}
		if (!attackterCoordinateYHandler.validate(attackterCoordinateY)) {
			return false;
		}
		if (!currentRageHandler.validate(currentRage)) {
			return false;
		}
		return true;
	}

	@Override
	public int getMain() {
		return MAIN;
	}

	@Override
	public int getSub() {
		return SUB;
	}

	@Override
	public String getMessageKey() {
		return MESSAGE_KEY;
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("attackterBattleUnitId:").append(this.attackterBattleUnitId).append(", ");
		bb.append("targetBattleUnitId:").append(this.targetBattleUnitId).append(", ");
		bb.append("skillId:").append(this.skillId).append(", ");
		bb.append("targetCoordinateX:").append(this.targetCoordinateX).append(", ");
		bb.append("targetCoordinateY:").append(this.targetCoordinateY).append(", ");
		bb.append("attackterCoordinateX:").append(this.attackterCoordinateX).append(", ");
		bb.append("attackterCoordinateY:").append(this.attackterCoordinateY).append(", ");
		bb.append("currentRage:").append(this.currentRage);
		return bb.toString();	
	}
}