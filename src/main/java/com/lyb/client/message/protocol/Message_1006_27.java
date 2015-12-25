package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 卡牌换装信息
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1006_27 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 27;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 27);

	private HuanzhuangArray huanzhuangArray;


	public static Message_1006_27 create() {
		return new Message_1006_27();
	}

	/**
	 * @return the huanzhuangArray
	 */
	public HuanzhuangArray getHuanzhuangArray() {
		return huanzhuangArray;
	}

	/**
	 * @param huanzhuangArray
	 *            the huanzhuangArray to set
	 */
	public void setHuanzhuangArray(HuanzhuangArray huanzhuangArray) {
		this.huanzhuangArray = huanzhuangArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		huanzhuangArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		huanzhuangArray = HuanzhuangArray.create();
		huanzhuangArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!huanzhuangArray.validate()) {
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
		bb.append("huanzhuangArray:").append(huanzhuangArray.toString());
		return bb.toString();	
	}
}