package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 装备强化
 *
 * @author codeGenerator
 * 
 */
public class Message_1010_2 implements IMessage {

	private static int MAIN = 1010;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1010, 2);

	private long generalId;
	private int itemId;
	private int strengthenLevel;
	private int param1;
	private int param2;

	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
	private static IntMessageParameterHandler strengthenLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrengthenLevel");
	private static IntMessageParameterHandler param1Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param1");
	private static IntMessageParameterHandler param2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param2");

	public static Message_1010_2 create() {
		return new Message_1010_2();
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
	 * @return the param1
	 */
	public int getParam1() {
		return param1;
	}

	/**
	 * @param param1
	 *            the param1 to set
	 */
	public void setParam1(int param1) {
		this.param1 = param1;
	}

	/**
	 * @return the param2
	 */
	public int getParam2() {
		return param2;
	}

	/**
	 * @param param2
	 *            the param2 to set
	 */
	public void setParam2(int param2) {
		this.param2 = param2;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.generalId);
		data.writeInt(this.itemId);
		data.writeInt(this.strengthenLevel);
		data.writeInt(this.param1);
		data.writeInt(this.param2);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalId = data.getLong();
		this.itemId = data.getInt();
		this.strengthenLevel = data.getInt();
		this.param1 = data.getInt();
		this.param2 = data.getInt();
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
		if (!param1Handler.validate(param1)) {
			return false;
		}
		if (!param2Handler.validate(param2)) {
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
		bb.append("strengthenLevel:").append(this.strengthenLevel).append(", ");
		bb.append("param1:").append(this.param1).append(", ");
		bb.append("param2:").append(this.param2);
		return bb.toString();	
	}
}