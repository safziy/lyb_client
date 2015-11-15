package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  切换手动自动战斗
 *
 * @author codeGenerator
 * 
 */
public class Message_7_30 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 30;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 30);

	private int booleanValue;

	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_7_30 create() {
		return new Message_7_30();
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