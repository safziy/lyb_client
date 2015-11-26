package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 兵书数据
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1006_25 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 25;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 25);

	private long generalId;
	private long iD;
	private int level;
	private int strengthenLevel;

	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
	private static IntMessageParameterHandler strengthenLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrengthenLevel");

	public static Message_1006_25 create() {
		return new Message_1006_25();
	}

	/**
	 * @return the generalId
	 */
	public long getGeneralId() {
		return generalId;
	}

	/**
	 * @param generalId
	 *            the generalId to set
	 */
	public void setGeneralId(long generalId) {
		this.generalId = generalId;
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
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the strengthenLevel
	 */
	public int getStrengthenLevel() {
		return strengthenLevel;
	}

	/**
	 * @param strengthenLevel
	 *            the strengthenLevel to set
	 */
	public void setStrengthenLevel(int strengthenLevel) {
		this.strengthenLevel = strengthenLevel;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.generalId);
		data.writeLong(this.iD);
		data.writeInt(this.level);
		data.writeInt(this.strengthenLevel);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalId = data.getLong();
		this.iD = data.getLong();
		this.level = data.getInt();
		this.strengthenLevel = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!generalIdHandler.validate(generalId)) {
			return false;
		}
		if (!iDHandler.validate(iD)) {
			return false;
		}
		if (!levelHandler.validate(level)) {
			return false;
		}
		if (!strengthenLevelHandler.validate(strengthenLevel)) {
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
		bb.append("generalId:").append(this.generalId).append(", ");
		bb.append("iD:").append(this.iD).append(", ");
		bb.append("level:").append(this.level).append(", ");
		bb.append("strengthenLevel:").append(this.strengthenLevel);
		return bb.toString();	
	}
}