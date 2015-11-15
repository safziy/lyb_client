package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.ApplierArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 审批列表
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_5 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 5;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 5);

	private ApplierArray applierArray;


	public static Message_1027_5 create() {
		return new Message_1027_5();
	}

	/**
	 * @return the applierArray
	 */
	public ApplierArray getApplierArray() {
		return applierArray;
	}

	/**
	 * @param applierArray
	 *            the applierArray to set
	 */
	public void setApplierArray(ApplierArray applierArray) {
		this.applierArray = applierArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		applierArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		applierArray = ApplierArray.create();
		applierArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!applierArray.validate()) {
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
		bb.append("applierArray:").append(applierArray.toString());
		return bb.toString();	
	}
}