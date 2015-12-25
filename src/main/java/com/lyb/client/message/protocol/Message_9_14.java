package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 请求 卖道具
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_9_14 implements IMessage {

	private static int MAIN = 9;
	private static int SUB = 14;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(9, 14);

	private UserItemIdArray userItemIdArray;


	public static Message_9_14 create() {
		return new Message_9_14();
	}

	/**
	 * @return the userItemIdArray
	 */
	public UserItemIdArray getUserItemIdArray() {
		return userItemIdArray;
	}

	/**
	 * @param userItemIdArray
	 *            the userItemIdArray to set
	 */
	public void setUserItemIdArray(UserItemIdArray userItemIdArray) {
		this.userItemIdArray = userItemIdArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		userItemIdArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		userItemIdArray = UserItemIdArray.create();
		userItemIdArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!userItemIdArray.validate()) {
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
		bb.append("userItemIdArray:").append(userItemIdArray.toString());
		return bb.toString();	
	}
}