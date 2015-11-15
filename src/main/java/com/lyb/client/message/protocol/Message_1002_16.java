package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 封禁信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1002_16 implements IMessage {

	private static int MAIN = 1002;
	private static int SUB = 16;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1002, 16);

	private int type;
	private int time;
	private String content;

	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
	private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

	public static Message_1002_16 create() {
		return new Message_1002_16();
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.type);
		data.writeInt(this.time);
		data.writeString(this.content);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.type = data.getInt();
		this.time = data.getInt();
		this.content = data.getString();
	}

	@Override
	public boolean validate() {
		if (!typeHandler.validate(type)) {
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
		bb.append("type:").append(this.type).append(", ");
		bb.append("time:").append(this.time).append(", ");
		bb.append("content:").append(this.content);
		return bb.toString();	
	}
}