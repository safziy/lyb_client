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
public class StoryLineIdArray implements IMessageEncoder {
	private List<StoryLineIdArrayItem> list = new LinkedList<StoryLineIdArrayItem>();

	public List<StoryLineIdArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (StoryLineIdArrayItem item : list) {
			data.writeInt(item.getStoryLineId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			StoryLineIdArrayItem item = StoryLineIdArrayItem.create();
			item.setStoryLineId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (StoryLineIdArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static StoryLineIdArray create() {
		StoryLineIdArray array = new StoryLineIdArray();
		return array;
	}

	public static StoryLineIdArrayItem createItem() {
		StoryLineIdArrayItem item = new StoryLineIdArrayItem();
		return item;
	}

	public StoryLineIdArrayItem addData(int storyLineId) {
		StoryLineIdArrayItem item = new StoryLineIdArrayItem();
		item.setStoryLineId(storyLineId);
		list.add(item);
		return item;
	}

	public void addItem(StoryLineIdArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (StoryLineIdArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class StoryLineIdArrayItem implements IMessageEncoder {
		private int storyLineId;

		private static IntMessageParameterHandler storyLineIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StoryLineId");

		public static StoryLineIdArrayItem create() {
			StoryLineIdArrayItem item = new StoryLineIdArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.storyLineId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.storyLineId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!storyLineIdHandler.validate(storyLineId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("storyLineId:").append(this.storyLineId);
			return bb.toString();	
		}
	}
}