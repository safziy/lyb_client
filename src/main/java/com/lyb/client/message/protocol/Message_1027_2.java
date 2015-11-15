package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.SceneMemberArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  场景信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_2 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 2);

	private SceneMemberArray sceneMemberArray;
	private String paramStr1;
	private String userName;
	private int configId;

	private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

	public static Message_1027_2 create() {
		return new Message_1027_2();
	}

	/**
	 * @return the sceneMemberArray
	 */
	public SceneMemberArray getSceneMemberArray() {
		return sceneMemberArray;
	}

	/**
	 * @param sceneMemberArray
	 *            the sceneMemberArray to set
	 */
	public void setSceneMemberArray(SceneMemberArray sceneMemberArray) {
		this.sceneMemberArray = sceneMemberArray;
	}

	/**
	 * @return the paramStr1
	 */
	public String getParamStr1() {
		return paramStr1;
	}

	/**
	 * @param paramStr1
	 *            the paramStr1 to set
	 */
	public void setParamStr1(String paramStr1) {
		this.paramStr1 = paramStr1;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
		sceneMemberArray.encode(data);
		data.writeString(this.paramStr1);
		data.writeString(this.userName);
		data.writeInt(this.configId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		sceneMemberArray = SceneMemberArray.create();
		sceneMemberArray.decode(data);
		this.paramStr1 = data.getString();
		this.userName = data.getString();
		this.configId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!sceneMemberArray.validate()) {
			return false;
		}
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
		bb.append("sceneMemberArray:").append(sceneMemberArray.toString()).append(", ");
		bb.append("paramStr1:").append(this.paramStr1).append(", ");
		bb.append("userName:").append(this.userName).append(", ");
		bb.append("configId:").append(this.configId);
		return bb.toString();	
	}
}