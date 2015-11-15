package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 战场是否有效
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_39 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 39;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 39);

	private int booleanValue;

	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1003_39 create() {
		return new Message_1003_39();
	}

	/**
	 * @return the booleanValue
	 */
	public int getBooleanValue() {
		return booleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(int booleanValue) {
		this.booleanValue = booleanValue;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!booleanValueHandler.validate(booleanValue)) {
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
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}