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
public class IDAndStateArray implements IMessageEncoder {
	private List<IDAndStateArrayItem> list = new LinkedList<IDAndStateArrayItem>();

	public List<IDAndStateArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (IDAndStateArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getState());
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
			IDAndStateArrayItem item = IDAndStateArrayItem.create();
			item.setID(data.getLong());
			item.setState(data.getInt());
			item.setTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (IDAndStateArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static IDAndStateArray create() {
		IDAndStateArray array = new IDAndStateArray();
		return array;
	}

	public static IDAndStateArrayItem createItem() {
		IDAndStateArrayItem item = new IDAndStateArrayItem();
		return item;
	}

	public IDAndStateArrayItem addData(long iD, int state, int time) {
		IDAndStateArrayItem item = new IDAndStateArrayItem();
		item.setID(iD);
		item.setState(state);
		item.setTime(time);
		list.add(item);
		return item;
	}

	public void addItem(IDAndStateArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (IDAndStateArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class IDAndStateArrayItem implements IMessageEncoder {
		private long iD;
		private int state;
		private int time;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

		public static IDAndStateArrayItem create() {
			IDAndStateArrayItem item = new IDAndStateArrayItem();
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
			data.writeInt(this.state);
			data.writeInt(this.time);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.state = data.getInt();
			this.time = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
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
			bb.append("state:").append(this.state).append(", ");
			bb.append("time:").append(this.time);
			return bb.toString();	
		}
	}
}