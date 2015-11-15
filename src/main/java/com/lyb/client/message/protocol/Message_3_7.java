package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 时间加速
 *
 * @author codeGenerator
 * 
 */
public class Message_3_7 implements IMessage {

	private static int MAIN = 3;
	private static int SUB = 7;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(3, 7);

	private String timerType;


	public static Message_3_7 create() {
		return new Message_3_7();
	}

	/**
	 * @return the timerType
	 */
	public String getTimerType() {
		return timerType;
	}

	/**
	 * @param timerType
	 *            the timerType to set
	 */
	public void setTimerType(String timerType) {
		this.timerType = timerType;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.timerType);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.timerType = data.getString();
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
		bb.append("timerType:").append(this.timerType);
		return bb.toString();	
	}
}