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
public class YXZStrongPointArray implements IMessageEncoder {
	private List<YXZStrongPointArrayItem> list = new LinkedList<YXZStrongPointArrayItem>();

	public List<YXZStrongPointArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (YXZStrongPointArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getStrongPointId());
			data.writeInt(item.getCount());
			data.writeInt(item.getTotalCount());
			data.writeInt(item.getState());
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
			YXZStrongPointArrayItem item = YXZStrongPointArrayItem.create();
			item.setID(data.getLong());
			item.setStrongPointId(data.getInt());
			item.setCount(data.getInt());
			item.setTotalCount(data.getInt());
			item.setState(data.getInt());
			item.setStarLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (YXZStrongPointArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static YXZStrongPointArray create() {
		YXZStrongPointArray array = new YXZStrongPointArray();
		return array;
	}

	public static YXZStrongPointArrayItem createItem() {
		YXZStrongPointArrayItem item = new YXZStrongPointArrayItem();
		return item;
	}

	public YXZStrongPointArrayItem addData(long iD, int strongPointId, int count, int totalCount, int state, int starLevel) {
		YXZStrongPointArrayItem item = new YXZStrongPointArrayItem();
		item.setID(iD);
		item.setStrongPointId(strongPointId);
		item.setCount(count);
		item.setTotalCount(totalCount);
		item.setState(state);
		item.setStarLevel(starLevel);
		list.add(item);
		return item;
	}

	public void addItem(YXZStrongPointArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (YXZStrongPointArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class YXZStrongPointArrayItem implements IMessageEncoder {
		private long iD;
		private int strongPointId;
		private int count;
		private int totalCount;
		private int state;
		private int starLevel;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler strongPointIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StrongPointId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler totalCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TotalCount");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
		private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");

		public static YXZStrongPointArrayItem create() {
			YXZStrongPointArrayItem item = new YXZStrongPointArrayItem();
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
		 * @return the totalCount
		 */
		public int getTotalCount() {
			return totalCount;
		}

		/**
		 * @param totalCount
		 *            the totalCount to set
		 */
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
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
			data.writeLong(this.iD);
			data.writeInt(this.strongPointId);
			data.writeInt(this.count);
			data.writeInt(this.totalCount);
			data.writeInt(this.state);
			data.writeInt(this.starLevel);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.strongPointId = data.getInt();
			this.count = data.getInt();
			this.totalCount = data.getInt();
			this.state = data.getInt();
			this.starLevel = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!strongPointIdHandler.validate(strongPointId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!totalCountHandler.validate(totalCount)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			if (!starLevelHandler.validate(starLevel)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("strongPointId:").append(this.strongPointId).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("totalCount:").append(this.totalCount).append(", ");
			bb.append("state:").append(this.state).append(", ");
			bb.append("starLevel:").append(this.starLevel);
			return bb.toString();	
		}
	}
}