package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.RoundItemIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  扫荡结果
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_58 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 58;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 58);

	private int strongPointId;
	private RoundItemIdArray roundItemIdArray;

	private static IntMessageParameterHandler strongPointIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrongPointId");

	public static Message_1007_58 create() {
		return new Message_1007_58();
	}

	/**
	 * @return the strongPointId
	 */
	public int getStrongPointId() {
		return strongPointId;
	}

	/**
	 * @param strongPointId
	 *            the strongPointId to set
	 */
	public void setStrongPointId(int strongPointId) {
		this.strongPointId = strongPointId;
	}

	/**
	 * @return the roundItemIdArray
	 */
	public RoundItemIdArray getRoundItemIdArray() {
		return roundItemIdArray;
	}

	/**
	 * @param roundItemIdArray
	 *            the roundItemIdArray to set
	 */
	public void setRoundItemIdArray(RoundItemIdArray roundItemIdArray) {
		this.roundItemIdArray = roundItemIdArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.strongPointId);
		roundItemIdArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.strongPointId = data.getInt();
		roundItemIdArray = RoundItemIdArray.create();
		roundItemIdArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!strongPointIdHandler.validate(strongPointId)) {
			return false;
		}
		if (!roundItemIdArray.validate()) {
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
		bb.append("strongPointId:").append(this.strongPointId).append(", ");
		bb.append("roundItemIdArray:").append(roundItemIdArray.toString());
		return bb.toString();	
	}
}