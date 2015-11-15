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
public class MonsterInvadeArray implements IMessageEncoder {
	private List<MonsterInvadeArrayItem> list = new LinkedList<MonsterInvadeArrayItem>();

	public List<MonsterInvadeArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (MonsterInvadeArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getBattleFieldId());
			data.writeInt(item.getState());
			data.writeInt(item.getCoordinateX());
			data.writeInt(item.getCoordinateY());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			MonsterInvadeArrayItem item = MonsterInvadeArrayItem.create();
			item.setID(data.getLong());
			item.setBattleFieldId(data.getInt());
			item.setState(data.getInt());
			item.setCoordinateX(data.getInt());
			item.setCoordinateY(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (MonsterInvadeArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static MonsterInvadeArray create() {
		MonsterInvadeArray array = new MonsterInvadeArray();
		return array;
	}

	public static MonsterInvadeArrayItem createItem() {
		MonsterInvadeArrayItem item = new MonsterInvadeArrayItem();
		return item;
	}

	public MonsterInvadeArrayItem addData(long iD, int battleFieldId, int state, int coordinateX, int coordinateY) {
		MonsterInvadeArrayItem item = new MonsterInvadeArrayItem();
		item.setID(iD);
		item.setBattleFieldId(battleFieldId);
		item.setState(state);
		item.setCoordinateX(coordinateX);
		item.setCoordinateY(coordinateY);
		list.add(item);
		return item;
	}

	public void addItem(MonsterInvadeArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (MonsterInvadeArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class MonsterInvadeArrayItem implements IMessageEncoder {
		private long iD;
		private int battleFieldId;
		private int state;
		private int coordinateX;
		private int coordinateY;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler battleFieldIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleFieldId");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
		private static IntMessageParameterHandler coordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CoordinateX");
		private static IntMessageParameterHandler coordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CoordinateY");

		public static MonsterInvadeArrayItem create() {
			MonsterInvadeArrayItem item = new MonsterInvadeArrayItem();
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
		 * @return the battleFieldId
		 */
		public int getBattleFieldId() {
			return battleFieldId;
		}

		/**
		 * @param battleFieldId
		 *            the battleFieldId to set
		 */
		public void setBattleFieldId(int battleFieldId) {
			this.battleFieldId = battleFieldId;
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
		 * @return the coordinateX
		 */
		public int getCoordinateX() {
			return coordinateX;
		}

		/**
		 * @param coordinateX
		 *            the coordinateX to set
		 */
		public void setCoordinateX(int coordinateX) {
			this.coordinateX = coordinateX;
		}
		/**
		 * @return the coordinateY
		 */
		public int getCoordinateY() {
			return coordinateY;
		}

		/**
		 * @param coordinateY
		 *            the coordinateY to set
		 */
		public void setCoordinateY(int coordinateY) {
			this.coordinateY = coordinateY;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.battleFieldId);
			data.writeInt(this.state);
			data.writeInt(this.coordinateX);
			data.writeInt(this.coordinateY);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.battleFieldId = data.getInt();
			this.state = data.getInt();
			this.coordinateX = data.getInt();
			this.coordinateY = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!battleFieldIdHandler.validate(battleFieldId)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			if (!coordinateXHandler.validate(coordinateX)) {
				return false;
			}
			if (!coordinateYHandler.validate(coordinateY)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("battleFieldId:").append(this.battleFieldId).append(", ");
			bb.append("state:").append(this.state).append(", ");
			bb.append("coordinateX:").append(this.coordinateX).append(", ");
			bb.append("coordinateY:").append(this.coordinateY);
			return bb.toString();	
		}
	}
}