package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.UserArenaArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 刷新刷新对手
 *
 * @author codeGenerator
 * 
 */
public class Message_1016_4 implements IMessage {

	private static int MAIN = 1016;
	private static int SUB = 4;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1016, 4);

	private UserArenaArray userArenaArray;


	public static Message_1016_4 create() {
		return new Message_1016_4();
	}

	/**
	 * @return the userArenaArray
	 */
	public UserArenaArray getUserArenaArray() {
		return userArenaArray;
	}

	/**
	 * @param userArenaArray
	 *            the userArenaArray to set
	 */
	public void setUserArenaArray(UserArenaArray userArenaArray) {
		this.userArenaArray = userArenaArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		userArenaArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		userArenaArray = UserArenaArray.create();
		userArenaArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!userArenaArray.validate()) {
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
		bb.append("userArenaArray:").append(userArenaArray.toString());
		return bb.toString();	
	}
}