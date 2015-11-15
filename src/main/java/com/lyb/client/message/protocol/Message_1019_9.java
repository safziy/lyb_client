package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.IDParamArray;
import com.lyb.client.message.protocol.segment.IDStateParamArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 打开朝堂议事
 *
 * @author codeGenerator
 * 
 */
public class Message_1019_9 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 9;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 9);

	private int state;
	private IDParamArray iDParamArray;
	private IDStateParamArray iDStateParamArray;

	private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

	public static Message_1019_9 create() {
		return new Message_1019_9();
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
	 * @return the iDParamArray
	 */
	public IDParamArray getIDParamArray() {
		return iDParamArray;
	}

	/**
	 * @param iDParamArray
	 *            the iDParamArray to set
	 */
	public void setIDParamArray(IDParamArray iDParamArray) {
		this.iDParamArray = iDParamArray;
	}

	/**
	 * @return the iDStateParamArray
	 */
	public IDStateParamArray getIDStateParamArray() {
		return iDStateParamArray;
	}

	/**
	 * @param iDStateParamArray
	 *            the iDStateParamArray to set
	 */
	public void setIDStateParamArray(IDStateParamArray iDStateParamArray) {
		this.iDStateParamArray = iDStateParamArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.state);
		iDParamArray.encode(data);
		iDStateParamArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.state = data.getInt();
		iDParamArray = IDParamArray.create();
		iDParamArray.decode(data);
		iDStateParamArray = IDStateParamArray.create();
		iDStateParamArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!stateHandler.validate(state)) {
			return false;
		}
		if (!iDParamArray.validate()) {
			return false;
		}
		if (!iDStateParamArray.validate()) {
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
		bb.append("iDParamArray:").append(iDParamArray.toString()).append(", ");
		bb.append("iDStateParamArray:").append(iDStateParamArray.toString());
		return bb.toString();	
	}
}