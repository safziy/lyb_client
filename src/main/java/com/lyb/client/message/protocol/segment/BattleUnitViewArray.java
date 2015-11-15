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
public class BattleUnitViewArray implements IMessageEncoder {
	private List<BattleUnitViewArrayItem> list = new LinkedList<BattleUnitViewArrayItem>();

	public List<BattleUnitViewArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleUnitViewArrayItem item : list) {
			data.writeLong(item.getBattleUnitID());
			data.writeInt(item.getType());
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getCareer());
			data.writeInt(item.getLevel());
			data.writeInt(item.getMaxHP());
			item.getSkillArray().encode(data);
			data.writeInt(item.getPlace());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleUnitViewArrayItem item = BattleUnitViewArrayItem.create();
			item.setBattleUnitID(data.getLong());
			item.setType(data.getInt());
			item.setGeneralId(data.getLong());
			item.setCareer(data.getInt());
			item.setLevel(data.getInt());
			item.setMaxHP(data.getInt());
			item.setSkillArray(SkillArray.create());
			item.getSkillArray().decode(data);
			item.setPlace(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleUnitViewArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleUnitViewArray create() {
		BattleUnitViewArray array = new BattleUnitViewArray();
		return array;
	}

	public static BattleUnitViewArrayItem createItem() {
		BattleUnitViewArrayItem item = new BattleUnitViewArrayItem();
		return item;
	}

	public BattleUnitViewArrayItem addData(long battleUnitID, int type, long generalId, int career, int level, int maxHP, SkillArray skillArray, int place) {
		BattleUnitViewArrayItem item = new BattleUnitViewArrayItem();
		item.setBattleUnitID(battleUnitID);
		item.setType(type);
		item.setGeneralId(generalId);
		item.setCareer(career);
		item.setLevel(level);
		item.setMaxHP(maxHP);
		item.setSkillArray(skillArray);
		item.setPlace(place);
		list.add(item);
		return item;
	}

	public void addItem(BattleUnitViewArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleUnitViewArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleUnitViewArrayItem implements IMessageEncoder {
		private long battleUnitID;
		private int type;
		private long generalId;
		private int career;
		private int level;
		private int maxHP;
		private SkillArray skillArray;
		private int place;

		private static LongMessageParameterHandler battleUnitIDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("BattleUnitID");
		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler maxHPHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MaxHP");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");

		public static BattleUnitViewArrayItem create() {
			BattleUnitViewArrayItem item = new BattleUnitViewArrayItem();
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
		 * @return the maxHP
		 */
		public int getMaxHP() {
			return maxHP;
		}

		/**
		 * @param maxHP
		 *            the maxHP to set
		 */
		public void setMaxHP(int maxHP) {
			this.maxHP = maxHP;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.battleUnitID);
			data.writeInt(this.type);
			data.writeLong(this.generalId);
			data.writeInt(this.career);
			data.writeInt(this.level);
			data.writeInt(this.maxHP);
			skillArray.encode(data);
			data.writeInt(this.place);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.battleUnitID = data.getLong();
			this.type = data.getInt();
			this.generalId = data.getLong();
			this.career = data.getInt();
			this.level = data.getInt();
			this.maxHP = data.getInt();
			skillArray = SkillArray.create();
			skillArray.decode(data);
			this.place = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!battleUnitIDHandler.validate(battleUnitID)) {
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
			if (!maxHPHandler.validate(maxHP)) {
				return false;
			}
			if (!skillArray.validate()) {
				return false;
			}
			if (!placeHandler.validate(place)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("battleUnitID:").append(this.battleUnitID).append(", ");
			bb.append("type:").append(this.type).append(", ");
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("maxHP:").append(this.maxHP).append(", ");
			bb.append("skillArray:").append(skillArray.toString()).append(", ");
			bb.append("place:").append(this.place);
			return bb.toString();	
		}
	}
}