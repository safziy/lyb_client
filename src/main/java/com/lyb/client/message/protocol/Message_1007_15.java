package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 玩家当前位置
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_15 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 15;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 15);

	private long battleUnitID;
	private int coordinateX;
	private int coordinateY;

	private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
	private static IntMessageParameterHandler coordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CoordinateX");
	private static IntMessageParameterHandler coordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CoordinateY");

	public static Message_1007_15 create() {
		return new Message_1007_15();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.battleUnitID);
		data.writeInt(this.coordinateX);
		data.writeInt(this.coordinateY);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleUnitID = data.getLong();
		this.coordinateX = data.getInt();
		this.coordinateY = data.getInt();
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
		bb.append("coordinateY:").append(this.coordinateY);
		return bb.toString();	
	}
}