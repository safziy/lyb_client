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
public class BattleInfoArray implements IMessageEncoder {
	private List<BattleInfoArrayItem> list = new LinkedList<BattleInfoArrayItem>();

	public List<BattleInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleInfoArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getBattleId());
			data.writeInt(item.getWinFamilyId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleInfoArrayItem item = BattleInfoArrayItem.create();
			item.setID(data.getLong());
			item.setBattleId(data.getInt());
			item.setWinFamilyId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleInfoArray create() {
		BattleInfoArray array = new BattleInfoArray();
		return array;
	}

	public static BattleInfoArrayItem createItem() {
		BattleInfoArrayItem item = new BattleInfoArrayItem();
		return item;
	}

	public BattleInfoArrayItem addData(long iD, int battleId, int winFamilyId) {
		BattleInfoArrayItem item = new BattleInfoArrayItem();
		item.setID(iD);
		item.setBattleId(battleId);
		item.setWinFamilyId(winFamilyId);
		list.add(item);
		return item;
	}

	public void addItem(BattleInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleInfoArrayItem implements IMessageEncoder {
		private long iD;
		private int battleId;
		private int winFamilyId;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler battleIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleId");
		private static IntMessageParameterHandler winFamilyIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("WinFamilyId");

		public static BattleInfoArrayItem create() {
			BattleInfoArrayItem item = new BattleInfoArrayItem();
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
		 * @return the battleId
		 */
		public int getBattleId() {
			return battleId;
		}

		/**
		 * @param battleId
		 *            the battleId to set
		 */
		public void setBattleId(int battleId) {
			this.battleId = battleId;
		}
		/**
		 * @return the winFamilyId
		 */
		public int getWinFamilyId() {
			return winFamilyId;
		}

		/**
		 * @param winFamilyId
		 *            the winFamilyId to set
		 */
		public void setWinFamilyId(int winFamilyId) {
			this.winFamilyId = winFamilyId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.battleId);
			data.writeInt(this.winFamilyId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.battleId = data.getInt();
			this.winFamilyId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!battleIdHandler.validate(battleId)) {
				return false;
			}
			if (!winFamilyIdHandler.validate(winFamilyId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("battleId:").append(this.battleId).append(", ");
			bb.append("winFamilyId:").append(this.winFamilyId);
			return bb.toString();	
		}
	}
}