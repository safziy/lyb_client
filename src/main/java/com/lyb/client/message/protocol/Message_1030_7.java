package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 查看地牢战队
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1030_7 implements IMessage {

	private static int MAIN = 1030;
	private static int SUB = 7;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1030, 7);

	private int formationId;
	private PlaceIDArray placeIDArray;
	private int zhanli;

	private static IntMessageParameterHandler formationIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FormationId");
	private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");

	public static Message_1030_7 create() {
		return new Message_1030_7();
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
		data.writeInt(this.formationId);
		placeIDArray.encode(data);
		data.writeInt(this.zhanli);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.formationId = data.getInt();
		placeIDArray = PlaceIDArray.create();
		placeIDArray.decode(data);
		this.zhanli = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!formationIdHandler.validate(formationId)) {
			return false;
		}
		if (!placeIDArray.validate()) {
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
		bb.append("formationId:").append(this.formationId).append(", ");
		bb.append("placeIDArray:").append(placeIDArray.toString()).append(", ");
		bb.append("zhanli:").append(this.zhanli);
		return bb.toString();	
	}
}