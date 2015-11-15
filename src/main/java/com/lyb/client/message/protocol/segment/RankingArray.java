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
public class RankingArray implements IMessageEncoder {
	private List<RankingArrayItem> list = new LinkedList<RankingArrayItem>();

	public List<RankingArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (RankingArrayItem item : list) {
			data.writeInt(item.getRanking());
			data.writeString(item.getUserName());
			data.writeInt(item.getScore());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			RankingArrayItem item = RankingArrayItem.create();
			item.setRanking(data.getInt());
			item.setUserName(data.getString());
			item.setScore(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (RankingArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static RankingArray create() {
		RankingArray array = new RankingArray();
		return array;
	}

	public static RankingArrayItem createItem() {
		RankingArrayItem item = new RankingArrayItem();
		return item;
	}

	public RankingArrayItem addData(int ranking, String userName, int score) {
		RankingArrayItem item = new RankingArrayItem();
		item.setRanking(ranking);
		item.setUserName(userName);
		item.setScore(score);
		list.add(item);
		return item;
	}

	public void addItem(RankingArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (RankingArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class RankingArrayItem implements IMessageEncoder {
		private int ranking;
		private String userName;
		private int score;

		private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");
		private static IntMessageParameterHandler scoreHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Score");

		public static RankingArrayItem create() {
			RankingArrayItem item = new RankingArrayItem();
			return item;
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
		 * @return the score
		 */
		public int getScore() {
			return score;
		}

		/**
		 * @param score
		 *            the score to set
		 */
		public void setScore(int score) {
			this.score = score;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.ranking);
			data.writeString(this.userName);
			data.writeInt(this.score);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.ranking = data.getInt();
			this.userName = data.getString();
			this.score = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!rankingHandler.validate(ranking)) {
				return false;
			}
			if (!scoreHandler.validate(score)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("ranking:").append(this.ranking).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("score:").append(this.score);
			return bb.toString();	
		}
	}
}