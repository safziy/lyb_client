package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.BeInvitedArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 输入邀请码
 *
 * @author codeGenerator
 * 
 */
public class Message_1034_2 implements IMessage {

	private static int MAIN = 1034;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1034, 2);

	private BeInvitedArray beInvitedArray;
	private long userId;
	private String userName;
	private int level;
	private int career;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
	private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");

	public static Message_1034_2 create() {
		return new Message_1034_2();
	}

	/**
	 * @return the beInvitedArray
	 */
	public BeInvitedArray getBeInvitedArray() {
		return beInvitedArray;
	}

	/**
	 * @param beInvitedArray
	 *            the beInvitedArray to set
	 */
	public void setBeInvitedArray(BeInvitedArray beInvitedArray) {
		this.beInvitedArray = beInvitedArray;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		beInvitedArray.encode(data);
		data.writeLong(this.userId);
		data.writeString(this.userName);
		data.writeInt(this.level);
		data.writeInt(this.career);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		beInvitedArray = BeInvitedArray.create();
		beInvitedArray.decode(data);
		this.userId = data.getLong();
		this.userName = data.getString();
		this.level = data.getInt();
		this.career = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!beInvitedArray.validate()) {
			return false;
		}
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!levelHandler.validate(level)) {
			return false;
		}
		if (!careerHandler.validate(career)) {
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
		bb.append("beInvitedArray:").append(beInvitedArray.toString()).append(", ");
		bb.append("userId:").append(this.userId).append(", ");
		bb.append("userName:").append(this.userName).append(", ");
		bb.append("level:").append(this.level).append(", ");
		bb.append("career:").append(this.career);
		return bb.toString();	
	}
}