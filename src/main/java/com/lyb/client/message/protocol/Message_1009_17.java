package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 动态商店
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1009_17 implements IMessage {

	private static int MAIN = 1009;
	private static int SUB = 17;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1009, 17);

	private ShopItemArray shopItemArray;


	public static Message_1009_17 create() {
		return new Message_1009_17();
	}

	/**
	 * @return the shopItemArray
	 */
	public ShopItemArray getShopItemArray() {
		return shopItemArray;
	}

	/**
	 * @param shopItemArray
	 *            the shopItemArray to set
	 */
	public void setShopItemArray(ShopItemArray shopItemArray) {
		this.shopItemArray = shopItemArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		shopItemArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		shopItemArray = ShopItemArray.create();
		shopItemArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!shopItemArray.validate()) {
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
		bb.append("shopItemArray:").append(shopItemArray.toString());
		return bb.toString();	
	}
}