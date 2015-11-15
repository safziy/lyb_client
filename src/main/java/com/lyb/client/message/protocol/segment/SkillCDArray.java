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
public class SkillCDArray implements IMessageEncoder {
	private List<SkillCDArrayItem> list = new LinkedList<SkillCDArrayItem>();

	public List<SkillCDArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (SkillCDArrayItem item : list) {
			data.writeInt(item.getSkillId());
			data.writeInt(item.getTime());
			data.writeInt(item.getCartoonTime());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			SkillCDArrayItem item = SkillCDArrayItem.create();
			item.setSkillId(data.getInt());
			item.setTime(data.getInt());
			item.setCartoonTime(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (SkillCDArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static SkillCDArray create() {
		SkillCDArray array = new SkillCDArray();
		return array;
	}

	public static SkillCDArrayItem createItem() {
		SkillCDArrayItem item = new SkillCDArrayItem();
		return item;
	}

	public SkillCDArrayItem addData(int skillId, int time, int cartoonTime) {
		SkillCDArrayItem item = new SkillCDArrayItem();
		item.setSkillId(skillId);
		item.setTime(time);
		item.setCartoonTime(cartoonTime);
		list.add(item);
		return item;
	}

	public void addItem(SkillCDArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (SkillCDArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class SkillCDArrayItem implements IMessageEncoder {
		private int skillId;
		private int time;
		private int cartoonTime;

		private static IntMessageParameterHandler skillIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SkillId");
		private static IntMessageParameterHandler timeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Time");
		private static IntMessageParameterHandler cartoonTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("CartoonTime");

		public static SkillCDArrayItem create() {
			SkillCDArrayItem item = new SkillCDArrayItem();
			return item;
		}

		/**
		 * @return the skillId
		 */
		public int getSkillId() {
			return skillId;
		}

		/**
		 * @param skillId
		 *            the skillId to set
		 */
		public void setSkillId(int skillId) {
			this.skillId = skillId;
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
		 * @return the cartoonTime
		 */
		public int getCartoonTime() {
			return cartoonTime;
		}

		/**
		 * @param cartoonTime
		 *            the cartoonTime to set
		 */
		public void setCartoonTime(int cartoonTime) {
			this.cartoonTime = cartoonTime;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.skillId);
			data.writeInt(this.time);
			data.writeInt(this.cartoonTime);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.skillId = data.getInt();
			this.time = data.getInt();
			this.cartoonTime = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!skillIdHandler.validate(skillId)) {
				return false;
			}
			if (!timeHandler.validate(time)) {
				return false;
			}
			if (!cartoonTimeHandler.validate(cartoonTime)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("skillId:").append(this.skillId).append(", ");
			bb.append("time:").append(this.time).append(", ");
			bb.append("cartoonTime:").append(this.cartoonTime);
			return bb.toString();	
		}
	}
}