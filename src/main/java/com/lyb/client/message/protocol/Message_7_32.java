package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.BattleFieldAttackRecordArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  战场验证
 *
 * @author codeGenerator
 * 
 */
public class Message_7_32 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 32;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 32);

	private int battleId;
	private int standPoint;
	private int count;
	private int count2;
	private BattleFieldAttackRecordArray battleFieldAttackRecordArray;
	private int starLevel;

	private static IntMessageParameterHandler battleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleId");
	private static IntMessageParameterHandler standPointHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StandPoint");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
	private static IntMessageParameterHandler count2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count2");
	private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");

	public static Message_7_32 create() {
		return new Message_7_32();
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
	 * @return the standPoint
	 */
	public int getStandPoint() {
		return standPoint;
	}

	/**
	 * @param standPoint
	 *            the standPoint to set
	 */
	public void setStandPoint(int standPoint) {
		this.standPoint = standPoint;
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
	 * @return the count2
	 */
	public int getCount2() {
		return count2;
	}

	/**
	 * @param count2
	 *            the count2 to set
	 */
	public void setCount2(int count2) {
		this.count2 = count2;
	}

	/**
	 * @return the battleFieldAttackRecordArray
	 */
	public BattleFieldAttackRecordArray getBattleFieldAttackRecordArray() {
		return battleFieldAttackRecordArray;
	}

	/**
	 * @param battleFieldAttackRecordArray
	 *            the battleFieldAttackRecordArray to set
	 */
	public void setBattleFieldAttackRecordArray(BattleFieldAttackRecordArray battleFieldAttackRecordArray) {
		this.battleFieldAttackRecordArray = battleFieldAttackRecordArray;
	}

	/**
	 * @return the starLevel
	 */
	public int getStarLevel() {
		return starLevel;
	}

	/**
	 * @param starLevel
	 *            the starLevel to set
	 */
	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.battleId);
		data.writeInt(this.standPoint);
		data.writeInt(this.count);
		data.writeInt(this.count2);
		battleFieldAttackRecordArray.encode(data);
		data.writeInt(this.starLevel);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleId = data.getInt();
		this.standPoint = data.getInt();
		this.count = data.getInt();
		this.count2 = data.getInt();
		battleFieldAttackRecordArray = BattleFieldAttackRecordArray.create();
		battleFieldAttackRecordArray.decode(data);
		this.starLevel = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!battleIdHandler.validate(battleId)) {
			return false;
		}
		if (!standPointHandler.validate(standPoint)) {
			return false;
		}
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!count2Handler.validate(count2)) {
			return false;
		}
		if (!battleFieldAttackRecordArray.validate()) {
			return false;
		}
		if (!starLevelHandler.validate(starLevel)) {
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
		bb.append("standPoint:").append(this.standPoint).append(", ");
		bb.append("count:").append(this.count).append(", ");
		bb.append("count2:").append(this.count2).append(", ");
		bb.append("battleFieldAttackRecordArray:").append(battleFieldAttackRecordArray.toString()).append(", ");
		bb.append("starLevel:").append(this.starLevel);
		return bb.toString();	
	}
}