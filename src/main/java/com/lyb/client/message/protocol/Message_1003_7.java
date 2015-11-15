package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.TimerArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 冷却时间
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_7 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 7;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 7);

	private TimerArray timerArray;


	public static Message_1003_7 create() {
		return new Message_1003_7();
	}

	/**
	 * @return the timerArray
	 */
	public TimerArray getTimerArray() {
		return timerArray;
	}

	/**
	 * @param timerArray
	 *            the timerArray to set
	 */
	public void setTimerArray(TimerArray timerArray) {
		this.timerArray = timerArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		timerArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		timerArray = TimerArray.create();
		timerArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!timerArray.validate()) {
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
		bb.append("timerArray:").append(timerArray.toString());
		return bb.toString();	
	}
}