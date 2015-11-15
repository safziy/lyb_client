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
public class UserArenaRecordArray implements IMessageEncoder {
	private List<UserArenaRecordArrayItem> list = new LinkedList<UserArenaRecordArrayItem>();

	public List<UserArenaRecordArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserArenaRecordArrayItem item : list) {
			data.writeInt(item.getBattleResulttype());
			data.writeInt(item.getBattleTime());
			data.writeString(item.getChallengeName());
			data.writeInt(item.getRanking());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			UserArenaRecordArrayItem item = UserArenaRecordArrayItem.create();
			item.setBattleResulttype(data.getInt());
			item.setBattleTime(data.getInt());
			item.setChallengeName(data.getString());
			item.setRanking(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserArenaRecordArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserArenaRecordArray create() {
		UserArenaRecordArray array = new UserArenaRecordArray();
		return array;
	}

	public static UserArenaRecordArrayItem createItem() {
		UserArenaRecordArrayItem item = new UserArenaRecordArrayItem();
		return item;
	}

	public UserArenaRecordArrayItem addData(int battleResulttype, int battleTime, String challengeName, int ranking) {
		UserArenaRecordArrayItem item = new UserArenaRecordArrayItem();
		item.setBattleResulttype(battleResulttype);
		item.setBattleTime(battleTime);
		item.setChallengeName(challengeName);
		item.setRanking(ranking);
		list.add(item);
		return item;
	}

	public void addItem(UserArenaRecordArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserArenaRecordArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserArenaRecordArrayItem implements IMessageEncoder {
		private int battleResulttype;
		private int battleTime;
		private String challengeName;
		private int ranking;

		private static IntMessageParameterHandler battleResulttypeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleResulttype");
		private static IntMessageParameterHandler battleTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BattleTime");
		private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");

		public static UserArenaRecordArrayItem create() {
			UserArenaRecordArrayItem item = new UserArenaRecordArrayItem();
			return item;
		}

		/**
		 * @return the battleResulttype
		 */
		public int getBattleResulttype() {
			return battleResulttype;
		}

		/**
		 * @param battleResulttype
		 *            the battleResulttype to set
		 */
		public void setBattleResulttype(int battleResulttype) {
			this.battleResulttype = battleResulttype;
		}
		/**
		 * @return the battleTime
		 */
		public int getBattleTime() {
			return battleTime;
		}

		/**
		 * @param battleTime
		 *            the battleTime to set
		 */
		public void setBattleTime(int battleTime) {
			this.battleTime = battleTime;
		}
		/**
		 * @return the challengeName
		 */
		public String getChallengeName() {
			return challengeName;
		}

		/**
		 * @param challengeName
		 *            the challengeName to set
		 */
		public void setChallengeName(String challengeName) {
			this.challengeName = challengeName;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.battleResulttype);
			data.writeInt(this.battleTime);
			data.writeString(this.challengeName);
			data.writeInt(this.ranking);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.battleResulttype = data.getInt();
			this.battleTime = data.getInt();
			this.challengeName = data.getString();
			this.ranking = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!battleResulttypeHandler.validate(battleResulttype)) {
				return false;
			}
			if (!battleTimeHandler.validate(battleTime)) {
				return false;
			}
			if (!rankingHandler.validate(ranking)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("battleResulttype:").append(this.battleResulttype).append(", ");
			bb.append("battleTime:").append(this.battleTime).append(", ");
			bb.append("challengeName:").append(this.challengeName).append(", ");
			bb.append("ranking:").append(this.ranking);
			return bb.toString();	
		}
	}
}