package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 合服随机名字
 *
 * @author codeGenerator
 * 
 */
public class Message_2_12 implements IMessage {

	private static int MAIN = 2;
	private static int SUB = 12;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(2, 12);

	private int userGender;

	private static IntMessageParameterHandler userGenderHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("UserGender");

	public static Message_2_12 create() {
		return new Message_2_12();
	}

	/**
	 * @return the userGender
	 */
	public int getUserGender() {
		return userGender;
	}

	/**
	 * @param userGender
	 *            the userGender to set
	 */
	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.userGender);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userGender = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userGenderHandler.validate(userGender)) {
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
		bb.append("userGender:").append(this.userGender);
		return bb.toString();	
	}
}