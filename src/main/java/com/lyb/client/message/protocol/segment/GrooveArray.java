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
public class GrooveArray implements IMessageEncoder {
	private List<GrooveArrayItem> list = new LinkedList<GrooveArrayItem>();

	public List<GrooveArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (GrooveArrayItem item : list) {
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getGrooveId());
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
			GrooveArrayItem item = GrooveArrayItem.create();
			item.setGeneralId(data.getLong());
			item.setGrooveId(data.getInt());
			item.setState(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (GrooveArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static GrooveArray create() {
		GrooveArray array = new GrooveArray();
		return array;
	}

	public static GrooveArrayItem createItem() {
		GrooveArrayItem item = new GrooveArrayItem();
		return item;
	}

	public GrooveArrayItem addData(long generalId, int grooveId, int state) {
		GrooveArrayItem item = new GrooveArrayItem();
		item.setGeneralId(generalId);
		item.setGrooveId(grooveId);
		item.setState(state);
		list.add(item);
		return item;
	}

	public void addItem(GrooveArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (GrooveArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class GrooveArrayItem implements IMessageEncoder {
		private long generalId;
		private int grooveId;
		private int state;

		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler grooveIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("GrooveId");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

		public static GrooveArrayItem create() {
			GrooveArrayItem item = new GrooveArrayItem();
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
		 * @return the grooveId
		 */
		public int getGrooveId() {
			return grooveId;
		}

		/**
		 * @param grooveId
		 *            the grooveId to set
		 */
		public void setGrooveId(int grooveId) {
			this.grooveId = grooveId;
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
			data.writeLong(this.generalId);
			data.writeInt(this.grooveId);
			data.writeInt(this.state);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalId = data.getLong();
			this.grooveId = data.getInt();
			this.state = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!grooveIdHandler.validate(grooveId)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("grooveId:").append(this.grooveId).append(", ");
			bb.append("state:").append(this.state);
			return bb.toString();	
		}
	}
}