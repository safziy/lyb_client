package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  任务完成
 *
 * @author codeGenerator
 * 
 */
public class Message_1008_9 implements IMessage {

	private static int MAIN = 1008;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1008, 9);



	public static Message_1008_9 create() {
		return new Message_1008_9();
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