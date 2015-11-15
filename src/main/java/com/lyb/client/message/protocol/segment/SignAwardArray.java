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
public class SignAwardArray implements IMessageEncoder {
	private List<SignAwardArrayItem> list = new LinkedList<SignAwardArrayItem>();

	public List<SignAwardArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (SignAwardArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeLong(item.getID());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			SignAwardArrayItem item = SignAwardArrayItem.create();
			item.setPlace(data.getInt());
			item.setID(data.getLong());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (SignAwardArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static SignAwardArray create() {
		SignAwardArray array = new SignAwardArray();
		return array;
	}

	public static SignAwardArrayItem createItem() {
		SignAwardArrayItem item = new SignAwardArrayItem();
		return item;
	}

	public SignAwardArrayItem addData(int place, long iD) {
		SignAwardArrayItem item = new SignAwardArrayItem();
		item.setPlace(place);
		item.setID(iD);
		list.add(item);
		return item;
	}

	public void addItem(SignAwardArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (SignAwardArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class SignAwardArrayItem implements IMessageEncoder {
		private int place;
		private long iD;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");

		public static SignAwardArrayItem create() {
			SignAwardArrayItem item = new SignAwardArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeLong(this.iD);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.iD = data.getLong();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!iDHandler.validate(iD)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("iD:").append(this.iD);
			return bb.toString();	
		}
	}
}