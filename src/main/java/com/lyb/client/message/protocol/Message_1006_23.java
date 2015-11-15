package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.GeneralFateArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 缘分变化
 *
 * @author codeGenerator
 * 
 */
public class Message_1006_23 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 23;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 23);

	private GeneralFateArray generalFateArray;


	public static Message_1006_23 create() {
		return new Message_1006_23();
	}

	/**
	 * @return the generalFateArray
	 */
	public GeneralFateArray getGeneralFateArray() {
		return generalFateArray;
	}

	/**
	 * @param generalFateArray
	 *            the generalFateArray to set
	 */
	public void setGeneralFateArray(GeneralFateArray generalFateArray) {
		this.generalFateArray = generalFateArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		generalFateArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		generalFateArray = GeneralFateArray.create();
		generalFateArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!generalFateArray.validate()) {
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
		bb.append("generalFateArray:").append(generalFateArray.toString());
		return bb.toString();	
	}
}