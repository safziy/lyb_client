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
public class UserAccountInfoArray implements IMessageEncoder {
	private List<UserAccountInfoArrayItem> list = new LinkedList<UserAccountInfoArrayItem>();

	public List<UserAccountInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserAccountInfoArrayItem item : list) {
			data.writeString(item.getUserName());
			data.writeInt(item.getCareer());
			data.writeInt(item.getLevel());
			data.writeInt(item.getOrigainalServerId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			UserAccountInfoArrayItem item = UserAccountInfoArrayItem.create();
			item.setUserName(data.getString());
			item.setCareer(data.getInt());
			item.setLevel(data.getInt());
			item.setOrigainalServerId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserAccountInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserAccountInfoArray create() {
		UserAccountInfoArray array = new UserAccountInfoArray();
		return array;
	}

	public static UserAccountInfoArrayItem createItem() {
		UserAccountInfoArrayItem item = new UserAccountInfoArrayItem();
		return item;
	}

	public UserAccountInfoArrayItem addData(String userName, int career, int level, int origainalServerId) {
		UserAccountInfoArrayItem item = new UserAccountInfoArrayItem();
		item.setUserName(userName);
		item.setCareer(career);
		item.setLevel(level);
		item.setOrigainalServerId(origainalServerId);
		list.add(item);
		return item;
	}

	public void addItem(UserAccountInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserAccountInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserAccountInfoArrayItem implements IMessageEncoder {
		private String userName;
		private int career;
		private int level;
		private int origainalServerId;

		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler origainalServerIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("OrigainalServerId");

		public static UserAccountInfoArrayItem create() {
			UserAccountInfoArrayItem item = new UserAccountInfoArrayItem();
			return item;
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
		 * @return the origainalServerId
		 */
		public int getOrigainalServerId() {
			return origainalServerId;
		}

		/**
		 * @param origainalServerId
		 *            the origainalServerId to set
		 */
		public void setOrigainalServerId(int origainalServerId) {
			this.origainalServerId = origainalServerId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.userName);
			data.writeInt(this.career);
			data.writeInt(this.level);
			data.writeInt(this.origainalServerId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userName = data.getString();
			this.career = data.getInt();
			this.level = data.getInt();
			this.origainalServerId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!origainalServerIdHandler.validate(origainalServerId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("origainalServerId:").append(this.origainalServerId);
			return bb.toString();	
		}
	}
}