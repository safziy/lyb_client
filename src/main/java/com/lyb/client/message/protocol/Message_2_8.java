package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 随机名字
 *
 * @author codeGenerator
 * 
 */
public class Message_2_8 implements IMessage {

	private static int MAIN = 2;
	private static int SUB = 8;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(2, 8);

	private int career;

	private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");

	public static Message_2_8 create() {
		return new Message_2_8();
	}

	/**
	 * @return the career
	 */
	public int getCareer() {
		return career;
	}

	/**
	 * @param career
	 *            the career to set
	 */
	public void setCareer(int career) {
		this.career = career;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.career);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.career = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!careerHandler.validate(career)) {
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
		bb.append("career:").append(this.career);
		return bb.toString();	
	}
}