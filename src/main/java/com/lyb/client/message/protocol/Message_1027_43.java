package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 广播 活跃度变化
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1027_43 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 43;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 43);

	private int value;
	private int huoyuedu;

	private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");
	private static IntMessageParameterHandler huoyueduHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Huoyuedu");

	public static Message_1027_43 create() {
		return new Message_1027_43();
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the huoyuedu
	 */
	public int getHuoyuedu() {
		return huoyuedu;
	}

	/**
	 * @param huoyuedu
	 *            the huoyuedu to set
	 */
	public void setHuoyuedu(int huoyuedu) {
		this.huoyuedu = huoyuedu;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.value);
		data.writeInt(this.huoyuedu);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.value = data.getInt();
		this.huoyuedu = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!valueHandler.validate(value)) {
			return false;
		}
		if (!huoyueduHandler.validate(huoyuedu)) {
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
		bb.append("value:").append(this.value).append(", ");
		bb.append("huoyuedu:").append(this.huoyuedu);
		return bb.toString();	
	}
}