package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.ItemIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 战斗结束
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_6 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 6;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 6);

	private int booleanValue;
	private ItemIdArray itemIdArray;
	private int battleContinueTime;

	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
	private static IntMessageParameterHandler battleContinueTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleContinueTime");

	public static Message_1007_6 create() {
		return new Message_1007_6();
	}

	/**
	 * @return the booleanValue
	 */
	public int getBooleanValue() {
		return booleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(int booleanValue) {
		this.booleanValue = booleanValue;
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
	 * @return the battleContinueTime
	 */
	public int getBattleContinueTime() {
		return battleContinueTime;
	}

	/**
	 * @param battleContinueTime
	 *            the battleContinueTime to set
	 */
	public void setBattleContinueTime(int battleContinueTime) {
		this.battleContinueTime = battleContinueTime;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.booleanValue);
		itemIdArray.encode(data);
		data.writeInt(this.battleContinueTime);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.booleanValue = data.getInt();
		itemIdArray = ItemIdArray.create();
		itemIdArray.decode(data);
		this.battleContinueTime = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!booleanValueHandler.validate(booleanValue)) {
			return false;
		}
		if (!itemIdArray.validate()) {
			return false;
		}
		if (!battleContinueTimeHandler.validate(battleContinueTime)) {
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
		bb.append("booleanValue:").append(this.booleanValue).append(", ");
		bb.append("itemIdArray:").append(itemIdArray.toString()).append(", ");
		bb.append("battleContinueTime:").append(this.battleContinueTime);
		return bb.toString();	
	}
}