package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.ItemIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 查看日常任务当天奖励
 *
 * @author codeGenerator
 * 
 */
public class Message_1008_5 implements IMessage {

	private static int MAIN = 1008;
	private static int SUB = 5;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1008, 5);

	private ItemIdArray itemIdArray;
	private int count;

	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_1008_5 create() {
		return new Message_1008_5();
	}

	/**
	 * @return the itemIdArray
	 */
	public ItemIdArray getItemIdArray() {
		return itemIdArray;
	}

	/**
	 * @param itemIdArray
	 *            the itemIdArray to set
	 */
	public void setItemIdArray(ItemIdArray itemIdArray) {
		this.itemIdArray = itemIdArray;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		itemIdArray.encode(data);
		data.writeInt(this.count);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		itemIdArray = ItemIdArray.create();
		itemIdArray.decode(data);
		this.count = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!itemIdArray.validate()) {
			return false;
		}
		if (!countHandler.validate(count)) {
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
		bb.append("itemIdArray:").append(itemIdArray.toString()).append(", ");
		bb.append("count:").append(this.count);
		return bb.toString();	
	}
}