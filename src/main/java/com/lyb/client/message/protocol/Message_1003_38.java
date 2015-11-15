package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.message.protocol.segment.RoomMemberArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 断线重连进入副本
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_38 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 38;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 38);

	private int booleanValue;
	private int configId;
	private RoomMemberArray roomMemberArray;
	private IDArray iDArray;

	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
	private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");

	public static Message_1003_38 create() {
		return new Message_1003_38();
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
	 * @return the configId
	 */
	public int getConfigId() {
		return configId;
	}

	/**
	 * @param configId
	 *            the configId to set
	 */
	public void setConfigId(int configId) {
		this.configId = configId;
	}

	/**
	 * @return the roomMemberArray
	 */
	public RoomMemberArray getRoomMemberArray() {
		return roomMemberArray;
	}

	/**
	 * @param roomMemberArray
	 *            the roomMemberArray to set
	 */
	public void setRoomMemberArray(RoomMemberArray roomMemberArray) {
		this.roomMemberArray = roomMemberArray;
	}

	/**
	 * @return the iDArray
	 */
	public IDArray getIDArray() {
		return iDArray;
	}

	/**
	 * @param iDArray
	 *            the iDArray to set
	 */
	public void setIDArray(IDArray iDArray) {
		this.iDArray = iDArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.booleanValue);
		data.writeInt(this.configId);
		roomMemberArray.encode(data);
		iDArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.booleanValue = data.getInt();
		this.configId = data.getInt();
		roomMemberArray = RoomMemberArray.create();
		roomMemberArray.decode(data);
		iDArray = IDArray.create();
		iDArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!booleanValueHandler.validate(booleanValue)) {
			return false;
		}
		if (!configIdHandler.validate(configId)) {
			return false;
		}
		if (!roomMemberArray.validate()) {
			return false;
		}
		if (!iDArray.validate()) {
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
		bb.append("configId:").append(this.configId).append(", ");
		bb.append("roomMemberArray:").append(roomMemberArray.toString()).append(", ");
		bb.append("iDArray:").append(iDArray.toString());
		return bb.toString();	
	}
}