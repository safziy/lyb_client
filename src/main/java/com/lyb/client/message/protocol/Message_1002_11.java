package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.UserAccountInfoArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  服务器账号数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1002_11 implements IMessage {

	private static int MAIN = 1002;
	private static int SUB = 11;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1002, 11);

	private int loginState;
	private String yunyingUserId;
	private UserAccountInfoArray userAccountInfoArray;

	private static IntMessageParameterHandler loginStateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("LoginState");

	public static Message_1002_11 create() {
		return new Message_1002_11();
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
	 * @return the yunyingUserId
	 */
	public String getYunyingUserId() {
		return yunyingUserId;
	}

	/**
	 * @param yunyingUserId
	 *            the yunyingUserId to set
	 */
	public void setYunyingUserId(String yunyingUserId) {
		this.yunyingUserId = yunyingUserId;
	}

	/**
	 * @return the userAccountInfoArray
	 */
	public UserAccountInfoArray getUserAccountInfoArray() {
		return userAccountInfoArray;
	}

	/**
	 * @param userAccountInfoArray
	 *            the userAccountInfoArray to set
	 */
	public void setUserAccountInfoArray(UserAccountInfoArray userAccountInfoArray) {
		this.userAccountInfoArray = userAccountInfoArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.loginState);
		data.writeString(this.yunyingUserId);
		userAccountInfoArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.loginState = data.getInt();
		this.yunyingUserId = data.getString();
		userAccountInfoArray = UserAccountInfoArray.create();
		userAccountInfoArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!loginStateHandler.validate(loginState)) {
			return false;
		}
		if (!userAccountInfoArray.validate()) {
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
		bb.append("loginState:").append(this.loginState).append(", ");
		bb.append("yunyingUserId:").append(this.yunyingUserId).append(", ");
		bb.append("userAccountInfoArray:").append(userAccountInfoArray.toString());
		return bb.toString();	
	}
}