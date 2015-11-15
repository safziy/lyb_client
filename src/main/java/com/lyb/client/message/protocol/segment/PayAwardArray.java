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
public class PayAwardArray implements IMessageEncoder {
	private List<PayAwardArrayItem> list = new LinkedList<PayAwardArrayItem>();

	public List<PayAwardArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PayAwardArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getState());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PayAwardArrayItem item = PayAwardArrayItem.create();
			item.setID(data.getLong());
			item.setState(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PayAwardArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PayAwardArray create() {
		PayAwardArray array = new PayAwardArray();
		return array;
	}

	public static PayAwardArrayItem createItem() {
		PayAwardArrayItem item = new PayAwardArrayItem();
		return item;
	}

	public PayAwardArrayItem addData(long iD, int state) {
		PayAwardArrayItem item = new PayAwardArrayItem();
		item.setID(iD);
		item.setState(state);
		list.add(item);
		return item;
	}

	public void addItem(PayAwardArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PayAwardArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PayAwardArrayItem implements IMessageEncoder {
		private long iD;
		private int state;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

		public static PayAwardArrayItem create() {
			PayAwardArrayItem item = new PayAwardArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.iD);
			data.writeInt(this.state);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.state = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("state:").append(this.state);
			return bb.toString();	
		}
	}
}