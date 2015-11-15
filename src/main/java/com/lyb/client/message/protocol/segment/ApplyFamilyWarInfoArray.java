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
public class ApplyFamilyWarInfoArray implements IMessageEncoder {
	private List<ApplyFamilyWarInfoArrayItem> list = new LinkedList<ApplyFamilyWarInfoArrayItem>();

	public List<ApplyFamilyWarInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ApplyFamilyWarInfoArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeLong(item.getFamilyId());
			data.writeString(item.getFamilyName());
			data.writeInt(item.getState());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ApplyFamilyWarInfoArrayItem item = ApplyFamilyWarInfoArrayItem.create();
			item.setPlace(data.getInt());
			item.setFamilyId(data.getLong());
			item.setFamilyName(data.getString());
			item.setState(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ApplyFamilyWarInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ApplyFamilyWarInfoArray create() {
		ApplyFamilyWarInfoArray array = new ApplyFamilyWarInfoArray();
		return array;
	}

	public static ApplyFamilyWarInfoArrayItem createItem() {
		ApplyFamilyWarInfoArrayItem item = new ApplyFamilyWarInfoArrayItem();
		return item;
	}

	public ApplyFamilyWarInfoArrayItem addData(int place, long familyId, String familyName, int state) {
		ApplyFamilyWarInfoArrayItem item = new ApplyFamilyWarInfoArrayItem();
		item.setPlace(place);
		item.setFamilyId(familyId);
		item.setFamilyName(familyName);
		item.setState(state);
		list.add(item);
		return item;
	}

	public void addItem(ApplyFamilyWarInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ApplyFamilyWarInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ApplyFamilyWarInfoArrayItem implements IMessageEncoder {
		private int place;
		private long familyId;
		private String familyName;
		private int state;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

		public static ApplyFamilyWarInfoArrayItem create() {
			ApplyFamilyWarInfoArrayItem item = new ApplyFamilyWarInfoArrayItem();
			return item;
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
		 * @return the familyId
		 */
		public long getFamilyId() {
			return familyId;
		}

		/**
		 * @param familyId
		 *            the familyId to set
		 */
		public void setFamilyId(long familyId) {
			this.familyId = familyId;
		}
		/**
		 * @return the familyName
		 */
		public String getFamilyName() {
			return familyName;
		}

		/**
		 * @param familyName
		 *            the familyName to set
		 */
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeLong(this.familyId);
			data.writeString(this.familyName);
			data.writeInt(this.state);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.familyId = data.getLong();
			this.familyName = data.getString();
			this.state = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!familyIdHandler.validate(familyId)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("familyId:").append(this.familyId).append(", ");
			bb.append("familyName:").append(this.familyName).append(", ");
			bb.append("state:").append(this.state);
			return bb.toString();	
		}
	}
}