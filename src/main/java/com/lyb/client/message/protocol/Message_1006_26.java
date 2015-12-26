package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 换装
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1006_26 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 26;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 26);

	private int bodyId;
	private long generalId;

	private static IntMessageParameterHandler bodyIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BodyId");
	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");

	public static Message_1006_26 create() {
		return new Message_1006_26();
	}

	/**
	 * @return the bodyId
	 */
	public int getBodyId() {
		return bodyId;
	}

	/**
	 * @param bodyId
	 *            the bodyId to set
	 */
	public void setBodyId(int bodyId) {
		this.bodyId = bodyId;
	}

	/**
	 * @return the generalId
	 */
	public long getGeneralId() {
		return generalId;
	}

	/**
	 * @param generalId
	 *            the generalId to set
	 */
	public void setGeneralId(long generalId) {
		this.generalId = generalId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.bodyId);
		data.writeLong(this.generalId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.bodyId = data.getInt();
		this.generalId = data.getLong();
	}

	@Override
	public boolean validate() {
		if (!bodyIdHandler.validate(bodyId)) {
			return false;
		}
		if (!generalIdHandler.validate(generalId)) {
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
		bb.append("bodyId:").append(this.bodyId).append(", ");
		bb.append("generalId:").append(this.generalId);
		return bb.toString();	
	}
}