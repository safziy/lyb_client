package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 卡牌升级
 *
 * @author codeGenerator
 * 
 */
public class Message_6_11 implements IMessage {

	private static int MAIN = 6;
	private static int SUB = 11;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(6, 11);

	private long generalId;
	private int itemId;
	private int count;
	private int count2;

	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
	private static IntMessageParameterHandler count2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count2");

	public static Message_6_11 create() {
		return new Message_6_11();
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
	 * @return the count2
	 */
	public int getCount2() {
		return count2;
	}

	/**
	 * @param count2
	 *            the count2 to set
	 */
	public void setCount2(int count2) {
		this.count2 = count2;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.generalId);
		data.writeInt(this.itemId);
		data.writeInt(this.count);
		data.writeInt(this.count2);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalId = data.getLong();
		this.itemId = data.getInt();
		this.count = data.getInt();
		this.count2 = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!generalIdHandler.validate(generalId)) {
			return false;
		}
		if (!itemIdHandler.validate(itemId)) {
			return false;
		}
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!count2Handler.validate(count2)) {
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
		bb.append("count:").append(this.count).append(", ");
		bb.append("count2:").append(this.count2);
		return bb.toString();	
	}
}