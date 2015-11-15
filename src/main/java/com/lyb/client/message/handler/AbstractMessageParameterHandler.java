package com.lyb.client.message.handler;

public abstract class AbstractMessageParameterHandler implements IMessageParameterHandler {

	private final String name;
	private final String type;
	private final String param;

	public AbstractMessageParameterHandler(String name, String type, String param) {
		this.name = name;
		this.type = type;
		this.param = param;
	}

	public String getType() {
		return type;
	}

	public String getParam() {
		return param;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean validate(int jinghun) {
		return false;
	}

	@Override
	public boolean validate(long var) {
		return false;
	}

}
