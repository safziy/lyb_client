package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.RankGeneralArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  查看玩家信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_11 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 11;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 11);

	private long userId;
	private String userName;
	private int level;
	private int career;
	private int transforId;
	private int zhanli;
	private RankGeneralArray rankGeneralArray;
	private int flower;
	private int booleanValue;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
	private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
	private static IntMessageParameterHandler transforIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TransforId");
	private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
	private static IntMessageParameterHandler flowerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Flower");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1003_11 create() {
		return new Message_1003_11();
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the career
	 */
	public int getCareer() {
		return career;
	}

	/**
	 * @param career
	 *            the career to set
	 */
	public void setCareer(int career) {
		this.career = career;
	}

	/**
	 * @return the transforId
	 */
	public int getTransforId() {
		return transforId;
	}

	/**
	 * @param transforId
	 *            the transforId to set
	 */
	public void setTransforId(int transforId) {
		this.transforId = transforId;
	}

	/**
	 * @return the zhanli
	 */
	public int getZhanli() {
		return zhanli;
	}

	/**
	 * @param zhanli
	 *            the zhanli to set
	 */
	public void setZhanli(int zhanli) {
		this.zhanli = zhanli;
	}

	/**
	 * @return the rankGeneralArray
	 */
	public RankGeneralArray getRankGeneralArray() {
		return rankGeneralArray;
	}

	/**
	 * @param rankGeneralArray
	 *            the rankGeneralArray to set
	 */
	public void setRankGeneralArray(RankGeneralArray rankGeneralArray) {
		this.rankGeneralArray = rankGeneralArray;
	}

	/**
	 * @return the flower
	 */
	public int getFlower() {
		return flower;
	}

	/**
	 * @param flower
	 *            the flower to set
	 */
	public void setFlower(int flower) {
		this.flower = flower;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
		data.writeString(this.userName);
		data.writeInt(this.level);
		data.writeInt(this.career);
		data.writeInt(this.transforId);
		data.writeInt(this.zhanli);
		rankGeneralArray.encode(data);
		data.writeInt(this.flower);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
		this.userName = data.getString();
		this.level = data.getInt();
		this.career = data.getInt();
		this.transforId = data.getInt();
		this.zhanli = data.getInt();
		rankGeneralArray = RankGeneralArray.create();
		rankGeneralArray.decode(data);
		this.flower = data.getInt();
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!levelHandler.validate(level)) {
			return false;
		}
		if (!careerHandler.validate(career)) {
			return false;
		}
		if (!transforIdHandler.validate(transforId)) {
			return false;
		}
		if (!zhanliHandler.validate(zhanli)) {
			return false;
		}
		if (!rankGeneralArray.validate()) {
			return false;
		}
		if (!flowerHandler.validate(flower)) {
			return false;
		}
		if (!booleanValueHandler.validate(booleanValue)) {
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
		bb.append("userId:").append(this.userId).append(", ");
		bb.append("userName:").append(this.userName).append(", ");
		bb.append("level:").append(this.level).append(", ");
		bb.append("career:").append(this.career).append(", ");
		bb.append("transforId:").append(this.transforId).append(", ");
		bb.append("zhanli:").append(this.zhanli).append(", ");
		bb.append("rankGeneralArray:").append(rankGeneralArray.toString()).append(", ");
		bb.append("flower:").append(this.flower).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}