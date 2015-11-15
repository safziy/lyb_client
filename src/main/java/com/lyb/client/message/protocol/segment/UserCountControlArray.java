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
public class UserCountControlArray implements IMessageEncoder {
	private List<UserCountControlArrayItem> list = new LinkedList<UserCountControlArrayItem>();

	public List<UserCountControlArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserCountControlArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getCurrentCount());
			data.writeInt(item.getTotalCount());
			data.writeInt(item.getAddCount());
			data.writeInt(item.getMaxAddCount());
			data.writeString(item.getBuyCountNeedGold());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			UserCountControlArrayItem item = UserCountControlArrayItem.create();
			item.setID(data.getLong());
			item.setCurrentCount(data.getInt());
			item.setTotalCount(data.getInt());
			item.setAddCount(data.getInt());
			item.setMaxAddCount(data.getInt());
			item.setBuyCountNeedGold(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserCountControlArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserCountControlArray create() {
		UserCountControlArray array = new UserCountControlArray();
		return array;
	}

	public static UserCountControlArrayItem createItem() {
		UserCountControlArrayItem item = new UserCountControlArrayItem();
		return item;
	}

	public UserCountControlArrayItem addData(long iD, int currentCount, int totalCount, int addCount, int maxAddCount, String buyCountNeedGold) {
		UserCountControlArrayItem item = new UserCountControlArrayItem();
		item.setID(iD);
		item.setCurrentCount(currentCount);
		item.setTotalCount(totalCount);
		item.setAddCount(addCount);
		item.setMaxAddCount(maxAddCount);
		item.setBuyCountNeedGold(buyCountNeedGold);
		list.add(item);
		return item;
	}

	public void addItem(UserCountControlArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserCountControlArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserCountControlArrayItem implements IMessageEncoder {
		private long iD;
		private int currentCount;
		private int totalCount;
		private int addCount;
		private int maxAddCount;
		private String buyCountNeedGold;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler currentCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentCount");
		private static IntMessageParameterHandler totalCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TotalCount");
		private static IntMessageParameterHandler addCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("AddCount");
		private static IntMessageParameterHandler maxAddCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MaxAddCount");

		public static UserCountControlArrayItem create() {
			UserCountControlArrayItem item = new UserCountControlArrayItem();
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
		 * @return the currentCount
		 */
		public int getCurrentCount() {
			return currentCount;
		}

		/**
		 * @param currentCount
		 *            the currentCount to set
		 */
		public void setCurrentCount(int currentCount) {
			this.currentCount = currentCount;
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
		 * @return the addCount
		 */
		public int getAddCount() {
			return addCount;
		}

		/**
		 * @param addCount
		 *            the addCount to set
		 */
		public void setAddCount(int addCount) {
			this.addCount = addCount;
		}
		/**
		 * @return the maxAddCount
		 */
		public int getMaxAddCount() {
			return maxAddCount;
		}

		/**
		 * @param maxAddCount
		 *            the maxAddCount to set
		 */
		public void setMaxAddCount(int maxAddCount) {
			this.maxAddCount = maxAddCount;
		}
		/**
		 * @return the buyCountNeedGold
		 */
		public String getBuyCountNeedGold() {
			return buyCountNeedGold;
		}

		/**
		 * @param buyCountNeedGold
		 *            the buyCountNeedGold to set
		 */
		public void setBuyCountNeedGold(String buyCountNeedGold) {
			this.buyCountNeedGold = buyCountNeedGold;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.currentCount);
			data.writeInt(this.totalCount);
			data.writeInt(this.addCount);
			data.writeInt(this.maxAddCount);
			data.writeString(this.buyCountNeedGold);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.currentCount = data.getInt();
			this.totalCount = data.getInt();
			this.addCount = data.getInt();
			this.maxAddCount = data.getInt();
			this.buyCountNeedGold = data.getString();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!currentCountHandler.validate(currentCount)) {
				return false;
			}
			if (!totalCountHandler.validate(totalCount)) {
				return false;
			}
			if (!addCountHandler.validate(addCount)) {
				return false;
			}
			if (!maxAddCountHandler.validate(maxAddCount)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("currentCount:").append(this.currentCount).append(", ");
			bb.append("totalCount:").append(this.totalCount).append(", ");
			bb.append("addCount:").append(this.addCount).append(", ");
			bb.append("maxAddCount:").append(this.maxAddCount).append(", ");
			bb.append("buyCountNeedGold:").append(this.buyCountNeedGold);
			return bb.toString();	
		}
	}
}