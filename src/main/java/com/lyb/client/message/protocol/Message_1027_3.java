package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 广播  进入场景
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_3 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 3);

	private long userId;
	private String userName;
	private int configId;
	private int vip;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
	private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");

	public static Message_1027_3 create() {
		return new Message_1027_3();
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
	 * @return the vip
	 */
	public int getVip() {
		return vip;
	}

	/**
	 * @param vip
	 *            the vip to set
	 */
	public void setVip(int vip) {
		this.vip = vip;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
		data.writeString(this.userName);
		data.writeInt(this.configId);
		data.writeInt(this.vip);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
		this.userName = data.getString();
		this.configId = data.getInt();
		this.vip = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!configIdHandler.validate(configId)) {
			return false;
		}
		if (!vipHandler.validate(vip)) {
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
		bb.append("configId:").append(this.configId).append(", ");
		bb.append("vip:").append(this.vip);
		return bb.toString();	
	}
}