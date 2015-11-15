package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.GeneralStateArray;
import com.lyb.client.message.protocol.segment.TargetStateArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  回传战场结果数据
 *
 * @author codeGenerator
 * 
 */
public class Message_7_59 implements IMessage {

	private static int MAIN = 7;
	private static int SUB = 59;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(7, 59);

	private int battleId;
	private GeneralStateArray generalStateArray;
	private TargetStateArray targetStateArray;

	private static IntMessageParameterHandler battleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleId");

	public static Message_7_59 create() {
		return new Message_7_59();
	}

	/**
	 * @return the battleId
	 */
	public int getBattleId() {
		return battleId;
	}

	/**
	 * @param battleId
	 *            the battleId to set
	 */
	public void setBattleId(int battleId) {
		this.battleId = battleId;
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
	 * @return the targetStateArray
	 */
	public TargetStateArray getTargetStateArray() {
		return targetStateArray;
	}

	/**
	 * @param targetStateArray
	 *            the targetStateArray to set
	 */
	public void setTargetStateArray(TargetStateArray targetStateArray) {
		this.targetStateArray = targetStateArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.battleId);
		generalStateArray.encode(data);
		targetStateArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.battleId = data.getInt();
		generalStateArray = GeneralStateArray.create();
		generalStateArray.decode(data);
		targetStateArray = TargetStateArray.create();
		targetStateArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!battleIdHandler.validate(battleId)) {
			return false;
		}
		if (!generalStateArray.validate()) {
			return false;
		}
		if (!targetStateArray.validate()) {
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
		bb.append("battleId:").append(this.battleId).append(", ");
		bb.append("generalStateArray:").append(generalStateArray.toString()).append(", ");
		bb.append("targetStateArray:").append(targetStateArray.toString());
		return bb.toString();	
	}
}