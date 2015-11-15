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
public class FactionUserArray1 implements IMessageEncoder {
	private List<FactionUserArray1Item> list = new LinkedList<FactionUserArray1Item>();

	public List<FactionUserArray1Item> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FactionUserArray1Item item : list) {
			data.writeString(item.getUserName());
			data.writeInt(item.getLevel());
			data.writeInt(item.getPlace());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FactionUserArray1Item item = FactionUserArray1Item.create();
			item.setUserName(data.getString());
			item.setLevel(data.getInt());
			item.setPlace(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FactionUserArray1Item item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FactionUserArray1 create() {
		FactionUserArray1 array = new FactionUserArray1();
		return array;
	}

	public static FactionUserArray1Item createItem() {
		FactionUserArray1Item item = new FactionUserArray1Item();
		return item;
	}

	public FactionUserArray1Item addData(String userName, int level, int place) {
		FactionUserArray1Item item = new FactionUserArray1Item();
		item.setUserName(userName);
		item.setLevel(level);
		item.setPlace(place);
		list.add(item);
		return item;
	}

	public void addItem(FactionUserArray1Item item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FactionUserArray1Item item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FactionUserArray1Item implements IMessageEncoder {
		private String userName;
		private int level;
		private int place;

		private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
		private static IntMessageParameterHandler placeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Place");

		public static FactionUserArray1Item create() {
			FactionUserArray1Item item = new FactionUserArray1Item();
			return item;
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
		 * @return the place
		 */
		public int getPlace() {
			return place;
		}

		/**
		 * @param place
		 *            the place to set
		 */
		public void setPlace(int place) {
			this.place = place;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.userName);
			data.writeInt(this.level);
			data.writeInt(this.place);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.userName = data.getString();
			this.level = data.getInt();
			this.place = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!levelHandler.validate(level)) {
				return false;
			}
			if (!placeHandler.validate(place)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("userName:").append(this.userName).append(", ");
			bb.append("level:").append(this.level).append(", ");
			bb.append("place:").append(this.place);
			return bb.toString();	
		}
	}
}