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
public class BattleRoomArray implements IMessageEncoder {
	private List<BattleRoomArrayItem> list = new LinkedList<BattleRoomArrayItem>();

	public List<BattleRoomArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleRoomArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getIsFull());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getBooleanValue());
			data.writeString(item.getCaptainName());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleRoomArrayItem item = BattleRoomArrayItem.create();
			item.setID(data.getLong());
			item.setIsFull(data.getInt());
			item.setConfigId(data.getInt());
			item.setBooleanValue(data.getInt());
			item.setCaptainName(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleRoomArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleRoomArray create() {
		BattleRoomArray array = new BattleRoomArray();
		return array;
	}

	public static BattleRoomArrayItem createItem() {
		BattleRoomArrayItem item = new BattleRoomArrayItem();
		return item;
	}

	public BattleRoomArrayItem addData(long iD, int isFull, int configId, int booleanValue, String captainName) {
		BattleRoomArrayItem item = new BattleRoomArrayItem();
		item.setID(iD);
		item.setIsFull(isFull);
		item.setConfigId(configId);
		item.setBooleanValue(booleanValue);
		item.setCaptainName(captainName);
		list.add(item);
		return item;
	}

	public void addItem(BattleRoomArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleRoomArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleRoomArrayItem implements IMessageEncoder {
		private long iD;
		private int isFull;
		private int configId;
		private int booleanValue;
		private String captainName;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler isFullHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("IsFull");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static BattleRoomArrayItem create() {
			BattleRoomArrayItem item = new BattleRoomArrayItem();
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
		 * @return the isFull
		 */
		public int getIsFull() {
			return isFull;
		}

		/**
		 * @param isFull
		 *            the isFull to set
		 */
		public void setIsFull(int isFull) {
			this.isFull = isFull;
		}
		/**
		 * @return the configId
		 */
		public int getConfigId() {
			return configId;
		}

		/**
		 * @param configId
		 *            the configId to set
		 */
		public void setConfigId(int configId) {
			this.configId = configId;
		}
		/**
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
		}
		/**
		 * @return the captainName
		 */
		public String getCaptainName() {
			return captainName;
		}

		/**
		 * @param captainName
		 *            the captainName to set
		 */
		public void setCaptainName(String captainName) {
			this.captainName = captainName;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.isFull);
			data.writeInt(this.configId);
			data.writeInt(this.booleanValue);
			data.writeString(this.captainName);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.isFull = data.getInt();
			this.configId = data.getInt();
			this.booleanValue = data.getInt();
			this.captainName = data.getString();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!isFullHandler.validate(isFull)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("isFull:").append(this.isFull).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("captainName:").append(this.captainName);
			return bb.toString();	
		}
	}
}