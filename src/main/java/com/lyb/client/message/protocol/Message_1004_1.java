package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.StrongPointArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 关卡数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1004_1 implements IMessage {

	private static int MAIN = 1004;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1004, 1);

	private int storyLineId;
	private StrongPointArray strongPointArray;

	private static IntMessageParameterHandler storyLineIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StoryLineId");

	public static Message_1004_1 create() {
		return new Message_1004_1();
	}

	/**
	 * @return the storyLineId
	 */
	public int getStoryLineId() {
		return storyLineId;
	}

	/**
	 * @param storyLineId
	 *            the storyLineId to set
	 */
	public void setStoryLineId(int storyLineId) {
		this.storyLineId = storyLineId;
	}

	/**
	 * @return the strongPointArray
	 */
	public StrongPointArray getStrongPointArray() {
		return strongPointArray;
	}

	/**
	 * @param strongPointArray
	 *            the strongPointArray to set
	 */
	public void setStrongPointArray(StrongPointArray strongPointArray) {
		this.strongPointArray = strongPointArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.storyLineId);
		strongPointArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.storyLineId = data.getInt();
		strongPointArray = StrongPointArray.create();
		strongPointArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!storyLineIdHandler.validate(storyLineId)) {
			return false;
		}
		if (!strongPointArray.validate()) {
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
		bb.append("storyLineId:").append(this.storyLineId).append(", ");
		bb.append("strongPointArray:").append(strongPointArray.toString());
		return bb.toString();	
	}
}