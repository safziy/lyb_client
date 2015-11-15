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
public class GeneralIdArray implements IMessageEncoder {
	private List<GeneralIdArrayItem> list = new LinkedList<GeneralIdArrayItem>();

	public List<GeneralIdArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (GeneralIdArrayItem item : list) {
			data.writeInt(item.getPlace());
			data.writeLong(item.getGeneralId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			GeneralIdArrayItem item = GeneralIdArrayItem.create();
			item.setPlace(data.getInt());
			item.setGeneralId(data.getLong());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (GeneralIdArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static GeneralIdArray create() {
		GeneralIdArray array = new GeneralIdArray();
		return array;
	}

	public static GeneralIdArrayItem createItem() {
		GeneralIdArrayItem item = new GeneralIdArrayItem();
		return item;
	}

	public GeneralIdArrayItem addData(int place, long generalId) {
		GeneralIdArrayItem item = new GeneralIdArrayItem();
		item.setPlace(place);
		item.setGeneralId(generalId);
		list.add(item);
		return item;
	}

	public void addItem(GeneralIdArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (GeneralIdArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class GeneralIdArrayItem implements IMessageEncoder {
		private int place;
		private long generalId;

		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");
		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");

		public static GeneralIdArrayItem create() {
			GeneralIdArrayItem item = new GeneralIdArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.place);
			data.writeLong(this.generalId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.place = data.getInt();
			this.generalId = data.getLong();
		}
	
		@Override
		public boolean validate() {
			if (!placeHandler.validate(place)) {
				return false;
			}
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("place:").append(this.place).append(", ");
			bb.append("generalId:").append(this.generalId);
			return bb.toString();	
		}
	}
}