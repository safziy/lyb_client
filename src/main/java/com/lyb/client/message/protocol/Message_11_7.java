package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 请求 展示装备
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_11_7 implements IMessage {

	private static int MAIN = 11;
	private static int SUB = 7;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(11, 7);

	private ShareEquipArray shareEquipArray;


	public static Message_11_7 create() {
		return new Message_11_7();
	}

	/**
	 * @return the shareEquipArray
	 */
	public ShareEquipArray getShareEquipArray() {
		return shareEquipArray;
	}

	/**
	 * @param shareEquipArray
	 *            the shareEquipArray to set
	 */
	public void setShareEquipArray(ShareEquipArray shareEquipArray) {
		this.shareEquipArray = shareEquipArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		shareEquipArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		shareEquipArray = ShareEquipArray.create();
		shareEquipArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!shareEquipArray.validate()) {
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
		bb.append("shareEquipArray:").append(shareEquipArray.toString());
		return bb.toString();	
	}
}