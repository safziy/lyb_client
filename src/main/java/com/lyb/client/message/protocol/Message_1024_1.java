package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.IDBooleanArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 限时商店
 *
 * @author codeGenerator
 * 
 */
public class Message_1024_1 implements IMessage {

	private static int MAIN = 1024;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1024, 1);

	private IDBooleanArray iDBooleanArray;
	private int time;

	private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

	public static Message_1024_1 create() {
		return new Message_1024_1();
	}

	/**
	 * @return the iDBooleanArray
	 */
	public IDBooleanArray getIDBooleanArray() {
		return iDBooleanArray;
	}

	/**
	 * @param iDBooleanArray
	 *            the iDBooleanArray to set
	 */
	public void setIDBooleanArray(IDBooleanArray iDBooleanArray) {
		this.iDBooleanArray = iDBooleanArray;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		iDBooleanArray.encode(data);
		data.writeInt(this.time);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		iDBooleanArray = IDBooleanArray.create();
		iDBooleanArray.decode(data);
		this.time = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!iDBooleanArray.validate()) {
			return false;
		}
		if (!timeHandler.validate(time)) {
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
		bb.append("iDBooleanArray:").append(iDBooleanArray.toString()).append(", ");
		bb.append("time:").append(this.time);
		return bb.toString();	
	}
}