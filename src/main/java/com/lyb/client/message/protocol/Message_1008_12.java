package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  状态更新
 *
 * @author codeGenerator
 * 
 */
public class Message_1008_12 implements IMessage {

	private static int MAIN = 1008;
	private static int SUB = 12;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1008, 12);

	private int place;
	private int state;

	private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
	private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

	public static Message_1008_12 create() {
		return new Message_1008_12();
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
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.place);
		data.writeInt(this.state);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.place = data.getInt();
		this.state = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!placeHandler.validate(place)) {
			return false;
		}
		if (!stateHandler.validate(state)) {
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
		bb.append("state:").append(this.state);
		return bb.toString();	
	}
}