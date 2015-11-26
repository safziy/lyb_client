package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 升级帮派技能
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1027_46 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 46;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 46);

	private int configId;
	private int level;

	private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");

	public static Message_1027_46 create() {
		return new Message_1027_46();
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
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.configId);
		data.writeInt(this.level);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.configId = data.getInt();
		this.level = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!configIdHandler.validate(configId)) {
			return false;
		}
		if (!levelHandler.validate(level)) {
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
		bb.append("configId:").append(this.configId).append(", ");
		bb.append("level:").append(this.level);
		return bb.toString();	
	}
}