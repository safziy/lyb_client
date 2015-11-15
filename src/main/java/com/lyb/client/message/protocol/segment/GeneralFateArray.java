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
public class GeneralFateArray implements IMessageEncoder {
	private List<GeneralFateArrayItem> list = new LinkedList<GeneralFateArrayItem>();

	public List<GeneralFateArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (GeneralFateArrayItem item : list) {
			data.writeLong(item.getGeneralId());
			item.getFateLevelArray().encode(data);
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			GeneralFateArrayItem item = GeneralFateArrayItem.create();
			item.setGeneralId(data.getLong());
			item.setFateLevelArray(FateLevelArray.create());
			item.getFateLevelArray().decode(data);
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (GeneralFateArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static GeneralFateArray create() {
		GeneralFateArray array = new GeneralFateArray();
		return array;
	}

	public static GeneralFateArrayItem createItem() {
		GeneralFateArrayItem item = new GeneralFateArrayItem();
		return item;
	}

	public GeneralFateArrayItem addData(long generalId, FateLevelArray fateLevelArray) {
		GeneralFateArrayItem item = new GeneralFateArrayItem();
		item.setGeneralId(generalId);
		item.setFateLevelArray(fateLevelArray);
		list.add(item);
		return item;
	}

	public void addItem(GeneralFateArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (GeneralFateArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class GeneralFateArrayItem implements IMessageEncoder {
		private long generalId;
		private FateLevelArray fateLevelArray;

		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");

		public static GeneralFateArrayItem create() {
			GeneralFateArrayItem item = new GeneralFateArrayItem();
			return item;
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
		 * @return the fateLevelArray
		 */
		public FateLevelArray getFateLevelArray() {
			return fateLevelArray;
		}

		/**
		 * @param fateLevelArray
		 *            the fateLevelArray to set
		 */
		public void setFateLevelArray(FateLevelArray fateLevelArray) {
			this.fateLevelArray = fateLevelArray;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.generalId);
			fateLevelArray.encode(data);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalId = data.getLong();
			fateLevelArray = FateLevelArray.create();
			fateLevelArray.decode(data);
		}
	
		@Override
		public boolean validate() {
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!fateLevelArray.validate()) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("fateLevelArray:").append(fateLevelArray.toString());
			return bb.toString();	
		}
	}
}