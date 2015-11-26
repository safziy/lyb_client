package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 请求 升级帮派技能
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_27_46 implements IMessage {

	private static int MAIN = 27;
	private static int SUB = 46;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(27, 46);

	private int configId;

	private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

	public static Message_27_46 create() {
		return new Message_27_46();
	}

	/**
	 * @return the configId
	 */
	public int getConfigId() {
		return configId;
	}

	/**
	 * @param configId
	 *            the configId to set
	 */
	public void setConfigId(int configId) {
		this.configId = configId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.configId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.configId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!configIdHandler.validate(configId)) {
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
		bb.append("configId:").append(this.configId);
		return bb.toString();	
	}
}