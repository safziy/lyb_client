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
public class FortGameLogArray implements IMessageEncoder {
	private List<FortGameLogArrayItem> list = new LinkedList<FortGameLogArrayItem>();

	public List<FortGameLogArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (FortGameLogArrayItem item : list) {
			data.writeString(item.getParamStr1());
			data.writeString(item.getParamStr2());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			FortGameLogArrayItem item = FortGameLogArrayItem.create();
			item.setParamStr1(data.getString());
			item.setParamStr2(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (FortGameLogArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static FortGameLogArray create() {
		FortGameLogArray array = new FortGameLogArray();
		return array;
	}

	public static FortGameLogArrayItem createItem() {
		FortGameLogArrayItem item = new FortGameLogArrayItem();
		return item;
	}

	public FortGameLogArrayItem addData(String paramStr1, String paramStr2) {
		FortGameLogArrayItem item = new FortGameLogArrayItem();
		item.setParamStr1(paramStr1);
		item.setParamStr2(paramStr2);
		list.add(item);
		return item;
	}

	public void addItem(FortGameLogArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (FortGameLogArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class FortGameLogArrayItem implements IMessageEncoder {
		private String paramStr1;
		private String paramStr2;


		public static FortGameLogArrayItem create() {
			FortGameLogArrayItem item = new FortGameLogArrayItem();
			return item;
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
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.paramStr1);
			data.writeString(this.paramStr2);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.paramStr1 = data.getString();
			this.paramStr2 = data.getString();
		}
	
		@Override
		public boolean validate() {
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("paramStr1:").append(this.paramStr1).append(", ");
			bb.append("paramStr2:").append(this.paramStr2);
			return bb.toString();	
		}
	}
}