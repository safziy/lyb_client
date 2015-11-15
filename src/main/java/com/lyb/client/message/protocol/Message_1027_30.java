package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.BanquetInfoArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 酒宴场景数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_30 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 30;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 30);

	private int familyLevel;
	private BanquetInfoArray banquetInfoArray;

	private static IntMessageParameterHandler familyLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyLevel");

	public static Message_1027_30 create() {
		return new Message_1027_30();
	}

	/**
	 * @return the familyLevel
	 */
	public int getFamilyLevel() {
		return familyLevel;
	}

	/**
	 * @param familyLevel
	 *            the familyLevel to set
	 */
	public void setFamilyLevel(int familyLevel) {
		this.familyLevel = familyLevel;
	}

	/**
	 * @return the banquetInfoArray
	 */
	public BanquetInfoArray getBanquetInfoArray() {
		return banquetInfoArray;
	}

	/**
	 * @param banquetInfoArray
	 *            the banquetInfoArray to set
	 */
	public void setBanquetInfoArray(BanquetInfoArray banquetInfoArray) {
		this.banquetInfoArray = banquetInfoArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.familyLevel);
		banquetInfoArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.familyLevel = data.getInt();
		banquetInfoArray = BanquetInfoArray.create();
		banquetInfoArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!familyLevelHandler.validate(familyLevel)) {
			return false;
		}
		if (!banquetInfoArray.validate()) {
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
		bb.append("familyLevel:").append(this.familyLevel).append(", ");
		bb.append("banquetInfoArray:").append(banquetInfoArray.toString());
		return bb.toString();	
	}
}