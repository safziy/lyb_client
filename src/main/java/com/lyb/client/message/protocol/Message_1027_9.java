package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.ChangeMemberArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 广播 别人信息的改变
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_9 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 9);

	private ChangeMemberArray changeMemberArray;


	public static Message_1027_9 create() {
		return new Message_1027_9();
	}

	/**
	 * @return the changeMemberArray
	 */
	public ChangeMemberArray getChangeMemberArray() {
		return changeMemberArray;
	}

	/**
	 * @param changeMemberArray
	 *            the changeMemberArray to set
	 */
	public void setChangeMemberArray(ChangeMemberArray changeMemberArray) {
		this.changeMemberArray = changeMemberArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		changeMemberArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		changeMemberArray = ChangeMemberArray.create();
		changeMemberArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!changeMemberArray.validate()) {
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
		bb.append("changeMemberArray:").append(changeMemberArray.toString());
		return bb.toString();	
	}
}