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
public class OperationActivityArray implements IMessageEncoder {
	private List<OperationActivityArrayItem> list = new LinkedList<OperationActivityArrayItem>();

	public List<OperationActivityArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (OperationActivityArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeString(item.getTitle());
			data.writeInt(item.getValue());
			data.writeInt(item.getSort());
			data.writeInt(item.getBooleanValue());
			data.writeInt(item.getBeginTime());
			data.writeInt(item.getEndTime());
			data.writeInt(item.getRemainSeconds());
			data.writeInt(item.getTemplateId());
			data.writeString(item.getContent());
			data.writeInt(item.getArtId());
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
			OperationActivityArrayItem item = OperationActivityArrayItem.create();
			item.setID(data.getLong());
			item.setTitle(data.getString());
			item.setValue(data.getInt());
			item.setSort(data.getInt());
			item.setBooleanValue(data.getInt());
			item.setBeginTime(data.getInt());
			item.setEndTime(data.getInt());
			item.setRemainSeconds(data.getInt());
			item.setTemplateId(data.getInt());
			item.setContent(data.getString());
			item.setArtId(data.getInt());
			item.setParam1(data.getInt());
			item.setParam2(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (OperationActivityArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static OperationActivityArray create() {
		OperationActivityArray array = new OperationActivityArray();
		return array;
	}

	public static OperationActivityArrayItem createItem() {
		OperationActivityArrayItem item = new OperationActivityArrayItem();
		return item;
	}

	public OperationActivityArrayItem addData(long iD, String title, int value, int sort, int booleanValue, int beginTime, int endTime, int remainSeconds, int templateId, String content, int artId, int param1, int param2) {
		OperationActivityArrayItem item = new OperationActivityArrayItem();
		item.setID(iD);
		item.setTitle(title);
		item.setValue(value);
		item.setSort(sort);
		item.setBooleanValue(booleanValue);
		item.setBeginTime(beginTime);
		item.setEndTime(endTime);
		item.setRemainSeconds(remainSeconds);
		item.setTemplateId(templateId);
		item.setContent(content);
		item.setArtId(artId);
		item.setParam1(param1);
		item.setParam2(param2);
		list.add(item);
		return item;
	}

	public void addItem(OperationActivityArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (OperationActivityArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class OperationActivityArrayItem implements IMessageEncoder {
		private long iD;
		private String title;
		private int value;
		private int sort;
		private int booleanValue;
		private int beginTime;
		private int endTime;
		private int remainSeconds;
		private int templateId;
		private String content;
		private int artId;
		private int param1;
		private int param2;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler valueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Value");
		private static IntMessageParameterHandler sortHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Sort");
		private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
		private static IntMessageParameterHandler beginTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BeginTime");
		private static IntMessageParameterHandler endTimeHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("EndTime");
		private static IntMessageParameterHandler remainSecondsHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("RemainSeconds");
		private static IntMessageParameterHandler templateIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TemplateId");
		private static IntMessageParameterHandler artIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ArtId");
		private static IntMessageParameterHandler param1Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param1");
		private static IntMessageParameterHandler param2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Param2");

		public static OperationActivityArrayItem create() {
			OperationActivityArrayItem item = new OperationActivityArrayItem();
			return item;
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
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}
		/**
		 * @return the sort
		 */
		public int getSort() {
			return sort;
		}

		/**
		 * @param sort
		 *            the sort to set
		 */
		public void setSort(int sort) {
			this.sort = sort;
		}
		/**
		 * @return the booleanValue
		 */
		public int getBooleanValue() {
			return booleanValue;
		}

		/**
		 * @param booleanValue
		 *            the booleanValue to set
		 */
		public void setBooleanValue(int booleanValue) {
			this.booleanValue = booleanValue;
		}
		/**
		 * @return the beginTime
		 */
		public int getBeginTime() {
			return beginTime;
		}

		/**
		 * @param beginTime
		 *            the beginTime to set
		 */
		public void setBeginTime(int beginTime) {
			this.beginTime = beginTime;
		}
		/**
		 * @return the endTime
		 */
		public int getEndTime() {
			return endTime;
		}

		/**
		 * @param endTime
		 *            the endTime to set
		 */
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		/**
		 * @return the remainSeconds
		 */
		public int getRemainSeconds() {
			return remainSeconds;
		}

		/**
		 * @param remainSeconds
		 *            the remainSeconds to set
		 */
		public void setRemainSeconds(int remainSeconds) {
			this.remainSeconds = remainSeconds;
		}
		/**
		 * @return the templateId
		 */
		public int getTemplateId() {
			return templateId;
		}

		/**
		 * @param templateId
		 *            the templateId to set
		 */
		public void setTemplateId(int templateId) {
			this.templateId = templateId;
		}
		/**
		 * @return the content
		 */
		public String getContent() {
			return content;
		}

		/**
		 * @param content
		 *            the content to set
		 */
		public void setContent(String content) {
			this.content = content;
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
			data.writeLong(this.iD);
			data.writeString(this.title);
			data.writeInt(this.value);
			data.writeInt(this.sort);
			data.writeInt(this.booleanValue);
			data.writeInt(this.beginTime);
			data.writeInt(this.endTime);
			data.writeInt(this.remainSeconds);
			data.writeInt(this.templateId);
			data.writeString(this.content);
			data.writeInt(this.artId);
			data.writeInt(this.param1);
			data.writeInt(this.param2);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.title = data.getString();
			this.value = data.getInt();
			this.sort = data.getInt();
			this.booleanValue = data.getInt();
			this.beginTime = data.getInt();
			this.endTime = data.getInt();
			this.remainSeconds = data.getInt();
			this.templateId = data.getInt();
			this.content = data.getString();
			this.artId = data.getInt();
			this.param1 = data.getInt();
			this.param2 = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!valueHandler.validate(value)) {
				return false;
			}
			if (!sortHandler.validate(sort)) {
				return false;
			}
			if (!booleanValueHandler.validate(booleanValue)) {
				return false;
			}
			if (!beginTimeHandler.validate(beginTime)) {
				return false;
			}
			if (!endTimeHandler.validate(endTime)) {
				return false;
			}
			if (!remainSecondsHandler.validate(remainSeconds)) {
				return false;
			}
			if (!templateIdHandler.validate(templateId)) {
				return false;
			}
			if (!artIdHandler.validate(artId)) {
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
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("title:").append(this.title).append(", ");
			bb.append("value:").append(this.value).append(", ");
			bb.append("sort:").append(this.sort).append(", ");
			bb.append("booleanValue:").append(this.booleanValue).append(", ");
			bb.append("beginTime:").append(this.beginTime).append(", ");
			bb.append("endTime:").append(this.endTime).append(", ");
			bb.append("remainSeconds:").append(this.remainSeconds).append(", ");
			bb.append("templateId:").append(this.templateId).append(", ");
			bb.append("content:").append(this.content).append(", ");
			bb.append("artId:").append(this.artId).append(", ");
			bb.append("param1:").append(this.param1).append(", ");
			bb.append("param2:").append(this.param2);
			return bb.toString();	
		}
	}
}