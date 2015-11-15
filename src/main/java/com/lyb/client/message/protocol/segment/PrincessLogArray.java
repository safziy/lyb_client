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
public class PrincessLogArray implements IMessageEncoder {
	private List<PrincessLogArrayItem> list = new LinkedList<PrincessLogArrayItem>();

	public List<PrincessLogArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (PrincessLogArrayItem item : list) {
			data.writeInt(item.getType());
			data.writeString(item.getUserName());
			data.writeString(item.getPrincessName());
			data.writeInt(item.getDeltaTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			PrincessLogArrayItem item = PrincessLogArrayItem.create();
			item.setType(data.getInt());
			item.setUserName(data.getString());
			item.setPrincessName(data.getString());
			item.setDeltaTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (PrincessLogArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static PrincessLogArray create() {
		PrincessLogArray array = new PrincessLogArray();
		return array;
	}

	public static PrincessLogArrayItem createItem() {
		PrincessLogArrayItem item = new PrincessLogArrayItem();
		return item;
	}

	public PrincessLogArrayItem addData(int type, String userName, String princessName, int deltaTime) {
		PrincessLogArrayItem item = new PrincessLogArrayItem();
		item.setType(type);
		item.setUserName(userName);
		item.setPrincessName(princessName);
		item.setDeltaTime(deltaTime);
		list.add(item);
		return item;
	}

	public void addItem(PrincessLogArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (PrincessLogArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class PrincessLogArrayItem implements IMessageEncoder {
		private int type;
		private String userName;
		private String princessName;
		private int deltaTime;

		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");
		private static IntMessageParameterHandler deltaTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("DeltaTime");

		public static PrincessLogArrayItem create() {
			PrincessLogArrayItem item = new PrincessLogArrayItem();
			return item;
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
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName
		 *            the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/**
		 * @return the princessName
		 */
		public String getPrincessName() {
			return princessName;
		}

		/**
		 * @param princessName
		 *            the princessName to set
		 */
		public void setPrincessName(String princessName) {
			this.princessName = princessName;
		}
		/**
		 * @return the deltaTime
		 */
		public int getDeltaTime() {
			return deltaTime;
		}

		/**
		 * @param deltaTime
		 *            the deltaTime to set
		 */
		public void setDeltaTime(int deltaTime) {
			this.deltaTime = deltaTime;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.type);
			data.writeString(this.userName);
			data.writeString(this.princessName);
			data.writeInt(this.deltaTime);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.type = data.getInt();
			this.userName = data.getString();
			this.princessName = data.getString();
			this.deltaTime = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!typeHandler.validate(type)) {
				return false;
			}
			if (!deltaTimeHandler.validate(deltaTime)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("type:").append(this.type).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("princessName:").append(this.princessName).append(", ");
			bb.append("deltaTime:").append(this.deltaTime);
			return bb.toString();	
		}
	}
}