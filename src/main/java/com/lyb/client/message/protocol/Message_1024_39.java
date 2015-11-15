package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 招财进宝
 *
 * @author codeGenerator
 * 
 */
public class Message_1024_39 implements IMessage {

	private static int MAIN = 1024;
	private static int SUB = 39;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1024, 39);

	private int gold;

	private static IntMessageParameterHandler goldHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Gold");

	public static Message_1024_39 create() {
		return new Message_1024_39();
	}

	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * @param gold
	 *            the gold to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.gold);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.gold = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!goldHandler.validate(gold)) {
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
		bb.append("gold:").append(this.gold);
		return bb.toString();	
	}
}