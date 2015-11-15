package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 申请加入家族
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_13 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 13;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 13);

	private long familyId;
	private int booleanValue;

	private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1027_13 create() {
		return new Message_1027_13();
	}

	/**
	 * @return the familyId
	 */
	public long getFamilyId() {
		return familyId;
	}

	/**
	 * @param familyId
	 *            the familyId to set
	 */
	public void setFamilyId(long familyId) {
		this.familyId = familyId;
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
		data.writeLong(this.familyId);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.familyId = data.getLong();
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!familyIdHandler.validate(familyId)) {
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
		bb.append("familyId:").append(this.familyId).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}