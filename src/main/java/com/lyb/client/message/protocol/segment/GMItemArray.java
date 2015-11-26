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
public class GMItemArray implements IMessageEncoder {
	private List<GMItemArrayItem> list = new LinkedList<GMItemArrayItem>();

	public List<GMItemArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (GMItemArrayItem item : list) {
			data.writeInt(item.getItemId());
			data.writeString(item.getItemName());
			data.writeInt(item.getArtId());
			data.writeInt(item.getColor());
			data.writeInt(item.getPrice());
			data.writeInt(item.getOverlap());
			data.writeInt(item.getFunctionId());
			data.writeString(item.getFunction());
			data.writeString(item.getOrigin());
			data.writeInt(item.getParam1());
			data.writeInt(item.getParam2());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			GMItemArrayItem item = GMItemArrayItem.create();
			item.setItemId(data.getInt());
			item.setItemName(data.getString());
			item.setArtId(data.getInt());
			item.setColor(data.getInt());
			item.setPrice(data.getInt());
			item.setOverlap(data.getInt());
			item.setFunctionId(data.getInt());
			item.setFunction(data.getString());
			item.setOrigin(data.getString());
			item.setParam1(data.getInt());
			item.setParam2(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (GMItemArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static GMItemArray create() {
		GMItemArray array = new GMItemArray();
		return array;
	}

	public static GMItemArrayItem createItem() {
		GMItemArrayItem item = new GMItemArrayItem();
		return item;
	}

	public GMItemArrayItem addData(int itemId, String itemName, int artId, int color, int price, int overlap, int functionId, String function, String origin, int param1, int param2) {
		GMItemArrayItem item = new GMItemArrayItem();
		item.setItemId(itemId);
		item.setItemName(itemName);
		item.setArtId(artId);
		item.setColor(color);
		item.setPrice(price);
		item.setOverlap(overlap);
		item.setFunctionId(functionId);
		item.setFunction(function);
		item.setOrigin(origin);
		item.setParam1(param1);
		item.setParam2(param2);
		list.add(item);
		return item;
	}

	public void addItem(GMItemArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (GMItemArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class GMItemArrayItem implements IMessageEncoder {
		private int itemId;
		private String itemName;
		private int artId;
		private int color;
		private int price;
		private int overlap;
		private int functionId;
		private String function;
		private String origin;
		private int param1;
		private int param2;

		private static IntMessageParameterHandler itemIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ItemId");
		private static IntMessageParameterHandler artIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ArtId");
		private static IntMessageParameterHandler colorHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Color");
		private static IntMessageParameterHandler priceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Price");
		private static IntMessageParameterHandler overlapHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Overlap");
		private static IntMessageParameterHandler functionIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FunctionId");
		private static IntMessageParameterHandler param1Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param1");
		private static IntMessageParameterHandler param2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param2");

		public static GMItemArrayItem create() {
			GMItemArrayItem item = new GMItemArrayItem();
			return item;
		}

		/**
		 * @return the itemId
		 */
		public int getItemId() {
			return itemId;
		}

		/**
		 * @param itemId
		 *            the itemId to set
		 */
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		/**
		 * @return the itemName
		 */
		public String getItemName() {
			return itemName;
		}

		/**
		 * @param itemName
		 *            the itemName to set
		 */
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		/**
		 * @return the artId
		 */
		public int getArtId() {
			return artId;
		}

		/**
		 * @param artId
		 *            the artId to set
		 */
		public void setArtId(int artId) {
			this.artId = artId;
		}
		/**
		 * @return the color
		 */
		public int getColor() {
			return color;
		}

		/**
		 * @param color
		 *            the color to set
		 */
		public void setColor(int color) {
			this.color = color;
		}
		/**
		 * @return the price
		 */
		public int getPrice() {
			return price;
		}

		/**
		 * @param price
		 *            the price to set
		 */
		public void setPrice(int price) {
			this.price = price;
		}
		/**
		 * @return the overlap
		 */
		public int getOverlap() {
			return overlap;
		}

		/**
		 * @param overlap
		 *            the overlap to set
		 */
		public void setOverlap(int overlap) {
			this.overlap = overlap;
		}
		/**
		 * @return the functionId
		 */
		public int getFunctionId() {
			return functionId;
		}

		/**
		 * @param functionId
		 *            the functionId to set
		 */
		public void setFunctionId(int functionId) {
			this.functionId = functionId;
		}
		/**
		 * @return the function
		 */
		public String getFunction() {
			return function;
		}

		/**
		 * @param function
		 *            the function to set
		 */
		public void setFunction(String function) {
			this.function = function;
		}
		/**
		 * @return the origin
		 */
		public String getOrigin() {
			return origin;
		}

		/**
		 * @param origin
		 *            the origin to set
		 */
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		/**
		 * @return the param1
		 */
		public int getParam1() {
			return param1;
		}

		/**
		 * @param param1
		 *            the param1 to set
		 */
		public void setParam1(int param1) {
			this.param1 = param1;
		}
		/**
		 * @return the param2
		 */
		public int getParam2() {
			return param2;
		}

		/**
		 * @param param2
		 *            the param2 to set
		 */
		public void setParam2(int param2) {
			this.param2 = param2;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeInt(this.itemId);
			data.writeString(this.itemName);
			data.writeInt(this.artId);
			data.writeInt(this.color);
			data.writeInt(this.price);
			data.writeInt(this.overlap);
			data.writeInt(this.functionId);
			data.writeString(this.function);
			data.writeString(this.origin);
			data.writeInt(this.param1);
			data.writeInt(this.param2);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.itemId = data.getInt();
			this.itemName = data.getString();
			this.artId = data.getInt();
			this.color = data.getInt();
			this.price = data.getInt();
			this.overlap = data.getInt();
			this.functionId = data.getInt();
			this.function = data.getString();
			this.origin = data.getString();
			this.param1 = data.getInt();
			this.param2 = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!itemIdHandler.validate(itemId)) {
				return false;
			}
			if (!artIdHandler.validate(artId)) {
				return false;
			}
			if (!colorHandler.validate(color)) {
				return false;
			}
			if (!priceHandler.validate(price)) {
				return false;
			}
			if (!overlapHandler.validate(overlap)) {
				return false;
			}
			if (!functionIdHandler.validate(functionId)) {
				return false;
			}
			if (!param1Handler.validate(param1)) {
				return false;
			}
			if (!param2Handler.validate(param2)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("itemId:").append(this.itemId).append(", ");
			bb.append("itemName:").append(this.itemName).append(", ");
			bb.append("artId:").append(this.artId).append(", ");
			bb.append("color:").append(this.color).append(", ");
			bb.append("price:").append(this.price).append(", ");
			bb.append("overlap:").append(this.overlap).append(", ");
			bb.append("functionId:").append(this.functionId).append(", ");
			bb.append("function:").append(this.function).append(", ");
			bb.append("origin:").append(this.origin).append(", ");
			bb.append("param1:").append(this.param1).append(", ");
			bb.append("param2:").append(this.param2);
			return bb.toString();	
		}
	}
}