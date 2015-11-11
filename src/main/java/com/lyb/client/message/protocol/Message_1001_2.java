package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 成功
 *
 * @author codeGenerator
 * 
 */
public class Message_1001_2 implements IMessage {

	private static int MAIN = 1001;
	private static int SUB = 2;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1001, 2);

	private int mainCommand;
	private int subCommand;

	private static IntMessageParameterHandler mainCommandHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("MainCommand");
	private static IntMessageParameterHandler subCommandHandler = MessageParameterContext.getInstance().getIntMessageParameterHandler("SubCommand");

	public static Message_1001_2 create() {
		return new Message_1001_2();
	}

	/**
	 * @return the mainCommand
	 */
	public int getMainCommand() {
		return mainCommand;
	}

	/**
	 * @param mainCommand
	 *            the mainCommand to set
	 */
	public void setMainCommand(int mainCommand) {
		this.mainCommand = mainCommand;
	}

	/**
	 * @return the subCommand
	 */
	public int getSubCommand() {
		return subCommand;
	}

	/**
	 * @param subCommand
	 *            the subCommand to set
	 */
	public void setSubCommand(int subCommand) {
		this.subCommand = subCommand;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		data.writeInt(this.mainCommand);
		data.writeInt(this.subCommand);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		this.mainCommand = data.getInt();
		this.subCommand = data.getInt();
	}

	@Override
	public boolean validate() {
		if (!mainCommandHandler.validate(mainCommand)) {
			return false;
		}
		if (!subCommandHandler.validate(subCommand)) {
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
		bb.append("mainCommand:").append(this.mainCommand).append(", ");
		bb.append("subCommand:").append(this.subCommand);
		return bb.toString();	
	}
}