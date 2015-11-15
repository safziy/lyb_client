package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.AttackResultArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回攻击结果
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_24 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 24;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 24);

	private long attackterBattleUnitId;
	private int attackterCoordinateX;
	private int attackterCoordinateY;
	private int skillId;
	private int attackResult;
	private int currentRage;
	private int targetCoordinateX;
	private int targetCoordinateY;
	private AttackResultArray attackResultArray;

	private static LongMessageParameterHandler attackterBattleUnitIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("AttackterBattleUnitId");
	private static IntMessageParameterHandler attackterCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackterCoordinateX");
	private static IntMessageParameterHandler attackterCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackterCoordinateY");
	private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
	private static IntMessageParameterHandler attackResultHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackResult");
	private static IntMessageParameterHandler currentRageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentRage");
	private static IntMessageParameterHandler targetCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateX");
	private static IntMessageParameterHandler targetCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateY");

	public static Message_1007_24 create() {
		return new Message_1007_24();
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
	 * @return the attackResultArray
	 */
	public AttackResultArray getAttackResultArray() {
		return attackResultArray;
	}

	/**
	 * @param attackResultArray
	 *            the attackResultArray to set
	 */
	public void setAttackResultArray(AttackResultArray attackResultArray) {
		this.attackResultArray = attackResultArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.attackterBattleUnitId);
		data.writeInt(this.attackterCoordinateX);
		data.writeInt(this.attackterCoordinateY);
		data.writeInt(this.skillId);
		data.writeInt(this.attackResult);
		data.writeInt(this.currentRage);
		data.writeInt(this.targetCoordinateX);
		data.writeInt(this.targetCoordinateY);
		attackResultArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.attackterBattleUnitId = data.getLong();
		this.attackterCoordinateX = data.getInt();
		this.attackterCoordinateY = data.getInt();
		this.skillId = data.getInt();
		this.attackResult = data.getInt();
		this.currentRage = data.getInt();
		this.targetCoordinateX = data.getInt();
		this.targetCoordinateY = data.getInt();
		attackResultArray = AttackResultArray.create();
		attackResultArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!attackterBattleUnitIdHandler.validate(attackterBattleUnitId)) {
			return false;
		}
		if (!attackterCoordinateXHandler.validate(attackterCoordinateX)) {
			return false;
		}
		if (!attackterCoordinateYHandler.validate(attackterCoordinateY)) {
			return false;
		}
		if (!skillIdHandler.validate(skillId)) {
			return false;
		}
		if (!attackResultHandler.validate(attackResult)) {
			return false;
		}
		if (!currentRageHandler.validate(currentRage)) {
			return false;
		}
		if (!targetCoordinateXHandler.validate(targetCoordinateX)) {
			return false;
		}
		if (!targetCoordinateYHandler.validate(targetCoordinateY)) {
			return false;
		}
		if (!attackResultArray.validate()) {
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
		bb.append("attackterCoordinateX:").append(this.attackterCoordinateX).append(", ");
		bb.append("attackterCoordinateY:").append(this.attackterCoordinateY).append(", ");
		bb.append("skillId:").append(this.skillId).append(", ");
		bb.append("attackResult:").append(this.attackResult).append(", ");
		bb.append("currentRage:").append(this.currentRage).append(", ");
		bb.append("targetCoordinateX:").append(this.targetCoordinateX).append(", ");
		bb.append("targetCoordinateY:").append(this.targetCoordinateY).append(", ");
		bb.append("attackResultArray:").append(attackResultArray.toString());
		return bb.toString();	
	}
}