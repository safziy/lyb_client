package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 玩家移动目标位置
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_16 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 16;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 16);

	private long battleUnitID;
	private int coordinateX;
	private int coordinateY;
	private int targetCoordinateX;
	private int targetCoordinateY;
	private int booleanValue;

	private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
	private static IntMessageParameterHandler coordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CoordinateX");
	private static IntMessageParameterHandler coordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CoordinateY");
	private static IntMessageParameterHandler targetCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateX");
	private static IntMessageParameterHandler targetCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateY");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1007_16 create() {
		return new Message_1007_16();
	}

	/**
	 * @return the battleUnitID
	 */
	public long getBattleUnitID() {
		return battleUnitID;
	}

	/**
	 * @param battleUnitID
	 *            the battleUnitID to set
	 */
	public void setBattleUnitID(long battleUnitID) {
		this.battleUnitID = battleUnitID;
	}

	/**
	 * @return the coordinateX
	 */
	public int getCoordinateX() {
		return coordinateX;
	}

	/**
	 * @param coordinateX
	 *            the coordinateX to set
	 */
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	/**
	 * @return the coordinateY
	 */
	public int getCoordinateY() {
		return coordinateY;
	}

	/**
	 * @param coordinateY
	 *            the coordinateY to set
	 */
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}

	/**
	 * @return the targetCoordinateX
	 */
	public int getTargetCoordinateX() {
		return targetCoordinateX;
	}

	/**
	 * @param targetCoordinateX
	 *            the targetCoordinateX to set
	 */
	public void setTargetCoordinateX(int targetCoordinateX) {
		this.targetCoordinateX = targetCoordinateX;
	}

	/**
	 * @return the targetCoordinateY
	 */
	public int getTargetCoordinateY() {
		return targetCoordinateY;
	}

	/**
	 * @param targetCoordinateY
	 *            the targetCoordinateY to set
	 */
	public void setTargetCoordinateY(int targetCoordinateY) {
		this.targetCoordinateY = targetCoordinateY;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.battleUnitID);
		data.writeInt(this.coordinateX);
		data.writeInt(this.coordinateY);
		data.writeInt(this.targetCoordinateX);
		data.writeInt(this.targetCoordinateY);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleUnitID = data.getLong();
		this.coordinateX = data.getInt();
		this.coordinateY = data.getInt();
		this.targetCoordinateX = data.getInt();
		this.targetCoordinateY = data.getInt();
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!battleUnitIDHandler.validate(battleUnitID)) {
			return false;
		}
		if (!coordinateXHandler.validate(coordinateX)) {
			return false;
		}
		if (!coordinateYHandler.validate(coordinateY)) {
			return false;
		}
		if (!targetCoordinateXHandler.validate(targetCoordinateX)) {
			return false;
		}
		if (!targetCoordinateYHandler.validate(targetCoordinateY)) {
			return false;
		}
		if (!booleanValueHandler.validate(booleanValue)) {
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
		bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
		bb.append("coordinateX:").append(this.coordinateX).append(", ");
		bb.append("coordinateY:").append(this.coordinateY).append(", ");
		bb.append("targetCoordinateX:").append(this.targetCoordinateX).append(", ");
		bb.append("targetCoordinateY:").append(this.targetCoordinateY).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}