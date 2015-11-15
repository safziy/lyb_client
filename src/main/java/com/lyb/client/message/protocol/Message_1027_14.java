package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.FamilyLogArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 家族日志列表
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_14 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 14;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 14);

	private FamilyLogArray familyLogArray;


	public static Message_1027_14 create() {
		return new Message_1027_14();
	}

	/**
	 * @return the familyLogArray
	 */
	public FamilyLogArray getFamilyLogArray() {
		return familyLogArray;
	}

	/**
	 * @param familyLogArray
	 *            the familyLogArray to set
	 */
	public void setFamilyLogArray(FamilyLogArray familyLogArray) {
		this.familyLogArray = familyLogArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		familyLogArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		familyLogArray = FamilyLogArray.create();
		familyLogArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!familyLogArray.validate()) {
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
		bb.append("familyLogArray:").append(familyLogArray.toString());
		return bb.toString();	
	}
}