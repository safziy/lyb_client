package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 请求 充值成功
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_2_17 implements IMessage {

	private static int MAIN = 2;
	private static int SUB = 17;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(2, 17);

	private int value;

	private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");

	public static Message_2_17 create() {
		return new Message_2_17();
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.value);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.value = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!valueHandler.validate(value)) {
			return false;
		}
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
		bb.append("value:").append(this.value);
		return bb.toString();	
	}
}