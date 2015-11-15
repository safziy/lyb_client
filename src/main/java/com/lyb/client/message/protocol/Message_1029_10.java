package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 答题结果
 *
 * @author codeGenerator
 * 
 */
public class Message_1029_10 implements IMessage {

	private static int MAIN = 1029;
	private static int SUB = 10;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1029, 10);

	private int score;
	private int value;
	private long iD;

	private static IntMessageParameterHandler scoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Score");
	private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");
	private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");

	public static Message_1029_10 create() {
		return new Message_1029_10();
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
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return iD;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(long iD) {
		this.iD = iD;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.score);
		data.writeInt(this.value);
		data.writeLong(this.iD);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.score = data.getInt();
		this.value = data.getInt();
		this.iD = data.getLong();
	}

	@Override
	public boolean validate() {
		if (!scoreHandler.validate(score)) {
			return false;
		}
		if (!valueHandler.validate(value)) {
			return false;
		}
		if (!iDHandler.validate(iD)) {
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
		bb.append("score:").append(this.score).append(", ");
		bb.append("value:").append(this.value).append(", ");
		bb.append("iD:").append(this.iD);
		return bb.toString();	
	}
}