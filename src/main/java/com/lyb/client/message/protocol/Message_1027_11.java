package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.MemberArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 家族详细信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_11 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 11;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 11);

	private long familyId;
	private String familyName;
	private MemberArray memberArray;
	private int count;
	private int familyLevel;
	private int ranking;
	private int huoyuedu;

	private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
	private static IntMessageParameterHandler familyLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyLevel");
	private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");
	private static IntMessageParameterHandler huoyueduHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Huoyuedu");

	public static Message_1027_11 create() {
		return new Message_1027_11();
	}

	/**
	 * @return the familyId
	 */
	public long getFamilyId() {
		return familyId;
	}

	/**
	 * @param familyId
	 *            the familyId to set
	 */
	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the memberArray
	 */
	public MemberArray getMemberArray() {
		return memberArray;
	}

	/**
	 * @param memberArray
	 *            the memberArray to set
	 */
	public void setMemberArray(MemberArray memberArray) {
		this.memberArray = memberArray;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the familyLevel
	 */
	public int getFamilyLevel() {
		return familyLevel;
	}

	/**
	 * @param familyLevel
	 *            the familyLevel to set
	 */
	public void setFamilyLevel(int familyLevel) {
		this.familyLevel = familyLevel;
	}

	/**
	 * @return the ranking
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * @param ranking
	 *            the ranking to set
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	/**
	 * @return the huoyuedu
	 */
	public int getHuoyuedu() {
		return huoyuedu;
	}

	/**
	 * @param huoyuedu
	 *            the huoyuedu to set
	 */
	public void setHuoyuedu(int huoyuedu) {
		this.huoyuedu = huoyuedu;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.familyId);
		data.writeString(this.familyName);
		memberArray.encode(data);
		data.writeInt(this.count);
		data.writeInt(this.familyLevel);
		data.writeInt(this.ranking);
		data.writeInt(this.huoyuedu);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.familyId = data.getLong();
		this.familyName = data.getString();
		memberArray = MemberArray.create();
		memberArray.decode(data);
		this.count = data.getInt();
		this.familyLevel = data.getInt();
		this.ranking = data.getInt();
		this.huoyuedu = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!familyIdHandler.validate(familyId)) {
			return false;
		}
		if (!memberArray.validate()) {
			return false;
		}
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!familyLevelHandler.validate(familyLevel)) {
			return false;
		}
		if (!rankingHandler.validate(ranking)) {
			return false;
		}
		if (!huoyueduHandler.validate(huoyuedu)) {
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
		bb.append("familyId:").append(this.familyId).append(", ");
		bb.append("familyName:").append(this.familyName).append(", ");
		bb.append("memberArray:").append(memberArray.toString()).append(", ");
		bb.append("count:").append(this.count).append(", ");
		bb.append("familyLevel:").append(this.familyLevel).append(", ");
		bb.append("ranking:").append(this.ranking).append(", ");
		bb.append("huoyuedu:").append(this.huoyuedu);
		return bb.toString();	
	}
}