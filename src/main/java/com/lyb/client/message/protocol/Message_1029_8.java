package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.RankingArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 答题数量分数
 *
 * @author codeGenerator
 * 
 */
public class Message_1029_8 implements IMessage {

	private static int MAIN = 1029;
	private static int SUB = 8;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1029, 8);

	private int count;
	private int count2;
	private int score;
	private int booleanValue;
	private RankingArray rankingArray;

	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
	private static IntMessageParameterHandler count2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count2");
	private static IntMessageParameterHandler scoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Score");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1029_8 create() {
		return new Message_1029_8();
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the count2
	 */
	public int getCount2() {
		return count2;
	}

	/**
	 * @param count2
	 *            the count2 to set
	 */
	public void setCount2(int count2) {
		this.count2 = count2;
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
	 * @return the booleanValue
	 */
	public int getBooleanValue() {
		return booleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(int booleanValue) {
		this.booleanValue = booleanValue;
	}

	/**
	 * @return the rankingArray
	 */
	public RankingArray getRankingArray() {
		return rankingArray;
	}

	/**
	 * @param rankingArray
	 *            the rankingArray to set
	 */
	public void setRankingArray(RankingArray rankingArray) {
		this.rankingArray = rankingArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.count);
		data.writeInt(this.count2);
		data.writeInt(this.score);
		data.writeInt(this.booleanValue);
		rankingArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.count = data.getInt();
		this.count2 = data.getInt();
		this.score = data.getInt();
		this.booleanValue = data.getInt();
		rankingArray = RankingArray.create();
		rankingArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!count2Handler.validate(count2)) {
			return false;
		}
		if (!scoreHandler.validate(score)) {
			return false;
		}
		if (!booleanValueHandler.validate(booleanValue)) {
			return false;
		}
		if (!rankingArray.validate()) {
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
		bb.append("count:").append(this.count).append(", ");
		bb.append("count2:").append(this.count2).append(", ");
		bb.append("score:").append(this.score).append(", ");
		bb.append("booleanValue:").append(this.booleanValue).append(", ");
		bb.append("rankingArray:").append(rankingArray.toString());
		return bb.toString();	
	}
}