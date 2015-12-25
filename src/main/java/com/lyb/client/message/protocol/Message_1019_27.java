package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 护送界面需要同步的信息
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1019_27 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 27;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 27);

	private int startId;
	private int endId;
	private int carriageId;
	private int time;
	private int endTime;
	private int value;

	private static IntMessageParameterHandler startIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StartId");
	private static IntMessageParameterHandler endIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EndId");
	private static IntMessageParameterHandler carriageIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CarriageId");
	private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");
	private static IntMessageParameterHandler endTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EndTime");
	private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");

	public static Message_1019_27 create() {
		return new Message_1019_27();
	}

	/**
	 * @return the startId
	 */
	public int getStartId() {
		return startId;
	}

	/**
	 * @param startId
	 *            the startId to set
	 */
	public void setStartId(int startId) {
		this.startId = startId;
	}

	/**
	 * @return the endId
	 */
	public int getEndId() {
		return endId;
	}

	/**
	 * @param endId
	 *            the endId to set
	 */
	public void setEndId(int endId) {
		this.endId = endId;
	}

	/**
	 * @return the carriageId
	 */
	public int getCarriageId() {
		return carriageId;
	}

	/**
	 * @param carriageId
	 *            the carriageId to set
	 */
	public void setCarriageId(int carriageId) {
		this.carriageId = carriageId;
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
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.startId);
		data.writeInt(this.endId);
		data.writeInt(this.carriageId);
		data.writeInt(this.time);
		data.writeInt(this.endTime);
		data.writeInt(this.value);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.startId = data.getInt();
		this.endId = data.getInt();
		this.carriageId = data.getInt();
		this.time = data.getInt();
		this.endTime = data.getInt();
		this.value = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!startIdHandler.validate(startId)) {
			return false;
		}
		if (!endIdHandler.validate(endId)) {
			return false;
		}
		if (!carriageIdHandler.validate(carriageId)) {
			return false;
		}
		if (!timeHandler.validate(time)) {
			return false;
		}
		if (!endTimeHandler.validate(endTime)) {
			return false;
		}
		if (!valueHandler.validate(value)) {
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
		bb.append("startId:").append(this.startId).append(", ");
		bb.append("endId:").append(this.endId).append(", ");
		bb.append("carriageId:").append(this.carriageId).append(", ");
		bb.append("time:").append(this.time).append(", ");
		bb.append("endTime:").append(this.endTime).append(", ");
		bb.append("value:").append(this.value);
		return bb.toString();	
	}
}