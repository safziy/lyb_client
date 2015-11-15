package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  走路
 *
 * @author codeGenerator
 * 
 */
public class Message_7_36 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 36;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 36);

	private int targetCoordinateX;
	private int targetCoordinateY;

	private static IntMessageParameterHandler targetCoordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateX");
	private static IntMessageParameterHandler targetCoordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TargetCoordinateY");

	public static Message_7_36 create() {
		return new Message_7_36();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.targetCoordinateX);
		data.writeInt(this.targetCoordinateY);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.targetCoordinateX = data.getInt();
		this.targetCoordinateY = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!targetCoordinateXHandler.validate(targetCoordinateX)) {
			return false;
		}
		if (!targetCoordinateYHandler.validate(targetCoordinateY)) {
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
		bb.append("targetCoordinateX:").append(this.targetCoordinateX).append(", ");
		bb.append("targetCoordinateY:").append(this.targetCoordinateY);
		return bb.toString();	
	}
}