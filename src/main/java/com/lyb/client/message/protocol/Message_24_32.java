package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 领取
 *
 * @author codeGenerator
 * 
 */
public class Message_24_32 implements IMessage {

	private static int MAIN = 24;
	private static int SUB = 32;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(24, 32);

	private String cDKey;


	public static Message_24_32 create() {
		return new Message_24_32();
	}

	/**
	 * @return the cDKey
	 */
	public String getCDKey() {
		return cDKey;
	}

	/**
	 * @param cDKey
	 *            the cDKey to set
	 */
	public void setCDKey(String cDKey) {
		this.cDKey = cDKey;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.cDKey);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.cDKey = data.getString();
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
		bb.append("cDKey:").append(this.cDKey);
		return bb.toString();	
	}
}