package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 查看家族详细信息
 *
 * @author codeGenerator
 * 
 */
public class Message_27_11 implements IMessage {

	private static int MAIN = 27;
	private static int SUB = 11;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(27, 11);

	private long familyId;

	private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");

	public static Message_27_11 create() {
		return new Message_27_11();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.familyId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.familyId = data.getLong();
	}

	@Override
	public boolean validate() {
		if (!familyIdHandler.validate(familyId)) {
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
		bb.append("familyId:").append(this.familyId);
		return bb.toString();	
	}
}