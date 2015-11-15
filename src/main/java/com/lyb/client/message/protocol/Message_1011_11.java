package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 查看展示的卡牌
 *
 * @author codeGenerator
 * 
 */
public class Message_1011_11 implements IMessage {

	private static int MAIN = 1011;
	private static int SUB = 11;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1011, 11);

	private long generalId;
	private int configId;
	private int grade;
	private int starLevel;

	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
	private static IntMessageParameterHandler gradeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Grade");
	private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");

	public static Message_1011_11 create() {
		return new Message_1011_11();
	}

	/**
	 * @return the generalId
	 */
	public long getGeneralId() {
		return generalId;
	}

	/**
	 * @param generalId
	 *            the generalId to set
	 */
	public void setGeneralId(long generalId) {
		this.generalId = generalId;
	}

	/**
	 * @return the configId
	 */
	public int getConfigId() {
		return configId;
	}

	/**
	 * @param configId
	 *            the configId to set
	 */
	public void setConfigId(int configId) {
		this.configId = configId;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * @return the starLevel
	 */
	public int getStarLevel() {
		return starLevel;
	}

	/**
	 * @param starLevel
	 *            the starLevel to set
	 */
	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.generalId);
		data.writeInt(this.configId);
		data.writeInt(this.grade);
		data.writeInt(this.starLevel);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalId = data.getLong();
		this.configId = data.getInt();
		this.grade = data.getInt();
		this.starLevel = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!generalIdHandler.validate(generalId)) {
			return false;
		}
		if (!configIdHandler.validate(configId)) {
			return false;
		}
		if (!gradeHandler.validate(grade)) {
			return false;
		}
		if (!starLevelHandler.validate(starLevel)) {
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
		bb.append("generalId:").append(this.generalId).append(", ");
		bb.append("configId:").append(this.configId).append(", ");
		bb.append("grade:").append(this.grade).append(", ");
		bb.append("starLevel:").append(this.starLevel);
		return bb.toString();	
	}
}