package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  手动放技能
 *
 * @author codeGenerator
 * 
 */
public class Message_7_9 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 9);

	private int skillId;

	private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");

	public static Message_7_9 create() {
		return new Message_7_9();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.skillId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.skillId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!skillIdHandler.validate(skillId)) {
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
		bb.append("skillId:").append(this.skillId);
		return bb.toString();	
	}
}