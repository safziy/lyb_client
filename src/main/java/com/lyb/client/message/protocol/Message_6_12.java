package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.GeneralIdArray;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 出战配置
 *
 * @author codeGenerator
 * 
 */
public class Message_6_12 implements IMessage {

	private static int MAIN = 6;
	private static int SUB = 12;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(6, 12);

	private GeneralIdArray generalIdArray;
	private int type;
	private long generalId;
	private int place;
	private int formationId;
	private IDArray iDArray;

	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
	private static IntMessageParameterHandler formationIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FormationId");

	public static Message_6_12 create() {
		return new Message_6_12();
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
		generalIdArray.encode(data);
		data.writeInt(this.type);
		data.writeLong(this.generalId);
		data.writeInt(this.place);
		data.writeInt(this.formationId);
		iDArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		generalIdArray = GeneralIdArray.create();
		generalIdArray.decode(data);
		this.type = data.getInt();
		this.generalId = data.getLong();
		this.place = data.getInt();
		this.formationId = data.getInt();
		iDArray = IDArray.create();
		iDArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!generalIdArray.validate()) {
			return false;
		}
		if (!typeHandler.validate(type)) {
			return false;
		}
		if (!generalIdHandler.validate(generalId)) {
			return false;
		}
		if (!placeHandler.validate(place)) {
			return false;
		}
		if (!formationIdHandler.validate(formationId)) {
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
		bb.append("generalIdArray:").append(generalIdArray.toString()).append(", ");
		bb.append("type:").append(this.type).append(", ");
		bb.append("generalId:").append(this.generalId).append(", ");
		bb.append("place:").append(this.place).append(", ");
		bb.append("formationId:").append(this.formationId).append(", ");
		bb.append("iDArray:").append(iDArray.toString());
		return bb.toString();	
	}
}