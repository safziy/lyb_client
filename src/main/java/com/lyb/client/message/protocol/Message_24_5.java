package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 请求 领取当月签到奖励
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_24_5 implements IMessage {

	private static int MAIN = 24;
	private static int SUB = 5;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(24, 5);



	public static Message_24_5 create() {
		return new Message_24_5();
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