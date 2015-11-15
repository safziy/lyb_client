package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 对话完成
 *
 * @author codeGenerator
 * 
 */
public class Message_4_2 implements IMessage {

	private static int MAIN = 4;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(4, 2);

	private int strongPointId;

	private static IntMessageParameterHandler strongPointIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrongPointId");

	public static Message_4_2 create() {
		return new Message_4_2();
	}

	/**
	 * @return the strongPointId
	 */
	public int getStrongPointId() {
		return strongPointId;
	}

	/**
	 * @param strongPointId
	 *            the strongPointId to set
	 */
	public void setStrongPointId(int strongPointId) {
		this.strongPointId = strongPointId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.strongPointId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.strongPointId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!strongPointIdHandler.validate(strongPointId)) {
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
		bb.append("strongPointId:").append(this.strongPointId);
		return bb.toString();	
	}
}