package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 升级技能
 *
 * @author codeGenerator
 * 
 */
public class Message_6_9 implements IMessage {

	private static int MAIN = 6;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(6, 9);

	private long generalId;
	private int type;

	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");

	public static Message_6_9 create() {
		return new Message_6_9();
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
		data.writeLong(this.generalId);
		data.writeInt(this.type);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalId = data.getLong();
		this.type = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!generalIdHandler.validate(generalId)) {
			return false;
		}
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
		bb.append("generalId:").append(this.generalId).append(", ");
		bb.append("type:").append(this.type);
		return bb.toString();	
	}
}