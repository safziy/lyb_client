package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 提交 BUG,意见,投诉,其他
 *
 * @author codeGenerator
 * 
 */
public class Message_24_33 implements IMessage {

	private static int MAIN = 24;
	private static int SUB = 33;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(24, 33);

	private int type;
	private String title;
	private String content;

	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");

	public static Message_24_33 create() {
		return new Message_24_33();
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
		data.writeString(this.title);
		data.writeString(this.content);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.type = data.getInt();
		this.title = data.getString();
		this.content = data.getString();
	}

	@Override
	public boolean validate() {
		if (!typeHandler.validate(type)) {
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
		bb.append("title:").append(this.title).append(", ");
		bb.append("content:").append(this.content);
		return bb.toString();	
	}
}