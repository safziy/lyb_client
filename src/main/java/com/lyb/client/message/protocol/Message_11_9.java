package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 请求 私聊玩家是否存在
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_11_9 implements IMessage {

	private static int MAIN = 11;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(11, 9);

	private String userName;


	public static Message_11_9 create() {
		return new Message_11_9();
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