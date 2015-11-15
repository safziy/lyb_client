package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 被踢下线
 *
 * @author codeGenerator
 * 
 */
public class Message_1002_4 implements IMessage {

	private static int MAIN = 1002;
	private static int SUB = 4;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1002, 4);

	private int type;

	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");

	public static Message_1002_4 create() {
		return new Message_1002_4();
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.type);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.type = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!typeHandler.validate(type)) {
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
		bb.append("type:").append(this.type);
		return bb.toString();	
	}
}