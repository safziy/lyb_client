package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 卖道具
 *
 * @author codeGenerator
 * 
 */
public class Message_9_10 implements IMessage {

	private static int MAIN = 9;
	private static int SUB = 10;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(9, 10);

	private long userItemId;
	private int count;

	private static LongMessageParameterHandler userItemIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserItemId");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_9_10 create() {
		return new Message_9_10();
	}

	/**
	 * @return the userItemId
	 */
	public long getUserItemId() {
		return userItemId;
	}

	/**
	 * @param userItemId
	 *            the userItemId to set
	 */
	public void setUserItemId(long userItemId) {
		this.userItemId = userItemId;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userItemId);
		data.writeInt(this.count);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userItemId = data.getLong();
		this.count = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userItemIdHandler.validate(userItemId)) {
			return false;
		}
		if (!countHandler.validate(count)) {
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
		bb.append("userItemId:").append(this.userItemId).append(", ");
		bb.append("count:").append(this.count);
		return bb.toString();	
	}
}