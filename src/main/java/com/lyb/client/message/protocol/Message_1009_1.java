package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.UserItemArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 同步背包所有数据
 *
 * @author codeGenerator
 * 
 */
public class Message_1009_1 implements IMessage {

	private static int MAIN = 1009;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1009, 1);

	private UserItemArray userItemArray;
	private int type;
	private int booleanValue2;

	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
	private static IntMessageParameterHandler booleanValue2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue2");

	public static Message_1009_1 create() {
		return new Message_1009_1();
	}

	/**
	 * @return the userItemArray
	 */
	public UserItemArray getUserItemArray() {
		return userItemArray;
	}

	/**
	 * @param userItemArray
	 *            the userItemArray to set
	 */
	public void setUserItemArray(UserItemArray userItemArray) {
		this.userItemArray = userItemArray;
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
	 * @return the booleanValue2
	 */
	public int getBooleanValue2() {
		return booleanValue2;
	}

	/**
	 * @param booleanValue2
	 *            the booleanValue2 to set
	 */
	public void setBooleanValue2(int booleanValue2) {
		this.booleanValue2 = booleanValue2;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		userItemArray.encode(data);
		data.writeInt(this.type);
		data.writeInt(this.booleanValue2);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		userItemArray = UserItemArray.create();
		userItemArray.decode(data);
		this.type = data.getInt();
		this.booleanValue2 = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userItemArray.validate()) {
			return false;
		}
		if (!typeHandler.validate(type)) {
			return false;
		}
		if (!booleanValue2Handler.validate(booleanValue2)) {
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
		bb.append("userItemArray:").append(userItemArray.toString()).append(", ");
		bb.append("type:").append(this.type).append(", ");
		bb.append("booleanValue2:").append(this.booleanValue2);
		return bb.toString();	
	}
}