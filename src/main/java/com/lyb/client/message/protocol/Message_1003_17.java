package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回  玩家常修改属性
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_17 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 17;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 17);

	private int vip;
	private int level;
	private int experience;

	private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");
	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
	private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");

	public static Message_1003_17 create() {
		return new Message_1003_17();
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
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param experience
	 *            the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.vip);
		data.writeInt(this.level);
		data.writeInt(this.experience);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.vip = data.getInt();
		this.level = data.getInt();
		this.experience = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!vipHandler.validate(vip)) {
			return false;
		}
		if (!levelHandler.validate(level)) {
			return false;
		}
		if (!experienceHandler.validate(experience)) {
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
		bb.append("vip:").append(this.vip).append(", ");
		bb.append("level:").append(this.level).append(", ");
		bb.append("experience:").append(this.experience);
		return bb.toString();	
	}
}