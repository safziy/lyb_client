package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.YXZStrongPointArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 英雄志
 *
 * @author codeGenerator
 * 
 */
public class Message_1004_5 implements IMessage {

	private static int MAIN = 1004;
	private static int SUB = 5;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1004, 5);

	private YXZStrongPointArray yXZStrongPointArray;


	public static Message_1004_5 create() {
		return new Message_1004_5();
	}

	/**
	 * @return the yXZStrongPointArray
	 */
	public YXZStrongPointArray getYXZStrongPointArray() {
		return yXZStrongPointArray;
	}

	/**
	 * @param yXZStrongPointArray
	 *            the yXZStrongPointArray to set
	 */
	public void setYXZStrongPointArray(YXZStrongPointArray yXZStrongPointArray) {
		this.yXZStrongPointArray = yXZStrongPointArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		yXZStrongPointArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		yXZStrongPointArray = YXZStrongPointArray.create();
		yXZStrongPointArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!yXZStrongPointArray.validate()) {
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
		bb.append("yXZStrongPointArray:").append(yXZStrongPointArray.toString());
		return bb.toString();	
	}
}