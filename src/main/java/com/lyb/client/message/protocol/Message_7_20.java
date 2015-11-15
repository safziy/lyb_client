package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.BufArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求   战场验证
 *
 * @author codeGenerator
 * 
 */
public class Message_7_20 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 20;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 20);

	private int param;
	private String paramStr1;
	private int param2;
	private int param3;
	private BufArray bufArray;

	private static IntMessageParameterHandler paramHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param");
	private static IntMessageParameterHandler param2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param2");
	private static IntMessageParameterHandler param3Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param3");

	public static Message_7_20 create() {
		return new Message_7_20();
	}

	/**
	 * @return the param
	 */
	public int getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(int param) {
		this.param = param;
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
	 * @return the param2
	 */
	public int getParam2() {
		return param2;
	}

	/**
	 * @param param2
	 *            the param2 to set
	 */
	public void setParam2(int param2) {
		this.param2 = param2;
	}

	/**
	 * @return the param3
	 */
	public int getParam3() {
		return param3;
	}

	/**
	 * @param param3
	 *            the param3 to set
	 */
	public void setParam3(int param3) {
		this.param3 = param3;
	}

	/**
	 * @return the bufArray
	 */
	public BufArray getBufArray() {
		return bufArray;
	}

	/**
	 * @param bufArray
	 *            the bufArray to set
	 */
	public void setBufArray(BufArray bufArray) {
		this.bufArray = bufArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.param);
		data.writeString(this.paramStr1);
		data.writeInt(this.param2);
		data.writeInt(this.param3);
		bufArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.param = data.getInt();
		this.paramStr1 = data.getString();
		this.param2 = data.getInt();
		this.param3 = data.getInt();
		bufArray = BufArray.create();
		bufArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!paramHandler.validate(param)) {
			return false;
		}
		if (!param2Handler.validate(param2)) {
			return false;
		}
		if (!param3Handler.validate(param3)) {
			return false;
		}
		if (!bufArray.validate()) {
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
		bb.append("param:").append(this.param).append(", ");
		bb.append("paramStr1:").append(this.paramStr1).append(", ");
		bb.append("param2:").append(this.param2).append(", ");
		bb.append("param3:").append(this.param3).append(", ");
		bb.append("bufArray:").append(bufArray.toString());
		return bb.toString();	
	}
}