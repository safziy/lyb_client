package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  手动放技能成功
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_29 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 29;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 29);

	private int skillId;
	private int booleanValue;

	private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1007_29 create() {
		return new Message_1007_29();
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
		data.writeInt(this.skillId);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.skillId = data.getInt();
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!skillIdHandler.validate(skillId)) {
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
		bb.append("skillId:").append(this.skillId).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}