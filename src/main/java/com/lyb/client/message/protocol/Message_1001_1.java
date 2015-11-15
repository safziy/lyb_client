package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 对应的错误码
 *
 * @author codeGenerator
 * 
 */
public class Message_1001_1 implements IMessage {

	private static int MAIN = 1001;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1001, 1);

	private int errorCode;

	private static IntMessageParameterHandler errorCodeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ErrorCode");

	public static Message_1001_1 create() {
		return new Message_1001_1();
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.errorCode);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.errorCode = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!errorCodeHandler.validate(errorCode)) {
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
		bb.append("errorCode:").append(this.errorCode);
		return bb.toString();	
	}
}