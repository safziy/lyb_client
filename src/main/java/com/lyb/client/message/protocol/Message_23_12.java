package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 领取附件
 *
 * @author codeGenerator
 * 
 */
public class Message_23_12 implements IMessage {

	private static int MAIN = 23;
	private static int SUB = 12;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(23, 12);

	private long mailId;

	private static LongMessageParameterHandler mailIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("MailId");

	public static Message_23_12 create() {
		return new Message_23_12();
	}

	/**
	 * @return the mailId
	 */
	public long getMailId() {
		return mailId;
	}

	/**
	 * @param mailId
	 *            the mailId to set
	 */
	public void setMailId(long mailId) {
		this.mailId = mailId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.mailId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.mailId = data.getLong();
	}

	@Override
	public boolean validate() {
		if (!mailIdHandler.validate(mailId)) {
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
		bb.append("mailId:").append(this.mailId);
		return bb.toString();	
	}
}