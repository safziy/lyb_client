package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 合服随机名字
 *
 * @author codeGenerator
 * 
 */
public class Message_1002_12 implements IMessage {

	private static int MAIN = 1002;
	private static int SUB = 12;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1002, 12);

	private String userName;


	public static Message_1002_12 create() {
		return new Message_1002_12();
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.userName);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userName = data.getString();
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
		bb.append("userName:").append(this.userName);
		return bb.toString();	
	}
}