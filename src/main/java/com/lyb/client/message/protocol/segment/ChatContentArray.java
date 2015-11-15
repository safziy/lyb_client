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
public class ChatContentArray implements IMessageEncoder {
	private List<ChatContentArrayItem> list = new LinkedList<ChatContentArrayItem>();

	public List<ChatContentArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ChatContentArrayItem item : list) {
			data.writeInt(item.getType());
			data.writeString(item.getParamStr1());
			data.writeString(item.getParamStr2());
			data.writeString(item.getParamStr3());
			data.writeString(item.getParamStr4());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ChatContentArrayItem item = ChatContentArrayItem.create();
			item.setType(data.getInt());
			item.setParamStr1(data.getString());
			item.setParamStr2(data.getString());
			item.setParamStr3(data.getString());
			item.setParamStr4(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ChatContentArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ChatContentArray create() {
		ChatContentArray array = new ChatContentArray();
		return array;
	}

	public static ChatContentArrayItem createItem() {
		ChatContentArrayItem item = new ChatContentArrayItem();
		return item;
	}

	public ChatContentArrayItem addData(int type, String paramStr1, String paramStr2, String paramStr3, String paramStr4) {
		ChatContentArrayItem item = new ChatContentArrayItem();
		item.setType(type);
		item.setParamStr1(paramStr1);
		item.setParamStr2(paramStr2);
		item.setParamStr3(paramStr3);
		item.setParamStr4(paramStr4);
		list.add(item);
		return item;
	}

	public void addItem(ChatContentArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ChatContentArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ChatContentArrayItem implements IMessageEncoder {
		private int type;
		private String paramStr1;
		private String paramStr2;
		private String paramStr3;
		private String paramStr4;

		private static IntMessageParameterHandler typeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Type");

		public static ChatContentArrayItem create() {
			ChatContentArrayItem item = new ChatContentArrayItem();
			return item;
		}

		/**
		 * @return the type
		 */
		public int getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(int type) {
			this.type = type;
		}
		/**
		 * @return the paramStr1
		 */
		public String getParamStr1() {
			return paramStr1;
		}

		/**
		 * @param paramStr1
		 *            the paramStr1 to set
		 */
		public void setParamStr1(String paramStr1) {
			this.paramStr1 = paramStr1;
		}
		/**
		 * @return the paramStr2
		 */
		public String getParamStr2() {
			return paramStr2;
		}

		/**
		 * @param paramStr2
		 *            the paramStr2 to set
		 */
		public void setParamStr2(String paramStr2) {
			this.paramStr2 = paramStr2;
		}
		/**
		 * @return the paramStr3
		 */
		public String getParamStr3() {
			return paramStr3;
		}

		/**
		 * @param paramStr3
		 *            the paramStr3 to set
		 */
		public void setParamStr3(String paramStr3) {
			this.paramStr3 = paramStr3;
		}
		/**
		 * @return the paramStr4
		 */
		public String getParamStr4() {
			return paramStr4;
		}

		/**
		 * @param paramStr4
		 *            the paramStr4 to set
		 */
		public void setParamStr4(String paramStr4) {
			this.paramStr4 = paramStr4;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.type);
			data.writeString(this.paramStr1);
			data.writeString(this.paramStr2);
			data.writeString(this.paramStr3);
			data.writeString(this.paramStr4);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.type = data.getInt();
			this.paramStr1 = data.getString();
			this.paramStr2 = data.getString();
			this.paramStr3 = data.getString();
			this.paramStr4 = data.getString();
		}
	
		@Override
		public boolean validate() {
			if (!typeHandler.validate(type)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("type:").append(this.type).append(", ");
			bb.append("paramStr1:").append(this.paramStr1).append(", ");
			bb.append("paramStr2:").append(this.paramStr2).append(", ");
			bb.append("paramStr3:").append(this.paramStr3).append(", ");
			bb.append("paramStr4:").append(this.paramStr4);
			return bb.toString();	
		}
	}
}