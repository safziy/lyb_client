package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.GeneralIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 查看战队
 *
 * @author codeGenerator
 * 
 */
public class Message_1006_13 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 13;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 13);

	private int type;
	private GeneralIdArray generalIdArray;
	private int formationId;
	private long generalId;
	private int place;

	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
	private static IntMessageParameterHandler formationIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FormationId");
	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");

	public static Message_1006_13 create() {
		return new Message_1006_13();
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the generalIdArray
	 */
	public GeneralIdArray getGeneralIdArray() {
		return generalIdArray;
	}

	/**
	 * @param generalIdArray
	 *            the generalIdArray to set
	 */
	public void setGeneralIdArray(GeneralIdArray generalIdArray) {
		this.generalIdArray = generalIdArray;
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
	 * @return the place
	 */
	public int getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(int place) {
		this.place = place;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.type);
		generalIdArray.encode(data);
		data.writeInt(this.formationId);
		data.writeLong(this.generalId);
		data.writeInt(this.place);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.type = data.getInt();
		generalIdArray = GeneralIdArray.create();
		generalIdArray.decode(data);
		this.formationId = data.getInt();
		this.generalId = data.getLong();
		this.place = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!typeHandler.validate(type)) {
			return false;
		}
		if (!generalIdArray.validate()) {
			return false;
		}
		if (!formationIdHandler.validate(formationId)) {
			return false;
		}
		if (!generalIdHandler.validate(generalId)) {
			return false;
		}
		if (!placeHandler.validate(place)) {
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
		bb.append("type:").append(this.type).append(", ");
		bb.append("generalIdArray:").append(generalIdArray.toString()).append(", ");
		bb.append("formationId:").append(this.formationId).append(", ");
		bb.append("generalId:").append(this.generalId).append(", ");
		bb.append("place:").append(this.place);
		return bb.toString();	
	}
}