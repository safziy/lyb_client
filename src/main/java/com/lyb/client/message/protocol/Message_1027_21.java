package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 广播 帮派等级变化
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_21 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 21;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 21);

	private int familyLevel;

	private static IntMessageParameterHandler familyLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyLevel");

	public static Message_1027_21 create() {
		return new Message_1027_21();
	}

	/**
	 * @return the familyLevel
	 */
	public int getFamilyLevel() {
		return familyLevel;
	}

	/**
	 * @param familyLevel
	 *            the familyLevel to set
	 */
	public void setFamilyLevel(int familyLevel) {
		this.familyLevel = familyLevel;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.familyLevel);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.familyLevel = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!familyLevelHandler.validate(familyLevel)) {
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
		bb.append("familyLevel:").append(this.familyLevel);
		return bb.toString();	
	}
}