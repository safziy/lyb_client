package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.NoticeBarArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 通知栏通知
 *
 * @author codeGenerator
 * 
 */
public class Message_1024_3 implements IMessage {

	private static int MAIN = 1024;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1024, 3);

	private NoticeBarArray noticeBarArray;


	public static Message_1024_3 create() {
		return new Message_1024_3();
	}

	/**
	 * @return the noticeBarArray
	 */
	public NoticeBarArray getNoticeBarArray() {
		return noticeBarArray;
	}

	/**
	 * @param noticeBarArray
	 *            the noticeBarArray to set
	 */
	public void setNoticeBarArray(NoticeBarArray noticeBarArray) {
		this.noticeBarArray = noticeBarArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		noticeBarArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		noticeBarArray = NoticeBarArray.create();
		noticeBarArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!noticeBarArray.validate()) {
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
		bb.append("noticeBarArray:").append(noticeBarArray.toString());
		return bb.toString();	
	}
}