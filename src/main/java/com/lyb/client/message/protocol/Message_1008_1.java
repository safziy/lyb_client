package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.TaskMapArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 同步任务详细
 *
 * @author codeGenerator
 * 
 */
public class Message_1008_1 implements IMessage {

	private static int MAIN = 1008;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1008, 1);

	private TaskMapArray taskMapArray;


	public static Message_1008_1 create() {
		return new Message_1008_1();
	}

	/**
	 * @return the taskMapArray
	 */
	public TaskMapArray getTaskMapArray() {
		return taskMapArray;
	}

	/**
	 * @param taskMapArray
	 *            the taskMapArray to set
	 */
	public void setTaskMapArray(TaskMapArray taskMapArray) {
		this.taskMapArray = taskMapArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		taskMapArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		taskMapArray = TaskMapArray.create();
		taskMapArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!taskMapArray.validate()) {
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
		bb.append("taskMapArray:").append(taskMapArray.toString());
		return bb.toString();	
	}
}