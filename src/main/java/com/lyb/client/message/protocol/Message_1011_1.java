package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.ChatContentArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 聊天信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1011_1 implements IMessage {

	private static int MAIN = 1011;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1011, 1);

	private long userId;
	private String userName;
	private int level;
	private int configId;
	private int vip;
	private String familyName;
	private ChatContentArray chatContentArray;
	private int mainType;
	private int subType;
	private long targetUserId;
	private String targetUserName;
	private int dateTime;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
	private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
	private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");
	private static IntMessageParameterHandler mainTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MainType");
	private static IntMessageParameterHandler subTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SubType");
	private static LongMessageParameterHandler targetUserIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("TargetUserId");
	private static IntMessageParameterHandler dateTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("DateTime");

	public static Message_1011_1 create() {
		return new Message_1011_1();
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
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the chatContentArray
	 */
	public ChatContentArray getChatContentArray() {
		return chatContentArray;
	}

	/**
	 * @param chatContentArray
	 *            the chatContentArray to set
	 */
	public void setChatContentArray(ChatContentArray chatContentArray) {
		this.chatContentArray = chatContentArray;
	}

	/**
	 * @return the mainType
	 */
	public int getMainType() {
		return mainType;
	}

	/**
	 * @param mainType
	 *            the mainType to set
	 */
	public void setMainType(int mainType) {
		this.mainType = mainType;
	}

	/**
	 * @return the subType
	 */
	public int getSubType() {
		return subType;
	}

	/**
	 * @param subType
	 *            the subType to set
	 */
	public void setSubType(int subType) {
		this.subType = subType;
	}

	/**
	 * @return the targetUserId
	 */
	public long getTargetUserId() {
		return targetUserId;
	}

	/**
	 * @param targetUserId
	 *            the targetUserId to set
	 */
	public void setTargetUserId(long targetUserId) {
		this.targetUserId = targetUserId;
	}

	/**
	 * @return the targetUserName
	 */
	public String getTargetUserName() {
		return targetUserName;
	}

	/**
	 * @param targetUserName
	 *            the targetUserName to set
	 */
	public void setTargetUserName(String targetUserName) {
		this.targetUserName = targetUserName;
	}

	/**
	 * @return the dateTime
	 */
	public int getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(int dateTime) {
		this.dateTime = dateTime;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
		data.writeString(this.userName);
		data.writeInt(this.level);
		data.writeInt(this.configId);
		data.writeInt(this.vip);
		data.writeString(this.familyName);
		chatContentArray.encode(data);
		data.writeInt(this.mainType);
		data.writeInt(this.subType);
		data.writeLong(this.targetUserId);
		data.writeString(this.targetUserName);
		data.writeInt(this.dateTime);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
		this.userName = data.getString();
		this.level = data.getInt();
		this.configId = data.getInt();
		this.vip = data.getInt();
		this.familyName = data.getString();
		chatContentArray = ChatContentArray.create();
		chatContentArray.decode(data);
		this.mainType = data.getInt();
		this.subType = data.getInt();
		this.targetUserId = data.getLong();
		this.targetUserName = data.getString();
		this.dateTime = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!levelHandler.validate(level)) {
			return false;
		}
		if (!configIdHandler.validate(configId)) {
			return false;
		}
		if (!vipHandler.validate(vip)) {
			return false;
		}
		if (!chatContentArray.validate()) {
			return false;
		}
		if (!mainTypeHandler.validate(mainType)) {
			return false;
		}
		if (!subTypeHandler.validate(subType)) {
			return false;
		}
		if (!targetUserIdHandler.validate(targetUserId)) {
			return false;
		}
		if (!dateTimeHandler.validate(dateTime)) {
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
		bb.append("configId:").append(this.configId).append(", ");
		bb.append("vip:").append(this.vip).append(", ");
		bb.append("familyName:").append(this.familyName).append(", ");
		bb.append("chatContentArray:").append(chatContentArray.toString()).append(", ");
		bb.append("mainType:").append(this.mainType).append(", ");
		bb.append("subType:").append(this.subType).append(", ");
		bb.append("targetUserId:").append(this.targetUserId).append(", ");
		bb.append("targetUserName:").append(this.targetUserName).append(", ");
		bb.append("dateTime:").append(this.dateTime);
		return bb.toString();	
	}
}