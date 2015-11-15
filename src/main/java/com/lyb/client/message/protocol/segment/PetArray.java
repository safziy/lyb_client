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
public class PetArray implements IMessageEncoder {
	private List<PetArrayItem> list = new LinkedList<PetArrayItem>();

	public List<PetArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PetArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getExperience());
			item.getUnitPropertyArray().encode(data);
			data.writeInt(item.getZhanli());
			data.writeInt(item.getPetTempIntell());
			data.writeInt(item.getParam1());
			item.getPetActiveSkillArray().encode(data);
			data.writeInt(item.getParam2());
			item.getPetPassiveSkillArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PetArrayItem item = PetArrayItem.create();
			item.setID(data.getLong());
			item.setConfigId(data.getInt());
			item.setExperience(data.getInt());
			item.setUnitPropertyArray(UnitPropertyArray.create());
			item.getUnitPropertyArray().decode(data);
			item.setZhanli(data.getInt());
			item.setPetTempIntell(data.getInt());
			item.setParam1(data.getInt());
			item.setPetActiveSkillArray(PetActiveSkillArray.create());
			item.getPetActiveSkillArray().decode(data);
			item.setParam2(data.getInt());
			item.setPetPassiveSkillArray(PetPassiveSkillArray.create());
			item.getPetPassiveSkillArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PetArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PetArray create() {
		PetArray array = new PetArray();
		return array;
	}

	public static PetArrayItem createItem() {
		PetArrayItem item = new PetArrayItem();
		return item;
	}

	public PetArrayItem addData(long iD, int configId, int experience, UnitPropertyArray unitPropertyArray, int zhanli, int petTempIntell, int param1, PetActiveSkillArray petActiveSkillArray, int param2, PetPassiveSkillArray petPassiveSkillArray) {
		PetArrayItem item = new PetArrayItem();
		item.setID(iD);
		item.setConfigId(configId);
		item.setExperience(experience);
		item.setUnitPropertyArray(unitPropertyArray);
		item.setZhanli(zhanli);
		item.setPetTempIntell(petTempIntell);
		item.setParam1(param1);
		item.setPetActiveSkillArray(petActiveSkillArray);
		item.setParam2(param2);
		item.setPetPassiveSkillArray(petPassiveSkillArray);
		list.add(item);
		return item;
	}

	public void addItem(PetArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PetArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PetArrayItem implements IMessageEncoder {
		private long iD;
		private int configId;
		private int experience;
		private UnitPropertyArray unitPropertyArray;
		private int zhanli;
		private int petTempIntell;
		private int param1;
		private PetActiveSkillArray petActiveSkillArray;
		private int param2;
		private PetPassiveSkillArray petPassiveSkillArray;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
		private static IntMessageParameterHandler petTempIntellHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PetTempIntell");
		private static IntMessageParameterHandler param1Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param1");
		private static IntMessageParameterHandler param2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param2");

		public static PetArrayItem create() {
			PetArrayItem item = new PetArrayItem();
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
		 * @return the experience
		 */
		public int getExperience() {
			return experience;
		}

		/**
		 * @param experience
		 *            the experience to set
		 */
		public void setExperience(int experience) {
			this.experience = experience;
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
		 * @return the zhanli
		 */
		public int getZhanli() {
			return zhanli;
		}

		/**
		 * @param zhanli
		 *            the zhanli to set
		 */
		public void setZhanli(int zhanli) {
			this.zhanli = zhanli;
		}
		/**
		 * @return the petTempIntell
		 */
		public int getPetTempIntell() {
			return petTempIntell;
		}

		/**
		 * @param petTempIntell
		 *            the petTempIntell to set
		 */
		public void setPetTempIntell(int petTempIntell) {
			this.petTempIntell = petTempIntell;
		}
		/**
		 * @return the param1
		 */
		public int getParam1() {
			return param1;
		}

		/**
		 * @param param1
		 *            the param1 to set
		 */
		public void setParam1(int param1) {
			this.param1 = param1;
		}
		/**
		 * @return the petActiveSkillArray
		 */
		public PetActiveSkillArray getPetActiveSkillArray() {
			return petActiveSkillArray;
		}

		/**
		 * @param petActiveSkillArray
		 *            the petActiveSkillArray to set
		 */
		public void setPetActiveSkillArray(PetActiveSkillArray petActiveSkillArray) {
			this.petActiveSkillArray = petActiveSkillArray;
		}
		/**
		 * @return the param2
		 */
		public int getParam2() {
			return param2;
		}

		/**
		 * @param param2
		 *            the param2 to set
		 */
		public void setParam2(int param2) {
			this.param2 = param2;
		}
		/**
		 * @return the petPassiveSkillArray
		 */
		public PetPassiveSkillArray getPetPassiveSkillArray() {
			return petPassiveSkillArray;
		}

		/**
		 * @param petPassiveSkillArray
		 *            the petPassiveSkillArray to set
		 */
		public void setPetPassiveSkillArray(PetPassiveSkillArray petPassiveSkillArray) {
			this.petPassiveSkillArray = petPassiveSkillArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.configId);
			data.writeInt(this.experience);
			unitPropertyArray.encode(data);
			data.writeInt(this.zhanli);
			data.writeInt(this.petTempIntell);
			data.writeInt(this.param1);
			petActiveSkillArray.encode(data);
			data.writeInt(this.param2);
			petPassiveSkillArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.configId = data.getInt();
			this.experience = data.getInt();
			unitPropertyArray = UnitPropertyArray.create();
			unitPropertyArray.decode(data);
			this.zhanli = data.getInt();
			this.petTempIntell = data.getInt();
			this.param1 = data.getInt();
			petActiveSkillArray = PetActiveSkillArray.create();
			petActiveSkillArray.decode(data);
			this.param2 = data.getInt();
			petPassiveSkillArray = PetPassiveSkillArray.create();
			petPassiveSkillArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!experienceHandler.validate(experience)) {
				return false;
			}
			if (!unitPropertyArray.validate()) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			if (!petTempIntellHandler.validate(petTempIntell)) {
				return false;
			}
			if (!param1Handler.validate(param1)) {
				return false;
			}
			if (!petActiveSkillArray.validate()) {
				return false;
			}
			if (!param2Handler.validate(param2)) {
				return false;
			}
			if (!petPassiveSkillArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("experience:").append(this.experience).append(", ");
			bb.append("unitPropertyArray:").append(unitPropertyArray.toString()).append(", ");
			bb.append("zhanli:").append(this.zhanli).append(", ");
			bb.append("petTempIntell:").append(this.petTempIntell).append(", ");
			bb.append("param1:").append(this.param1).append(", ");
			bb.append("petActiveSkillArray:").append(petActiveSkillArray.toString()).append(", ");
			bb.append("param2:").append(this.param2).append(", ");
			bb.append("petPassiveSkillArray:").append(petPassiveSkillArray.toString());
			return bb.toString();	
		}
	}
}