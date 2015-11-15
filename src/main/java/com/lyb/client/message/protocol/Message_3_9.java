package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 增加次数
 *
 * @author codeGenerator
 * 
 */
public class Message_3_9 implements IMessage {

	private static int MAIN = 3;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(3, 9);

	private int countControlType;
	private int countControlParam;

	private static IntMessageParameterHandler countControlTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CountControlType");
	private static IntMessageParameterHandler countControlParamHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CountControlParam");

	public static Message_3_9 create() {
		return new Message_3_9();
	}

	/**
	 * @return the countControlType
	 */
	public int getCountControlType() {
		return countControlType;
	}

	/**
	 * @param countControlType
	 *            the countControlType to set
	 */
	public void setCountControlType(int countControlType) {
		this.countControlType = countControlType;
	}

	/**
	 * @return the countControlParam
	 */
	public int getCountControlParam() {
		return countControlParam;
	}

	/**
	 * @param countControlParam
	 *            the countControlParam to set
	 */
	public void setCountControlParam(int countControlParam) {
		this.countControlParam = countControlParam;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.countControlType);
		data.writeInt(this.countControlParam);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.countControlType = data.getInt();
		this.countControlParam = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!countControlTypeHandler.validate(countControlType)) {
			return false;
		}
		if (!countControlParamHandler.validate(countControlParam)) {
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
		bb.append("countControlType:").append(this.countControlType).append(", ");
		bb.append("countControlParam:").append(this.countControlParam);
		return bb.toString();	
	}
}