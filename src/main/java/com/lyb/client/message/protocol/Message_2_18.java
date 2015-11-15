package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 刷新Token
 *
 * @author codeGenerator
 * 
 */
public class Message_2_18 implements IMessage {

	private static int MAIN = 2;
	private static int SUB = 18;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(2, 18);

	private String paramStr1;
	private String paramStr2;


	public static Message_2_18 create() {
		return new Message_2_18();
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
	 * @return the paramStr2
	 */
	public String getParamStr2() {
		return paramStr2;
	}

	/**
	 * @param paramStr2
	 *            the paramStr2 to set
	 */
	public void setParamStr2(String paramStr2) {
		this.paramStr2 = paramStr2;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.paramStr1);
		data.writeString(this.paramStr2);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.paramStr1 = data.getString();
		this.paramStr2 = data.getString();
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
		bb.append("paramStr1:").append(this.paramStr1).append(", ");
		bb.append("paramStr2:").append(this.paramStr2);
		return bb.toString();	
	}
}