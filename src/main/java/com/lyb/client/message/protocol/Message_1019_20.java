package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.ChancellorStateArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 打开我要上朝
 *
 * @author codeGenerator
 * 
 */
public class Message_1019_20 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 20;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 20);

	private ChancellorStateArray chancellorStateArray;


	public static Message_1019_20 create() {
		return new Message_1019_20();
	}

	/**
	 * @return the chancellorStateArray
	 */
	public ChancellorStateArray getChancellorStateArray() {
		return chancellorStateArray;
	}

	/**
	 * @param chancellorStateArray
	 *            the chancellorStateArray to set
	 */
	public void setChancellorStateArray(ChancellorStateArray chancellorStateArray) {
		this.chancellorStateArray = chancellorStateArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		chancellorStateArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		chancellorStateArray = ChancellorStateArray.create();
		chancellorStateArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!chancellorStateArray.validate()) {
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
		bb.append("chancellorStateArray:").append(chancellorStateArray.toString());
		return bb.toString();	
	}
}