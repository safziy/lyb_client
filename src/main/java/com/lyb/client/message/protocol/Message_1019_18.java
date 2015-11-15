package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.protocol.segment.PlaceConfigArray;
import com.lyb.client.message.protocol.segment.TargetStateArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 十国征战对手信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1019_18 implements IMessage {

	private static int MAIN = 1019;
	private static int SUB = 18;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1019, 18);

	private String userName;
	private int level;
	private int zhanli;
	private int formationId;
	private PlaceConfigArray placeConfigArray;
	private TargetStateArray targetStateArray;

	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
	private static IntMessageParameterHandler zhanliHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Zhanli");
	private static IntMessageParameterHandler formationIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FormationId");

	public static Message_1019_18 create() {
		return new Message_1019_18();
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
	 * @return the zhanli
	 */
	public int getZhanli() {
		return zhanli;
	}

	/**
	 * @param zhanli
	 *            the zhanli to set
	 */
	public void setZhanli(int zhanli) {
		this.zhanli = zhanli;
	}

	/**
	 * @return the formationId
	 */
	public int getFormationId() {
		return formationId;
	}

	/**
	 * @param formationId
	 *            the formationId to set
	 */
	public void setFormationId(int formationId) {
		this.formationId = formationId;
	}

	/**
	 * @return the placeConfigArray
	 */
	public PlaceConfigArray getPlaceConfigArray() {
		return placeConfigArray;
	}

	/**
	 * @param placeConfigArray
	 *            the placeConfigArray to set
	 */
	public void setPlaceConfigArray(PlaceConfigArray placeConfigArray) {
		this.placeConfigArray = placeConfigArray;
	}

	/**
	 * @return the targetStateArray
	 */
	public TargetStateArray getTargetStateArray() {
		return targetStateArray;
	}

	/**
	 * @param targetStateArray
	 *            the targetStateArray to set
	 */
	public void setTargetStateArray(TargetStateArray targetStateArray) {
		this.targetStateArray = targetStateArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.userName);
		data.writeInt(this.level);
		data.writeInt(this.zhanli);
		data.writeInt(this.formationId);
		placeConfigArray.encode(data);
		targetStateArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.userName = data.getString();
		this.level = data.getInt();
		this.zhanli = data.getInt();
		this.formationId = data.getInt();
		placeConfigArray = PlaceConfigArray.create();
		placeConfigArray.decode(data);
		targetStateArray = TargetStateArray.create();
		targetStateArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!levelHandler.validate(level)) {
			return false;
		}
		if (!zhanliHandler.validate(zhanli)) {
			return false;
		}
		if (!formationIdHandler.validate(formationId)) {
			return false;
		}
		if (!placeConfigArray.validate()) {
			return false;
		}
		if (!targetStateArray.validate()) {
			return false;
		}
		return true;
	}

	@Override
	public int getMain() {
		return MAIN;
	}

	@Override
	public int getSub() {
		return SUB;
	}

	@Override
	public String getMessageKey() {
		return MESSAGE_KEY;
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("userName:").append(this.userName).append(", ");
		bb.append("level:").append(this.level).append(", ");
		bb.append("zhanli:").append(this.zhanli).append(", ");
		bb.append("formationId:").append(this.formationId).append(", ");
		bb.append("placeConfigArray:").append(placeConfigArray.toString()).append(", ");
		bb.append("targetStateArray:").append(targetStateArray.toString());
		return bb.toString();	
	}
}