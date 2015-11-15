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
public class ChangeStarArray implements IMessageEncoder {
	private List<ChangeStarArrayItem> list = new LinkedList<ChangeStarArrayItem>();

	public List<ChangeStarArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ChangeStarArrayItem item : list) {
			data.writeInt(item.getStarId());
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
			ChangeStarArrayItem item = ChangeStarArrayItem.create();
			item.setStarId(data.getInt());
			item.setPlace(data.getInt());
			item.setExperience(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ChangeStarArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ChangeStarArray create() {
		ChangeStarArray array = new ChangeStarArray();
		return array;
	}

	public static ChangeStarArrayItem createItem() {
		ChangeStarArrayItem item = new ChangeStarArrayItem();
		return item;
	}

	public ChangeStarArrayItem addData(int starId, int place, int experience) {
		ChangeStarArrayItem item = new ChangeStarArrayItem();
		item.setStarId(starId);
		item.setPlace(place);
		item.setExperience(experience);
		list.add(item);
		return item;
	}

	public void addItem(ChangeStarArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ChangeStarArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ChangeStarArrayItem implements IMessageEncoder {
		private int starId;
		private int place;
		private int experience;

		private static IntMessageParameterHandler starIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarId");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");

		public static ChangeStarArrayItem create() {
			ChangeStarArrayItem item = new ChangeStarArrayItem();
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
			data.writeInt(this.place);
			data.writeInt(this.experience);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.starId = data.getInt();
			this.place = data.getInt();
			this.experience = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!starIdHandler.validate(starId)) {
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
			bb.append("place:").append(this.place).append(", ");
			bb.append("experience:").append(this.experience);
			return bb.toString();	
		}
	}
}