package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 提升爵位
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_27 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 27;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 27);

	private int nobility;

	private static IntMessageParameterHandler nobilityHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Nobility");

	public static Message_1003_27 create() {
		return new Message_1003_27();
	}

	/**
	 * @return the nobility
	 */
	public int getNobility() {
		return nobility;
	}

	/**
	 * @param nobility
	 *            the nobility to set
	 */
	public void setNobility(int nobility) {
		this.nobility = nobility;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.nobility);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.nobility = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!nobilityHandler.validate(nobility)) {
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
		bb.append("nobility:").append(this.nobility);
		return bb.toString();	
	}
}