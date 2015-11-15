package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 积分奖励
 *
 * @author codeGenerator
 * 
 */
public class Message_1030_6 implements IMessage {

	private static int MAIN = 1030;
	private static int SUB = 6;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1030, 6);

	private IDArray iDArray;
	private int remainSeconds;

	private static IntMessageParameterHandler remainSecondsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSeconds");

	public static Message_1030_6 create() {
		return new Message_1030_6();
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		iDArray.encode(data);
		data.writeInt(this.remainSeconds);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		iDArray = IDArray.create();
		iDArray.decode(data);
		this.remainSeconds = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!iDArray.validate()) {
			return false;
		}
		if (!remainSecondsHandler.validate(remainSeconds)) {
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
		bb.append("iDArray:").append(iDArray.toString()).append(", ");
		bb.append("remainSeconds:").append(this.remainSeconds);
		return bb.toString();	
	}
}