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
public class EmployArray implements IMessageEncoder {
	private List<EmployArrayItem> list = new LinkedList<EmployArrayItem>();

	public List<EmployArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (EmployArrayItem item : list) {
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getLevel());
			data.writeInt(item.getGrade());
			data.writeInt(item.getStarLevel());
			data.writeInt(item.getZhanli());
			data.writeInt(item.getCount());
			data.writeInt(item.getUserCount());
			data.writeInt(item.getTime());
			data.writeString(item.getUserName());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			EmployArrayItem item = EmployArrayItem.create();
			item.setGeneralId(data.getLong());
			item.setConfigId(data.getInt());
			item.setLevel(data.getInt());
			item.setGrade(data.getInt());
			item.setStarLevel(data.getInt());
			item.setZhanli(data.getInt());
			item.setCount(data.getInt());
			item.setUserCount(data.getInt());
			item.setTime(data.getInt());
			item.setUserName(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (EmployArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static EmployArray create() {
		EmployArray array = new EmployArray();
		return array;
	}

	public static EmployArrayItem createItem() {
		EmployArrayItem item = new EmployArrayItem();
		return item;
	}

	public EmployArrayItem addData(long generalId, int configId, int level, int grade, int starLevel, int zhanli, int count, int userCount, int time, String userName) {
		EmployArrayItem item = new EmployArrayItem();
		item.setGeneralId(generalId);
		item.setConfigId(configId);
		item.setLevel(level);
		item.setGrade(grade);
		item.setStarLevel(starLevel);
		item.setZhanli(zhanli);
		item.setCount(count);
		item.setUserCount(userCount);
		item.setTime(time);
		item.setUserName(userName);
		list.add(item);
		return item;
	}

	public void addItem(EmployArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (EmployArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class EmployArrayItem implements IMessageEncoder {
		private long generalId;
		private int configId;
		private int level;
		private int grade;
		private int starLevel;
		private int zhanli;
		private int count;
		private int userCount;
		private int time;
		private String userName;

		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler gradeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Grade");
		private static IntMessageParameterHandler starLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("StarLevel");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler userCountHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("UserCount");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");

		public static EmployArrayItem create() {
			EmployArrayItem item = new EmployArrayItem();
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
		 * @return the starLevel
		 */
		public int getStarLevel() {
			return starLevel;
		}

		/**
		 * @param starLevel
		 *            the starLevel to set
		 */
		public void setStarLevel(int starLevel) {
			this.starLevel = starLevel;
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
		 * @return the count
		 */
		public int getCount() {
			return count;
		}

		/**
		 * @param count
		 *            the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}
		/**
		 * @return the userCount
		 */
		public int getUserCount() {
			return userCount;
		}

		/**
		 * @param userCount
		 *            the userCount to set
		 */
		public void setUserCount(int userCount) {
			this.userCount = userCount;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.generalId);
			data.writeInt(this.configId);
			data.writeInt(this.level);
			data.writeInt(this.grade);
			data.writeInt(this.starLevel);
			data.writeInt(this.zhanli);
			data.writeInt(this.count);
			data.writeInt(this.userCount);
			data.writeInt(this.time);
			data.writeString(this.userName);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalId = data.getLong();
			this.configId = data.getInt();
			this.level = data.getInt();
			this.grade = data.getInt();
			this.starLevel = data.getInt();
			this.zhanli = data.getInt();
			this.count = data.getInt();
			this.userCount = data.getInt();
			this.time = data.getInt();
			this.userName = data.getString();
		}
	
		@Override
		public boolean validate() {
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!gradeHandler.validate(grade)) {
				return false;
			}
			if (!starLevelHandler.validate(starLevel)) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!userCountHandler.validate(userCount)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("grade:").append(this.grade).append(", ");
			bb.append("starLevel:").append(this.starLevel).append(", ");
			bb.append("zhanli:").append(this.zhanli).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("userCount:").append(this.userCount).append(", ");
			bb.append("time:").append(this.time).append(", ");
			bb.append("userName:").append(this.userName);
			return bb.toString();	
		}
	}
}