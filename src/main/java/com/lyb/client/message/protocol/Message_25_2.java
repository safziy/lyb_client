package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 修改 公告
 *
 * @author codeGenerator
 * 
 */
public class Message_25_2 implements IMessage {

	private static int MAIN = 25;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(25, 2);

	private String notice;


	public static Message_25_2 create() {
		return new Message_25_2();
	}

	/**
	 * @return the notice
	 */
	public String getNotice() {
		return notice;
	}

	/**
	 * @param notice
	 *            the notice to set
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.notice);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.notice = data.getString();
	}

	@Override
	public boolean validate() {
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
		bb.append("notice:").append(this.notice);
		return bb.toString();	
	}
}