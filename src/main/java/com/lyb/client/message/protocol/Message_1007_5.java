package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.EffectArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 战斗效果
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_5 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 5;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 5);

	private long battleUnitID;
	private EffectArray effectArray;

	private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");

	public static Message_1007_5 create() {
		return new Message_1007_5();
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
	 * @return the effectArray
	 */
	public EffectArray getEffectArray() {
		return effectArray;
	}

	/**
	 * @param effectArray
	 *            the effectArray to set
	 */
	public void setEffectArray(EffectArray effectArray) {
		this.effectArray = effectArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.battleUnitID);
		effectArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleUnitID = data.getLong();
		effectArray = EffectArray.create();
		effectArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!battleUnitIDHandler.validate(battleUnitID)) {
			return false;
		}
		if (!effectArray.validate()) {
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
		bb.append("effectArray:").append(effectArray.toString());
		return bb.toString();	
	}
}