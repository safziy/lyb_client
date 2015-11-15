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
public class ActivityEmployRankingArray implements IMessageEncoder {
	private List<ActivityEmployRankingArrayItem> list = new LinkedList<ActivityEmployRankingArrayItem>();

	public List<ActivityEmployRankingArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ActivityEmployRankingArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getRanking());
			data.writeInt(item.getActivityEmployScore());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ActivityEmployRankingArrayItem item = ActivityEmployRankingArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setRanking(data.getInt());
			item.setActivityEmployScore(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ActivityEmployRankingArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ActivityEmployRankingArray create() {
		ActivityEmployRankingArray array = new ActivityEmployRankingArray();
		return array;
	}

	public static ActivityEmployRankingArrayItem createItem() {
		ActivityEmployRankingArrayItem item = new ActivityEmployRankingArrayItem();
		return item;
	}

	public ActivityEmployRankingArrayItem addData(long userId, String userName, int ranking, int activityEmployScore) {
		ActivityEmployRankingArrayItem item = new ActivityEmployRankingArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setRanking(ranking);
		item.setActivityEmployScore(activityEmployScore);
		list.add(item);
		return item;
	}

	public void addItem(ActivityEmployRankingArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ActivityEmployRankingArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ActivityEmployRankingArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int ranking;
		private int activityEmployScore;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");
		private static IntMessageParameterHandler activityEmployScoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ActivityEmployScore");

		public static ActivityEmployRankingArrayItem create() {
			ActivityEmployRankingArrayItem item = new ActivityEmployRankingArrayItem();
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
		 * @return the activityEmployScore
		 */
		public int getActivityEmployScore() {
			return activityEmployScore;
		}

		/**
		 * @param activityEmployScore
		 *            the activityEmployScore to set
		 */
		public void setActivityEmployScore(int activityEmployScore) {
			this.activityEmployScore = activityEmployScore;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.ranking);
			data.writeInt(this.activityEmployScore);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.ranking = data.getInt();
			this.activityEmployScore = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!rankingHandler.validate(ranking)) {
				return false;
			}
			if (!activityEmployScoreHandler.validate(activityEmployScore)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("ranking:").append(this.ranking).append(", ");
			bb.append("activityEmployScore:").append(this.activityEmployScore);
			return bb.toString();	
		}
	}
}