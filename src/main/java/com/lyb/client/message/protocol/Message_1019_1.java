package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.CDTimeArray;
import com.lyb.client.message.protocol.segment.GeneralIdArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 打开琅琊试炼
 *
 * @author codeGenerator
 * 
 */
public class Message_1019_1 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 1);

	private CDTimeArray cDTimeArray;
	private GeneralIdArray generalIdArray;


	public static Message_1019_1 create() {
		return new Message_1019_1();
	}

	/**
	 * @return the cDTimeArray
	 */
	public CDTimeArray getCDTimeArray() {
		return cDTimeArray;
	}

	/**
	 * @param cDTimeArray
	 *            the cDTimeArray to set
	 */
	public void setCDTimeArray(CDTimeArray cDTimeArray) {
		this.cDTimeArray = cDTimeArray;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		cDTimeArray.encode(data);
		generalIdArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		cDTimeArray = CDTimeArray.create();
		cDTimeArray.decode(data);
		generalIdArray = GeneralIdArray.create();
		generalIdArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!cDTimeArray.validate()) {
			return false;
		}
		if (!generalIdArray.validate()) {
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
		bb.append("cDTimeArray:").append(cDTimeArray.toString()).append(", ");
		bb.append("generalIdArray:").append(generalIdArray.toString());
		return bb.toString();	
	}
}