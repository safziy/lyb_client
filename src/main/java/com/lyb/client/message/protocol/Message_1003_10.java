package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.ItemIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  获得道具
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_10 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 10;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 10);

	private ItemIdArray itemIdArray;


	public static Message_1003_10 create() {
		return new Message_1003_10();
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