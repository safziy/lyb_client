package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.UserArenaArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回决战巅峰面板信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1016_1 implements IMessage {

	private static int MAIN = 1016;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1016, 1);

	private int season;
	private int remainSeconds;
	private int ranking;
	private int score;
	private int count;
	private UserArenaArray userArenaArray;

	private static IntMessageParameterHandler seasonHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Season");
	private static IntMessageParameterHandler remainSecondsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSeconds");
	private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");
	private static IntMessageParameterHandler scoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Score");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_1016_1 create() {
		return new Message_1016_1();
	}

	/**
	 * @return the season
	 */
	public int getSeason() {
		return season;
	}

	/**
	 * @param season
	 *            the season to set
	 */
	public void setSeason(int season) {
		this.season = season;
	}

	/**
	 * @return the remainSeconds
	 */
	public int getRemainSeconds() {
		return remainSeconds;
	}

	/**
	 * @param remainSeconds
	 *            the remainSeconds to set
	 */
	public void setRemainSeconds(int remainSeconds) {
		this.remainSeconds = remainSeconds;
	}

	/**
	 * @return the ranking
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * @param ranking
	 *            the ranking to set
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
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
	 * @return the userArenaArray
	 */
	public UserArenaArray getUserArenaArray() {
		return userArenaArray;
	}

	/**
	 * @param userArenaArray
	 *            the userArenaArray to set
	 */
	public void setUserArenaArray(UserArenaArray userArenaArray) {
		this.userArenaArray = userArenaArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.season);
		data.writeInt(this.remainSeconds);
		data.writeInt(this.ranking);
		data.writeInt(this.score);
		data.writeInt(this.count);
		userArenaArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.season = data.getInt();
		this.remainSeconds = data.getInt();
		this.ranking = data.getInt();
		this.score = data.getInt();
		this.count = data.getInt();
		userArenaArray = UserArenaArray.create();
		userArenaArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!seasonHandler.validate(season)) {
			return false;
		}
		if (!remainSecondsHandler.validate(remainSeconds)) {
			return false;
		}
		if (!rankingHandler.validate(ranking)) {
			return false;
		}
		if (!scoreHandler.validate(score)) {
			return false;
		}
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!userArenaArray.validate()) {
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
		bb.append("season:").append(this.season).append(", ");
		bb.append("remainSeconds:").append(this.remainSeconds).append(", ");
		bb.append("ranking:").append(this.ranking).append(", ");
		bb.append("score:").append(this.score).append(", ");
		bb.append("count:").append(this.count).append(", ");
		bb.append("userArenaArray:").append(userArenaArray.toString());
		return bb.toString();	
	}
}