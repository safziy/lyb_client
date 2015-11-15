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
public class TaskScriptArray implements IMessageEncoder {
	private List<TaskScriptArrayItem> list = new LinkedList<TaskScriptArrayItem>();

	public List<TaskScriptArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (TaskScriptArrayItem item : list) {
			data.writeString(item.getScript());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			TaskScriptArrayItem item = TaskScriptArrayItem.create();
			item.setScript(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (TaskScriptArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static TaskScriptArray create() {
		TaskScriptArray array = new TaskScriptArray();
		return array;
	}

	public static TaskScriptArrayItem createItem() {
		TaskScriptArrayItem item = new TaskScriptArrayItem();
		return item;
	}

	public TaskScriptArrayItem addData(String script) {
		TaskScriptArrayItem item = new TaskScriptArrayItem();
		item.setScript(script);
		list.add(item);
		return item;
	}

	public void addItem(TaskScriptArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (TaskScriptArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class TaskScriptArrayItem implements IMessageEncoder {
		private String script;


		public static TaskScriptArrayItem create() {
			TaskScriptArrayItem item = new TaskScriptArrayItem();
			return item;
		}

		/**
		 * @return the script
		 */
		public String getScript() {
			return script;
		}

		/**
		 * @param script
		 *            the script to set
		 */
		public void setScript(String script) {
			this.script = script;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.script);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.script = data.getString();
		}
	
		@Override
		public boolean validate() {
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("script:").append(this.script);
			return bb.toString();	
		}
	}
}