package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 战场加载失败
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_3 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 3);

	private int battleId;

	private static IntMessageParameterHandler battleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleId");

	public static Message_1007_3 create() {
		return new Message_1007_3();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.battleId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!battleIdHandler.validate(battleId)) {
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
		bb.append("battleId:").append(this.battleId);
		return bb.toString();	
	}
}