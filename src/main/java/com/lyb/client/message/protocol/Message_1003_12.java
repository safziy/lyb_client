package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  系统数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_12 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 12;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 12);

	private int generalMaxLevel;
	private int serverTime;
	private int beginTime;

	private static IntMessageParameterHandler generalMaxLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("GeneralMaxLevel");
	private static IntMessageParameterHandler serverTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ServerTime");
	private static IntMessageParameterHandler beginTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BeginTime");

	public static Message_1003_12 create() {
		return new Message_1003_12();
	}

	/**
	 * @return the generalMaxLevel
	 */
	public int getGeneralMaxLevel() {
		return generalMaxLevel;
	}

	/**
	 * @param generalMaxLevel
	 *            the generalMaxLevel to set
	 */
	public void setGeneralMaxLevel(int generalMaxLevel) {
		this.generalMaxLevel = generalMaxLevel;
	}

	/**
	 * @return the serverTime
	 */
	public int getServerTime() {
		return serverTime;
	}

	/**
	 * @param serverTime
	 *            the serverTime to set
	 */
	public void setServerTime(int serverTime) {
		this.serverTime = serverTime;
	}

	/**
	 * @return the beginTime
	 */
	public int getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime
	 *            the beginTime to set
	 */
	public void setBeginTime(int beginTime) {
		this.beginTime = beginTime;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.generalMaxLevel);
		data.writeInt(this.serverTime);
		data.writeInt(this.beginTime);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalMaxLevel = data.getInt();
		this.serverTime = data.getInt();
		this.beginTime = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!generalMaxLevelHandler.validate(generalMaxLevel)) {
			return false;
		}
		if (!serverTimeHandler.validate(serverTime)) {
			return false;
		}
		if (!beginTimeHandler.validate(beginTime)) {
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
		bb.append("generalMaxLevel:").append(this.generalMaxLevel).append(", ");
		bb.append("serverTime:").append(this.serverTime).append(", ");
		bb.append("beginTime:").append(this.beginTime);
		return bb.toString();	
	}
}