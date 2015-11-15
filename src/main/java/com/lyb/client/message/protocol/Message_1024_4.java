package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 签到奖励
 *
 * @author codeGenerator
 * 
 */
public class Message_1024_4 implements IMessage {

	private static int MAIN = 1024;
	private static int SUB = 4;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1024, 4);

	private int month;
	private int count;
	private int booleanValue;
	private int totalCount;

	private static IntMessageParameterHandler monthHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Month");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
	private static IntMessageParameterHandler totalCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TotalCount");

	public static Message_1024_4 create() {
		return new Message_1024_4();
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
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
	 * @return the booleanValue
	 */
	public int getBooleanValue() {
		return booleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(int booleanValue) {
		this.booleanValue = booleanValue;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.month);
		data.writeInt(this.count);
		data.writeInt(this.booleanValue);
		data.writeInt(this.totalCount);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.month = data.getInt();
		this.count = data.getInt();
		this.booleanValue = data.getInt();
		this.totalCount = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!monthHandler.validate(month)) {
			return false;
		}
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!booleanValueHandler.validate(booleanValue)) {
			return false;
		}
		if (!totalCountHandler.validate(totalCount)) {
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
		bb.append("month:").append(this.month).append(", ");
		bb.append("count:").append(this.count).append(", ");
		bb.append("booleanValue:").append(this.booleanValue).append(", ");
		bb.append("totalCount:").append(this.totalCount);
		return bb.toString();	
	}
}