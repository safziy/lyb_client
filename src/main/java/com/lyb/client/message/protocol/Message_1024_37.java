package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.message.protocol.segment.TurnTableArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 转盘结果
 *
 * @author codeGenerator
 * 
 */
public class Message_1024_37 implements IMessage {

	private static int MAIN = 1024;
	private static int SUB = 37;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1024, 37);

	private long iD;
	private TurnTableArray turnTableArray;
	private IDArray iDArray;

	private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");

	public static Message_1024_37 create() {
		return new Message_1024_37();
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
	 * @return the turnTableArray
	 */
	public TurnTableArray getTurnTableArray() {
		return turnTableArray;
	}

	/**
	 * @param turnTableArray
	 *            the turnTableArray to set
	 */
	public void setTurnTableArray(TurnTableArray turnTableArray) {
		this.turnTableArray = turnTableArray;
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
		data.writeLong(this.iD);
		turnTableArray.encode(data);
		iDArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.iD = data.getLong();
		turnTableArray = TurnTableArray.create();
		turnTableArray.decode(data);
		iDArray = IDArray.create();
		iDArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!iDHandler.validate(iD)) {
			return false;
		}
		if (!turnTableArray.validate()) {
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
		bb.append("iD:").append(this.iD).append(", ");
		bb.append("turnTableArray:").append(turnTableArray.toString()).append(", ");
		bb.append("iDArray:").append(iDArray.toString());
		return bb.toString();	
	}
}