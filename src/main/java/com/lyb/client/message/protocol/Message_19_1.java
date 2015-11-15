package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 打开琅琊试炼
 *
 * @author codeGenerator
 * 
 */
public class Message_19_1 implements IMessage {

	private static int MAIN = 19;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(19, 1);



	public static Message_19_1 create() {
		return new Message_19_1();
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