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
public class UserRelationArray implements IMessageEncoder {
	private List<UserRelationArrayItem> list = new LinkedList<UserRelationArrayItem>();

	public List<UserRelationArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserRelationArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getCareer());
			data.writeInt(item.getTransforId());
			data.writeInt(item.getLevel());
			data.writeInt(item.getVip());
			data.writeInt(item.getZhanli());
			data.writeInt(item.getBooleanValue());
			data.writeInt(item.getBooleanValue2());
			data.writeInt(item.getBooleanValue3());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			UserRelationArrayItem item = UserRelationArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setCareer(data.getInt());
			item.setTransforId(data.getInt());
			item.setLevel(data.getInt());
			item.setVip(data.getInt());
			item.setZhanli(data.getInt());
			item.setBooleanValue(data.getInt());
			item.setBooleanValue2(data.getInt());
			item.setBooleanValue3(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserRelationArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserRelationArray create() {
		UserRelationArray array = new UserRelationArray();
		return array;
	}

	public static UserRelationArrayItem createItem() {
		UserRelationArrayItem item = new UserRelationArrayItem();
		return item;
	}

	public UserRelationArrayItem addData(long userId, String userName, int career, int transforId, int level, int vip, int zhanli, int booleanValue, int booleanValue2, int booleanValue3) {
		UserRelationArrayItem item = new UserRelationArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setCareer(career);
		item.setTransforId(transforId);
		item.setLevel(level);
		item.setVip(vip);
		item.setZhanli(zhanli);
		item.setBooleanValue(booleanValue);
		item.setBooleanValue2(booleanValue2);
		item.setBooleanValue3(booleanValue3);
		list.add(item);
		return item;
	}

	public void addItem(UserRelationArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserRelationArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserRelationArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int career;
		private int transforId;
		private int level;
		private int vip;
		private int zhanli;
		private int booleanValue;
		private int booleanValue2;
		private int booleanValue3;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler transforIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TransforId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler booleanValue2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue2");
		private static IntMessageParameterHandler booleanValue3Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue3");

		public static UserRelationArrayItem create() {
			UserRelationArrayItem item = new UserRelationArrayItem();
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
		 * @return the transforId
		 */
		public int getTransforId() {
			return transforId;
		}

		/**
		 * @param transforId
		 *            the transforId to set
		 */
		public void setTransforId(int transforId) {
			this.transforId = transforId;
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
		 * @return the vip
		 */
		public int getVip() {
			return vip;
		}

		/**
		 * @param vip
		 *            the vip to set
		 */
		public void setVip(int vip) {
			this.vip = vip;
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
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
		}
		/**
		 * @return the booleanValue2
		 */
		public int getBooleanValue2() {
			return booleanValue2;
		}

		/**
		 * @param booleanValue2
		 *            the booleanValue2 to set
		 */
		public void setBooleanValue2(int booleanValue2) {
			this.booleanValue2 = booleanValue2;
		}
		/**
		 * @return the booleanValue3
		 */
		public int getBooleanValue3() {
			return booleanValue3;
		}

		/**
		 * @param booleanValue3
		 *            the booleanValue3 to set
		 */
		public void setBooleanValue3(int booleanValue3) {
			this.booleanValue3 = booleanValue3;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.career);
			data.writeInt(this.transforId);
			data.writeInt(this.level);
			data.writeInt(this.vip);
			data.writeInt(this.zhanli);
			data.writeInt(this.booleanValue);
			data.writeInt(this.booleanValue2);
			data.writeInt(this.booleanValue3);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.career = data.getInt();
			this.transforId = data.getInt();
			this.level = data.getInt();
			this.vip = data.getInt();
			this.zhanli = data.getInt();
			this.booleanValue = data.getInt();
			this.booleanValue2 = data.getInt();
			this.booleanValue3 = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!transforIdHandler.validate(transforId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!vipHandler.validate(vip)) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			if (!booleanValue2Handler.validate(booleanValue2)) {
				return false;
			}
			if (!booleanValue3Handler.validate(booleanValue3)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("transforId:").append(this.transforId).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("vip:").append(this.vip).append(", ");
			bb.append("zhanli:").append(this.zhanli).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("booleanValue2:").append(this.booleanValue2).append(", ");
			bb.append("booleanValue3:").append(this.booleanValue3);
			return bb.toString();	
		}
	}
}