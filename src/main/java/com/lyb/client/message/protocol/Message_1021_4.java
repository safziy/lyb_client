package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.FriendArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 申请添加好友弹窗
 *
 * @author codeGenerator
 * 
 */
public class Message_1021_4 implements IMessage {

	private static int MAIN = 1021;
	private static int SUB = 4;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1021, 4);

	private FriendArray friendArray;


	public static Message_1021_4 create() {
		return new Message_1021_4();
	}

	/**
	 * @return the friendArray
	 */
	public FriendArray getFriendArray() {
		return friendArray;
	}

	/**
	 * @param friendArray
	 *            the friendArray to set
	 */
	public void setFriendArray(FriendArray friendArray) {
		this.friendArray = friendArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		friendArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		friendArray = FriendArray.create();
		friendArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!friendArray.validate()) {
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
		bb.append("friendArray:").append(friendArray.toString());
		return bb.toString();	
	}
}