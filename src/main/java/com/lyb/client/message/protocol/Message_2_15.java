package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 请求 设置
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_2_15 implements IMessage {

	private static int MAIN = 2;
	private static int SUB = 15;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(2, 15);

	private IDBooleanArray iDBooleanArray;


	public static Message_2_15 create() {
		return new Message_2_15();
	}

	/**
	 * @return the iDBooleanArray
	 */
	public IDBooleanArray getIDBooleanArray() {
		return iDBooleanArray;
	}

	/**
	 * @param iDBooleanArray
	 *            the iDBooleanArray to set
	 */
	public void setIDBooleanArray(IDBooleanArray iDBooleanArray) {
		this.iDBooleanArray = iDBooleanArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		iDBooleanArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		iDBooleanArray = IDBooleanArray.create();
		iDBooleanArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!iDBooleanArray.validate()) {
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
		bb.append("iDBooleanArray:").append(iDBooleanArray.toString());
		return bb.toString();	
	}
}