package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.ItemIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 抽卡牌
 *
 * @author codeGenerator
 * 
 */
public class Message_1006_3 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 3);

	private ItemIdArray itemIdArray;


	public static Message_1006_3 create() {
		return new Message_1006_3();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		itemIdArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		itemIdArray = ItemIdArray.create();
		itemIdArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!itemIdArray.validate()) {
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
		bb.append("itemIdArray:").append(itemIdArray.toString());
		return bb.toString();	
	}
}