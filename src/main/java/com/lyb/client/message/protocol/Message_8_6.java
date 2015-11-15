package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  打开寻宝界面
 *
 * @author codeGenerator
 * 
 */
public class Message_8_6 implements IMessage {

	private static int MAIN = 8;
	private static int SUB = 6;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(8, 6);



	public static Message_8_6 create() {
		return new Message_8_6();
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