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
public class ChancellorStateArray implements IMessageEncoder {
	private List<ChancellorStateArrayItem> list = new LinkedList<ChancellorStateArrayItem>();

	public List<ChancellorStateArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ChancellorStateArrayItem item : list) {
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
			ChancellorStateArrayItem item = ChancellorStateArrayItem.create();
			item.setID(data.getLong());
			item.setState(data.getInt());
			item.setTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ChancellorStateArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ChancellorStateArray create() {
		ChancellorStateArray array = new ChancellorStateArray();
		return array;
	}

	public static ChancellorStateArrayItem createItem() {
		ChancellorStateArrayItem item = new ChancellorStateArrayItem();
		return item;
	}

	public ChancellorStateArrayItem addData(long iD, int state, int time) {
		ChancellorStateArrayItem item = new ChancellorStateArrayItem();
		item.setID(iD);
		item.setState(state);
		item.setTime(time);
		list.add(item);
		return item;
	}

	public void addItem(ChancellorStateArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ChancellorStateArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ChancellorStateArrayItem implements IMessageEncoder {
		private long iD;
		private int state;
		private int time;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

		public static ChancellorStateArrayItem create() {
			ChancellorStateArrayItem item = new ChancellorStateArrayItem();
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