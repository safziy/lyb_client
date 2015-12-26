package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 掉落福袋
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1027_56 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 56;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 56);

	private IDParamArray iDParamArray;


	public static Message_1027_56 create() {
		return new Message_1027_56();
	}

	/**
	 * @return the iDParamArray
	 */
	public IDParamArray getIDParamArray() {
		return iDParamArray;
	}

	/**
	 * @param iDParamArray
	 *            the iDParamArray to set
	 */
	public void setIDParamArray(IDParamArray iDParamArray) {
		this.iDParamArray = iDParamArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		iDParamArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		iDParamArray = IDParamArray.create();
		iDParamArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!iDParamArray.validate()) {
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
		bb.append("iDParamArray:").append(iDParamArray.toString());
		return bb.toString();	
	}
}