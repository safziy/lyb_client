package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.CheckBattleUnitArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  验证战场数据
 *
 * @author codeGenerator
 * 
 */
public class Message_7_33 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 33;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 33);

	private int battleId;
	private CheckBattleUnitArray checkBattleUnitArray;

	private static IntMessageParameterHandler battleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleId");

	public static Message_7_33 create() {
		return new Message_7_33();
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
	 * @return the checkBattleUnitArray
	 */
	public CheckBattleUnitArray getCheckBattleUnitArray() {
		return checkBattleUnitArray;
	}

	/**
	 * @param checkBattleUnitArray
	 *            the checkBattleUnitArray to set
	 */
	public void setCheckBattleUnitArray(CheckBattleUnitArray checkBattleUnitArray) {
		this.checkBattleUnitArray = checkBattleUnitArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.battleId);
		checkBattleUnitArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleId = data.getInt();
		checkBattleUnitArray = CheckBattleUnitArray.create();
		checkBattleUnitArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!battleIdHandler.validate(battleId)) {
			return false;
		}
		if (!checkBattleUnitArray.validate()) {
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
		bb.append("checkBattleUnitArray:").append(checkBattleUnitArray.toString());
		return bb.toString();	
	}
}