package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.message.protocol.segment.*;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;

/**
 * 返回 刷新可以掠夺的马车
 *
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class Message_1019_30 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 30;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 30);

	private long userId;
	private String userName;
	private int level;
	private int carriageId;
	private int startId;
	private int endId;
	private int time;
	private int count;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
	private static IntMessageParameterHandler carriageIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CarriageId");
	private static IntMessageParameterHandler startIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StartId");
	private static IntMessageParameterHandler endIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EndId");
	private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_1019_30 create() {
		return new Message_1019_30();
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the carriageId
	 */
	public int getCarriageId() {
		return carriageId;
	}

	/**
	 * @param carriageId
	 *            the carriageId to set
	 */
	public void setCarriageId(int carriageId) {
		this.carriageId = carriageId;
	}

	/**
	 * @return the startId
	 */
	public int getStartId() {
		return startId;
	}

	/**
	 * @param startId
	 *            the startId to set
	 */
	public void setStartId(int startId) {
		this.startId = startId;
	}

	/**
	 * @return the endId
	 */
	public int getEndId() {
		return endId;
	}

	/**
	 * @param endId
	 *            the endId to set
	 */
	public void setEndId(int endId) {
		this.endId = endId;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(int time) {
		this.time = time;
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
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeLong(this.userId);
		data.writeString(this.userName);
		data.writeInt(this.level);
		data.writeInt(this.carriageId);
		data.writeInt(this.startId);
		data.writeInt(this.endId);
		data.writeInt(this.time);
		data.writeInt(this.count);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userId = data.getLong();
		this.userName = data.getString();
		this.level = data.getInt();
		this.carriageId = data.getInt();
		this.startId = data.getInt();
		this.endId = data.getInt();
		this.time = data.getInt();
		this.count = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!levelHandler.validate(level)) {
			return false;
		}
		if (!carriageIdHandler.validate(carriageId)) {
			return false;
		}
		if (!startIdHandler.validate(startId)) {
			return false;
		}
		if (!endIdHandler.validate(endId)) {
			return false;
		}
		if (!timeHandler.validate(time)) {
			return false;
		}
		if (!countHandler.validate(count)) {
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
		bb.append("userId:").append(this.userId).append(", ");
		bb.append("userName:").append(this.userName).append(", ");
		bb.append("level:").append(this.level).append(", ");
		bb.append("carriageId:").append(this.carriageId).append(", ");
		bb.append("startId:").append(this.startId).append(", ");
		bb.append("endId:").append(this.endId).append(", ");
		bb.append("time:").append(this.time).append(", ");
		bb.append("count:").append(this.count);
		return bb.toString();	
	}
}