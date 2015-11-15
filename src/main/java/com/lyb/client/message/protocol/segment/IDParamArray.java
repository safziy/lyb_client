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
public class IDParamArray implements IMessageEncoder {
	private List<IDParamArrayItem> list = new LinkedList<IDParamArrayItem>();

	public List<IDParamArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (IDParamArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getParam());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			IDParamArrayItem item = IDParamArrayItem.create();
			item.setID(data.getLong());
			item.setParam(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (IDParamArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static IDParamArray create() {
		IDParamArray array = new IDParamArray();
		return array;
	}

	public static IDParamArrayItem createItem() {
		IDParamArrayItem item = new IDParamArrayItem();
		return item;
	}

	public IDParamArrayItem addData(long iD, int param) {
		IDParamArrayItem item = new IDParamArrayItem();
		item.setID(iD);
		item.setParam(param);
		list.add(item);
		return item;
	}

	public void addItem(IDParamArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (IDParamArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class IDParamArrayItem implements IMessageEncoder {
		private long iD;
		private int param;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler paramHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param");

		public static IDParamArrayItem create() {
			IDParamArrayItem item = new IDParamArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.param);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.param = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!paramHandler.validate(param)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("param:").append(this.param);
			return bb.toString();	
		}
	}
}