package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 用过的卡牌
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1019_37 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 37;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 37);

	private HusongUsedGeneralArray husongUsedGeneralArray;
	private PlunderUsedGeneralArray plunderUsedGeneralArray;
	private int time;
	private int endTime;

	private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");
	private static IntMessageParameterHandler endTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EndTime");

	public static Message_1019_37 create() {
		return new Message_1019_37();
	}

	/**
	 * @return the husongUsedGeneralArray
	 */
	public HusongUsedGeneralArray getHusongUsedGeneralArray() {
		return husongUsedGeneralArray;
	}

	/**
	 * @param husongUsedGeneralArray
	 *            the husongUsedGeneralArray to set
	 */
	public void setHusongUsedGeneralArray(HusongUsedGeneralArray husongUsedGeneralArray) {
		this.husongUsedGeneralArray = husongUsedGeneralArray;
	}

	/**
	 * @return the plunderUsedGeneralArray
	 */
	public PlunderUsedGeneralArray getPlunderUsedGeneralArray() {
		return plunderUsedGeneralArray;
	}

	/**
	 * @param plunderUsedGeneralArray
	 *            the plunderUsedGeneralArray to set
	 */
	public void setPlunderUsedGeneralArray(PlunderUsedGeneralArray plunderUsedGeneralArray) {
		this.plunderUsedGeneralArray = plunderUsedGeneralArray;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		husongUsedGeneralArray.encode(data);
		plunderUsedGeneralArray.encode(data);
		data.writeInt(this.time);
		data.writeInt(this.endTime);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		husongUsedGeneralArray = HusongUsedGeneralArray.create();
		husongUsedGeneralArray.decode(data);
		plunderUsedGeneralArray = PlunderUsedGeneralArray.create();
		plunderUsedGeneralArray.decode(data);
		this.time = data.getInt();
		this.endTime = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!husongUsedGeneralArray.validate()) {
			return false;
		}
		if (!plunderUsedGeneralArray.validate()) {
			return false;
		}
		if (!timeHandler.validate(time)) {
			return false;
		}
		if (!endTimeHandler.validate(endTime)) {
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
		bb.append("husongUsedGeneralArray:").append(husongUsedGeneralArray.toString()).append(", ");
		bb.append("plunderUsedGeneralArray:").append(plunderUsedGeneralArray.toString()).append(", ");
		bb.append("time:").append(this.time).append(", ");
		bb.append("endTime:").append(this.endTime);
		return bb.toString();	
	}
}