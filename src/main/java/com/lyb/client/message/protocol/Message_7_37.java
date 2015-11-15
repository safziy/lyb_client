package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  锁定目标
 *
 * @author codeGenerator
 * 
 */
public class Message_7_37 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 37;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 37);

	private long battleUnitID;

	private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");

	public static Message_7_37 create() {
		return new Message_7_37();
	}

	/**
	 * @return the battleUnitID
	 */
	public long getBattleUnitID() {
		return battleUnitID;
	}

	/**
	 * @param battleUnitID
	 *            the battleUnitID to set
	 */
	public void setBattleUnitID(long battleUnitID) {
		this.battleUnitID = battleUnitID;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.battleUnitID);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleUnitID = data.getLong();
	}

	@Override
	public boolean validate() {
		if (!battleUnitIDHandler.validate(battleUnitID)) {
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
		bb.append("battleUnitID:").append(this.battleUnitID);
		return bb.toString();	
	}
}