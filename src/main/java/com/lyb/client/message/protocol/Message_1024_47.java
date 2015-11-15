package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 钱庄数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1024_47 implements IMessage {

	private static int MAIN = 1024;
	private static int SUB = 47;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1024, 47);

	private int count;

	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_1024_47 create() {
		return new Message_1024_47();
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
		data.writeInt(this.count);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.count = data.getInt();
	}

	@Override
	public boolean validate() {
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
		bb.append("count:").append(this.count);
		return bb.toString();	
	}
}