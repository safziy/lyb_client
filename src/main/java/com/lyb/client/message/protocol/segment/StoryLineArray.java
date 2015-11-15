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
public class StoryLineArray implements IMessageEncoder {
	private List<StoryLineArrayItem> list = new LinkedList<StoryLineArrayItem>();

	public List<StoryLineArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (StoryLineArrayItem item : list) {
			data.writeInt(item.getStoryLineId());
			data.writeInt(item.getState());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			StoryLineArrayItem item = StoryLineArrayItem.create();
			item.setStoryLineId(data.getInt());
			item.setState(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (StoryLineArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static StoryLineArray create() {
		StoryLineArray array = new StoryLineArray();
		return array;
	}

	public static StoryLineArrayItem createItem() {
		StoryLineArrayItem item = new StoryLineArrayItem();
		return item;
	}

	public StoryLineArrayItem addData(int storyLineId, int state) {
		StoryLineArrayItem item = new StoryLineArrayItem();
		item.setStoryLineId(storyLineId);
		item.setState(state);
		list.add(item);
		return item;
	}

	public void addItem(StoryLineArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (StoryLineArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class StoryLineArrayItem implements IMessageEncoder {
		private int storyLineId;
		private int state;

		private static IntMessageParameterHandler storyLineIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StoryLineId");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

		public static StoryLineArrayItem create() {
			StoryLineArrayItem item = new StoryLineArrayItem();
			return item;
		}

		/**
		 * @return the storyLineId
		 */
		public int getStoryLineId() {
			return storyLineId;
		}

		/**
		 * @param storyLineId
		 *            the storyLineId to set
		 */
		public void setStoryLineId(int storyLineId) {
			this.storyLineId = storyLineId;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.storyLineId);
			data.writeInt(this.state);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.storyLineId = data.getInt();
			this.state = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!storyLineIdHandler.validate(storyLineId)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("storyLineId:").append(this.storyLineId).append(", ");
			bb.append("state:").append(this.state);
			return bb.toString();	
		}
	}
}