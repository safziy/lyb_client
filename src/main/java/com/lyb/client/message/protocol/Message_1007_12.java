package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 删除战斗效果
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_12 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 12;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 12);

	private long battleUnitID;
	private int effectId;

	private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
	private static IntMessageParameterHandler effectIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EffectId");

	public static Message_1007_12 create() {
		return new Message_1007_12();
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
	 * @return the effectId
	 */
	public int getEffectId() {
		return effectId;
	}

	/**
	 * @param effectId
	 *            the effectId to set
	 */
	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.battleUnitID);
		data.writeInt(this.effectId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleUnitID = data.getLong();
		this.effectId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!battleUnitIDHandler.validate(battleUnitID)) {
			return false;
		}
		if (!effectIdHandler.validate(effectId)) {
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
		bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
		bb.append("effectId:").append(this.effectId);
		return bb.toString();	
	}
}