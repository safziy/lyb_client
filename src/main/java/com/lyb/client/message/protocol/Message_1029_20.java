package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 活动列表
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1029_20 implements IMessage {

	private static int MAIN = 1029;
	private static int SUB = 20;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1029, 20);

	private ActivityArray activityArray;


	public static Message_1029_20 create() {
		return new Message_1029_20();
	}

	/**
	 * @return the activityArray
	 */
	public ActivityArray getActivityArray() {
		return activityArray;
	}

	/**
	 * @param activityArray
	 *            the activityArray to set
	 */
	public void setActivityArray(ActivityArray activityArray) {
		this.activityArray = activityArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		activityArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		activityArray = ActivityArray.create();
		activityArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!activityArray.validate()) {
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
		bb.append("activityArray:").append(activityArray.toString());
		return bb.toString();	
	}
}