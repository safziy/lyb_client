package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 帐号被屏蔽
 *
 * @author codeGenerator
 * 
 */
public class Message_2_5 implements IMessage {

	private static int MAIN = 2;
	private static int SUB = 5;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(2, 5);



	public static Message_2_5 create() {
		return new Message_2_5();
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
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
		return bb.toString();	
	}
}