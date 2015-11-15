package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 查看展示的装备
 *
 * @author codeGenerator
 * 
 */
public class Message_1011_8 implements IMessage {

	private static int MAIN = 1011;
	private static int SUB = 8;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1011, 8);

	private long generalId;
	private int itemId;
	private int strengthenLevel;

	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
	private static IntMessageParameterHandler strengthenLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrengthenLevel");

	public static Message_1011_8 create() {
		return new Message_1011_8();
	}

	/**
	 * @return the generalId
	 */
	public long getGeneralId() {
		return generalId;
	}

	/**
	 * @param generalId
	 *            the generalId to set
	 */
	public void setGeneralId(long generalId) {
		this.generalId = generalId;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the strengthenLevel
	 */
	public int getStrengthenLevel() {
		return strengthenLevel;
	}

	/**
	 * @param strengthenLevel
	 *            the strengthenLevel to set
	 */
	public void setStrengthenLevel(int strengthenLevel) {
		this.strengthenLevel = strengthenLevel;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.generalId);
		data.writeInt(this.itemId);
		data.writeInt(this.strengthenLevel);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalId = data.getLong();
		this.itemId = data.getInt();
		this.strengthenLevel = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!generalIdHandler.validate(generalId)) {
			return false;
		}
		if (!itemIdHandler.validate(itemId)) {
			return false;
		}
		if (!strengthenLevelHandler.validate(strengthenLevel)) {
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
		bb.append("generalId:").append(this.generalId).append(", ");
		bb.append("itemId:").append(this.itemId).append(", ");
		bb.append("strengthenLevel:").append(this.strengthenLevel);
		return bb.toString();	
	}
}