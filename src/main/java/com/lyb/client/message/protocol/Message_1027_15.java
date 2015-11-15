package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 广播 成员离开
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_15 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 15;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 15);

	private long userId;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");

	public static Message_1027_15 create() {
		return new Message_1027_15();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
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
		bb.append("userId:").append(this.userId);
		return bb.toString();	
	}
}