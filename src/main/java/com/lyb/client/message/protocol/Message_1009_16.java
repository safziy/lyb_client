package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 gm道具
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1009_16 implements IMessage {

	private static int MAIN = 1009;
	private static int SUB = 16;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1009, 16);

	private GMItemArray gMItemArray;


	public static Message_1009_16 create() {
		return new Message_1009_16();
	}

	/**
	 * @return the gMItemArray
	 */
	public GMItemArray getGMItemArray() {
		return gMItemArray;
	}

	/**
	 * @param gMItemArray
	 *            the gMItemArray to set
	 */
	public void setGMItemArray(GMItemArray gMItemArray) {
		this.gMItemArray = gMItemArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		gMItemArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		gMItemArray = GMItemArray.create();
		gMItemArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!gMItemArray.validate()) {
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
		bb.append("gMItemArray:").append(gMItemArray.toString());
		return bb.toString();	
	}
}