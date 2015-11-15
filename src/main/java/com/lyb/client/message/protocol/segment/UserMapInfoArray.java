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
public class UserMapInfoArray implements IMessageEncoder {
	private List<UserMapInfoArrayItem> list = new LinkedList<UserMapInfoArrayItem>();

	public List<UserMapInfoArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (UserMapInfoArrayItem item : list) {
			data.writeLong(item.getUserId());
			data.writeString(item.getUserName());
			data.writeInt(item.getVip());
			data.writeInt(item.getSpeed());
			data.writeInt(item.getCareer());
			data.writeInt(item.getCoordinateX());
			data.writeInt(item.getCoordinateY());
			data.writeInt(item.getLevel());
			item.getAbleTitleArray().encode(data);
			data.writeInt(item.getPetConfigId());
			data.writeInt(item.getState());
			data.writeString(item.getTargetUserName());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			UserMapInfoArrayItem item = UserMapInfoArrayItem.create();
			item.setUserId(data.getLong());
			item.setUserName(data.getString());
			item.setVip(data.getInt());
			item.setSpeed(data.getInt());
			item.setCareer(data.getInt());
			item.setCoordinateX(data.getInt());
			item.setCoordinateY(data.getInt());
			item.setLevel(data.getInt());
			item.setAbleTitleArray(AbleTitleArray.create());
			item.getAbleTitleArray().decode(data);
			item.setPetConfigId(data.getInt());
			item.setState(data.getInt());
			item.setTargetUserName(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (UserMapInfoArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static UserMapInfoArray create() {
		UserMapInfoArray array = new UserMapInfoArray();
		return array;
	}

	public static UserMapInfoArrayItem createItem() {
		UserMapInfoArrayItem item = new UserMapInfoArrayItem();
		return item;
	}

	public UserMapInfoArrayItem addData(long userId, String userName, int vip, int speed, int career, int coordinateX, int coordinateY, int level, AbleTitleArray ableTitleArray, int petConfigId, int state, String targetUserName) {
		UserMapInfoArrayItem item = new UserMapInfoArrayItem();
		item.setUserId(userId);
		item.setUserName(userName);
		item.setVip(vip);
		item.setSpeed(speed);
		item.setCareer(career);
		item.setCoordinateX(coordinateX);
		item.setCoordinateY(coordinateY);
		item.setLevel(level);
		item.setAbleTitleArray(ableTitleArray);
		item.setPetConfigId(petConfigId);
		item.setState(state);
		item.setTargetUserName(targetUserName);
		list.add(item);
		return item;
	}

	public void addItem(UserMapInfoArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (UserMapInfoArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class UserMapInfoArrayItem implements IMessageEncoder {
		private long userId;
		private String userName;
		private int vip;
		private int speed;
		private int career;
		private int coordinateX;
		private int coordinateY;
		private int level;
		private AbleTitleArray ableTitleArray;
		private int petConfigId;
		private int state;
		private String targetUserName;

		private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
		private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");
		private static IntMessageParameterHandler speedHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Speed");
		private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
		private static IntMessageParameterHandler coordinateXHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CoordinateX");
		private static IntMessageParameterHandler coordinateYHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CoordinateY");
		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler petConfigIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("PetConfigId");
		private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");

		public static UserMapInfoArrayItem create() {
			UserMapInfoArrayItem item = new UserMapInfoArrayItem();
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
		 * @return the speed
		 */
		public int getSpeed() {
			return speed;
		}

		/**
		 * @param speed
		 *            the speed to set
		 */
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		/**
		 * @return the career
		 */
		public int getCareer() {
			return career;
		}

		/**
		 * @param career
		 *            the career to set
		 */
		public void setCareer(int career) {
			this.career = career;
		}
		/**
		 * @return the coordinateX
		 */
		public int getCoordinateX() {
			return coordinateX;
		}

		/**
		 * @param coordinateX
		 *            the coordinateX to set
		 */
		public void setCoordinateX(int coordinateX) {
			this.coordinateX = coordinateX;
		}
		/**
		 * @return the coordinateY
		 */
		public int getCoordinateY() {
			return coordinateY;
		}

		/**
		 * @param coordinateY
		 *            the coordinateY to set
		 */
		public void setCoordinateY(int coordinateY) {
			this.coordinateY = coordinateY;
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
		 * @return the ableTitleArray
		 */
		public AbleTitleArray getAbleTitleArray() {
			return ableTitleArray;
		}

		/**
		 * @param ableTitleArray
		 *            the ableTitleArray to set
		 */
		public void setAbleTitleArray(AbleTitleArray ableTitleArray) {
			this.ableTitleArray = ableTitleArray;
		}
		/**
		 * @return the petConfigId
		 */
		public int getPetConfigId() {
			return petConfigId;
		}

		/**
		 * @param petConfigId
		 *            the petConfigId to set
		 */
		public void setPetConfigId(int petConfigId) {
			this.petConfigId = petConfigId;
		}
		/**
		 * @return the state
		 */
		public int getState() {
			return state;
		}

		/**
		 * @param state
		 *            the state to set
		 */
		public void setState(int state) {
			this.state = state;
		}
		/**
		 * @return the targetUserName
		 */
		public String getTargetUserName() {
			return targetUserName;
		}

		/**
		 * @param targetUserName
		 *            the targetUserName to set
		 */
		public void setTargetUserName(String targetUserName) {
			this.targetUserName = targetUserName;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.userId);
			data.writeString(this.userName);
			data.writeInt(this.vip);
			data.writeInt(this.speed);
			data.writeInt(this.career);
			data.writeInt(this.coordinateX);
			data.writeInt(this.coordinateY);
			data.writeInt(this.level);
			ableTitleArray.encode(data);
			data.writeInt(this.petConfigId);
			data.writeInt(this.state);
			data.writeString(this.targetUserName);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userId = data.getLong();
			this.userName = data.getString();
			this.vip = data.getInt();
			this.speed = data.getInt();
			this.career = data.getInt();
			this.coordinateX = data.getInt();
			this.coordinateY = data.getInt();
			this.level = data.getInt();
			ableTitleArray = AbleTitleArray.create();
			ableTitleArray.decode(data);
			this.petConfigId = data.getInt();
			this.state = data.getInt();
			this.targetUserName = data.getString();
		}
	
		@Override
		public boolean validate() {
			if (!userIdHandler.validate(userId)) {
				return false;
			}
			if (!vipHandler.validate(vip)) {
				return false;
			}
			if (!speedHandler.validate(speed)) {
				return false;
			}
			if (!careerHandler.validate(career)) {
				return false;
			}
			if (!coordinateXHandler.validate(coordinateX)) {
				return false;
			}
			if (!coordinateYHandler.validate(coordinateY)) {
				return false;
			}
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!ableTitleArray.validate()) {
				return false;
			}
			if (!petConfigIdHandler.validate(petConfigId)) {
				return false;
			}
			if (!stateHandler.validate(state)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userId:").append(this.userId).append(", ");
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("vip:").append(this.vip).append(", ");
			bb.append("speed:").append(this.speed).append(", ");
			bb.append("career:").append(this.career).append(", ");
			bb.append("coordinateX:").append(this.coordinateX).append(", ");
			bb.append("coordinateY:").append(this.coordinateY).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("ableTitleArray:").append(ableTitleArray.toString()).append(", ");
			bb.append("petConfigId:").append(this.petConfigId).append(", ");
			bb.append("state:").append(this.state).append(", ");
			bb.append("targetUserName:").append(this.targetUserName);
			return bb.toString();	
		}
	}
}