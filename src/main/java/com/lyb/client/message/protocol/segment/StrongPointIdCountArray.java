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
public class StrongPointIdCountArray implements IMessageEncoder {
	private List<StrongPointIdCountArrayItem> list = new LinkedList<StrongPointIdCountArrayItem>();

	public List<StrongPointIdCountArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (StrongPointIdCountArrayItem item : list) {
			data.writeInt(item.getStrongPointId());
			data.writeInt(item.getCount());
			data.writeInt(item.getStarLevel());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			StrongPointIdCountArrayItem item = StrongPointIdCountArrayItem.create();
			item.setStrongPointId(data.getInt());
			item.setCount(data.getInt());
			item.setStarLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (StrongPointIdCountArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static StrongPointIdCountArray create() {
		StrongPointIdCountArray array = new StrongPointIdCountArray();
		return array;
	}

	public static StrongPointIdCountArrayItem createItem() {
		StrongPointIdCountArrayItem item = new StrongPointIdCountArrayItem();
		return item;
	}

	public StrongPointIdCountArrayItem addData(int strongPointId, int count, int starLevel) {
		StrongPointIdCountArrayItem item = new StrongPointIdCountArrayItem();
		item.setStrongPointId(strongPointId);
		item.setCount(count);
		item.setStarLevel(starLevel);
		list.add(item);
		return item;
	}

	public void addItem(StrongPointIdCountArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (StrongPointIdCountArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class StrongPointIdCountArrayItem implements IMessageEncoder {
		private int strongPointId;
		private int count;
		private int starLevel;

		private static IntMessageParameterHandler strongPointIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrongPointId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");

		public static StrongPointIdCountArrayItem create() {
			StrongPointIdCountArrayItem item = new StrongPointIdCountArrayItem();
			return item;
		}

		/**
		 * @return the strongPointId
		 */
		public int getStrongPointId() {
			return strongPointId;
		}

		/**
		 * @param strongPointId
		 *            the strongPointId to set
		 */
		public void setStrongPointId(int strongPointId) {
			this.strongPointId = strongPointId;
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
		 * @return the starLevel
		 */
		public int getStarLevel() {
			return starLevel;
		}

		/**
		 * @param starLevel
		 *            the starLevel to set
		 */
		public void setStarLevel(int starLevel) {
			this.starLevel = starLevel;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.strongPointId);
			data.writeInt(this.count);
			data.writeInt(this.starLevel);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.strongPointId = data.getInt();
			this.count = data.getInt();
			this.starLevel = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!strongPointIdHandler.validate(strongPointId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!starLevelHandler.validate(starLevel)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("strongPointId:").append(this.strongPointId).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("starLevel:").append(this.starLevel);
			return bb.toString();	
		}
	}
}