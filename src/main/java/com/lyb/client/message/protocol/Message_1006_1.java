package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.GeneralArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 查看卡牌列表
 *
 * @author codeGenerator
 * 
 */
public class Message_1006_1 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 1);

	private GeneralArray generalArray;


	public static Message_1006_1 create() {
		return new Message_1006_1();
	}

	/**
	 * @return the generalArray
	 */
	public GeneralArray getGeneralArray() {
		return generalArray;
	}

	/**
	 * @param generalArray
	 *            the generalArray to set
	 */
	public void setGeneralArray(GeneralArray generalArray) {
		this.generalArray = generalArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		generalArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		generalArray = GeneralArray.create();
		generalArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!generalArray.validate()) {
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
		bb.append("generalArray:").append(generalArray.toString());
		return bb.toString();	
	}
}