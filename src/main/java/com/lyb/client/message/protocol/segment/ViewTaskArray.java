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
public class ViewTaskArray implements IMessageEncoder {
	private List<ViewTaskArrayItem> list = new LinkedList<ViewTaskArrayItem>();

	public List<ViewTaskArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ViewTaskArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getTaskState());
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
			ViewTaskArrayItem item = ViewTaskArrayItem.create();
			item.setID(data.getLong());
			item.setTaskState(data.getInt());
			item.setTaskConditionArray(TaskConditionArray.create());
			item.getTaskConditionArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ViewTaskArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ViewTaskArray create() {
		ViewTaskArray array = new ViewTaskArray();
		return array;
	}

	public static ViewTaskArrayItem createItem() {
		ViewTaskArrayItem item = new ViewTaskArrayItem();
		return item;
	}

	public ViewTaskArrayItem addData(long iD, int taskState, TaskConditionArray taskConditionArray) {
		ViewTaskArrayItem item = new ViewTaskArrayItem();
		item.setID(iD);
		item.setTaskState(taskState);
		item.setTaskConditionArray(taskConditionArray);
		list.add(item);
		return item;
	}

	public void addItem(ViewTaskArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ViewTaskArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ViewTaskArrayItem implements IMessageEncoder {
		private long iD;
		private int taskState;
		private TaskConditionArray taskConditionArray;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler taskStateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TaskState");

		public static ViewTaskArrayItem create() {
			ViewTaskArrayItem item = new ViewTaskArrayItem();
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
			data.writeInt(this.taskState);
			taskConditionArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.taskState = data.getInt();
			taskConditionArray = TaskConditionArray.create();
			taskConditionArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!taskStateHandler.validate(taskState)) {
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
			bb.append("taskState:").append(this.taskState).append(", ");
			bb.append("taskConditionArray:").append(taskConditionArray.toString());
			return bb.toString();	
		}
	}
}