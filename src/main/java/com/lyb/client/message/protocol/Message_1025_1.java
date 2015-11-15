package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.RankArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 查看排行榜
 *
 * @author codeGenerator
 * 
 */
public class Message_1025_1 implements IMessage {

	private static int MAIN = 1025;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1025, 1);

	private int type;
	private RankArray rankArray;

	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");

	public static Message_1025_1 create() {
		return new Message_1025_1();
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the rankArray
	 */
	public RankArray getRankArray() {
		return rankArray;
	}

	/**
	 * @param rankArray
	 *            the rankArray to set
	 */
	public void setRankArray(RankArray rankArray) {
		this.rankArray = rankArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.type);
		rankArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.type = data.getInt();
		rankArray = RankArray.create();
		rankArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!typeHandler.validate(type)) {
			return false;
		}
		if (!rankArray.validate()) {
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
		bb.append("type:").append(this.type).append(", ");
		bb.append("rankArray:").append(rankArray.toString());
		return bb.toString();	
	}
}