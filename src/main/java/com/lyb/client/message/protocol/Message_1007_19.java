package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.BattleGeneralArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 新出生的怪物列表
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_19 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 19;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 19);

	private BattleGeneralArray battleGeneralArray;
	private int booleanValue;

	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1007_19 create() {
		return new Message_1007_19();
	}

	/**
	 * @return the battleGeneralArray
	 */
	public BattleGeneralArray getBattleGeneralArray() {
		return battleGeneralArray;
	}

	/**
	 * @param battleGeneralArray
	 *            the battleGeneralArray to set
	 */
	public void setBattleGeneralArray(BattleGeneralArray battleGeneralArray) {
		this.battleGeneralArray = battleGeneralArray;
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
		battleGeneralArray.encode(data);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		battleGeneralArray = BattleGeneralArray.create();
		battleGeneralArray.decode(data);
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!battleGeneralArray.validate()) {
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
		bb.append("battleGeneralArray:").append(battleGeneralArray.toString()).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}