package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  自己信息的改变
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_1 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 1);

	private long familyId;
	private int familyPositionId;
	private String familyName;

	private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");
	private static IntMessageParameterHandler familyPositionIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyPositionId");

	public static Message_1027_1 create() {
		return new Message_1027_1();
	}

	/**
	 * @return the familyId
	 */
	public long getFamilyId() {
		return familyId;
	}

	/**
	 * @param familyId
	 *            the familyId to set
	 */
	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	/**
	 * @return the familyPositionId
	 */
	public int getFamilyPositionId() {
		return familyPositionId;
	}

	/**
	 * @param familyPositionId
	 *            the familyPositionId to set
	 */
	public void setFamilyPositionId(int familyPositionId) {
		this.familyPositionId = familyPositionId;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.familyId);
		data.writeInt(this.familyPositionId);
		data.writeString(this.familyName);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.familyId = data.getLong();
		this.familyPositionId = data.getInt();
		this.familyName = data.getString();
	}

	@Override
	public boolean validate() {
		if (!familyIdHandler.validate(familyId)) {
			return false;
		}
		if (!familyPositionIdHandler.validate(familyPositionId)) {
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
		bb.append("familyId:").append(this.familyId).append(", ");
		bb.append("familyPositionId:").append(this.familyPositionId).append(", ");
		bb.append("familyName:").append(this.familyName);
		return bb.toString();	
	}
}