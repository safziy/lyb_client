package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.EmployArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 帮派佣兵池
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_38 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 38;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 38);

	private EmployArray employArray;


	public static Message_1027_38 create() {
		return new Message_1027_38();
	}

	/**
	 * @return the employArray
	 */
	public EmployArray getEmployArray() {
		return employArray;
	}

	/**
	 * @param employArray
	 *            the employArray to set
	 */
	public void setEmployArray(EmployArray employArray) {
		this.employArray = employArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		employArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		employArray = EmployArray.create();
		employArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!employArray.validate()) {
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
		bb.append("employArray:").append(employArray.toString());
		return bb.toString();	
	}
}