package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 打开温酒界面
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_31 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 31;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 31);

	private long iD;
	private int remainSeconds;
	private int physicalPower;
	private int booleanValue;

	private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
	private static IntMessageParameterHandler remainSecondsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSeconds");
	private static IntMessageParameterHandler physicalPowerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PhysicalPower");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1027_31 create() {
		return new Message_1027_31();
	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return iD;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(long iD) {
		this.iD = iD;
	}

	/**
	 * @return the remainSeconds
	 */
	public int getRemainSeconds() {
		return remainSeconds;
	}

	/**
	 * @param remainSeconds
	 *            the remainSeconds to set
	 */
	public void setRemainSeconds(int remainSeconds) {
		this.remainSeconds = remainSeconds;
	}

	/**
	 * @return the physicalPower
	 */
	public int getPhysicalPower() {
		return physicalPower;
	}

	/**
	 * @param physicalPower
	 *            the physicalPower to set
	 */
	public void setPhysicalPower(int physicalPower) {
		this.physicalPower = physicalPower;
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
		data.writeLong(this.iD);
		data.writeInt(this.remainSeconds);
		data.writeInt(this.physicalPower);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.iD = data.getLong();
		this.remainSeconds = data.getInt();
		this.physicalPower = data.getInt();
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!iDHandler.validate(iD)) {
			return false;
		}
		if (!remainSecondsHandler.validate(remainSeconds)) {
			return false;
		}
		if (!physicalPowerHandler.validate(physicalPower)) {
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
		bb.append("iD:").append(this.iD).append(", ");
		bb.append("remainSeconds:").append(this.remainSeconds).append(", ");
		bb.append("physicalPower:").append(this.physicalPower).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}