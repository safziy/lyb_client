package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.RedPointArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 失效小红点
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_42 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 42;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 42);

	private RedPointArray redPointArray;


	public static Message_1003_42 create() {
		return new Message_1003_42();
	}

	/**
	 * @return the redPointArray
	 */
	public RedPointArray getRedPointArray() {
		return redPointArray;
	}

	/**
	 * @param redPointArray
	 *            the redPointArray to set
	 */
	public void setRedPointArray(RedPointArray redPointArray) {
		this.redPointArray = redPointArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		redPointArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		redPointArray = RedPointArray.create();
		redPointArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!redPointArray.validate()) {
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
		bb.append("redPointArray:").append(redPointArray.toString());
		return bb.toString();	
	}
}