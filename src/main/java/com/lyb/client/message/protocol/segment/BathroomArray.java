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
public class BathroomArray implements IMessageEncoder {
	private List<BathroomArrayItem> list = new LinkedList<BathroomArrayItem>();

	public List<BathroomArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BathroomArrayItem item : list) {
			data.writeInt(item.getBathroomId());
			data.writeString(item.getUserName());
			data.writeInt(item.getCareer());
			data.writeInt(item.getLevel());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BathroomArrayItem item = BathroomArrayItem.create();
			item.setBathroomId(data.getInt());
			item.setUserName(data.getString());
			item.setCareer(data.getInt());
			item.setLevel(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BathroomArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BathroomArray create() {
		BathroomArray array = new BathroomArray();
		return array;
	}

	public static BathroomArrayItem createItem() {
		BathroomArrayItem item = new BathroomArrayItem();
		return item;
	}

	public BathroomArrayItem addData(int bathroomId, String userName, int career, int level) {
		BathroomArrayItem item = new BathroomArrayItem();
		item.setBathroomId(bathroomId);
		item.setUserName(userName);
		item.setCareer(career);
		item.setLevel(level);
		list.add(item);
		return item;
	}

	public void addItem(BathroomArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BathroomArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BathroomArrayItem implements IMessageEncoder {
		private int bathroomId;
		private String userName;
		private int career;
		private int level;

		private static IntMessageParameterHandler bathroomIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BathroomId");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");

		public static BathroomArrayItem create() {
			BathroomArrayItem item = new BathroomArrayItem();
			return item;
		}

		/**
		 * @return the bathroomId
		 */
		public int getBathroomId() {
			return bathroomId;
		}

		/**
		 * @param bathroomId
		 *            the bathroomId to set
		 */
		public void setBathroomId(int bathroomId) {
			this.bathroomId = bathroomId;
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
		 * @return the career
		 */
		public int getCareer() {
			return career;
		}

		/**
		 * @param career
		 *            the career to set
		 */
		public void setCareer(int career) {
			this.career = career;
		}
		/**
		 * @return the level
		 */
		public int getLevel() {
			return level;
		}

		/**
		 * @param level
		 *            the level to set
		 */
		public void setLevel(int level) {
			this.level = level;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.bathroomId);
			data.writeString(this.userName);
			data.writeInt(this.career);
			data.writeInt(this.level);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.bathroomId = data.getInt();
			this.userName = data.getString();
			this.career = data.getInt();
			this.level = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!bathroomIdHandler.validate(bathroomId)) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("bathroomId:").append(this.bathroomId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("level:").append(this.level);
			return bb.toString();	
		}
	}
}