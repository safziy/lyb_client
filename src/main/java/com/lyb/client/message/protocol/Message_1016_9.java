package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.IDStateArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 任务
 *
 * @author codeGenerator
 * 
 */
public class Message_1016_9 implements IMessage {

	private static int MAIN = 1016;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1016, 9);

	private IDStateArray iDStateArray;


	public static Message_1016_9 create() {
		return new Message_1016_9();
	}

	/**
	 * @return the iDStateArray
	 */
	public IDStateArray getIDStateArray() {
		return iDStateArray;
	}

	/**
	 * @param iDStateArray
	 *            the iDStateArray to set
	 */
	public void setIDStateArray(IDStateArray iDStateArray) {
		this.iDStateArray = iDStateArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		iDStateArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		iDStateArray = IDStateArray.create();
		iDStateArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!iDStateArray.validate()) {
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
		bb.append("iDStateArray:").append(iDStateArray.toString());
		return bb.toString();	
	}
}