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
public class RecordArray implements IMessageEncoder {
	private List<RecordArrayItem> list = new LinkedList<RecordArrayItem>();

	public List<RecordArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (RecordArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getParamStr1());
			data.writeString(item.getParamStr2());
			data.writeString(item.getParamStr3());
			data.writeString(item.getParamStr4());
			data.writeInt(item.getParam1());
			data.writeInt(item.getParam2());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			RecordArrayItem item = RecordArrayItem.create();
			item.setID(data.getLong());
			item.setParamStr1(data.getString());
			item.setParamStr2(data.getString());
			item.setParamStr3(data.getString());
			item.setParamStr4(data.getString());
			item.setParam1(data.getInt());
			item.setParam2(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (RecordArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static RecordArray create() {
		RecordArray array = new RecordArray();
		return array;
	}

	public static RecordArrayItem createItem() {
		RecordArrayItem item = new RecordArrayItem();
		return item;
	}

	public RecordArrayItem addData(long iD, String paramStr1, String paramStr2, String paramStr3, String paramStr4, int param1, int param2) {
		RecordArrayItem item = new RecordArrayItem();
		item.setID(iD);
		item.setParamStr1(paramStr1);
		item.setParamStr2(paramStr2);
		item.setParamStr3(paramStr3);
		item.setParamStr4(paramStr4);
		item.setParam1(param1);
		item.setParam2(param2);
		list.add(item);
		return item;
	}

	public void addItem(RecordArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (RecordArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class RecordArrayItem implements IMessageEncoder {
		private long iD;
		private String paramStr1;
		private String paramStr2;
		private String paramStr3;
		private String paramStr4;
		private int param1;
		private int param2;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler param1Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param1");
		private static IntMessageParameterHandler param2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param2");

		public static RecordArrayItem create() {
			RecordArrayItem item = new RecordArrayItem();
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
		 * @return the paramStr4
		 */
		public String getParamStr4() {
			return paramStr4;
		}

		/**
		 * @param paramStr4
		 *            the paramStr4 to set
		 */
		public void setParamStr4(String paramStr4) {
			this.paramStr4 = paramStr4;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeString(this.paramStr1);
			data.writeString(this.paramStr2);
			data.writeString(this.paramStr3);
			data.writeString(this.paramStr4);
			data.writeInt(this.param1);
			data.writeInt(this.param2);
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
			this.paramStr4 = data.getString();
			this.param1 = data.getInt();
			this.param2 = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!param1Handler.validate(param1)) {
				return false;
			}
			if (!param2Handler.validate(param2)) {
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
			bb.append("paramStr4:").append(this.paramStr4).append(", ");
			bb.append("param1:").append(this.param1).append(", ");
			bb.append("param2:").append(this.param2);
			return bb.toString();	
		}
	}
}