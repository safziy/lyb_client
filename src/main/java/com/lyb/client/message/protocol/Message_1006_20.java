package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.FormationArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 阵法信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1006_20 implements IMessage {

	private static int MAIN = 1006;
	private static int SUB = 20;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1006, 20);

	private FormationArray formationArray;


	public static Message_1006_20 create() {
		return new Message_1006_20();
	}

	/**
	 * @return the formationArray
	 */
	public FormationArray getFormationArray() {
		return formationArray;
	}

	/**
	 * @param formationArray
	 *            the formationArray to set
	 */
	public void setFormationArray(FormationArray formationArray) {
		this.formationArray = formationArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		formationArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		formationArray = FormationArray.create();
		formationArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!formationArray.validate()) {
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
		bb.append("formationArray:").append(formationArray.toString());
		return bb.toString();	
	}
}