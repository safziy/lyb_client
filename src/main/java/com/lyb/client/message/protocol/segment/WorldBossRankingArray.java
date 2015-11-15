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
public class WorldBossRankingArray implements IMessageEncoder {
	private List<WorldBossRankingArrayItem> list = new LinkedList<WorldBossRankingArrayItem>();

	public List<WorldBossRankingArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (WorldBossRankingArrayItem item : list) {
			data.writeInt(item.getRanking());
			data.writeString(item.getUserName());
			data.writeInt(item.getCount());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			WorldBossRankingArrayItem item = WorldBossRankingArrayItem.create();
			item.setRanking(data.getInt());
			item.setUserName(data.getString());
			item.setCount(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (WorldBossRankingArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static WorldBossRankingArray create() {
		WorldBossRankingArray array = new WorldBossRankingArray();
		return array;
	}

	public static WorldBossRankingArrayItem createItem() {
		WorldBossRankingArrayItem item = new WorldBossRankingArrayItem();
		return item;
	}

	public WorldBossRankingArrayItem addData(int ranking, String userName, int count) {
		WorldBossRankingArrayItem item = new WorldBossRankingArrayItem();
		item.setRanking(ranking);
		item.setUserName(userName);
		item.setCount(count);
		list.add(item);
		return item;
	}

	public void addItem(WorldBossRankingArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (WorldBossRankingArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class WorldBossRankingArrayItem implements IMessageEncoder {
		private int ranking;
		private String userName;
		private int count;

		private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");

		public static WorldBossRankingArrayItem create() {
			WorldBossRankingArrayItem item = new WorldBossRankingArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.ranking);
			data.writeString(this.userName);
			data.writeInt(this.count);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.ranking = data.getInt();
			this.userName = data.getString();
			this.count = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!rankingHandler.validate(ranking)) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("ranking:").append(this.ranking).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("count:").append(this.count);
			return bb.toString();	
		}
	}
}