package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 领取奖励
 *
 * @author codeGenerator
 * 
 */
public class Message_29_3 implements IMessage {

	private static int MAIN = 29;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(29, 3);

	private int conditionID;

	private static IntMessageParameterHandler conditionIDHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConditionID");

	public static Message_29_3 create() {
		return new Message_29_3();
	}

	/**
	 * @return the conditionID
	 */
	public int getConditionID() {
		return conditionID;
	}

	/**
	 * @param conditionID
	 *            the conditionID to set
	 */
	public void setConditionID(int conditionID) {
		this.conditionID = conditionID;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.conditionID);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.conditionID = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!conditionIDHandler.validate(conditionID)) {
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
		bb.append("conditionID:").append(this.conditionID);
		return bb.toString();	
	}
}