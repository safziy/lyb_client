package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.EquipmentInfoArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 装备信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1010_1 implements IMessage {

	private static int MAIN = 1010;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1010, 1);

	private EquipmentInfoArray equipmentInfoArray;


	public static Message_1010_1 create() {
		return new Message_1010_1();
	}

	/**
	 * @return the equipmentInfoArray
	 */
	public EquipmentInfoArray getEquipmentInfoArray() {
		return equipmentInfoArray;
	}

	/**
	 * @param equipmentInfoArray
	 *            the equipmentInfoArray to set
	 */
	public void setEquipmentInfoArray(EquipmentInfoArray equipmentInfoArray) {
		this.equipmentInfoArray = equipmentInfoArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		equipmentInfoArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		equipmentInfoArray = EquipmentInfoArray.create();
		equipmentInfoArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!equipmentInfoArray.validate()) {
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
		bb.append("equipmentInfoArray:").append(equipmentInfoArray.toString());
		return bb.toString();	
	}
}