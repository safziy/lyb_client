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
public class BattleGeneralArray implements IMessageEncoder {
	private List<BattleGeneralArrayItem> list = new LinkedList<BattleGeneralArrayItem>();

	public List<BattleGeneralArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleGeneralArrayItem item : list) {
			data.writeLong(item.getBattleUnitID());
			data.writeLong(item.getUserId());
			data.writeInt(item.getStandPoint());
			data.writeInt(item.getType());
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getCareer());
			data.writeInt(item.getLevel());
			data.writeInt(item.getPlace());
			item.getSkillArray().encode(data);
			item.getUnitPropertyArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleGeneralArrayItem item = BattleGeneralArrayItem.create();
			item.setBattleUnitID(data.getLong());
			item.setUserId(data.getLong());
			item.setStandPoint(data.getInt());
			item.setType(data.getInt());
			item.setGeneralId(data.getLong());
			item.setCareer(data.getInt());
			item.setLevel(data.getInt());
			item.setPlace(data.getInt());
			item.setSkillArray(SkillArray.create());
			item.getSkillArray().decode(data);
			item.setUnitPropertyArray(UnitPropertyArray.create());
			item.getUnitPropertyArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleGeneralArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleGeneralArray create() {
		BattleGeneralArray array = new BattleGeneralArray();
		return array;
	}

	public static BattleGeneralArrayItem createItem() {
		BattleGeneralArrayItem item = new BattleGeneralArrayItem();
		return item;
	}

	public BattleGeneralArrayItem addData(long battleUnitID, long userId, int standPoint, int type, long generalId, int career, int level, int place, SkillArray skillArray, UnitPropertyArray unitPropertyArray) {
		BattleGeneralArrayItem item = new BattleGeneralArrayItem();
		item.setBattleUnitID(battleUnitID);
		item.setUserId(userId);
		item.setStandPoint(standPoint);
		item.setType(type);
		item.setGeneralId(generalId);
		item.setCareer(career);
		item.setLevel(level);
		item.setPlace(place);
		item.setSkillArray(skillArray);
		item.setUnitPropertyArray(unitPropertyArray);
		list.add(item);
		return item;
	}

	public void addItem(BattleGeneralArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleGeneralArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleGeneralArrayItem implements IMessageEncoder {
		private long battleUnitID;
		private long userId;
		private int standPoint;
		private int type;
		private long generalId;
		private int career;
		private int level;
		private int place;
		private SkillArray skillArray;
		private UnitPropertyArray unitPropertyArray;

		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler standPointHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StandPoint");
		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");

		public static BattleGeneralArrayItem create() {
			BattleGeneralArrayItem item = new BattleGeneralArrayItem();
			return item;
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
		 * @return the generalId
		 */
		public long getGeneralId() {
			return generalId;
		}

		/**
		 * @param generalId
		 *            the generalId to set
		 */
		public void setGeneralId(long generalId) {
			this.generalId = generalId;
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
		 * @return the skillArray
		 */
		public SkillArray getSkillArray() {
			return skillArray;
		}

		/**
		 * @param skillArray
		 *            the skillArray to set
		 */
		public void setSkillArray(SkillArray skillArray) {
			this.skillArray = skillArray;
		}
		/**
		 * @return the unitPropertyArray
		 */
		public UnitPropertyArray getUnitPropertyArray() {
			return unitPropertyArray;
		}

		/**
		 * @param unitPropertyArray
		 *            the unitPropertyArray to set
		 */
		public void setUnitPropertyArray(UnitPropertyArray unitPropertyArray) {
			this.unitPropertyArray = unitPropertyArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.battleUnitID);
			data.writeLong(this.userId);
			data.writeInt(this.standPoint);
			data.writeInt(this.type);
			data.writeLong(this.generalId);
			data.writeInt(this.career);
			data.writeInt(this.level);
			data.writeInt(this.place);
			skillArray.encode(data);
			unitPropertyArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.battleUnitID = data.getLong();
			this.userId = data.getLong();
			this.standPoint = data.getInt();
			this.type = data.getInt();
			this.generalId = data.getLong();
			this.career = data.getInt();
			this.level = data.getInt();
			this.place = data.getInt();
			skillArray = SkillArray.create();
			skillArray.decode(data);
			unitPropertyArray = UnitPropertyArray.create();
			unitPropertyArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!battleUnitIDHandler.validate(battleUnitID)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!standPointHandler.validate(standPoint)) {
				return false;
			}
			if (!typeHandler.validate(type)) {
				return false;
			}
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!skillArray.validate()) {
				return false;
			}
			if (!unitPropertyArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("standPoint:").append(this.standPoint).append(", ");
			bb.append("type:").append(this.type).append(", ");
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("place:").append(this.place).append(", ");
			bb.append("skillArray:").append(skillArray.toString()).append(", ");
			bb.append("unitPropertyArray:").append(unitPropertyArray.toString());
			return bb.toString();	
		}
	}
}