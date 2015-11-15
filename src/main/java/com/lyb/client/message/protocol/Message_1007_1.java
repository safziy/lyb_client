package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.BattleGeneralArray;
import com.lyb.client.message.protocol.segment.BattleUnitIDArray;
import com.lyb.client.message.protocol.segment.BattleUserArray;
import com.lyb.client.message.protocol.segment.ItemIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 初始化战场数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_1 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 1);

	private int battleId;
	private int battleFieldId;
	private int mapId;
	private int battleTemplateId;
	private String randomSeed;
	private BattleUserArray battleUserArray;
	private BattleGeneralArray battleGeneralArray;
	private BattleUnitIDArray battleUnitIDArray;
	private ItemIdArray itemIdArray;

	private static IntMessageParameterHandler battleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleId");
	private static IntMessageParameterHandler battleFieldIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleFieldId");
	private static IntMessageParameterHandler mapIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MapId");
	private static IntMessageParameterHandler battleTemplateIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleTemplateId");

	public static Message_1007_1 create() {
		return new Message_1007_1();
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
	 * @return the battleFieldId
	 */
	public int getBattleFieldId() {
		return battleFieldId;
	}

	/**
	 * @param battleFieldId
	 *            the battleFieldId to set
	 */
	public void setBattleFieldId(int battleFieldId) {
		this.battleFieldId = battleFieldId;
	}

	/**
	 * @return the mapId
	 */
	public int getMapId() {
		return mapId;
	}

	/**
	 * @param mapId
	 *            the mapId to set
	 */
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	/**
	 * @return the battleTemplateId
	 */
	public int getBattleTemplateId() {
		return battleTemplateId;
	}

	/**
	 * @param battleTemplateId
	 *            the battleTemplateId to set
	 */
	public void setBattleTemplateId(int battleTemplateId) {
		this.battleTemplateId = battleTemplateId;
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
	 * @return the battleUserArray
	 */
	public BattleUserArray getBattleUserArray() {
		return battleUserArray;
	}

	/**
	 * @param battleUserArray
	 *            the battleUserArray to set
	 */
	public void setBattleUserArray(BattleUserArray battleUserArray) {
		this.battleUserArray = battleUserArray;
	}

	/**
	 * @return the battleGeneralArray
	 */
	public BattleGeneralArray getBattleGeneralArray() {
		return battleGeneralArray;
	}

	/**
	 * @param battleGeneralArray
	 *            the battleGeneralArray to set
	 */
	public void setBattleGeneralArray(BattleGeneralArray battleGeneralArray) {
		this.battleGeneralArray = battleGeneralArray;
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
		data.writeInt(this.battleFieldId);
		data.writeInt(this.mapId);
		data.writeInt(this.battleTemplateId);
		data.writeString(this.randomSeed);
		battleUserArray.encode(data);
		battleGeneralArray.encode(data);
		battleUnitIDArray.encode(data);
		itemIdArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleId = data.getInt();
		this.battleFieldId = data.getInt();
		this.mapId = data.getInt();
		this.battleTemplateId = data.getInt();
		this.randomSeed = data.getString();
		battleUserArray = BattleUserArray.create();
		battleUserArray.decode(data);
		battleGeneralArray = BattleGeneralArray.create();
		battleGeneralArray.decode(data);
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
		if (!battleFieldIdHandler.validate(battleFieldId)) {
			return false;
		}
		if (!mapIdHandler.validate(mapId)) {
			return false;
		}
		if (!battleTemplateIdHandler.validate(battleTemplateId)) {
			return false;
		}
		if (!battleUserArray.validate()) {
			return false;
		}
		if (!battleGeneralArray.validate()) {
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
		bb.append("battleFieldId:").append(this.battleFieldId).append(", ");
		bb.append("mapId:").append(this.mapId).append(", ");
		bb.append("battleTemplateId:").append(this.battleTemplateId).append(", ");
		bb.append("randomSeed:").append(this.randomSeed).append(", ");
		bb.append("battleUserArray:").append(battleUserArray.toString()).append(", ");
		bb.append("battleGeneralArray:").append(battleGeneralArray.toString()).append(", ");
		bb.append("battleUnitIDArray:").append(battleUnitIDArray.toString()).append(", ");
		bb.append("itemIdArray:").append(itemIdArray.toString());
		return bb.toString();	
	}
}