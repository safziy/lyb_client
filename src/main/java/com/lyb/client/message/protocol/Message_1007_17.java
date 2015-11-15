package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.AttackResultArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 技能释放结果
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_17 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 17;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 17);

	private long attackterBattleUnitId;
	private long targetBattleUnitId;
	private int attackterCoordinateX;
	private int attackterCoordinateY;
	private int skillId;
	private AttackResultArray attackResultArray;
	private int currentHP;
	private int changeValue;
	private int targetCoordinateX;
	private int targetCoordinateY;
	private int booleanValue;
	private int beJidao;
	private int booleanValue2;
	private int currentRage;

	private static LongMessageParameterHandler attackterBattleUnitIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("AttackterBattleUnitId");
	private static LongMessageParameterHandler targetBattleUnitIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("TargetBattleUnitId");
	private static IntMessageParameterHandler attackterCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackterCoordinateX");
	private static IntMessageParameterHandler attackterCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AttackterCoordinateY");
	private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
	private static IntMessageParameterHandler currentHPHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentHP");
	private static IntMessageParameterHandler changeValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ChangeValue");
	private static IntMessageParameterHandler targetCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateX");
	private static IntMessageParameterHandler targetCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateY");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
	private static IntMessageParameterHandler beJidaoHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BeJidao");
	private static IntMessageParameterHandler booleanValue2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue2");
	private static IntMessageParameterHandler currentRageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentRage");

	public static Message_1007_17 create() {
		return new Message_1007_17();
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
	 * @return the beJidao
	 */
	public int getBeJidao() {
		return beJidao;
	}

	/**
	 * @param beJidao
	 *            the beJidao to set
	 */
	public void setBeJidao(int beJidao) {
		this.beJidao = beJidao;
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
		data.writeLong(this.attackterBattleUnitId);
		data.writeLong(this.targetBattleUnitId);
		data.writeInt(this.attackterCoordinateX);
		data.writeInt(this.attackterCoordinateY);
		data.writeInt(this.skillId);
		attackResultArray.encode(data);
		data.writeInt(this.currentHP);
		data.writeInt(this.changeValue);
		data.writeInt(this.targetCoordinateX);
		data.writeInt(this.targetCoordinateY);
		data.writeInt(this.booleanValue);
		data.writeInt(this.beJidao);
		data.writeInt(this.booleanValue2);
		data.writeInt(this.currentRage);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.attackterBattleUnitId = data.getLong();
		this.targetBattleUnitId = data.getLong();
		this.attackterCoordinateX = data.getInt();
		this.attackterCoordinateY = data.getInt();
		this.skillId = data.getInt();
		attackResultArray = AttackResultArray.create();
		attackResultArray.decode(data);
		this.currentHP = data.getInt();
		this.changeValue = data.getInt();
		this.targetCoordinateX = data.getInt();
		this.targetCoordinateY = data.getInt();
		this.booleanValue = data.getInt();
		this.beJidao = data.getInt();
		this.booleanValue2 = data.getInt();
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
		if (!attackterCoordinateXHandler.validate(attackterCoordinateX)) {
			return false;
		}
		if (!attackterCoordinateYHandler.validate(attackterCoordinateY)) {
			return false;
		}
		if (!skillIdHandler.validate(skillId)) {
			return false;
		}
		if (!attackResultArray.validate()) {
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
		if (!beJidaoHandler.validate(beJidao)) {
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
		bb.append("attackterCoordinateX:").append(this.attackterCoordinateX).append(", ");
		bb.append("attackterCoordinateY:").append(this.attackterCoordinateY).append(", ");
		bb.append("skillId:").append(this.skillId).append(", ");
		bb.append("attackResultArray:").append(attackResultArray.toString()).append(", ");
		bb.append("currentHP:").append(this.currentHP).append(", ");
		bb.append("changeValue:").append(this.changeValue).append(", ");
		bb.append("targetCoordinateX:").append(this.targetCoordinateX).append(", ");
		bb.append("targetCoordinateY:").append(this.targetCoordinateY).append(", ");
		bb.append("booleanValue:").append(this.booleanValue).append(", ");
		bb.append("beJidao:").append(this.beJidao).append(", ");
		bb.append("booleanValue2:").append(this.booleanValue2).append(", ");
		bb.append("currentRage:").append(this.currentRage);
		return bb.toString();	
	}
}