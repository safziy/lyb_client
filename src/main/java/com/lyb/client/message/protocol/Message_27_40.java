package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 派遣(返回成功)
 *
 * @author codeGenerator
 * 
 */
public class Message_27_40 implements IMessage {

	private static int MAIN = 27;
	private static int SUB = 40;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(27, 40);

	private long generalId;

	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");

	public static Message_27_40 create() {
		return new Message_27_40();
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
		data.writeLong(this.generalId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalId = data.getLong();
	}

	@Override
	public boolean validate() {
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
		bb.append("generalId:").append(this.generalId);
		return bb.toString();	
	}
}