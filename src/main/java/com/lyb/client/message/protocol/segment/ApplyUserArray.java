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
public class ApplyUserArray implements IMessageEncoder {
	private List<ApplyUserArrayItem> list = new LinkedList<ApplyUserArrayItem>();

	public List<ApplyUserArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ApplyUserArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getZhanli());
			item.getUnitPropertyArray().encode(data);
			data.writeInt(item.getCareer());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ApplyUserArrayItem item = ApplyUserArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setZhanli(data.getInt());
			item.setUnitPropertyArray(UnitPropertyArray.create());
			item.getUnitPropertyArray().decode(data);
			item.setCareer(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ApplyUserArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ApplyUserArray create() {
		ApplyUserArray array = new ApplyUserArray();
		return array;
	}

	public static ApplyUserArrayItem createItem() {
		ApplyUserArrayItem item = new ApplyUserArrayItem();
		return item;
	}

	public ApplyUserArrayItem addData(long userId, String userName, int zhanli, UnitPropertyArray unitPropertyArray, int career) {
		ApplyUserArrayItem item = new ApplyUserArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setZhanli(zhanli);
		item.setUnitPropertyArray(unitPropertyArray);
		item.setCareer(career);
		list.add(item);
		return item;
	}

	public void addItem(ApplyUserArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ApplyUserArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ApplyUserArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int zhanli;
		private UnitPropertyArray unitPropertyArray;
		private int career;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");

		public static ApplyUserArrayItem create() {
			ApplyUserArrayItem item = new ApplyUserArrayItem();
			return item;
		}

		/**
		 * @return the userId
		 */
		public long getUserId() {
			return userId;
		}

		/**
		 * @param userId
		 *            the userId to set
		 */
		public void setUserId(long userId) {
			this.userId = userId;
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
		 * @return the zhanli
		 */
		public int getZhanli() {
			return zhanli;
		}

		/**
		 * @param zhanli
		 *            the zhanli to set
		 */
		public void setZhanli(int zhanli) {
			this.zhanli = zhanli;
		}
		/**
		 * @return the unitPropertyArray
		 */
		public UnitPropertyArray getUnitPropertyArray() {
			return unitPropertyArray;
		}

		/**
		 * @param unitPropertyArray
		 *            the unitPropertyArray to set
		 */
		public void setUnitPropertyArray(UnitPropertyArray unitPropertyArray) {
			this.unitPropertyArray = unitPropertyArray;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.zhanli);
			unitPropertyArray.encode(data);
			data.writeInt(this.career);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.zhanli = data.getInt();
			unitPropertyArray = UnitPropertyArray.create();
			unitPropertyArray.decode(data);
			this.career = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			if (!unitPropertyArray.validate()) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("zhanli:").append(this.zhanli).append(", ");
			bb.append("unitPropertyArray:").append(unitPropertyArray.toString()).append(", ");
			bb.append("career:").append(this.career);
			return bb.toString();	
		}
	}
}