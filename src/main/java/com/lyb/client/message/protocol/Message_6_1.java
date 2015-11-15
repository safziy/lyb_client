package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 查看卡牌列表
 *
 * @author codeGenerator
 * 
 */
public class Message_6_1 implements IMessage {

	private static int MAIN = 6;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(6, 1);



	public static Message_6_1 create() {
		return new Message_6_1();
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