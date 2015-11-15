package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.UserRelationArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 确认添加好友
 *
 * @author codeGenerator
 * 
 */
public class Message_1021_2 implements IMessage {

	private static int MAIN = 1021;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1021, 2);

	private UserRelationArray userRelationArray;


	public static Message_1021_2 create() {
		return new Message_1021_2();
	}

	/**
	 * @return the userRelationArray
	 */
	public UserRelationArray getUserRelationArray() {
		return userRelationArray;
	}

	/**
	 * @param userRelationArray
	 *            the userRelationArray to set
	 */
	public void setUserRelationArray(UserRelationArray userRelationArray) {
		this.userRelationArray = userRelationArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		userRelationArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		userRelationArray = UserRelationArray.create();
		userRelationArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!userRelationArray.validate()) {
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
		bb.append("userRelationArray:").append(userRelationArray.toString());
		return bb.toString();	
	}
}