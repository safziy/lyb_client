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
public class HuanzhuangArray implements IMessageEncoder {
	private List<HuanzhuangArrayItem> list = new LinkedList<HuanzhuangArrayItem>();

	public List<HuanzhuangArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (HuanzhuangArrayItem item : list) {
			data.writeLong(item.getGeneralId());
			data.writeInt(item.getBodyId());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			HuanzhuangArrayItem item = HuanzhuangArrayItem.create();
			item.setGeneralId(data.getLong());
			item.setBodyId(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (HuanzhuangArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static HuanzhuangArray create() {
		HuanzhuangArray array = new HuanzhuangArray();
		return array;
	}

	public static HuanzhuangArrayItem createItem() {
		HuanzhuangArrayItem item = new HuanzhuangArrayItem();
		return item;
	}

	public HuanzhuangArrayItem addData(long generalId, int bodyId) {
		HuanzhuangArrayItem item = new HuanzhuangArrayItem();
		item.setGeneralId(generalId);
		item.setBodyId(bodyId);
		list.add(item);
		return item;
	}

	public void addItem(HuanzhuangArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (HuanzhuangArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class HuanzhuangArrayItem implements IMessageEncoder {
		private long generalId;
		private int bodyId;

		private static LongMessageParameterHandler generalIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("GeneralId");
		private static IntMessageParameterHandler bodyIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BodyId");

		public static HuanzhuangArrayItem create() {
			HuanzhuangArrayItem item = new HuanzhuangArrayItem();
			return item;
		}

		/**
		 * @return the generalId
		 */
		public long getGeneralId() {
			return generalId;
		}

		/**
		 * @param generalId
		 *            the generalId to set
		 */
		public void setGeneralId(long generalId) {
			this.generalId = generalId;
		}
		/**
		 * @return the bodyId
		 */
		public int getBodyId() {
			return bodyId;
		}

		/**
		 * @param bodyId
		 *            the bodyId to set
		 */
		public void setBodyId(int bodyId) {
			this.bodyId = bodyId;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeLong(this.generalId);
			data.writeInt(this.bodyId);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.generalId = data.getLong();
			this.bodyId = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!generalIdHandler.validate(generalId)) {
				return false;
			}
			if (!bodyIdHandler.validate(bodyId)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("generalId:").append(this.generalId).append(", ");
			bb.append("bodyId:").append(this.bodyId);
			return bb.toString();	
		}
	}
}