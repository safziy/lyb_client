package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.TaskConditionArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 同步任务状态和数量
 *
 * @author codeGenerator
 * 
 */
public class Message_1008_2 implements IMessage {

	private static int MAIN = 1008;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1008, 2);

	private int taskId;
	private int taskState;
	private int type;
	private int param;
	private TaskConditionArray taskConditionArray;

	private static IntMessageParameterHandler taskIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TaskId");
	private static IntMessageParameterHandler taskStateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TaskState");
	private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
	private static IntMessageParameterHandler paramHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param");

	public static Message_1008_2 create() {
		return new Message_1008_2();
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
	 * @return the taskState
	 */
	public int getTaskState() {
		return taskState;
	}

	/**
	 * @param taskState
	 *            the taskState to set
	 */
	public void setTaskState(int taskState) {
		this.taskState = taskState;
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
	 * @return the param
	 */
	public int getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(int param) {
		this.param = param;
	}

	/**
	 * @return the taskConditionArray
	 */
	public TaskConditionArray getTaskConditionArray() {
		return taskConditionArray;
	}

	/**
	 * @param taskConditionArray
	 *            the taskConditionArray to set
	 */
	public void setTaskConditionArray(TaskConditionArray taskConditionArray) {
		this.taskConditionArray = taskConditionArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.taskId);
		data.writeInt(this.taskState);
		data.writeInt(this.type);
		data.writeInt(this.param);
		taskConditionArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.taskId = data.getInt();
		this.taskState = data.getInt();
		this.type = data.getInt();
		this.param = data.getInt();
		taskConditionArray = TaskConditionArray.create();
		taskConditionArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!taskIdHandler.validate(taskId)) {
			return false;
		}
		if (!taskStateHandler.validate(taskState)) {
			return false;
		}
		if (!typeHandler.validate(type)) {
			return false;
		}
		if (!paramHandler.validate(param)) {
			return false;
		}
		if (!taskConditionArray.validate()) {
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
		bb.append("taskId:").append(this.taskId).append(", ");
		bb.append("taskState:").append(this.taskState).append(", ");
		bb.append("type:").append(this.type).append(", ");
		bb.append("param:").append(this.param).append(", ");
		bb.append("taskConditionArray:").append(taskConditionArray.toString());
		return bb.toString();	
	}
}