package com.lyb.client.message.protocol.segment;

import java.util.LinkedList;
import java.util.List;

import com.lyb.client.message.IMessageEncoder;
import com.lyb.client.message.handler.IMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.*;

/**
 * ${desc}
 * 
 * @author codeGenerator
 * 
 */
@SuppressWarnings("unused")
public class TaskMapArray implements IMessageEncoder {
	private List<TaskMapArrayItem> list = new LinkedList<TaskMapArrayItem>();

	public List<TaskMapArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TaskMapArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getMainType());
			data.writeInt(item.getTaskState());
			data.writeInt(item.getType());
			data.writeInt(item.getParam());
			item.getTaskConditionArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			TaskMapArrayItem item = TaskMapArrayItem.create();
			item.setID(data.getLong());
			item.setMainType(data.getInt());
			item.setTaskState(data.getInt());
			item.setType(data.getInt());
			item.setParam(data.getInt());
			item.setTaskConditionArray(TaskConditionArray.create());
			item.getTaskConditionArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TaskMapArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TaskMapArray create() {
		TaskMapArray array = new TaskMapArray();
		return array;
	}

	public static TaskMapArrayItem createItem() {
		TaskMapArrayItem item = new TaskMapArrayItem();
		return item;
	}

	public TaskMapArrayItem addData(long iD, int mainType, int taskState, int type, int param, TaskConditionArray taskConditionArray) {
		TaskMapArrayItem item = new TaskMapArrayItem();
		item.setID(iD);
		item.setMainType(mainType);
		item.setTaskState(taskState);
		item.setType(type);
		item.setParam(param);
		item.setTaskConditionArray(taskConditionArray);
		list.add(item);
		return item;
	}

	public void addItem(TaskMapArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TaskMapArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TaskMapArrayItem implements IMessageEncoder {
		private long iD;
		private int mainType;
		private int taskState;
		private int type;
		private int param;
		private TaskConditionArray taskConditionArray;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler mainTypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MainType");
		private static IntMessageParameterHandler taskStateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TaskState");
		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler paramHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param");

		public static TaskMapArrayItem create() {
			TaskMapArrayItem item = new TaskMapArrayItem();
			return item;
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
		 * @return the mainType
		 */
		public int getMainType() {
			return mainType;
		}

		/**
		 * @param mainType
		 *            the mainType to set
		 */
		public void setMainType(int mainType) {
			this.mainType = mainType;
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
			data.writeLong(this.iD);
			data.writeInt(this.mainType);
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
			this.iD = data.getLong();
			this.mainType = data.getInt();
			this.taskState = data.getInt();
			this.type = data.getInt();
			this.param = data.getInt();
			taskConditionArray = TaskConditionArray.create();
			taskConditionArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!mainTypeHandler.validate(mainType)) {
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
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("mainType:").append(this.mainType).append(", ");
			bb.append("taskState:").append(this.taskState).append(", ");
			bb.append("type:").append(this.type).append(", ");
			bb.append("param:").append(this.param).append(", ");
			bb.append("taskConditionArray:").append(taskConditionArray.toString());
			return bb.toString();	
		}
	}
}