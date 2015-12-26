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
public class PlunderArray implements IMessageEncoder {
	private List<PlunderArrayItem> list = new LinkedList<PlunderArrayItem>();

	public List<PlunderArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PlunderArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getCarriageId());
			data.writeInt(item.getLevel());
			data.writeInt(item.getStartId());
			data.writeInt(item.getEndId());
			data.writeInt(item.getTime());
			data.writeInt(item.getCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PlunderArrayItem item = PlunderArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setCarriageId(data.getInt());
			item.setLevel(data.getInt());
			item.setStartId(data.getInt());
			item.setEndId(data.getInt());
			item.setTime(data.getInt());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PlunderArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PlunderArray create() {
		PlunderArray array = new PlunderArray();
		return array;
	}

	public static PlunderArrayItem createItem() {
		PlunderArrayItem item = new PlunderArrayItem();
		return item;
	}

	public PlunderArrayItem addData(long userId, String userName, int carriageId, int level, int startId, int endId, int time, int count) {
		PlunderArrayItem item = new PlunderArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setCarriageId(carriageId);
		item.setLevel(level);
		item.setStartId(startId);
		item.setEndId(endId);
		item.setTime(time);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(PlunderArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PlunderArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PlunderArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int carriageId;
		private int level;
		private int startId;
		private int endId;
		private int time;
		private int count;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler carriageIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CarriageId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler startIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StartId");
		private static IntMessageParameterHandler endIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EndId");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static PlunderArrayItem create() {
			PlunderArrayItem item = new PlunderArrayItem();
			return item;
		}

		/**
		 * @return the userId
		 */
		public long getUserId() {
			return userId;
		}

		/**
		 * @param userId
		 *            the userId to set
		 */
		public void setUserId(long userId) {
			this.userId = userId;
		}
		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName
		 *            the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/**
		 * @return the carriageId
		 */
		public int getCarriageId() {
			return carriageId;
		}

		/**
		 * @param carriageId
		 *            the carriageId to set
		 */
		public void setCarriageId(int carriageId) {
			this.carriageId = carriageId;
		}
		/**
		 * @return the level
		 */
		public int getLevel() {
			return level;
		}

		/**
		 * @param level
		 *            the level to set
		 */
		public void setLevel(int level) {
			this.level = level;
		}
		/**
		 * @return the startId
		 */
		public int getStartId() {
			return startId;
		}

		/**
		 * @param startId
		 *            the startId to set
		 */
		public void setStartId(int startId) {
			this.startId = startId;
		}
		/**
		 * @return the endId
		 */
		public int getEndId() {
			return endId;
		}

		/**
		 * @param endId
		 *            the endId to set
		 */
		public void setEndId(int endId) {
			this.endId = endId;
		}
		/**
		 * @return the time
		 */
		public int getTime() {
			return time;
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(int time) {
			this.time = time;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.carriageId);
			data.writeInt(this.level);
			data.writeInt(this.startId);
			data.writeInt(this.endId);
			data.writeInt(this.time);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.carriageId = data.getInt();
			this.level = data.getInt();
			this.startId = data.getInt();
			this.endId = data.getInt();
			this.time = data.getInt();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!carriageIdHandler.validate(carriageId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!startIdHandler.validate(startId)) {
				return false;
			}
			if (!endIdHandler.validate(endId)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("carriageId:").append(this.carriageId).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("startId:").append(this.startId).append(", ");
			bb.append("endId:").append(this.endId).append(", ");
			bb.append("time:").append(this.time).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}