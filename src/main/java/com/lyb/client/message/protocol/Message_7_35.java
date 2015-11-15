package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.ErrorMessageArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 战场伤害数据
 *
 * @author codeGenerator
 * 
 */
public class Message_7_35 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 35;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 35);

	private int battleId;
	private ErrorMessageArray errorMessageArray;

	private static IntMessageParameterHandler battleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleId");

	public static Message_7_35 create() {
		return new Message_7_35();
	}

	/**
	 * @return the battleId
	 */
	public int getBattleId() {
		return battleId;
	}

	/**
	 * @param battleId
	 *            the battleId to set
	 */
	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}

	/**
	 * @return the errorMessageArray
	 */
	public ErrorMessageArray getErrorMessageArray() {
		return errorMessageArray;
	}

	/**
	 * @param errorMessageArray
	 *            the errorMessageArray to set
	 */
	public void setErrorMessageArray(ErrorMessageArray errorMessageArray) {
		this.errorMessageArray = errorMessageArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.battleId);
		errorMessageArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleId = data.getInt();
		errorMessageArray = ErrorMessageArray.create();
		errorMessageArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!battleIdHandler.validate(battleId)) {
			return false;
		}
		if (!errorMessageArray.validate()) {
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
		bb.append("battleId:").append(this.battleId).append(", ");
		bb.append("errorMessageArray:").append(errorMessageArray.toString());
		return bb.toString();	
	}
}