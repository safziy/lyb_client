package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.NoticeArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 公告列表
 *
 * @author codeGenerator
 * 
 */
public class Message_1029_13 implements IMessage {

	private static int MAIN = 1029;
	private static int SUB = 13;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1029, 13);

	private NoticeArray noticeArray;


	public static Message_1029_13 create() {
		return new Message_1029_13();
	}

	/**
	 * @return the noticeArray
	 */
	public NoticeArray getNoticeArray() {
		return noticeArray;
	}

	/**
	 * @param noticeArray
	 *            the noticeArray to set
	 */
	public void setNoticeArray(NoticeArray noticeArray) {
		this.noticeArray = noticeArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		noticeArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		noticeArray = NoticeArray.create();
		noticeArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!noticeArray.validate()) {
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
		bb.append("noticeArray:").append(noticeArray.toString());
		return bb.toString();	
	}
}