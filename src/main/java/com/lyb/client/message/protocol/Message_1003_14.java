package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.UserDataAccumulateArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  数据累积
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_14 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 14;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 14);

	private UserDataAccumulateArray userDataAccumulateArray;


	public static Message_1003_14 create() {
		return new Message_1003_14();
	}

	/**
	 * @return the userDataAccumulateArray
	 */
	public UserDataAccumulateArray getUserDataAccumulateArray() {
		return userDataAccumulateArray;
	}

	/**
	 * @param userDataAccumulateArray
	 *            the userDataAccumulateArray to set
	 */
	public void setUserDataAccumulateArray(UserDataAccumulateArray userDataAccumulateArray) {
		this.userDataAccumulateArray = userDataAccumulateArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		userDataAccumulateArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		userDataAccumulateArray = UserDataAccumulateArray.create();
		userDataAccumulateArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!userDataAccumulateArray.validate()) {
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
		bb.append("userDataAccumulateArray:").append(userDataAccumulateArray.toString());
		return bb.toString();	
	}
}