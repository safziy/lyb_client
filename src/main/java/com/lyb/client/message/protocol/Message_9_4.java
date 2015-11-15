package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 无对象直接使用道具
 *
 * @author codeGenerator
 * 
 */
public class Message_9_4 implements IMessage {

	private static int MAIN = 9;
	private static int SUB = 4;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(9, 4);

	private int place;
	private int itemId;
	private int count;
	private int currencyType;

	private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
	private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
	private static IntMessageParameterHandler currencyTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrencyType");

	public static Message_9_4 create() {
		return new Message_9_4();
	}

	/**
	 * @return the place
	 */
	public int getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(int place) {
		this.place = place;
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
	 * @return the currencyType
	 */
	public int getCurrencyType() {
		return currencyType;
	}

	/**
	 * @param currencyType
	 *            the currencyType to set
	 */
	public void setCurrencyType(int currencyType) {
		this.currencyType = currencyType;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.place);
		data.writeInt(this.itemId);
		data.writeInt(this.count);
		data.writeInt(this.currencyType);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.place = data.getInt();
		this.itemId = data.getInt();
		this.count = data.getInt();
		this.currencyType = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!placeHandler.validate(place)) {
			return false;
		}
		if (!itemIdHandler.validate(itemId)) {
			return false;
		}
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!currencyTypeHandler.validate(currencyType)) {
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
		bb.append("place:").append(this.place).append(", ");
		bb.append("itemId:").append(this.itemId).append(", ");
		bb.append("count:").append(this.count).append(", ");
		bb.append("currencyType:").append(this.currencyType);
		return bb.toString();	
	}
}