package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 输入邀请码
 *
 * @author codeGenerator
 * 
 */
public class Message_34_2 implements IMessage {

	private static int MAIN = 34;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(34, 2);

	private String key;


	public static Message_34_2 create() {
		return new Message_34_2();
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.key);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.key = data.getString();
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
		bb.append("key:").append(this.key);
		return bb.toString();	
	}
}