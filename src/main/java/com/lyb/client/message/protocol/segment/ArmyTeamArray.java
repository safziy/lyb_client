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
public class ArmyTeamArray implements IMessageEncoder {
	private List<ArmyTeamArrayItem> list = new LinkedList<ArmyTeamArrayItem>();

	public List<ArmyTeamArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ArmyTeamArrayItem item : list) {
			data.writeInt(item.getMapId());
			data.writeLong(item.getID());
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getZhanli());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ArmyTeamArrayItem item = ArmyTeamArrayItem.create();
			item.setMapId(data.getInt());
			item.setID(data.getLong());
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setZhanli(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ArmyTeamArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ArmyTeamArray create() {
		ArmyTeamArray array = new ArmyTeamArray();
		return array;
	}

	public static ArmyTeamArrayItem createItem() {
		ArmyTeamArrayItem item = new ArmyTeamArrayItem();
		return item;
	}

	public ArmyTeamArrayItem addData(int mapId, long iD, long userId, String userName, int level, int zhanli) {
		ArmyTeamArrayItem item = new ArmyTeamArrayItem();
		item.setMapId(mapId);
		item.setID(iD);
		item.setUserId(userId);
		item.setUserName(userName);
		item.setLevel(level);
		item.setZhanli(zhanli);
		list.add(item);
		return item;
	}

	public void addItem(ArmyTeamArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ArmyTeamArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ArmyTeamArrayItem implements IMessageEncoder {
		private int mapId;
		private long iD;
		private long userId;
		private String userName;
		private int level;
		private int zhanli;

		private static IntMessageParameterHandler mapIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MapId");
		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");

		public static ArmyTeamArrayItem create() {
			ArmyTeamArrayItem item = new ArmyTeamArrayItem();
			return item;
		}

		/**
		 * @return the mapId
		 */
		public int getMapId() {
			return mapId;
		}

		/**
		 * @param mapId
		 *            the mapId to set
		 */
		public void setMapId(int mapId) {
			this.mapId = mapId;
		}
		/**
		 * @return the iD
		 */
		public long getID() {
			return iD;
		}

		/**
		 * @param iD
		 *            the iD to set
		 */
		public void setID(long iD) {
			this.iD = iD;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.mapId);
			data.writeLong(this.iD);
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.zhanli);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.mapId = data.getInt();
			this.iD = data.getLong();
			this.userId = data.getLong();
			this.userName = data.getString();
			this.level = data.getInt();
			this.zhanli = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!mapIdHandler.validate(mapId)) {
				return false;
			}
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("mapId:").append(this.mapId).append(", ");
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("zhanli:").append(this.zhanli);
			return bb.toString();	
		}
	}
}