package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 请求  引导阶段
 *
 * @author codeGenerator
 * 
 */
public class Message_3_23 implements IMessage {

	private static int MAIN = 3;
	private static int SUB = 23;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(3, 23);

	private int stage;
	private int step;
	private int booleanValue;
	private int booleanValue2;

	private static IntMessageParameterHandler stageHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Stage");
	private static IntMessageParameterHandler stepHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("Step");
	private static IntMessageParameterHandler booleanValueHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue");
	private static IntMessageParameterHandler booleanValue2Handler = MessageParameterContext.getInstance().getIntMessageParameterHandler("BooleanValue2");

	public static Message_3_23 create() {
		return new Message_3_23();
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
	 * @return the booleanValue2
	 */
	public int getBooleanValue2() {
		return booleanValue2;
	}

	/**
	 * @param booleanValue2
	 *            the booleanValue2 to set
	 */
	public void setBooleanValue2(int booleanValue2) {
		this.booleanValue2 = booleanValue2;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.stage);
		data.writeInt(this.step);
		data.writeInt(this.booleanValue);
		data.writeInt(this.booleanValue2);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.stage = data.getInt();
		this.step = data.getInt();
		this.booleanValue = data.getInt();
		this.booleanValue2 = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!stageHandler.validate(stage)) {
			return false;
		}
		if (!stepHandler.validate(step)) {
			return false;
		}
		if (!booleanValueHandler.validate(booleanValue)) {
			return false;
		}
		if (!booleanValue2Handler.validate(booleanValue2)) {
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
		bb.append("stage:").append(this.stage).append(", ");
		bb.append("step:").append(this.step).append(", ");
		bb.append("booleanValue:").append(this.booleanValue).append(", ");
		bb.append("booleanValue2:").append(this.booleanValue2);
		return bb.toString();	
	}
}