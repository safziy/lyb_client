package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求 装备洗练
 *
 * @author codeGenerator
 * 
 */
public class Message_10_4 implements IMessage {

	private static int MAIN = 10;
	private static int SUB = 4;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(10, 4);

	private long generalId;
	private int itemId;
	private IDArray iDArray;

	private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
	private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");

	public static Message_10_4 create() {
		return new Message_10_4();
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
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
		data.writeLong(this.generalId);
		data.writeInt(this.itemId);
		iDArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.generalId = data.getLong();
		this.itemId = data.getInt();
		iDArray = IDArray.create();
		iDArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!generalIdHandler.validate(generalId)) {
			return false;
		}
		if (!itemIdHandler.validate(itemId)) {
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
		bb.append("generalId:").append(this.generalId).append(", ");
		bb.append("itemId:").append(this.itemId).append(", ");
		bb.append("iDArray:").append(iDArray.toString());
		return bb.toString();	
	}
}