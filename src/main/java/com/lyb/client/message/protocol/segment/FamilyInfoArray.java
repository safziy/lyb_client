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
public class FamilyInfoArray implements IMessageEncoder {
	private List<FamilyInfoArrayItem> list = new LinkedList<FamilyInfoArrayItem>();

	public List<FamilyInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FamilyInfoArrayItem item : list) {
			data.writeLong(item.getFamilyId());
			data.writeString(item.getFamilyName());
			data.writeInt(item.getRanking());
			data.writeInt(item.getFamilyLevel());
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getCount());
			data.writeInt(item.getIsApplied());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FamilyInfoArrayItem item = FamilyInfoArrayItem.create();
			item.setFamilyId(data.getLong());
			item.setFamilyName(data.getString());
			item.setRanking(data.getInt());
			item.setFamilyLevel(data.getInt());
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setConfigId(data.getInt());
			item.setCount(data.getInt());
			item.setIsApplied(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FamilyInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FamilyInfoArray create() {
		FamilyInfoArray array = new FamilyInfoArray();
		return array;
	}

	public static FamilyInfoArrayItem createItem() {
		FamilyInfoArrayItem item = new FamilyInfoArrayItem();
		return item;
	}

	public FamilyInfoArrayItem addData(long familyId, String familyName, int ranking, int familyLevel, long userId, String userName, int configId, int count, int isApplied) {
		FamilyInfoArrayItem item = new FamilyInfoArrayItem();
		item.setFamilyId(familyId);
		item.setFamilyName(familyName);
		item.setRanking(ranking);
		item.setFamilyLevel(familyLevel);
		item.setUserId(userId);
		item.setUserName(userName);
		item.setConfigId(configId);
		item.setCount(count);
		item.setIsApplied(isApplied);
		list.add(item);
		return item;
	}

	public void addItem(FamilyInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FamilyInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FamilyInfoArrayItem implements IMessageEncoder {
		private long familyId;
		private String familyName;
		private int ranking;
		private int familyLevel;
		private long userId;
		private String userName;
		private int configId;
		private int count;
		private int isApplied;

		private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");
		private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");
		private static IntMessageParameterHandler familyLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyLevel");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler isAppliedHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("IsApplied");

		public static FamilyInfoArrayItem create() {
			FamilyInfoArrayItem item = new FamilyInfoArrayItem();
			return item;
		}

		/**
		 * @return the familyId
		 */
		public long getFamilyId() {
			return familyId;
		}

		/**
		 * @param familyId
		 *            the familyId to set
		 */
		public void setFamilyId(long familyId) {
			this.familyId = familyId;
		}
		/**
		 * @return the familyName
		 */
		public String getFamilyName() {
			return familyName;
		}

		/**
		 * @param familyName
		 *            the familyName to set
		 */
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}
		/**
		 * @return the ranking
		 */
		public int getRanking() {
			return ranking;
		}

		/**
		 * @param ranking
		 *            the ranking to set
		 */
		public void setRanking(int ranking) {
			this.ranking = ranking;
		}
		/**
		 * @return the familyLevel
		 */
		public int getFamilyLevel() {
			return familyLevel;
		}

		/**
		 * @param familyLevel
		 *            the familyLevel to set
		 */
		public void setFamilyLevel(int familyLevel) {
			this.familyLevel = familyLevel;
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
		 * @return the isApplied
		 */
		public int getIsApplied() {
			return isApplied;
		}

		/**
		 * @param isApplied
		 *            the isApplied to set
		 */
		public void setIsApplied(int isApplied) {
			this.isApplied = isApplied;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.familyId);
			data.writeString(this.familyName);
			data.writeInt(this.ranking);
			data.writeInt(this.familyLevel);
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.configId);
			data.writeInt(this.count);
			data.writeInt(this.isApplied);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.familyId = data.getLong();
			this.familyName = data.getString();
			this.ranking = data.getInt();
			this.familyLevel = data.getInt();
			this.userId = data.getLong();
			this.userName = data.getString();
			this.configId = data.getInt();
			this.count = data.getInt();
			this.isApplied = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!familyIdHandler.validate(familyId)) {
				return false;
			}
			if (!rankingHandler.validate(ranking)) {
				return false;
			}
			if (!familyLevelHandler.validate(familyLevel)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!isAppliedHandler.validate(isApplied)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("familyId:").append(this.familyId).append(", ");
			bb.append("familyName:").append(this.familyName).append(", ");
			bb.append("ranking:").append(this.ranking).append(", ");
			bb.append("familyLevel:").append(this.familyLevel).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("isApplied:").append(this.isApplied);
			return bb.toString();	
		}
	}
}