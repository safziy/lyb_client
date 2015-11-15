package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 登录认证
 *
 * @author codeGenerator
 * 
 */
public class Message_2_1 implements IMessage {

	private static int MAIN = 2;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(2, 1);

	private String userName;
	private int origainalServerId;

	private static IntMessageParameterHandler origainalServerIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("OrigainalServerId");

	public static Message_2_1 create() {
		return new Message_2_1();
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the origainalServerId
	 */
	public int getOrigainalServerId() {
		return origainalServerId;
	}

	/**
	 * @param origainalServerId
	 *            the origainalServerId to set
	 */
	public void setOrigainalServerId(int origainalServerId) {
		this.origainalServerId = origainalServerId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.userName);
		data.writeInt(this.origainalServerId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userName = data.getString();
		this.origainalServerId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!origainalServerIdHandler.validate(origainalServerId)) {
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
		bb.append("userName:").append(this.userName).append(", ");
		bb.append("origainalServerId:").append(this.origainalServerId);
		return bb.toString();	
	}
}