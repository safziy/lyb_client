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
public class MemberArray implements IMessageEncoder {
	private List<MemberArrayItem> list = new LinkedList<MemberArrayItem>();

	public List<MemberArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (MemberArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getConfigId());
			data.writeInt(item.getLevel());
			data.writeInt(item.getFamilyPositionId());
			data.writeInt(item.getHuoyuedu());
			data.writeInt(item.getZhanli());
			data.writeInt(item.getTime());
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
			MemberArrayItem item = MemberArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setConfigId(data.getInt());
			item.setLevel(data.getInt());
			item.setFamilyPositionId(data.getInt());
			item.setHuoyuedu(data.getInt());
			item.setZhanli(data.getInt());
			item.setTime(data.getInt());
			item.setVip(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (MemberArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static MemberArray create() {
		MemberArray array = new MemberArray();
		return array;
	}

	public static MemberArrayItem createItem() {
		MemberArrayItem item = new MemberArrayItem();
		return item;
	}

	public MemberArrayItem addData(long userId, String userName, int configId, int level, int familyPositionId, int huoyuedu, int zhanli, int time, int vip) {
		MemberArrayItem item = new MemberArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setConfigId(configId);
		item.setLevel(level);
		item.setFamilyPositionId(familyPositionId);
		item.setHuoyuedu(huoyuedu);
		item.setZhanli(zhanli);
		item.setTime(time);
		item.setVip(vip);
		list.add(item);
		return item;
	}

	public void addItem(MemberArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (MemberArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class MemberArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int configId;
		private int level;
		private int familyPositionId;
		private int huoyuedu;
		private int zhanli;
		private int time;
		private int vip;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler configIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ConfigId");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler familyPositionIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyPositionId");
		private static IntMessageParameterHandler huoyueduHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Huoyuedu");
		private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");
		private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");

		public static MemberArrayItem create() {
			MemberArrayItem item = new MemberArrayItem();
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
		 * @return the familyPositionId
		 */
		public int getFamilyPositionId() {
			return familyPositionId;
		}

		/**
		 * @param familyPositionId
		 *            the familyPositionId to set
		 */
		public void setFamilyPositionId(int familyPositionId) {
			this.familyPositionId = familyPositionId;
		}
		/**
		 * @return the huoyuedu
		 */
		public int getHuoyuedu() {
			return huoyuedu;
		}

		/**
		 * @param huoyuedu
		 *            the huoyuedu to set
		 */
		public void setHuoyuedu(int huoyuedu) {
			this.huoyuedu = huoyuedu;
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
			data.writeInt(this.configId);
			data.writeInt(this.level);
			data.writeInt(this.familyPositionId);
			data.writeInt(this.huoyuedu);
			data.writeInt(this.zhanli);
			data.writeInt(this.time);
			data.writeInt(this.vip);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.configId = data.getInt();
			this.level = data.getInt();
			this.familyPositionId = data.getInt();
			this.huoyuedu = data.getInt();
			this.zhanli = data.getInt();
			this.time = data.getInt();
			this.vip = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!configIdHandler.validate(configId)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!familyPositionIdHandler.validate(familyPositionId)) {
				return false;
			}
			if (!huoyueduHandler.validate(huoyuedu)) {
				return false;
			}
			if (!zhanliHandler.validate(zhanli)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
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
			bb.append("configId:").append(this.configId).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("familyPositionId:").append(this.familyPositionId).append(", ");
			bb.append("huoyuedu:").append(this.huoyuedu).append(", ");
			bb.append("zhanli:").append(this.zhanli).append(", ");
			bb.append("time:").append(this.time).append(", ");
			bb.append("vip:").append(this.vip);
			return bb.toString();	
		}
	}
}