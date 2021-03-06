package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 家族挂机祈福
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1027_55 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 55;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 55);

	private int state;

	private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

	public static Message_1027_55 create() {
		return new Message_1027_55();
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.state);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.state = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!stateHandler.validate(state)) {
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
		bb.append("state:").append(this.state);
		return bb.toString();	
	}
}