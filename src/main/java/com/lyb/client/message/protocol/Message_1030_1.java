package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.UserDungeonArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 地牢数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1030_1 implements IMessage {

	private static int MAIN = 1030;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1030, 1);

	private int count;
	private int booleanValue;
	private int booleanValue2;
	private int score;
	private UserDungeonArray userDungeonArray;
	private int remainSeconds;

	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
	private static IntMessageParameterHandler booleanValue2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue2");
	private static IntMessageParameterHandler scoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Score");
	private static IntMessageParameterHandler remainSecondsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSeconds");

	public static Message_1030_1 create() {
		return new Message_1030_1();
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
	 * @return the booleanValue2
	 */
	public int getBooleanValue2() {
		return booleanValue2;
	}

	/**
	 * @param booleanValue2
	 *            the booleanValue2 to set
	 */
	public void setBooleanValue2(int booleanValue2) {
		this.booleanValue2 = booleanValue2;
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
	 * @return the userDungeonArray
	 */
	public UserDungeonArray getUserDungeonArray() {
		return userDungeonArray;
	}

	/**
	 * @param userDungeonArray
	 *            the userDungeonArray to set
	 */
	public void setUserDungeonArray(UserDungeonArray userDungeonArray) {
		this.userDungeonArray = userDungeonArray;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.count);
		data.writeInt(this.booleanValue);
		data.writeInt(this.booleanValue2);
		data.writeInt(this.score);
		userDungeonArray.encode(data);
		data.writeInt(this.remainSeconds);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.count = data.getInt();
		this.booleanValue = data.getInt();
		this.booleanValue2 = data.getInt();
		this.score = data.getInt();
		userDungeonArray = UserDungeonArray.create();
		userDungeonArray.decode(data);
		this.remainSeconds = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!booleanValueHandler.validate(booleanValue)) {
			return false;
		}
		if (!booleanValue2Handler.validate(booleanValue2)) {
			return false;
		}
		if (!scoreHandler.validate(score)) {
			return false;
		}
		if (!userDungeonArray.validate()) {
			return false;
		}
		if (!remainSecondsHandler.validate(remainSeconds)) {
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
		bb.append("booleanValue:").append(this.booleanValue).append(", ");
		bb.append("booleanValue2:").append(this.booleanValue2).append(", ");
		bb.append("score:").append(this.score).append(", ");
		bb.append("userDungeonArray:").append(userDungeonArray.toString()).append(", ");
		bb.append("remainSeconds:").append(this.remainSeconds);
		return bb.toString();	
	}
}