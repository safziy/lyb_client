package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.FamilyInfoArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 家族列表
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_7 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 7;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 7);

	private int count;
	private FamilyInfoArray familyInfoArray;

	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_1027_7 create() {
		return new Message_1027_7();
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the familyInfoArray
	 */
	public FamilyInfoArray getFamilyInfoArray() {
		return familyInfoArray;
	}

	/**
	 * @param familyInfoArray
	 *            the familyInfoArray to set
	 */
	public void setFamilyInfoArray(FamilyInfoArray familyInfoArray) {
		this.familyInfoArray = familyInfoArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.count);
		familyInfoArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.count = data.getInt();
		familyInfoArray = FamilyInfoArray.create();
		familyInfoArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!familyInfoArray.validate()) {
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
		bb.append("count:").append(this.count).append(", ");
		bb.append("familyInfoArray:").append(familyInfoArray.toString());
		return bb.toString();	
	}
}