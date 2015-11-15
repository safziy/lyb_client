package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.MsgRecordArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 聊天记录
 *
 * @author codeGenerator
 * 
 */
public class Message_1011_2 implements IMessage {

	private static int MAIN = 1011;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1011, 2);

	private MsgRecordArray msgRecordArray;


	public static Message_1011_2 create() {
		return new Message_1011_2();
	}

	/**
	 * @return the msgRecordArray
	 */
	public MsgRecordArray getMsgRecordArray() {
		return msgRecordArray;
	}

	/**
	 * @param msgRecordArray
	 *            the msgRecordArray to set
	 */
	public void setMsgRecordArray(MsgRecordArray msgRecordArray) {
		this.msgRecordArray = msgRecordArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		msgRecordArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		msgRecordArray = MsgRecordArray.create();
		msgRecordArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!msgRecordArray.validate()) {
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
		bb.append("msgRecordArray:").append(msgRecordArray.toString());
		return bb.toString();	
	}
}