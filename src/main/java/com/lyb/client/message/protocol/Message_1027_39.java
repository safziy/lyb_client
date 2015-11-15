package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.ChangeEmployArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 帮派佣兵池变化
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_39 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 39;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 39);

	private ChangeEmployArray changeEmployArray;


	public static Message_1027_39 create() {
		return new Message_1027_39();
	}

	/**
	 * @return the changeEmployArray
	 */
	public ChangeEmployArray getChangeEmployArray() {
		return changeEmployArray;
	}

	/**
	 * @param changeEmployArray
	 *            the changeEmployArray to set
	 */
	public void setChangeEmployArray(ChangeEmployArray changeEmployArray) {
		this.changeEmployArray = changeEmployArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		changeEmployArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		changeEmployArray = ChangeEmployArray.create();
		changeEmployArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!changeEmployArray.validate()) {
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
		bb.append("changeEmployArray:").append(changeEmployArray.toString());
		return bb.toString();	
	}
}