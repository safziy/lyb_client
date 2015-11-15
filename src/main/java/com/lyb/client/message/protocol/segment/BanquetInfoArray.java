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
public class BanquetInfoArray implements IMessageEncoder {
	private List<BanquetInfoArrayItem> list = new LinkedList<BanquetInfoArrayItem>();

	public List<BanquetInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BanquetInfoArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getType());
			data.writeInt(item.getRemainSeconds());
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
			BanquetInfoArrayItem item = BanquetInfoArrayItem.create();
			item.setID(data.getLong());
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setType(data.getInt());
			item.setRemainSeconds(data.getInt());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BanquetInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BanquetInfoArray create() {
		BanquetInfoArray array = new BanquetInfoArray();
		return array;
	}

	public static BanquetInfoArrayItem createItem() {
		BanquetInfoArrayItem item = new BanquetInfoArrayItem();
		return item;
	}

	public BanquetInfoArrayItem addData(long iD, long userId, String userName, int type, int remainSeconds, int count) {
		BanquetInfoArrayItem item = new BanquetInfoArrayItem();
		item.setID(iD);
		item.setUserId(userId);
		item.setUserName(userName);
		item.setType(type);
		item.setRemainSeconds(remainSeconds);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(BanquetInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BanquetInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BanquetInfoArrayItem implements IMessageEncoder {
		private long iD;
		private long userId;
		private String userName;
		private int type;
		private int remainSeconds;
		private int count;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler remainSecondsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSeconds");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static BanquetInfoArrayItem create() {
			BanquetInfoArrayItem item = new BanquetInfoArrayItem();
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
		 * @return the remainSeconds
		 */
		public int getRemainSeconds() {
			return remainSeconds;
		}

		/**
		 * @param remainSeconds
		 *            the remainSeconds to set
		 */
		public void setRemainSeconds(int remainSeconds) {
			this.remainSeconds = remainSeconds;
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
			data.writeLong(this.iD);
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.type);
			data.writeInt(this.remainSeconds);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.userId = data.getLong();
			this.userName = data.getString();
			this.type = data.getInt();
			this.remainSeconds = data.getInt();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!typeHandler.validate(type)) {
				return false;
			}
			if (!remainSecondsHandler.validate(remainSeconds)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("type:").append(this.type).append(", ");
			bb.append("remainSeconds:").append(this.remainSeconds).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}