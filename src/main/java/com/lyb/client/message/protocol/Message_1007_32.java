package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.IndexArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  战场验证
 *
 * @author codeGenerator
 * 
 */
public class Message_1007_32 implements IMessage {

	private static int MAIN = 1007;
	private static int SUB = 32;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1007, 32);

	private IndexArray indexArray;


	public static Message_1007_32 create() {
		return new Message_1007_32();
	}

	/**
	 * @return the indexArray
	 */
	public IndexArray getIndexArray() {
		return indexArray;
	}

	/**
	 * @param indexArray
	 *            the indexArray to set
	 */
	public void setIndexArray(IndexArray indexArray) {
		this.indexArray = indexArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		indexArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		indexArray = IndexArray.create();
		indexArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!indexArray.validate()) {
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
		bb.append("indexArray:").append(indexArray.toString());
		return bb.toString();	
	}
}