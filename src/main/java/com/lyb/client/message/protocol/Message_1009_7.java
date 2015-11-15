package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.ItemUseQueue;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 道具使用队列
 *
 * @author codeGenerator
 * 
 */
public class Message_1009_7 implements IMessage {

	private static int MAIN = 1009;
	private static int SUB = 7;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1009, 7);

	private ItemUseQueue itemUseQueue;


	public static Message_1009_7 create() {
		return new Message_1009_7();
	}

	/**
	 * @return the itemUseQueue
	 */
	public ItemUseQueue getItemUseQueue() {
		return itemUseQueue;
	}

	/**
	 * @param itemUseQueue
	 *            the itemUseQueue to set
	 */
	public void setItemUseQueue(ItemUseQueue itemUseQueue) {
		this.itemUseQueue = itemUseQueue;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		itemUseQueue.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		itemUseQueue = ItemUseQueue.create();
		itemUseQueue.decode(data);
	}

	@Override
	public boolean validate() {
		if (!itemUseQueue.validate()) {
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
		bb.append("itemUseQueue:").append(itemUseQueue.toString());
		return bb.toString();	
	}
}