package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.HeatWineArray;
import com.lyb.client.message.protocol.segment.UserIdNameArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 广播酒宴数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1027_36 implements IMessage {

	private static int MAIN = 1027;
	private static int SUB = 36;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1027, 36);

	private long iD;
	private long userId;
	private UserIdNameArray userIdNameArray;
	private HeatWineArray heatWineArray;

	private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");

	public static Message_1027_36 create() {
		return new Message_1027_36();
	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return iD;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(long iD) {
		this.iD = iD;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userIdNameArray
	 */
	public UserIdNameArray getUserIdNameArray() {
		return userIdNameArray;
	}

	/**
	 * @param userIdNameArray
	 *            the userIdNameArray to set
	 */
	public void setUserIdNameArray(UserIdNameArray userIdNameArray) {
		this.userIdNameArray = userIdNameArray;
	}

	/**
	 * @return the heatWineArray
	 */
	public HeatWineArray getHeatWineArray() {
		return heatWineArray;
	}

	/**
	 * @param heatWineArray
	 *            the heatWineArray to set
	 */
	public void setHeatWineArray(HeatWineArray heatWineArray) {
		this.heatWineArray = heatWineArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.iD);
		data.writeLong(this.userId);
		userIdNameArray.encode(data);
		heatWineArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.iD = data.getLong();
		this.userId = data.getLong();
		userIdNameArray = UserIdNameArray.create();
		userIdNameArray.decode(data);
		heatWineArray = HeatWineArray.create();
		heatWineArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!iDHandler.validate(iD)) {
			return false;
		}
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!userIdNameArray.validate()) {
			return false;
		}
		if (!heatWineArray.validate()) {
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
		bb.append("iD:").append(this.iD).append(", ");
		bb.append("userId:").append(this.userId).append(", ");
		bb.append("userIdNameArray:").append(userIdNameArray.toString()).append(", ");
		bb.append("heatWineArray:").append(heatWineArray.toString());
		return bb.toString();	
	}
}