package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 推送记录
 *
 * @author codeGenerator
 * 
 */
public class Message_1011_6 implements IMessage {

	private static int MAIN = 1011;
	private static int SUB = 6;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1011, 6);

	private long iD;
	private String paramStr1;
	private String paramStr2;
	private String paramStr3;
	private String paramStr4;
	private String content;

	private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");

	public static Message_1011_6 create() {
		return new Message_1011_6();
	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return iD;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(long iD) {
		this.iD = iD;
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
	 * @return the paramStr2
	 */
	public String getParamStr2() {
		return paramStr2;
	}

	/**
	 * @param paramStr2
	 *            the paramStr2 to set
	 */
	public void setParamStr2(String paramStr2) {
		this.paramStr2 = paramStr2;
	}

	/**
	 * @return the paramStr3
	 */
	public String getParamStr3() {
		return paramStr3;
	}

	/**
	 * @param paramStr3
	 *            the paramStr3 to set
	 */
	public void setParamStr3(String paramStr3) {
		this.paramStr3 = paramStr3;
	}

	/**
	 * @return the paramStr4
	 */
	public String getParamStr4() {
		return paramStr4;
	}

	/**
	 * @param paramStr4
	 *            the paramStr4 to set
	 */
	public void setParamStr4(String paramStr4) {
		this.paramStr4 = paramStr4;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.iD);
		data.writeString(this.paramStr1);
		data.writeString(this.paramStr2);
		data.writeString(this.paramStr3);
		data.writeString(this.paramStr4);
		data.writeString(this.content);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.iD = data.getLong();
		this.paramStr1 = data.getString();
		this.paramStr2 = data.getString();
		this.paramStr3 = data.getString();
		this.paramStr4 = data.getString();
		this.content = data.getString();
	}

	@Override
	public boolean validate() {
		if (!iDHandler.validate(iD)) {
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
		bb.append("iD:").append(this.iD).append(", ");
		bb.append("paramStr1:").append(this.paramStr1).append(", ");
		bb.append("paramStr2:").append(this.paramStr2).append(", ");
		bb.append("paramStr3:").append(this.paramStr3).append(", ");
		bb.append("paramStr4:").append(this.paramStr4).append(", ");
		bb.append("content:").append(this.content);
		return bb.toString();	
	}
}