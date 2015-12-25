package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 查看日志
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1019_36 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 36;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 36);

	private YabiaoLogArray yabiaoLogArray;


	public static Message_1019_36 create() {
		return new Message_1019_36();
	}

	/**
	 * @return the yabiaoLogArray
	 */
	public YabiaoLogArray getYabiaoLogArray() {
		return yabiaoLogArray;
	}

	/**
	 * @param yabiaoLogArray
	 *            the yabiaoLogArray to set
	 */
	public void setYabiaoLogArray(YabiaoLogArray yabiaoLogArray) {
		this.yabiaoLogArray = yabiaoLogArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		yabiaoLogArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		yabiaoLogArray = YabiaoLogArray.create();
		yabiaoLogArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!yabiaoLogArray.validate()) {
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
		bb.append("yabiaoLogArray:").append(yabiaoLogArray.toString());
		return bb.toString();	
	}
}