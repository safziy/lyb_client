package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.StoryLineIdArray;
import com.lyb.client.message.protocol.segment.StrongPointIdCountArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 剧情宝箱关卡信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1004_6 implements IMessage {

	private static int MAIN = 1004;
	private static int SUB = 6;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1004, 6);

	private StoryLineIdArray storyLineIdArray;
	private StrongPointIdCountArray strongPointIdCountArray;


	public static Message_1004_6 create() {
		return new Message_1004_6();
	}

	/**
	 * @return the storyLineIdArray
	 */
	public StoryLineIdArray getStoryLineIdArray() {
		return storyLineIdArray;
	}

	/**
	 * @param storyLineIdArray
	 *            the storyLineIdArray to set
	 */
	public void setStoryLineIdArray(StoryLineIdArray storyLineIdArray) {
		this.storyLineIdArray = storyLineIdArray;
	}

	/**
	 * @return the strongPointIdCountArray
	 */
	public StrongPointIdCountArray getStrongPointIdCountArray() {
		return strongPointIdCountArray;
	}

	/**
	 * @param strongPointIdCountArray
	 *            the strongPointIdCountArray to set
	 */
	public void setStrongPointIdCountArray(StrongPointIdCountArray strongPointIdCountArray) {
		this.strongPointIdCountArray = strongPointIdCountArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		storyLineIdArray.encode(data);
		strongPointIdCountArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		storyLineIdArray = StoryLineIdArray.create();
		storyLineIdArray.decode(data);
		strongPointIdCountArray = StrongPointIdCountArray.create();
		strongPointIdCountArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!storyLineIdArray.validate()) {
			return false;
		}
		if (!strongPointIdCountArray.validate()) {
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
		bb.append("storyLineIdArray:").append(storyLineIdArray.toString()).append(", ");
		bb.append("strongPointIdCountArray:").append(strongPointIdCountArray.toString());
		return bb.toString();	
	}
}