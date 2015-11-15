package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.UserCountControlArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  次数控制
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_9 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 9);

	private int booleanValue;
	private UserCountControlArray userCountControlArray;

	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1003_9 create() {
		return new Message_1003_9();
	}

	/**
	 * @return the booleanValue
	 */
	public int getBooleanValue() {
		return booleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(int booleanValue) {
		this.booleanValue = booleanValue;
	}

	/**
	 * @return the userCountControlArray
	 */
	public UserCountControlArray getUserCountControlArray() {
		return userCountControlArray;
	}

	/**
	 * @param userCountControlArray
	 *            the userCountControlArray to set
	 */
	public void setUserCountControlArray(UserCountControlArray userCountControlArray) {
		this.userCountControlArray = userCountControlArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.booleanValue);
		userCountControlArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.booleanValue = data.getInt();
		userCountControlArray = UserCountControlArray.create();
		userCountControlArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!booleanValueHandler.validate(booleanValue)) {
			return false;
		}
		if (!userCountControlArray.validate()) {
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
		bb.append("booleanValue:").append(this.booleanValue).append(", ");
		bb.append("userCountControlArray:").append(userCountControlArray.toString());
		return bb.toString();	
	}
}