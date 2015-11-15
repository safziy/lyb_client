package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.protocol.segment.GeneralIdTableArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 玩家基本信息
 *
 * @author codeGenerator
 * 
 */
public class Message_1003_1 implements IMessage {

	private static int MAIN = 1003;
	private static int SUB = 1;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1003, 1);

	private String yunyingUserId;
	private long userId;
	private String userName;
	private int career;
	private int vip;
	private long familyId;
	private int familyPositionId;
	private String familyName;
	private int familyLevel;
	private int nobility;
	private GeneralIdTableArray generalIdTableArray;
	private int lastStrongPointId;
	private int state;
	private int stage;
	private int step;
	private int level;
	private int experience;
	private int transforId;
	private int zodiacId;

	private static LongMessageParameterHandler userIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("UserId");
	private static IntMessageParameterHandler careerHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Career");
	private static IntMessageParameterHandler vipHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Vip");
	private static LongMessageParameterHandler familyIdHandler = MessageParameterContext.getInstance().getLongMessageParameterHandler("FamilyId");
	private static IntMessageParameterHandler familyPositionIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyPositionId");
	private static IntMessageParameterHandler familyLevelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("FamilyLevel");
	private static IntMessageParameterHandler nobilityHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Nobility");
	private static IntMessageParameterHandler lastStrongPointIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("LastStrongPointId");
	private static IntMessageParameterHandler stateHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("State");
	private static IntMessageParameterHandler stageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Stage");
	private static IntMessageParameterHandler stepHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Step");
	private static IntMessageParameterHandler levelHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Level");
	private static IntMessageParameterHandler experienceHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Experience");
	private static IntMessageParameterHandler transforIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("TransforId");
	private static IntMessageParameterHandler zodiacIdHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("ZodiacId");

	public static Message_1003_1 create() {
		return new Message_1003_1();
	}

	/**
	 * @return the yunyingUserId
	 */
	public String getYunyingUserId() {
		return yunyingUserId;
	}

	/**
	 * @param yunyingUserId
	 *            the yunyingUserId to set
	 */
	public void setYunyingUserId(String yunyingUserId) {
		this.yunyingUserId = yunyingUserId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
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
	 * @return the career
	 */
	public int getCareer() {
		return career;
	}

	/**
	 * @param career
	 *            the career to set
	 */
	public void setCareer(int career) {
		this.career = career;
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
	 * @return the familyId
	 */
	public long getFamilyId() {
		return familyId;
	}

	/**
	 * @param familyId
	 *            the familyId to set
	 */
	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	/**
	 * @return the familyPositionId
	 */
	public int getFamilyPositionId() {
		return familyPositionId;
	}

	/**
	 * @param familyPositionId
	 *            the familyPositionId to set
	 */
	public void setFamilyPositionId(int familyPositionId) {
		this.familyPositionId = familyPositionId;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the familyLevel
	 */
	public int getFamilyLevel() {
		return familyLevel;
	}

	/**
	 * @param familyLevel
	 *            the familyLevel to set
	 */
	public void setFamilyLevel(int familyLevel) {
		this.familyLevel = familyLevel;
	}

	/**
	 * @return the nobility
	 */
	public int getNobility() {
		return nobility;
	}

	/**
	 * @param nobility
	 *            the nobility to set
	 */
	public void setNobility(int nobility) {
		this.nobility = nobility;
	}

	/**
	 * @return the generalIdTableArray
	 */
	public GeneralIdTableArray getGeneralIdTableArray() {
		return generalIdTableArray;
	}

	/**
	 * @param generalIdTableArray
	 *            the generalIdTableArray to set
	 */
	public void setGeneralIdTableArray(GeneralIdTableArray generalIdTableArray) {
		this.generalIdTableArray = generalIdTableArray;
	}

	/**
	 * @return the lastStrongPointId
	 */
	public int getLastStrongPointId() {
		return lastStrongPointId;
	}

	/**
	 * @param lastStrongPointId
	 *            the lastStrongPointId to set
	 */
	public void setLastStrongPointId(int lastStrongPointId) {
		this.lastStrongPointId = lastStrongPointId;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @return the stage
	 */
	public int getStage() {
		return stage;
	}

	/**
	 * @param stage
	 *            the stage to set
	 */
	public void setStage(int stage) {
		this.stage = stage;
	}

	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}

	/**
	 * @param step
	 *            the step to set
	 */
	public void setStep(int step) {
		this.step = step;
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
	 * @return the transforId
	 */
	public int getTransforId() {
		return transforId;
	}

	/**
	 * @param transforId
	 *            the transforId to set
	 */
	public void setTransforId(int transforId) {
		this.transforId = transforId;
	}

	/**
	 * @return the zodiacId
	 */
	public int getZodiacId() {
		return zodiacId;
	}

	/**
	 * @param zodiacId
	 *            the zodiacId to set
	 */
	public void setZodiacId(int zodiacId) {
		this.zodiacId = zodiacId;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeString(this.yunyingUserId);
		data.writeLong(this.userId);
		data.writeString(this.userName);
		data.writeInt(this.career);
		data.writeInt(this.vip);
		data.writeLong(this.familyId);
		data.writeInt(this.familyPositionId);
		data.writeString(this.familyName);
		data.writeInt(this.familyLevel);
		data.writeInt(this.nobility);
		generalIdTableArray.encode(data);
		data.writeInt(this.lastStrongPointId);
		data.writeInt(this.state);
		data.writeInt(this.stage);
		data.writeInt(this.step);
		data.writeInt(this.level);
		data.writeInt(this.experience);
		data.writeInt(this.transforId);
		data.writeInt(this.zodiacId);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.yunyingUserId = data.getString();
		this.userId = data.getLong();
		this.userName = data.getString();
		this.career = data.getInt();
		this.vip = data.getInt();
		this.familyId = data.getLong();
		this.familyPositionId = data.getInt();
		this.familyName = data.getString();
		this.familyLevel = data.getInt();
		this.nobility = data.getInt();
		generalIdTableArray = GeneralIdTableArray.create();
		generalIdTableArray.decode(data);
		this.lastStrongPointId = data.getInt();
		this.state = data.getInt();
		this.stage = data.getInt();
		this.step = data.getInt();
		this.level = data.getInt();
		this.experience = data.getInt();
		this.transforId = data.getInt();
		this.zodiacId = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!userIdHandler.validate(userId)) {
			return false;
		}
		if (!careerHandler.validate(career)) {
			return false;
		}
		if (!vipHandler.validate(vip)) {
			return false;
		}
		if (!familyIdHandler.validate(familyId)) {
			return false;
		}
		if (!familyPositionIdHandler.validate(familyPositionId)) {
			return false;
		}
		if (!familyLevelHandler.validate(familyLevel)) {
			return false;
		}
		if (!nobilityHandler.validate(nobility)) {
			return false;
		}
		if (!generalIdTableArray.validate()) {
			return false;
		}
		if (!lastStrongPointIdHandler.validate(lastStrongPointId)) {
			return false;
		}
		if (!stateHandler.validate(state)) {
			return false;
		}
		if (!stageHandler.validate(stage)) {
			return false;
		}
		if (!stepHandler.validate(step)) {
			return false;
		}
		if (!levelHandler.validate(level)) {
			return false;
		}
		if (!experienceHandler.validate(experience)) {
			return false;
		}
		if (!transforIdHandler.validate(transforId)) {
			return false;
		}
		if (!zodiacIdHandler.validate(zodiacId)) {
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
		bb.append("yunyingUserId:").append(this.yunyingUserId).append(", ");
		bb.append("userId:").append(this.userId).append(", ");
		bb.append("userName:").append(this.userName).append(", ");
		bb.append("career:").append(this.career).append(", ");
		bb.append("vip:").append(this.vip).append(", ");
		bb.append("familyId:").append(this.familyId).append(", ");
		bb.append("familyPositionId:").append(this.familyPositionId).append(", ");
		bb.append("familyName:").append(this.familyName).append(", ");
		bb.append("familyLevel:").append(this.familyLevel).append(", ");
		bb.append("nobility:").append(this.nobility).append(", ");
		bb.append("generalIdTableArray:").append(generalIdTableArray.toString()).append(", ");
		bb.append("lastStrongPointId:").append(this.lastStrongPointId).append(", ");
		bb.append("state:").append(this.state).append(", ");
		bb.append("stage:").append(this.stage).append(", ");
		bb.append("step:").append(this.step).append(", ");
		bb.append("level:").append(this.level).append(", ");
		bb.append("experience:").append(this.experience).append(", ");
		bb.append("transforId:").append(this.transforId).append(", ");
		bb.append("zodiacId:").append(this.zodiacId);
		return bb.toString();	
	}
}