package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.ChancellorArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 打开朝堂界面
 *
 * @author codeGenerator
 * 
 */
public class Message_1019_19 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 19;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 19);

	private int state;
	private ChancellorArray chancellorArray;

	private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

	public static Message_1019_19 create() {
		return new Message_1019_19();
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
	 * @return the chancellorArray
	 */
	public ChancellorArray getChancellorArray() {
		return chancellorArray;
	}

	/**
	 * @param chancellorArray
	 *            the chancellorArray to set
	 */
	public void setChancellorArray(ChancellorArray chancellorArray) {
		this.chancellorArray = chancellorArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.state);
		chancellorArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.state = data.getInt();
		chancellorArray = ChancellorArray.create();
		chancellorArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!stateHandler.validate(state)) {
			return false;
		}
		if (!chancellorArray.validate()) {
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
		bb.append("state:").append(this.state).append(", ");
		bb.append("chancellorArray:").append(chancellorArray.toString());
		return bb.toString();	
	}
}