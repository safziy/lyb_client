package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.BattleUnitIDArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  当前活着的单位
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_34 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 34;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 34);

	private BattleUnitIDArray battleUnitIDArray;


	public static Message_1007_34 create() {
		return new Message_1007_34();
	}

	/**
	 * @return the battleUnitIDArray
	 */
	public BattleUnitIDArray getBattleUnitIDArray() {
		return battleUnitIDArray;
	}

	/**
	 * @param battleUnitIDArray
	 *            the battleUnitIDArray to set
	 */
	public void setBattleUnitIDArray(BattleUnitIDArray battleUnitIDArray) {
		this.battleUnitIDArray = battleUnitIDArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		battleUnitIDArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		battleUnitIDArray = BattleUnitIDArray.create();
		battleUnitIDArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!battleUnitIDArray.validate()) {
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
		bb.append("battleUnitIDArray:").append(battleUnitIDArray.toString());
		return bb.toString();	
	}
}