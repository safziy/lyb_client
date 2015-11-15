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
public class ApplierArray implements IMessageEncoder {
	private List<ApplierArrayItem> list = new LinkedList<ApplierArrayItem>();

	public List<ApplierArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ApplierArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getRanking());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getVip());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ApplierArrayItem item = ApplierArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setRanking(data.getInt());
			item.setConfigId(data.getInt());
			item.setVip(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ApplierArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ApplierArray create() {
		ApplierArray array = new ApplierArray();
		return array;
	}

	public static ApplierArrayItem createItem() {
		ApplierArrayItem item = new ApplierArrayItem();
		return item;
	}

	public ApplierArrayItem addData(long userId, String userName, int level, int ranking, int configId, int vip) {
		ApplierArrayItem item = new ApplierArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setLevel(level);
		item.setRanking(ranking);
		item.setConfigId(configId);
		item.setVip(vip);
		list.add(item);
		return item;
	}

	public void addItem(ApplierArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ApplierArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ApplierArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int level;
		private int ranking;
		private int configId;
		private int vip;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");

		public static ApplierArrayItem create() {
			ApplierArrayItem item = new ApplierArrayItem();
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.ranking);
			data.writeInt(this.configId);
			data.writeInt(this.vip);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.level = data.getInt();
			this.ranking = data.getInt();
			this.configId = data.getInt();
			this.vip = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!rankingHandler.validate(ranking)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!vipHandler.validate(vip)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("ranking:").append(this.ranking).append(", ");
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("vip:").append(this.vip);
			return bb.toString();	
		}
	}
}