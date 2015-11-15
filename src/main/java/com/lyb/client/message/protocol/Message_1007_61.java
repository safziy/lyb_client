package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  打开五行战斗界面
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_61 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 61;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 61);

	private IDArray iDArray;


	public static Message_1007_61 create() {
		return new Message_1007_61();
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
		iDArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		iDArray = IDArray.create();
		iDArray.decode(data);
	}

	@Override
	public boolean validate() {
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
		bb.append("iDArray:").append(iDArray.toString());
		return bb.toString();	
	}
}