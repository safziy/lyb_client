package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.FlowerHistoryArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 送花记录
 *
 * @author codeGenerator
 * 
 */
public class Message_1021_6 implements IMessage {

	private static int MAIN = 1021;
	private static int SUB = 6;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1021, 6);

	private FlowerHistoryArray flowerHistoryArray;


	public static Message_1021_6 create() {
		return new Message_1021_6();
	}

	/**
	 * @return the flowerHistoryArray
	 */
	public FlowerHistoryArray getFlowerHistoryArray() {
		return flowerHistoryArray;
	}

	/**
	 * @param flowerHistoryArray
	 *            the flowerHistoryArray to set
	 */
	public void setFlowerHistoryArray(FlowerHistoryArray flowerHistoryArray) {
		this.flowerHistoryArray = flowerHistoryArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		flowerHistoryArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		flowerHistoryArray = FlowerHistoryArray.create();
		flowerHistoryArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!flowerHistoryArray.validate()) {
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
		bb.append("flowerHistoryArray:").append(flowerHistoryArray.toString());
		return bb.toString();	
	}
}