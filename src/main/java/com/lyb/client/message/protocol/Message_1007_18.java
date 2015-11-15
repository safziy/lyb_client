package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.UnitPropertyArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 战斗单位属性变化同步
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_18 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 18;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 18);

	private UnitPropertyArray unitPropertyArray;


	public static Message_1007_18 create() {
		return new Message_1007_18();
	}

	/**
	 * @return the unitPropertyArray
	 */
	public UnitPropertyArray getUnitPropertyArray() {
		return unitPropertyArray;
	}

	/**
	 * @param unitPropertyArray
	 *            the unitPropertyArray to set
	 */
	public void setUnitPropertyArray(UnitPropertyArray unitPropertyArray) {
		this.unitPropertyArray = unitPropertyArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		unitPropertyArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		unitPropertyArray = UnitPropertyArray.create();
		unitPropertyArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!unitPropertyArray.validate()) {
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
		bb.append("unitPropertyArray:").append(unitPropertyArray.toString());
		return bb.toString();	
	}
}