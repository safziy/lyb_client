package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.GeneralStateArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 打开十国征战
 *
 * @author codeGenerator
 * 
 */
public class Message_1019_3 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 3);

	private long iD;
	private int state;
	private GeneralStateArray generalStateArray;

	private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
	private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

	public static Message_1019_3 create() {
		return new Message_1019_3();
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
	 * @return the generalStateArray
	 */
	public GeneralStateArray getGeneralStateArray() {
		return generalStateArray;
	}

	/**
	 * @param generalStateArray
	 *            the generalStateArray to set
	 */
	public void setGeneralStateArray(GeneralStateArray generalStateArray) {
		this.generalStateArray = generalStateArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.iD);
		data.writeInt(this.state);
		generalStateArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.iD = data.getLong();
		this.state = data.getInt();
		generalStateArray = GeneralStateArray.create();
		generalStateArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!iDHandler.validate(iD)) {
			return false;
		}
		if (!stateHandler.validate(state)) {
			return false;
		}
		if (!generalStateArray.validate()) {
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
		bb.append("state:").append(this.state).append(", ");
		bb.append("generalStateArray:").append(generalStateArray.toString());
		return bb.toString();	
	}
}