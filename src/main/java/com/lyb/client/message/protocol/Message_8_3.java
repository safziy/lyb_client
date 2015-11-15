package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  领取任务奖励
 *
 * @author codeGenerator
 * 
 */
public class Message_8_3 implements IMessage {

	private static int MAIN = 8;
	private static int SUB = 3;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(8, 3);

	private int taskId;

	private static IntMessageParameterHandler taskIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TaskId");

	public static Message_8_3 create() {
		return new Message_8_3();
	}

	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.taskId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.taskId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!taskIdHandler.validate(taskId)) {
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
		bb.append("taskId:").append(this.taskId);
		return bb.toString();	
	}
}