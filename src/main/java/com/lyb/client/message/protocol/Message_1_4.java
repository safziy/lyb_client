package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 客户端错误回传
 *
 * @author codeGenerator
 * 
 */
public class Message_1_4 implements IMessage {

	private static int MAIN = 1;
	private static int SUB = 4;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1, 4);

	private String clientException;


	public static Message_1_4 create() {
		return new Message_1_4();
	}

	/**
	 * @return the clientException
	 */
	public String getClientException() {
		return clientException;
	}

	/**
	 * @param clientException
	 *            the clientException to set
	 */
	public void setClientException(String clientException) {
		this.clientException = clientException;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.clientException);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.clientException = data.getString();
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
		bb.append("clientException:").append(this.clientException);
		return bb.toString();	
	}
}