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
public class BattleUnitIDArray implements IMessageEncoder {
	private List<BattleUnitIDArrayItem> list = new LinkedList<BattleUnitIDArrayItem>();

	public List<BattleUnitIDArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleUnitIDArrayItem item : list) {
			data.writeInt(item.getMonsterId());
			data.writeInt(item.getRound());
			data.writeLong(item.getBattleUnitID());
			data.writeInt(item.getPlace());
			data.writeInt(item.getLevel());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleUnitIDArrayItem item = BattleUnitIDArrayItem.create();
			item.setMonsterId(data.getInt());
			item.setRound(data.getInt());
			item.setBattleUnitID(data.getLong());
			item.setPlace(data.getInt());
			item.setLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleUnitIDArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleUnitIDArray create() {
		BattleUnitIDArray array = new BattleUnitIDArray();
		return array;
	}

	public static BattleUnitIDArrayItem createItem() {
		BattleUnitIDArrayItem item = new BattleUnitIDArrayItem();
		return item;
	}

	public BattleUnitIDArrayItem addData(int monsterId, int round, long battleUnitID, int place, int level) {
		BattleUnitIDArrayItem item = new BattleUnitIDArrayItem();
		item.setMonsterId(monsterId);
		item.setRound(round);
		item.setBattleUnitID(battleUnitID);
		item.setPlace(place);
		item.setLevel(level);
		list.add(item);
		return item;
	}

	public void addItem(BattleUnitIDArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleUnitIDArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleUnitIDArrayItem implements IMessageEncoder {
		private int monsterId;
		private int round;
		private long battleUnitID;
		private int place;
		private int level;

		private static IntMessageParameterHandler monsterIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MonsterId");
		private static IntMessageParameterHandler roundHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Round");
		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");

		public static BattleUnitIDArrayItem create() {
			BattleUnitIDArrayItem item = new BattleUnitIDArrayItem();
			return item;
		}

		/**
		 * @return the monsterId
		 */
		public int getMonsterId() {
			return monsterId;
		}

		/**
		 * @param monsterId
		 *            the monsterId to set
		 */
		public void setMonsterId(int monsterId) {
			this.monsterId = monsterId;
		}
		/**
		 * @return the round
		 */
		public int getRound() {
			return round;
		}

		/**
		 * @param round
		 *            the round to set
		 */
		public void setRound(int round) {
			this.round = round;
		}
		/**
		 * @return the battleUnitID
		 */
		public long getBattleUnitID() {
			return battleUnitID;
		}

		/**
		 * @param battleUnitID
		 *            the battleUnitID to set
		 */
		public void setBattleUnitID(long battleUnitID) {
			this.battleUnitID = battleUnitID;
		}
		/**
		 * @return the place
		 */
		public int getPlace() {
			return place;
		}

		/**
		 * @param place
		 *            the place to set
		 */
		public void setPlace(int place) {
			this.place = place;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.monsterId);
			data.writeInt(this.round);
			data.writeLong(this.battleUnitID);
			data.writeInt(this.place);
			data.writeInt(this.level);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.monsterId = data.getInt();
			this.round = data.getInt();
			this.battleUnitID = data.getLong();
			this.place = data.getInt();
			this.level = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!monsterIdHandler.validate(monsterId)) {
				return false;
			}
			if (!roundHandler.validate(round)) {
				return false;
			}
			if (!battleUnitIDHandler.validate(battleUnitID)) {
				return false;
			}
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("monsterId:").append(this.monsterId).append(", ");
			bb.append("round:").append(this.round).append(", ");
			bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
			bb.append("place:").append(this.place).append(", ");
			bb.append("level:").append(this.level);
			return bb.toString();	
		}
	}
}