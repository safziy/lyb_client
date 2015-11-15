package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.BattleUnitIDArray;
import com.lyb.client.message.protocol.segment.BattleUnitPropertyArray;
import com.lyb.client.message.protocol.segment.ItemIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  战场计算数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_31 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 31;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 31);

	private int battleId;
	private String randomSeed;
	private BattleUnitPropertyArray battleUnitPropertyArray;
	private BattleUnitIDArray battleUnitIDArray;
	private ItemIdArray itemIdArray;

	private static IntMessageParameterHandler battleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleId");

	public static Message_1007_31 create() {
		return new Message_1007_31();
	}

	/**
	 * @return the battleId
	 */
	public int getBattleId() {
		return battleId;
	}

	/**
	 * @param battleId
	 *            the battleId to set
	 */
	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}

	/**
	 * @return the randomSeed
	 */
	public String getRandomSeed() {
		return randomSeed;
	}

	/**
	 * @param randomSeed
	 *            the randomSeed to set
	 */
	public void setRandomSeed(String randomSeed) {
		this.randomSeed = randomSeed;
	}

	/**
	 * @return the battleUnitPropertyArray
	 */
	public BattleUnitPropertyArray getBattleUnitPropertyArray() {
		return battleUnitPropertyArray;
	}

	/**
	 * @param battleUnitPropertyArray
	 *            the battleUnitPropertyArray to set
	 */
	public void setBattleUnitPropertyArray(BattleUnitPropertyArray battleUnitPropertyArray) {
		this.battleUnitPropertyArray = battleUnitPropertyArray;
	}

	/**
	 * @return the battleUnitIDArray
	 */
	public BattleUnitIDArray getBattleUnitIDArray() {
		return battleUnitIDArray;
	}

	/**
	 * @param battleUnitIDArray
	 *            the battleUnitIDArray to set
	 */
	public void setBattleUnitIDArray(BattleUnitIDArray battleUnitIDArray) {
		this.battleUnitIDArray = battleUnitIDArray;
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
		data.writeInt(this.battleId);
		data.writeString(this.randomSeed);
		battleUnitPropertyArray.encode(data);
		battleUnitIDArray.encode(data);
		itemIdArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleId = data.getInt();
		this.randomSeed = data.getString();
		battleUnitPropertyArray = BattleUnitPropertyArray.create();
		battleUnitPropertyArray.decode(data);
		battleUnitIDArray = BattleUnitIDArray.create();
		battleUnitIDArray.decode(data);
		itemIdArray = ItemIdArray.create();
		itemIdArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!battleIdHandler.validate(battleId)) {
			return false;
		}
		if (!battleUnitPropertyArray.validate()) {
			return false;
		}
		if (!battleUnitIDArray.validate()) {
			return false;
		}
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
		bb.append("battleId:").append(this.battleId).append(", ");
		bb.append("randomSeed:").append(this.randomSeed).append(", ");
		bb.append("battleUnitPropertyArray:").append(battleUnitPropertyArray.toString()).append(", ");
		bb.append("battleUnitIDArray:").append(battleUnitIDArray.toString()).append(", ");
		bb.append("itemIdArray:").append(itemIdArray.toString());
		return bb.toString();	
	}
}