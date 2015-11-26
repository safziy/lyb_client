package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 掠夺界面需要同步的信息
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1019_28 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 28;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 28);

	private PlunderArray plunderArray;


	public static Message_1019_28 create() {
		return new Message_1019_28();
	}

	/**
	 * @return the plunderArray
	 */
	public PlunderArray getPlunderArray() {
		return plunderArray;
	}

	/**
	 * @param plunderArray
	 *            the plunderArray to set
	 */
	public void setPlunderArray(PlunderArray plunderArray) {
		this.plunderArray = plunderArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		plunderArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		plunderArray = PlunderArray.create();
		plunderArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!plunderArray.validate()) {
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
		bb.append("plunderArray:").append(plunderArray.toString());
		return bb.toString();	
	}
}