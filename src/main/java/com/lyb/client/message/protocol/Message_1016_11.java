package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.PlaceIDArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 新战队
 *
 * @author codeGenerator
 * 
 */
public class Message_1016_11 implements IMessage {

	private static int MAIN = 1016;
	private static int SUB = 11;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1016, 11);

	private long userId;
	private PlaceIDArray placeIDArray;
	private int formationId;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler formationIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FormationId");

	public static Message_1016_11 create() {
		return new Message_1016_11();
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
	 * @return the placeIDArray
	 */
	public PlaceIDArray getPlaceIDArray() {
		return placeIDArray;
	}

	/**
	 * @param placeIDArray
	 *            the placeIDArray to set
	 */
	public void setPlaceIDArray(PlaceIDArray placeIDArray) {
		this.placeIDArray = placeIDArray;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
		placeIDArray.encode(data);
		data.writeInt(this.formationId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
		placeIDArray = PlaceIDArray.create();
		placeIDArray.decode(data);
		this.formationId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!placeIDArray.validate()) {
			return false;
		}
		if (!formationIdHandler.validate(formationId)) {
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
		bb.append("placeIDArray:").append(placeIDArray.toString()).append(", ");
		bb.append("formationId:").append(this.formationId);
		return bb.toString();	
	}
}