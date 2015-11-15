package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.OperationActivityArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 运营活动数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1029_1 implements IMessage {

	private static int MAIN = 1029;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1029, 1);

	private OperationActivityArray operationActivityArray;


	public static Message_1029_1 create() {
		return new Message_1029_1();
	}

	/**
	 * @return the operationActivityArray
	 */
	public OperationActivityArray getOperationActivityArray() {
		return operationActivityArray;
	}

	/**
	 * @param operationActivityArray
	 *            the operationActivityArray to set
	 */
	public void setOperationActivityArray(OperationActivityArray operationActivityArray) {
		this.operationActivityArray = operationActivityArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		operationActivityArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		operationActivityArray = OperationActivityArray.create();
		operationActivityArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!operationActivityArray.validate()) {
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
		bb.append("operationActivityArray:").append(operationActivityArray.toString());
		return bb.toString();	
	}
}