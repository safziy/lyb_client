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
public class BattleEmployArray implements IMessageEncoder {
	private List<BattleEmployArrayItem> list = new LinkedList<BattleEmployArrayItem>();

	public List<BattleEmployArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (BattleEmployArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getZhanli());
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getGrade());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			BattleEmployArrayItem item = BattleEmployArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setZhanli(data.getInt());
			item.setGeneralId(data.getLong());
			item.setConfigId(data.getInt());
			item.setGrade(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (BattleEmployArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static BattleEmployArray create() {
		BattleEmployArray array = new BattleEmployArray();
		return array;
	}

	public static BattleEmployArrayItem createItem() {
		BattleEmployArrayItem item = new BattleEmployArrayItem();
		return item;
	}

	public BattleEmployArrayItem addData(long userId, String userName, int level, int zhanli, long generalId, int configId, int grade) {
		BattleEmployArrayItem item = new BattleEmployArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setLevel(level);
		item.setZhanli(zhanli);
		item.setGeneralId(generalId);
		item.setConfigId(configId);
		item.setGrade(grade);
		list.add(item);
		return item;
	}

	public void addItem(BattleEmployArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (BattleEmployArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class BattleEmployArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int level;
		private int zhanli;
		private long generalId;
		private int configId;
		private int grade;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler gradeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Grade");

		public static BattleEmployArrayItem create() {
			BattleEmployArrayItem item = new BattleEmployArrayItem();
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
		 * @return the configId
		 */
		public int getConfigId() {
			return configId;
		}

		/**
		 * @param configId
		 *            the configId to set
		 */
		public void setConfigId(int configId) {
			this.configId = configId;
		}
		/**
		 * @return the grade
		 */
		public int getGrade() {
			return grade;
		}

		/**
		 * @param grade
		 *            the grade to set
		 */
		public void setGrade(int grade) {
			this.grade = grade;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.zhanli);
			data.writeLong(this.generalId);
			data.writeInt(this.configId);
			data.writeInt(this.grade);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.level = data.getInt();
			this.zhanli = data.getInt();
			this.generalId = data.getLong();
			this.configId = data.getInt();
			this.grade = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!gradeHandler.validate(grade)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("zhanli:").append(this.zhanli).append(", ");
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("grade:").append(this.grade);
			return bb.toString();	
		}
	}
}