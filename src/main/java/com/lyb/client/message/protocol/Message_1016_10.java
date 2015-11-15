package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 竞技场常修改数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1016_10 implements IMessage {

	private static int MAIN = 1016;
	private static int SUB = 10;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1016, 10);

	private int score;

	private static IntMessageParameterHandler scoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Score");

	public static Message_1016_10 create() {
		return new Message_1016_10();
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.score);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.score = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!scoreHandler.validate(score)) {
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
		bb.append("score:").append(this.score);
		return bb.toString();	
	}
}