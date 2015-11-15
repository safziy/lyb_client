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
public class EmployGeneralArray implements IMessageEncoder {
	private List<EmployGeneralArrayItem> list = new LinkedList<EmployGeneralArrayItem>();

	public List<EmployGeneralArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (EmployGeneralArrayItem item : list) {
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getType());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			EmployGeneralArrayItem item = EmployGeneralArrayItem.create();
			item.setGeneralId(data.getLong());
			item.setType(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (EmployGeneralArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static EmployGeneralArray create() {
		EmployGeneralArray array = new EmployGeneralArray();
		return array;
	}

	public static EmployGeneralArrayItem createItem() {
		EmployGeneralArrayItem item = new EmployGeneralArrayItem();
		return item;
	}

	public EmployGeneralArrayItem addData(long generalId, int type) {
		EmployGeneralArrayItem item = new EmployGeneralArrayItem();
		item.setGeneralId(generalId);
		item.setType(type);
		list.add(item);
		return item;
	}

	public void addItem(EmployGeneralArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (EmployGeneralArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class EmployGeneralArrayItem implements IMessageEncoder {
		private long generalId;
		private int type;

		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");

		public static EmployGeneralArrayItem create() {
			EmployGeneralArrayItem item = new EmployGeneralArrayItem();
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
		 * @return the type
		 */
		public int getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(int type) {
			this.type = type;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.generalId);
			data.writeInt(this.type);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalId = data.getLong();
			this.type = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!typeHandler.validate(type)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("type:").append(this.type);
			return bb.toString();	
		}
	}
}