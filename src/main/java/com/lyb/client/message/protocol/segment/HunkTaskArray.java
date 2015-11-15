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
public class HunkTaskArray implements IMessageEncoder {
	private List<HunkTaskArrayItem> list = new LinkedList<HunkTaskArrayItem>();

	public List<HunkTaskArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (HunkTaskArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeLong(item.getID());
			data.writeInt(item.getParam());
			data.writeInt(item.getBooleanValue());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			HunkTaskArrayItem item = HunkTaskArrayItem.create();
			item.setPlace(data.getInt());
			item.setID(data.getLong());
			item.setParam(data.getInt());
			item.setBooleanValue(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (HunkTaskArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static HunkTaskArray create() {
		HunkTaskArray array = new HunkTaskArray();
		return array;
	}

	public static HunkTaskArrayItem createItem() {
		HunkTaskArrayItem item = new HunkTaskArrayItem();
		return item;
	}

	public HunkTaskArrayItem addData(int place, long iD, int param, int booleanValue) {
		HunkTaskArrayItem item = new HunkTaskArrayItem();
		item.setPlace(place);
		item.setID(iD);
		item.setParam(param);
		item.setBooleanValue(booleanValue);
		list.add(item);
		return item;
	}

	public void addItem(HunkTaskArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (HunkTaskArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class HunkTaskArrayItem implements IMessageEncoder {
		private int place;
		private long iD;
		private int param;
		private int booleanValue;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler paramHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");

		public static HunkTaskArrayItem create() {
			HunkTaskArrayItem item = new HunkTaskArrayItem();
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
		 * @return the param
		 */
		public int getParam() {
			return param;
		}

		/**
		 * @param param
		 *            the param to set
		 */
		public void setParam(int param) {
			this.param = param;
		}
		/**
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeLong(this.iD);
			data.writeInt(this.param);
			data.writeInt(this.booleanValue);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.iD = data.getLong();
			this.param = data.getInt();
			this.booleanValue = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!paramHandler.validate(param)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("param:").append(this.param).append(", ");
			bb.append("booleanValue:").append(this.booleanValue);
			return bb.toString();	
		}
	}
}