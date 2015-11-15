package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 提升降低职位
 *
 * @author codeGenerator
 * 
 */
public class Message_27_9 implements IMessage {

	private static int MAIN = 27;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(27, 9);

	private long userId;
	private int familyPositionId;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler familyPositionIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyPositionId");

	public static Message_27_9 create() {
		return new Message_27_9();
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the familyPositionId
	 */
	public int getFamilyPositionId() {
		return familyPositionId;
	}

	/**
	 * @param familyPositionId
	 *            the familyPositionId to set
	 */
	public void setFamilyPositionId(int familyPositionId) {
		this.familyPositionId = familyPositionId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
		data.writeInt(this.familyPositionId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
		this.familyPositionId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!familyPositionIdHandler.validate(familyPositionId)) {
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
		bb.append("userId:").append(this.userId).append(", ");
		bb.append("familyPositionId:").append(this.familyPositionId);
		return bb.toString();	
	}
}