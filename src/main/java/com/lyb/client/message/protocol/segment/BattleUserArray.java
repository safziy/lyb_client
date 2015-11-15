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
public class BattleUserArray implements IMessageEncoder {
	private List<BattleUserArrayItem> list = new LinkedList<BattleUserArrayItem>();

	public List<BattleUserArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleUserArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getCareer());
			data.writeInt(item.getStandPoint());
			data.writeLong(item.getBattleUnitID());
			data.writeInt(item.getCurrentRage());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleUserArrayItem item = BattleUserArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setCareer(data.getInt());
			item.setStandPoint(data.getInt());
			item.setBattleUnitID(data.getLong());
			item.setCurrentRage(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleUserArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleUserArray create() {
		BattleUserArray array = new BattleUserArray();
		return array;
	}

	public static BattleUserArrayItem createItem() {
		BattleUserArrayItem item = new BattleUserArrayItem();
		return item;
	}

	public BattleUserArrayItem addData(long userId, String userName, int career, int standPoint, long battleUnitID, int currentRage) {
		BattleUserArrayItem item = new BattleUserArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setCareer(career);
		item.setStandPoint(standPoint);
		item.setBattleUnitID(battleUnitID);
		item.setCurrentRage(currentRage);
		list.add(item);
		return item;
	}

	public void addItem(BattleUserArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleUserArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleUserArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int career;
		private int standPoint;
		private long battleUnitID;
		private int currentRage;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler standPointHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StandPoint");
		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static IntMessageParameterHandler currentRageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CurrentRage");

		public static BattleUserArrayItem create() {
			BattleUserArrayItem item = new BattleUserArrayItem();
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
		 * @return the career
		 */
		public int getCareer() {
			return career;
		}

		/**
		 * @param career
		 *            the career to set
		 */
		public void setCareer(int career) {
			this.career = career;
		}
		/**
		 * @return the standPoint
		 */
		public int getStandPoint() {
			return standPoint;
		}

		/**
		 * @param standPoint
		 *            the standPoint to set
		 */
		public void setStandPoint(int standPoint) {
			this.standPoint = standPoint;
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
		 * @return the currentRage
		 */
		public int getCurrentRage() {
			return currentRage;
		}

		/**
		 * @param currentRage
		 *            the currentRage to set
		 */
		public void setCurrentRage(int currentRage) {
			this.currentRage = currentRage;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.career);
			data.writeInt(this.standPoint);
			data.writeLong(this.battleUnitID);
			data.writeInt(this.currentRage);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.career = data.getInt();
			this.standPoint = data.getInt();
			this.battleUnitID = data.getLong();
			this.currentRage = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!standPointHandler.validate(standPoint)) {
				return false;
			}
			if (!battleUnitIDHandler.validate(battleUnitID)) {
				return false;
			}
			if (!currentRageHandler.validate(currentRage)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("standPoint:").append(this.standPoint).append(", ");
			bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
			bb.append("currentRage:").append(this.currentRage);
			return bb.toString();	
		}
	}
}