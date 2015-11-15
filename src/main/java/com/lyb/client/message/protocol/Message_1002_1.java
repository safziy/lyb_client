package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 登录认证
 *
 * @author codeGenerator
 * 
 */
public class Message_1002_1 implements IMessage {

	private static int MAIN = 1002;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1002, 1);

	private int loginState;

	private static IntMessageParameterHandler loginStateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("LoginState");

	public static Message_1002_1 create() {
		return new Message_1002_1();
	}

	/**
	 * @return the loginState
	 */
	public int getLoginState() {
		return loginState;
	}

	/**
	 * @param loginState
	 *            the loginState to set
	 */
	public void setLoginState(int loginState) {
		this.loginState = loginState;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.loginState);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.loginState = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!loginStateHandler.validate(loginState)) {
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
		bb.append("loginState:").append(this.loginState);
		return bb.toString();	
	}
}