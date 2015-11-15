package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  扫荡
 *
 * @author codeGenerator
 * 
 */
public class Message_7_58 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 58;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 58);

	private int strongPointId;
	private int count;

	private static IntMessageParameterHandler strongPointIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrongPointId");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_7_58 create() {
		return new Message_7_58();
	}

	/**
	 * @return the strongPointId
	 */
	public int getStrongPointId() {
		return strongPointId;
	}

	/**
	 * @param strongPointId
	 *            the strongPointId to set
	 */
	public void setStrongPointId(int strongPointId) {
		this.strongPointId = strongPointId;
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
		data.writeInt(this.strongPointId);
		data.writeInt(this.count);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.strongPointId = data.getInt();
		this.count = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!strongPointIdHandler.validate(strongPointId)) {
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
		bb.append("strongPointId:").append(this.strongPointId).append(", ");
		bb.append("count:").append(this.count);
		return bb.toString();	
	}
}