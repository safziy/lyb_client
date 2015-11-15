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
public class FamilyLogArray implements IMessageEncoder {
	private List<FamilyLogArrayItem> list = new LinkedList<FamilyLogArrayItem>();

	public List<FamilyLogArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FamilyLogArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getParamStr1());
			data.writeString(item.getParamStr2());
			data.writeString(item.getParamStr3());
			data.writeInt(item.getTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FamilyLogArrayItem item = FamilyLogArrayItem.create();
			item.setID(data.getLong());
			item.setParamStr1(data.getString());
			item.setParamStr2(data.getString());
			item.setParamStr3(data.getString());
			item.setTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FamilyLogArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FamilyLogArray create() {
		FamilyLogArray array = new FamilyLogArray();
		return array;
	}

	public static FamilyLogArrayItem createItem() {
		FamilyLogArrayItem item = new FamilyLogArrayItem();
		return item;
	}

	public FamilyLogArrayItem addData(long iD, String paramStr1, String paramStr2, String paramStr3, int time) {
		FamilyLogArrayItem item = new FamilyLogArrayItem();
		item.setID(iD);
		item.setParamStr1(paramStr1);
		item.setParamStr2(paramStr2);
		item.setParamStr3(paramStr3);
		item.setTime(time);
		list.add(item);
		return item;
	}

	public void addItem(FamilyLogArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FamilyLogArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FamilyLogArrayItem implements IMessageEncoder {
		private long iD;
		private String paramStr1;
		private String paramStr2;
		private String paramStr3;
		private int time;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

		public static FamilyLogArrayItem create() {
			FamilyLogArrayItem item = new FamilyLogArrayItem();
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
		 * @return the paramStr1
		 */
		public String getParamStr1() {
			return paramStr1;
		}

		/**
		 * @param paramStr1
		 *            the paramStr1 to set
		 */
		public void setParamStr1(String paramStr1) {
			this.paramStr1 = paramStr1;
		}
		/**
		 * @return the paramStr2
		 */
		public String getParamStr2() {
			return paramStr2;
		}

		/**
		 * @param paramStr2
		 *            the paramStr2 to set
		 */
		public void setParamStr2(String paramStr2) {
			this.paramStr2 = paramStr2;
		}
		/**
		 * @return the paramStr3
		 */
		public String getParamStr3() {
			return paramStr3;
		}

		/**
		 * @param paramStr3
		 *            the paramStr3 to set
		 */
		public void setParamStr3(String paramStr3) {
			this.paramStr3 = paramStr3;
		}
		/**
		 * @return the time
		 */
		public int getTime() {
			return time;
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(int time) {
			this.time = time;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeString(this.paramStr1);
			data.writeString(this.paramStr2);
			data.writeString(this.paramStr3);
			data.writeInt(this.time);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.paramStr1 = data.getString();
			this.paramStr2 = data.getString();
			this.paramStr3 = data.getString();
			this.time = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("paramStr1:").append(this.paramStr1).append(", ");
			bb.append("paramStr2:").append(this.paramStr2).append(", ");
			bb.append("paramStr3:").append(this.paramStr3).append(", ");
			bb.append("time:").append(this.time);
			return bb.toString();	
		}
	}
}