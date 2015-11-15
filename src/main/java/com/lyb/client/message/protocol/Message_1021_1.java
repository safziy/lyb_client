package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.UserRelationArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 打开界面
 *
 * @author codeGenerator
 * 
 */
public class Message_1021_1 implements IMessage {

	private static int MAIN = 1021;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1021, 1);

	private UserRelationArray userRelationArray;
	private int flower;

	private static IntMessageParameterHandler flowerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Flower");

	public static Message_1021_1 create() {
		return new Message_1021_1();
	}

	/**
	 * @return the userRelationArray
	 */
	public UserRelationArray getUserRelationArray() {
		return userRelationArray;
	}

	/**
	 * @param userRelationArray
	 *            the userRelationArray to set
	 */
	public void setUserRelationArray(UserRelationArray userRelationArray) {
		this.userRelationArray = userRelationArray;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		userRelationArray.encode(data);
		data.writeInt(this.flower);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		userRelationArray = UserRelationArray.create();
		userRelationArray.decode(data);
		this.flower = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userRelationArray.validate()) {
			return false;
		}
		if (!flowerHandler.validate(flower)) {
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
		bb.append("userRelationArray:").append(userRelationArray.toString()).append(", ");
		bb.append("flower:").append(this.flower);
		return bb.toString();	
	}
}