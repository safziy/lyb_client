package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 绑定手机
 *
 * @author codeGenerator
 * 
 */
public class Message_1024_8 implements IMessage {

	private static int MAIN = 1024;
	private static int SUB = 8;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1024, 8);

	private String paramStr1;


	public static Message_1024_8 create() {
		return new Message_1024_8();
	}

	/**
	 * @return the paramStr1
	 */
	public String getParamStr1() {
		return paramStr1;
	}

	/**
	 * @param paramStr1
	 *            the paramStr1 to set
	 */
	public void setParamStr1(String paramStr1) {
		this.paramStr1 = paramStr1;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.paramStr1);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.paramStr1 = data.getString();
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
		bb.append("paramStr1:").append(this.paramStr1);
		return bb.toString();	
	}
}