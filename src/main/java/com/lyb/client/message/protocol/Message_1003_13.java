package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.RankGeneralArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  查看玩家英雄库
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_13 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 13;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 13);

	private RankGeneralArray rankGeneralArray;


	public static Message_1003_13 create() {
		return new Message_1003_13();
	}

	/**
	 * @return the rankGeneralArray
	 */
	public RankGeneralArray getRankGeneralArray() {
		return rankGeneralArray;
	}

	/**
	 * @param rankGeneralArray
	 *            the rankGeneralArray to set
	 */
	public void setRankGeneralArray(RankGeneralArray rankGeneralArray) {
		this.rankGeneralArray = rankGeneralArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		rankGeneralArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		rankGeneralArray = RankGeneralArray.create();
		rankGeneralArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!rankGeneralArray.validate()) {
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
		bb.append("rankGeneralArray:").append(rankGeneralArray.toString());
		return bb.toString();	
	}
}