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
public class ErrorMessageArray implements IMessageEncoder {
	private List<ErrorMessageArrayItem> list = new LinkedList<ErrorMessageArrayItem>();

	public List<ErrorMessageArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (ErrorMessageArrayItem item : list) {
			data.writeString(item.getErrorMessage());
		}
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		int size = data.getInt();
		for (int i = 0; i < size; i++) {
			ErrorMessageArrayItem item = ErrorMessageArrayItem.create();
			item.setErrorMessage(data.getString());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (ErrorMessageArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static ErrorMessageArray create() {
		ErrorMessageArray array = new ErrorMessageArray();
		return array;
	}

	public static ErrorMessageArrayItem createItem() {
		ErrorMessageArrayItem item = new ErrorMessageArrayItem();
		return item;
	}

	public ErrorMessageArrayItem addData(String errorMessage) {
		ErrorMessageArrayItem item = new ErrorMessageArrayItem();
		item.setErrorMessage(errorMessage);
		list.add(item);
		return item;
	}

	public void addItem(ErrorMessageArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (ErrorMessageArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class ErrorMessageArrayItem implements IMessageEncoder {
		private String errorMessage;


		public static ErrorMessageArrayItem create() {
			ErrorMessageArrayItem item = new ErrorMessageArrayItem();
			return item;
		}

		/**
		 * @return the errorMessage
		 */
		public String getErrorMessage() {
			return errorMessage;
		}

		/**
		 * @param errorMessage
		 *            the errorMessage to set
		 */
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		/**
		 * 编码
		 */
		@Override
		public void encode(Data data) {
			data.writeString(this.errorMessage);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.errorMessage = data.getString();
		}
	
		@Override
		public boolean validate() {
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("errorMessage:").append(this.errorMessage);
			return bb.toString();	
		}
	}
}