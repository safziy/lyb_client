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
public class IDStateParamArray implements IMessageEncoder {
	private List<IDStateParamArrayItem> list = new LinkedList<IDStateParamArrayItem>();

	public List<IDStateParamArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (IDStateParamArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getState());
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
			IDStateParamArrayItem item = IDStateParamArrayItem.create();
			item.setID(data.getLong());
			item.setState(data.getInt());
			item.setParam(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (IDStateParamArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static IDStateParamArray create() {
		IDStateParamArray array = new IDStateParamArray();
		return array;
	}

	public static IDStateParamArrayItem createItem() {
		IDStateParamArrayItem item = new IDStateParamArrayItem();
		return item;
	}

	public IDStateParamArrayItem addData(long iD, int state, int param) {
		IDStateParamArrayItem item = new IDStateParamArrayItem();
		item.setID(iD);
		item.setState(state);
		item.setParam(param);
		list.add(item);
		return item;
	}

	public void addItem(IDStateParamArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (IDStateParamArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class IDStateParamArrayItem implements IMessageEncoder {
		private long iD;
		private int state;
		private int param;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
		private static IntMessageParameterHandler paramHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param");

		public static IDStateParamArrayItem create() {
			IDStateParamArrayItem item = new IDStateParamArrayItem();
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
			data.writeInt(this.state);
			data.writeInt(this.param);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.state = data.getInt();
			this.param = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
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
			bb.append("state:").append(this.state).append(", ");
			bb.append("param:").append(this.param);
			return bb.toString();	
		}
	}
}