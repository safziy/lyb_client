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
public class RankArray implements IMessageEncoder {
	private List<RankArrayItem> list = new LinkedList<RankArrayItem>();

	public List<RankArrayItem> list(){
		return list;
	}

	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(list.size());
		for (RankArrayItem item : list) {
			data.writeLong(item.getID());
			data.writeInt(item.getRanking());
			data.writeString(item.getParamStr1());
			data.writeString(item.getParamStr2());
			data.writeString(item.getParamStr3());
			data.writeString(item.getParamStr4());
			data.writeString(item.getParamStr5());
			data.writeString(item.getParamStr6());
			data.writeString(item.getParamStr7());
			data.writeString(item.getParamStr8());
			data.writeString(item.getParamStr9());
			item.getRankGeneralArray().encode(data);
			data.writeInt(item.getCount());
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
			RankArrayItem item = RankArrayItem.create();
			item.setID(data.getLong());
			item.setRanking(data.getInt());
			item.setParamStr1(data.getString());
			item.setParamStr2(data.getString());
			item.setParamStr3(data.getString());
			item.setParamStr4(data.getString());
			item.setParamStr5(data.getString());
			item.setParamStr6(data.getString());
			item.setParamStr7(data.getString());
			item.setParamStr8(data.getString());
			item.setParamStr9(data.getString());
			item.setRankGeneralArray(RankGeneralArray.create());
			item.getRankGeneralArray().decode(data);
			item.setCount(data.getInt());
			item.setVip(data.getInt());
			list.add(item);
		}
	}

	@Override
	public boolean validate() {
		for (RankArrayItem item : list) {
			if (!item.validate()) {
				return false;
			}
		}
		return true;
	}

	public static RankArray create() {
		RankArray array = new RankArray();
		return array;
	}

	public static RankArrayItem createItem() {
		RankArrayItem item = new RankArrayItem();
		return item;
	}

	public RankArrayItem addData(long iD, int ranking, String paramStr1, String paramStr2, String paramStr3, String paramStr4, String paramStr5, String paramStr6, String paramStr7, String paramStr8, String paramStr9, RankGeneralArray rankGeneralArray, int count, int vip) {
		RankArrayItem item = new RankArrayItem();
		item.setID(iD);
		item.setRanking(ranking);
		item.setParamStr1(paramStr1);
		item.setParamStr2(paramStr2);
		item.setParamStr3(paramStr3);
		item.setParamStr4(paramStr4);
		item.setParamStr5(paramStr5);
		item.setParamStr6(paramStr6);
		item.setParamStr7(paramStr7);
		item.setParamStr8(paramStr8);
		item.setParamStr9(paramStr9);
		item.setRankGeneralArray(rankGeneralArray);
		item.setCount(count);
		item.setVip(vip);
		list.add(item);
		return item;
	}

	public void addItem(RankArrayItem item) {
		list.add(item);
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("[");
		int i = 0;
		for (RankArrayItem item : list) {
			bb.append("{").append(item.toString()).append("}");
			i++;
			if (i != list.size()) {
				bb.append(", ");
			}
		}
		bb.append("]");
		return bb.toString();
	}
	
	public static class RankArrayItem implements IMessageEncoder {
		private long iD;
		private int ranking;
		private String paramStr1;
		private String paramStr2;
		private String paramStr3;
		private String paramStr4;
		private String paramStr5;
		private String paramStr6;
		private String paramStr7;
		private String paramStr8;
		private String paramStr9;
		private RankGeneralArray rankGeneralArray;
		private int count;
		private int vip;

		private static LongMessageParameterHandler iDHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("ID");
		private static IntMessageParameterHandler rankingHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Ranking");
		private static IntMessageParameterHandler countHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Count");
		private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");

		public static RankArrayItem create() {
			RankArrayItem item = new RankArrayItem();
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
		 * @return the ranking
		 */
		public int getRanking() {
			return ranking;
		}

		/**
		 * @param ranking
		 *            the ranking to set
		 */
		public void setRanking(int ranking) {
			this.ranking = ranking;
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
		 * @return the paramStr5
		 */
		public String getParamStr5() {
			return paramStr5;
		}

		/**
		 * @param paramStr5
		 *            the paramStr5 to set
		 */
		public void setParamStr5(String paramStr5) {
			this.paramStr5 = paramStr5;
		}
		/**
		 * @return the paramStr6
		 */
		public String getParamStr6() {
			return paramStr6;
		}

		/**
		 * @param paramStr6
		 *            the paramStr6 to set
		 */
		public void setParamStr6(String paramStr6) {
			this.paramStr6 = paramStr6;
		}
		/**
		 * @return the paramStr7
		 */
		public String getParamStr7() {
			return paramStr7;
		}

		/**
		 * @param paramStr7
		 *            the paramStr7 to set
		 */
		public void setParamStr7(String paramStr7) {
			this.paramStr7 = paramStr7;
		}
		/**
		 * @return the paramStr8
		 */
		public String getParamStr8() {
			return paramStr8;
		}

		/**
		 * @param paramStr8
		 *            the paramStr8 to set
		 */
		public void setParamStr8(String paramStr8) {
			this.paramStr8 = paramStr8;
		}
		/**
		 * @return the paramStr9
		 */
		public String getParamStr9() {
			return paramStr9;
		}

		/**
		 * @param paramStr9
		 *            the paramStr9 to set
		 */
		public void setParamStr9(String paramStr9) {
			this.paramStr9 = paramStr9;
		}
		/**
		 * @return the rankGeneralArray
		 */
		public RankGeneralArray getRankGeneralArray() {
			return rankGeneralArray;
		}

		/**
		 * @param rankGeneralArray
		 *            the rankGeneralArray to set
		 */
		public void setRankGeneralArray(RankGeneralArray rankGeneralArray) {
			this.rankGeneralArray = rankGeneralArray;
		}
		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}

		/**
		 * @param count
		 *            the count to set
		 */
		public void setCount(int count) {
			this.count = count;
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
			data.writeLong(this.iD);
			data.writeInt(this.ranking);
			data.writeString(this.paramStr1);
			data.writeString(this.paramStr2);
			data.writeString(this.paramStr3);
			data.writeString(this.paramStr4);
			data.writeString(this.paramStr5);
			data.writeString(this.paramStr6);
			data.writeString(this.paramStr7);
			data.writeString(this.paramStr8);
			data.writeString(this.paramStr9);
			rankGeneralArray.encode(data);
			data.writeInt(this.count);
			data.writeInt(this.vip);
		}
		
		
		/**
		 * 解码
		 */
		@Override
		public void decode(Data data) {
			this.iD = data.getLong();
			this.ranking = data.getInt();
			this.paramStr1 = data.getString();
			this.paramStr2 = data.getString();
			this.paramStr3 = data.getString();
			this.paramStr4 = data.getString();
			this.paramStr5 = data.getString();
			this.paramStr6 = data.getString();
			this.paramStr7 = data.getString();
			this.paramStr8 = data.getString();
			this.paramStr9 = data.getString();
			rankGeneralArray = RankGeneralArray.create();
			rankGeneralArray.decode(data);
			this.count = data.getInt();
			this.vip = data.getInt();
		}
	
		@Override
		public boolean validate() {
			if (!iDHandler.validate(iD)) {
				return false;
			}
			if (!rankingHandler.validate(ranking)) {
				return false;
			}
			if (!rankGeneralArray.validate()) {
				return false;
			}
			if (!countHandler.validate(count)) {
				return false;
			}
			if (!vipHandler.validate(vip)) {
				return false;
			}
			return true;
		}
	
		public String toString() {
			StringBuilder bb = new StringBuilder();
			bb.append("iD:").append(this.iD).append(", ");
			bb.append("ranking:").append(this.ranking).append(", ");
			bb.append("paramStr1:").append(this.paramStr1).append(", ");
			bb.append("paramStr2:").append(this.paramStr2).append(", ");
			bb.append("paramStr3:").append(this.paramStr3).append(", ");
			bb.append("paramStr4:").append(this.paramStr4).append(", ");
			bb.append("paramStr5:").append(this.paramStr5).append(", ");
			bb.append("paramStr6:").append(this.paramStr6).append(", ");
			bb.append("paramStr7:").append(this.paramStr7).append(", ");
			bb.append("paramStr8:").append(this.paramStr8).append(", ");
			bb.append("paramStr9:").append(this.paramStr9).append(", ");
			bb.append("rankGeneralArray:").append(rankGeneralArray.toString()).append(", ");
			bb.append("count:").append(this.count).append(", ");
			bb.append("vip:").append(this.vip);
			return bb.toString();	
		}
	}
}