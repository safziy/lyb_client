package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 抽卡牌
 *
 * @author codeGenerator
 * 
 */
public class Message_6_3 implements IMessage {

	private static int MAIN = 6;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(6, 3);

	private int byteType;
	private int count;

	private static IntMessageParameterHandler byteTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ByteType");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_6_3 create() {
		return new Message_6_3();
	}

	/**
	 * @return the byteType
	 */
	public int getByteType() {
		return byteType;
	}

	/**
	 * @param byteType
	 *            the byteType to set
	 */
	public void setByteType(int byteType) {
		this.byteType = byteType;
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
		data.writeInt(this.byteType);
		data.writeInt(this.count);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.byteType = data.getInt();
		this.count = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!byteTypeHandler.validate(byteType)) {
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
		bb.append("byteType:").append(this.byteType).append(", ");
		bb.append("count:").append(this.count);
		return bb.toString();	
	}
}