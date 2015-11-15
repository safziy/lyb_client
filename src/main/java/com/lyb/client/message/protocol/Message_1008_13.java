package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  事件更新
 *
 * @author codeGenerator
 * 
 */
public class Message_1008_13 implements IMessage {

	private static int MAIN = 1008;
	private static int SUB = 13;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1008, 13);

	private int place;
	private long iD;
	private int param;
	private int booleanValue;

	private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
	private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
	private static IntMessageParameterHandler paramHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

	public static Message_1008_13 create() {
		return new Message_1008_13();
	}

	/**
	 * @return the place
	 */
	public int getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(int place) {
		this.place = place;
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
	 * @return the param
	 */
	public int getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(int param) {
		this.param = param;
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
		data.writeInt(this.place);
		data.writeLong(this.iD);
		data.writeInt(this.param);
		data.writeInt(this.booleanValue);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.place = data.getInt();
		this.iD = data.getLong();
		this.param = data.getInt();
		this.booleanValue = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!placeHandler.validate(place)) {
			return false;
		}
		if (!iDHandler.validate(iD)) {
			return false;
		}
		if (!paramHandler.validate(param)) {
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
		bb.append("place:").append(this.place).append(", ");
		bb.append("iD:").append(this.iD).append(", ");
		bb.append("param:").append(this.param).append(", ");
		bb.append("booleanValue:").append(this.booleanValue);
		return bb.toString();	
	}
}