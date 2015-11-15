package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.BattleEmployArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  打开雇佣界面
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_38 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 38;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 38);

	private BattleEmployArray battleEmployArray;


	public static Message_1007_38 create() {
		return new Message_1007_38();
	}

	/**
	 * @return the battleEmployArray
	 */
	public BattleEmployArray getBattleEmployArray() {
		return battleEmployArray;
	}

	/**
	 * @param battleEmployArray
	 *            the battleEmployArray to set
	 */
	public void setBattleEmployArray(BattleEmployArray battleEmployArray) {
		this.battleEmployArray = battleEmployArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		battleEmployArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		battleEmployArray = BattleEmployArray.create();
		battleEmployArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!battleEmployArray.validate()) {
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
		bb.append("battleEmployArray:").append(battleEmployArray.toString());
		return bb.toString();	
	}
}