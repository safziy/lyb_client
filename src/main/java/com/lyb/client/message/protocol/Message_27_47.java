package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 请求 家族改名
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_27_47 implements IMessage {

	private static int MAIN = 27;
	private static int SUB = 47;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(27, 47);

	private String familyName;


	public static Message_27_47 create() {
		return new Message_27_47();
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.familyName);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.familyName = data.getString();
	}

	@Override
	public boolean validate() {
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
		bb.append("familyName:").append(this.familyName);
		return bb.toString();	
	}
}