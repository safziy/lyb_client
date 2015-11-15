package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.ChatContentArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 聊天
 *
 * @author codeGenerator
 * 
 */
public class Message_11_3 implements IMessage {

	private static int MAIN = 11;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(11, 3);

	private long userId;
	private String userName;
	private int mainType;
	private int subType;
	private ChatContentArray chatContentArray;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler mainTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MainType");
	private static IntMessageParameterHandler subTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SubType");

	public static Message_11_3 create() {
		return new Message_11_3();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
		data.writeString(this.userName);
		data.writeInt(this.mainType);
		data.writeInt(this.subType);
		chatContentArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
		this.userName = data.getString();
		this.mainType = data.getInt();
		this.subType = data.getInt();
		chatContentArray = ChatContentArray.create();
		chatContentArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!mainTypeHandler.validate(mainType)) {
			return false;
		}
		if (!subTypeHandler.validate(subType)) {
			return false;
		}
		if (!chatContentArray.validate()) {
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
		bb.append("mainType:").append(this.mainType).append(", ");
		bb.append("subType:").append(this.subType).append(", ");
		bb.append("chatContentArray:").append(chatContentArray.toString());
		return bb.toString();	
	}
}