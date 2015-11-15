package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.IDCountArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 打开官职
 *
 * @author codeGenerator
 * 
 */
public class Message_1019_13 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 13;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 13);

	private IDCountArray iDCountArray;


	public static Message_1019_13 create() {
		return new Message_1019_13();
	}

	/**
	 * @return the iDCountArray
	 */
	public IDCountArray getIDCountArray() {
		return iDCountArray;
	}

	/**
	 * @param iDCountArray
	 *            the iDCountArray to set
	 */
	public void setIDCountArray(IDCountArray iDCountArray) {
		this.iDCountArray = iDCountArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		iDCountArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		iDCountArray = IDCountArray.create();
		iDCountArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!iDCountArray.validate()) {
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
		bb.append("iDCountArray:").append(iDCountArray.toString());
		return bb.toString();	
	}
}