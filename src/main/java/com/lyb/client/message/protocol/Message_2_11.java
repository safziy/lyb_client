package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 服务器账号数据
 *
 * @author codeGenerator
 * 
 */
public class Message_2_11 implements IMessage {

	private static int MAIN = 2;
	private static int SUB = 11;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(2, 11);

	private int platformId;
	private String key;
	private String pwd;
	private String dCParamStr;

	private static IntMessageParameterHandler platformIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PlatformId");

	public static Message_2_11 create() {
		return new Message_2_11();
	}

	/**
	 * @return the platformId
	 */
	public int getPlatformId() {
		return platformId;
	}

	/**
	 * @param platformId
	 *            the platformId to set
	 */
	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the dCParamStr
	 */
	public String getDCParamStr() {
		return dCParamStr;
	}

	/**
	 * @param dCParamStr
	 *            the dCParamStr to set
	 */
	public void setDCParamStr(String dCParamStr) {
		this.dCParamStr = dCParamStr;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.platformId);
		data.writeString(this.key);
		data.writeString(this.pwd);
		data.writeString(this.dCParamStr);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.platformId = data.getInt();
		this.key = data.getString();
		this.pwd = data.getString();
		this.dCParamStr = data.getString();
	}

	@Override
	public boolean validate() {
		if (!platformIdHandler.validate(platformId)) {
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
		bb.append("platformId:").append(this.platformId).append(", ");
		bb.append("key:").append(this.key).append(", ");
		bb.append("pwd:").append(this.pwd).append(", ");
		bb.append("dCParamStr:").append(this.dCParamStr);
		return bb.toString();	
	}
}