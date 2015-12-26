package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回  比武大会英雄信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1016_6 implements IMessage {

	private static int MAIN = 1016;
	private static int SUB = 6;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1016, 6);

	private long userId;
	private int formationId;
	private PlaceIDArray2 placeIDArray2;
	private int zhanli;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler formationIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FormationId");
	private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");

	public static Message_1016_6 create() {
		return new Message_1016_6();
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the formationId
	 */
	public int getFormationId() {
		return formationId;
	}

	/**
	 * @param formationId
	 *            the formationId to set
	 */
	public void setFormationId(int formationId) {
		this.formationId = formationId;
	}

	/**
	 * @return the placeIDArray2
	 */
	public PlaceIDArray2 getPlaceIDArray2() {
		return placeIDArray2;
	}

	/**
	 * @param placeIDArray2
	 *            the placeIDArray2 to set
	 */
	public void setPlaceIDArray2(PlaceIDArray2 placeIDArray2) {
		this.placeIDArray2 = placeIDArray2;
	}

	/**
	 * @return the zhanli
	 */
	public int getZhanli() {
		return zhanli;
	}

	/**
	 * @param zhanli
	 *            the zhanli to set
	 */
	public void setZhanli(int zhanli) {
		this.zhanli = zhanli;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
		data.writeInt(this.formationId);
		placeIDArray2.encode(data);
		data.writeInt(this.zhanli);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
		this.formationId = data.getInt();
		placeIDArray2 = PlaceIDArray2.create();
		placeIDArray2.decode(data);
		this.zhanli = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!formationIdHandler.validate(formationId)) {
			return false;
		}
		if (!placeIDArray2.validate()) {
			return false;
		}
		if (!zhanliHandler.validate(zhanli)) {
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
		bb.append("userId:").append(this.userId).append(", ");
		bb.append("formationId:").append(this.formationId).append(", ");
		bb.append("placeIDArray2:").append(placeIDArray2.toString()).append(", ");
		bb.append("zhanli:").append(this.zhanli);
		return bb.toString();	
	}
}