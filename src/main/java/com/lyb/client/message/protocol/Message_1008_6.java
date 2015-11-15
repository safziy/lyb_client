package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.HunkTaskArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 同步寻宝任务
 *
 * @author codeGenerator
 * 
 */
public class Message_1008_6 implements IMessage {

	private static int MAIN = 1008;
	private static int SUB = 6;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1008, 6);

	private int place;
	private int state;
	private int count;
	private HunkTaskArray hunkTaskArray;

	private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
	private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
	private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

	public static Message_1008_6 create() {
		return new Message_1008_6();
	}

	/**
	 * @return the place
	 */
	public int getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(int place) {
		this.place = place;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
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
	 * @return the hunkTaskArray
	 */
	public HunkTaskArray getHunkTaskArray() {
		return hunkTaskArray;
	}

	/**
	 * @param hunkTaskArray
	 *            the hunkTaskArray to set
	 */
	public void setHunkTaskArray(HunkTaskArray hunkTaskArray) {
		this.hunkTaskArray = hunkTaskArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.place);
		data.writeInt(this.state);
		data.writeInt(this.count);
		hunkTaskArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.place = data.getInt();
		this.state = data.getInt();
		this.count = data.getInt();
		hunkTaskArray = HunkTaskArray.create();
		hunkTaskArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!placeHandler.validate(place)) {
			return false;
		}
		if (!stateHandler.validate(state)) {
			return false;
		}
		if (!countHandler.validate(count)) {
			return false;
		}
		if (!hunkTaskArray.validate()) {
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
		bb.append("place:").append(this.place).append(", ");
		bb.append("state:").append(this.state).append(", ");
		bb.append("count:").append(this.count).append(", ");
		bb.append("hunkTaskArray:").append(hunkTaskArray.toString());
		return bb.toString();	
	}
}