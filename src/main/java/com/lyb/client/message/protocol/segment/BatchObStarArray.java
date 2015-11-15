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
public class BatchObStarArray implements IMessageEncoder {
	private List<BatchObStarArrayItem> list = new LinkedList<BatchObStarArrayItem>();

	public List<BatchObStarArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BatchObStarArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getStarId());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getPlace());
			data.writeInt(item.getExperience());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BatchObStarArrayItem item = BatchObStarArrayItem.create();
			item.setID(data.getLong());
			item.setStarId(data.getInt());
			item.setConfigId(data.getInt());
			item.setPlace(data.getInt());
			item.setExperience(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BatchObStarArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BatchObStarArray create() {
		BatchObStarArray array = new BatchObStarArray();
		return array;
	}

	public static BatchObStarArrayItem createItem() {
		BatchObStarArrayItem item = new BatchObStarArrayItem();
		return item;
	}

	public BatchObStarArrayItem addData(long iD, int starId, int configId, int place, int experience) {
		BatchObStarArrayItem item = new BatchObStarArrayItem();
		item.setID(iD);
		item.setStarId(starId);
		item.setConfigId(configId);
		item.setPlace(place);
		item.setExperience(experience);
		list.add(item);
		return item;
	}

	public void addItem(BatchObStarArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BatchObStarArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BatchObStarArrayItem implements IMessageEncoder {
		private long iD;
		private int starId;
		private int configId;
		private int place;
		private int experience;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler starIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");

		public static BatchObStarArrayItem create() {
			BatchObStarArrayItem item = new BatchObStarArrayItem();
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
		 * @return the starId
		 */
		public int getStarId() {
			return starId;
		}

		/**
		 * @param starId
		 *            the starId to set
		 */
		public void setStarId(int starId) {
			this.starId = starId;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.starId);
			data.writeInt(this.configId);
			data.writeInt(this.place);
			data.writeInt(this.experience);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.starId = data.getInt();
			this.configId = data.getInt();
			this.place = data.getInt();
			this.experience = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!starIdHandler.validate(starId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!experienceHandler.validate(experience)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("starId:").append(this.starId).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("place:").append(this.place).append(", ");
			bb.append("experience:").append(this.experience);
			return bb.toString();	
		}
	}
}