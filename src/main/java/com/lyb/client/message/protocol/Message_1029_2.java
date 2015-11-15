package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.OperationActivityDetailArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 活动详细数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1029_2 implements IMessage {

	private static int MAIN = 1029;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1029, 2);

	private OperationActivityDetailArray operationActivityDetailArray;


	public static Message_1029_2 create() {
		return new Message_1029_2();
	}

	/**
	 * @return the operationActivityDetailArray
	 */
	public OperationActivityDetailArray getOperationActivityDetailArray() {
		return operationActivityDetailArray;
	}

	/**
	 * @param operationActivityDetailArray
	 *            the operationActivityDetailArray to set
	 */
	public void setOperationActivityDetailArray(OperationActivityDetailArray operationActivityDetailArray) {
		this.operationActivityDetailArray = operationActivityDetailArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		operationActivityDetailArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		operationActivityDetailArray = OperationActivityDetailArray.create();
		operationActivityDetailArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!operationActivityDetailArray.validate()) {
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
		bb.append("operationActivityDetailArray:").append(operationActivityDetailArray.toString());
		return bb.toString();	
	}
}