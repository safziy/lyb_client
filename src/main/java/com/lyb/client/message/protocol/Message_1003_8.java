package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 用户货币
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_8 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 8;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 8);

	private int gold;
	private int silver;
	private int physicalPower;
	private int prestige;
	private int score;
	private int familyContribute;
	private int storyLineStar;
	private int booleanValue;

	private static IntMessageParameterHandler goldHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Gold");
	private static IntMessageParameterHandler silverHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Silver");
	private static IntMessageParameterHandler physicalPowerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PhysicalPower");
	private static IntMessageParameterHandler prestigeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Prestige");
	private static IntMessageParameterHandler scoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Score");
	private static IntMessageParameterHandler familyContributeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyContribute");
	private static IntMessageParameterHandler storyLineStarHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StoryLineStar");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1003_8 create() {
		return new Message_1003_8();
	}

	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * @param gold
	 *            the gold to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * @return the silver
	 */
	public int getSilver() {
		return silver;
	}

	/**
	 * @param silver
	 *            the silver to set
	 */
	public void setSilver(int silver) {
		this.silver = silver;
	}

	/**
	 * @return the physicalPower
	 */
	public int getPhysicalPower() {
		return physicalPower;
	}

	/**
	 * @param physicalPower
	 *            the physicalPower to set
	 */
	public void setPhysicalPower(int physicalPower) {
		this.physicalPower = physicalPower;
	}

	/**
	 * @return the prestige
	 */
	public int getPrestige() {
		return prestige;
	}

	/**
	 * @param prestige
	 *            the prestige to set
	 */
	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the familyContribute
	 */
	public int getFamilyContribute() {
		return familyContribute;
	}

	/**
	 * @param familyContribute
	 *            the familyContribute to set
	 */
	public void setFamilyContribute(int familyContribute) {
		this.familyContribute = familyContribute;
	}

	/**
	 * @return the storyLineStar
	 */
	public int getStoryLineStar() {
		return storyLineStar;
	}

	/**
	 * @param storyLineStar
	 *            the storyLineStar to set
	 */
	public void setStoryLineStar(int storyLineStar) {
		this.storyLineStar = storyLineStar;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.gold);
		data.writeInt(this.silver);
		data.writeInt(this.physicalPower);
		data.writeInt(this.prestige);
		data.writeInt(this.score);
		data.writeInt(this.familyContribute);
		data.writeInt(this.storyLineStar);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.gold = data.getInt();
		this.silver = data.getInt();
		this.physicalPower = data.getInt();
		this.prestige = data.getInt();
		this.score = data.getInt();
		this.familyContribute = data.getInt();
		this.storyLineStar = data.getInt();
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!goldHandler.validate(gold)) {
			return false;
		}
		if (!silverHandler.validate(silver)) {
			return false;
		}
		if (!physicalPowerHandler.validate(physicalPower)) {
			return false;
		}
		if (!prestigeHandler.validate(prestige)) {
			return false;
		}
		if (!scoreHandler.validate(score)) {
			return false;
		}
		if (!familyContributeHandler.validate(familyContribute)) {
			return false;
		}
		if (!storyLineStarHandler.validate(storyLineStar)) {
			return false;
		}
		if (!booleanValueHandler.validate(booleanValue)) {
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
		bb.append("gold:").append(this.gold).append(", ");
		bb.append("silver:").append(this.silver).append(", ");
		bb.append("physicalPower:").append(this.physicalPower).append(", ");
		bb.append("prestige:").append(this.prestige).append(", ");
		bb.append("score:").append(this.score).append(", ");
		bb.append("familyContribute:").append(this.familyContribute).append(", ");
		bb.append("storyLineStar:").append(this.storyLineStar).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}