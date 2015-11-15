package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 加密文件
 *
 * @author codeGenerator
 * 
 */
public class Message_1001_5 implements IMessage {

	private static int MAIN = 1001;
	private static int SUB = 5;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1001, 5);

	private String clientDecryptionData;


	public static Message_1001_5 create() {
		return new Message_1001_5();
	}

	/**
	 * @return the clientDecryptionData
	 */
	public String getClientDecryptionData() {
		return clientDecryptionData;
	}

	/**
	 * @param clientDecryptionData
	 *            the clientDecryptionData to set
	 */
	public void setClientDecryptionData(String clientDecryptionData) {
		this.clientDecryptionData = clientDecryptionData;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.clientDecryptionData);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.clientDecryptionData = data.getString();
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
		bb.append("clientDecryptionData:").append(this.clientDecryptionData);
		return bb.toString();	
	}
}