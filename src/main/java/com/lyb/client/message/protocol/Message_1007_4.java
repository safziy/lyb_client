package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 战斗hp
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_4 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 4;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 4);

	private long battleUnitID;
	private int currentHP;
	private int changeValue;

	private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
	private static IntMessageParameterHandler currentHPHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentHP");
	private static IntMessageParameterHandler changeValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ChangeValue");

	public static Message_1007_4 create() {
		return new Message_1007_4();
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
	 * @return the currentHP
	 */
	public int getCurrentHP() {
		return currentHP;
	}

	/**
	 * @param currentHP
	 *            the currentHP to set
	 */
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	/**
	 * @return the changeValue
	 */
	public int getChangeValue() {
		return changeValue;
	}

	/**
	 * @param changeValue
	 *            the changeValue to set
	 */
	public void setChangeValue(int changeValue) {
		this.changeValue = changeValue;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.battleUnitID);
		data.writeInt(this.currentHP);
		data.writeInt(this.changeValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleUnitID = data.getLong();
		this.currentHP = data.getInt();
		this.changeValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!battleUnitIDHandler.validate(battleUnitID)) {
			return false;
		}
		if (!currentHPHandler.validate(currentHP)) {
			return false;
		}
		if (!changeValueHandler.validate(changeValue)) {
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
		bb.append("currentHP:").append(this.currentHP).append(", ");
		bb.append("changeValue:").append(this.changeValue);
		return bb.toString();	
	}
}