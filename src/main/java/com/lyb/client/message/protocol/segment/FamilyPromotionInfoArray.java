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
public class FamilyPromotionInfoArray implements IMessageEncoder {
	private List<FamilyPromotionInfoArrayItem> list = new LinkedList<FamilyPromotionInfoArrayItem>();

	public List<FamilyPromotionInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FamilyPromotionInfoArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getPartAFamilyId());
			data.writeString(item.getPartAFamilyName());
			data.writeInt(item.getPartBFamilyId());
			data.writeString(item.getPartBFamilyName());
			data.writeInt(item.getWinFamilyId());
			item.getBattleInfoArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FamilyPromotionInfoArrayItem item = FamilyPromotionInfoArrayItem.create();
			item.setID(data.getLong());
			item.setPartAFamilyId(data.getInt());
			item.setPartAFamilyName(data.getString());
			item.setPartBFamilyId(data.getInt());
			item.setPartBFamilyName(data.getString());
			item.setWinFamilyId(data.getInt());
			item.setBattleInfoArray(BattleInfoArray.create());
			item.getBattleInfoArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FamilyPromotionInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FamilyPromotionInfoArray create() {
		FamilyPromotionInfoArray array = new FamilyPromotionInfoArray();
		return array;
	}

	public static FamilyPromotionInfoArrayItem createItem() {
		FamilyPromotionInfoArrayItem item = new FamilyPromotionInfoArrayItem();
		return item;
	}

	public FamilyPromotionInfoArrayItem addData(long iD, int partAFamilyId, String partAFamilyName, int partBFamilyId, String partBFamilyName, int winFamilyId, BattleInfoArray battleInfoArray) {
		FamilyPromotionInfoArrayItem item = new FamilyPromotionInfoArrayItem();
		item.setID(iD);
		item.setPartAFamilyId(partAFamilyId);
		item.setPartAFamilyName(partAFamilyName);
		item.setPartBFamilyId(partBFamilyId);
		item.setPartBFamilyName(partBFamilyName);
		item.setWinFamilyId(winFamilyId);
		item.setBattleInfoArray(battleInfoArray);
		list.add(item);
		return item;
	}

	public void addItem(FamilyPromotionInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FamilyPromotionInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FamilyPromotionInfoArrayItem implements IMessageEncoder {
		private long iD;
		private int partAFamilyId;
		private String partAFamilyName;
		private int partBFamilyId;
		private String partBFamilyName;
		private int winFamilyId;
		private BattleInfoArray battleInfoArray;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler partAFamilyIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PartAFamilyId");
		private static IntMessageParameterHandler partBFamilyIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PartBFamilyId");
		private static IntMessageParameterHandler winFamilyIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("WinFamilyId");

		public static FamilyPromotionInfoArrayItem create() {
			FamilyPromotionInfoArrayItem item = new FamilyPromotionInfoArrayItem();
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
		 * @return the partAFamilyId
		 */
		public int getPartAFamilyId() {
			return partAFamilyId;
		}

		/**
		 * @param partAFamilyId
		 *            the partAFamilyId to set
		 */
		public void setPartAFamilyId(int partAFamilyId) {
			this.partAFamilyId = partAFamilyId;
		}
		/**
		 * @return the partAFamilyName
		 */
		public String getPartAFamilyName() {
			return partAFamilyName;
		}

		/**
		 * @param partAFamilyName
		 *            the partAFamilyName to set
		 */
		public void setPartAFamilyName(String partAFamilyName) {
			this.partAFamilyName = partAFamilyName;
		}
		/**
		 * @return the partBFamilyId
		 */
		public int getPartBFamilyId() {
			return partBFamilyId;
		}

		/**
		 * @param partBFamilyId
		 *            the partBFamilyId to set
		 */
		public void setPartBFamilyId(int partBFamilyId) {
			this.partBFamilyId = partBFamilyId;
		}
		/**
		 * @return the partBFamilyName
		 */
		public String getPartBFamilyName() {
			return partBFamilyName;
		}

		/**
		 * @param partBFamilyName
		 *            the partBFamilyName to set
		 */
		public void setPartBFamilyName(String partBFamilyName) {
			this.partBFamilyName = partBFamilyName;
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
		 * @return the battleInfoArray
		 */
		public BattleInfoArray getBattleInfoArray() {
			return battleInfoArray;
		}

		/**
		 * @param battleInfoArray
		 *            the battleInfoArray to set
		 */
		public void setBattleInfoArray(BattleInfoArray battleInfoArray) {
			this.battleInfoArray = battleInfoArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.partAFamilyId);
			data.writeString(this.partAFamilyName);
			data.writeInt(this.partBFamilyId);
			data.writeString(this.partBFamilyName);
			data.writeInt(this.winFamilyId);
			battleInfoArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.partAFamilyId = data.getInt();
			this.partAFamilyName = data.getString();
			this.partBFamilyId = data.getInt();
			this.partBFamilyName = data.getString();
			this.winFamilyId = data.getInt();
			battleInfoArray = BattleInfoArray.create();
			battleInfoArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!partAFamilyIdHandler.validate(partAFamilyId)) {
				return false;
			}
			if (!partBFamilyIdHandler.validate(partBFamilyId)) {
				return false;
			}
			if (!winFamilyIdHandler.validate(winFamilyId)) {
				return false;
			}
			if (!battleInfoArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("partAFamilyId:").append(this.partAFamilyId).append(", ");
			bb.append("partAFamilyName:").append(this.partAFamilyName).append(", ");
			bb.append("partBFamilyId:").append(this.partBFamilyId).append(", ");
			bb.append("partBFamilyName:").append(this.partBFamilyName).append(", ");
			bb.append("winFamilyId:").append(this.winFamilyId).append(", ");
			bb.append("battleInfoArray:").append(battleInfoArray.toString());
			return bb.toString();	
		}
	}
}