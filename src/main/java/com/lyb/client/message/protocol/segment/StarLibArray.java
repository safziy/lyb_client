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
public class StarLibArray implements IMessageEncoder {
	private List<StarLibArrayItem> list = new LinkedList<StarLibArrayItem>();

	public List<StarLibArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (StarLibArrayItem item : list) {
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
			StarLibArrayItem item = StarLibArrayItem.create();
			item.setStarId(data.getInt());
			item.setConfigId(data.getInt());
			item.setPlace(data.getInt());
			item.setExperience(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (StarLibArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static StarLibArray create() {
		StarLibArray array = new StarLibArray();
		return array;
	}

	public static StarLibArrayItem createItem() {
		StarLibArrayItem item = new StarLibArrayItem();
		return item;
	}

	public StarLibArrayItem addData(int starId, int configId, int place, int experience) {
		StarLibArrayItem item = new StarLibArrayItem();
		item.setStarId(starId);
		item.setConfigId(configId);
		item.setPlace(place);
		item.setExperience(experience);
		list.add(item);
		return item;
	}

	public void addItem(StarLibArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (StarLibArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class StarLibArrayItem implements IMessageEncoder {
		private int starId;
		private int configId;
		private int place;
		private int experience;

		private static IntMessageParameterHandler starIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");

		public static StarLibArrayItem create() {
			StarLibArrayItem item = new StarLibArrayItem();
			return item;
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
			this.starId = data.getInt();
			this.configId = data.getInt();
			this.place = data.getInt();
			this.experience = data.getInt();
		}
	
		@Override
		public boolean validate() {
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
			bb.append("starId:").append(this.starId).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("place:").append(this.place).append(", ");
			bb.append("experience:").append(this.experience);
			return bb.toString();	
		}
	}
}