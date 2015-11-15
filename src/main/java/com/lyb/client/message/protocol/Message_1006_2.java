package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.ChangeGeneralArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 增删改卡牌
 *
 * @author codeGenerator
 * 
 */
public class Message_1006_2 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 2);

	private ChangeGeneralArray changeGeneralArray;
	private int booleanValue;

	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1006_2 create() {
		return new Message_1006_2();
	}

	/**
	 * @return the changeGeneralArray
	 */
	public ChangeGeneralArray getChangeGeneralArray() {
		return changeGeneralArray;
	}

	/**
	 * @param changeGeneralArray
	 *            the changeGeneralArray to set
	 */
	public void setChangeGeneralArray(ChangeGeneralArray changeGeneralArray) {
		this.changeGeneralArray = changeGeneralArray;
	}

	/**
	 * @return the booleanValue
	 */
	public int getBooleanValue() {
		return booleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(int booleanValue) {
		this.booleanValue = booleanValue;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		changeGeneralArray.encode(data);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		changeGeneralArray = ChangeGeneralArray.create();
		changeGeneralArray.decode(data);
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!changeGeneralArray.validate()) {
			return false;
		}
		if (!booleanValueHandler.validate(booleanValue)) {
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
		bb.append("changeGeneralArray:").append(changeGeneralArray.toString()).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}