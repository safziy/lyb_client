package com.lyb.client.message.handler;

public interface IMessageParameterHandler {

	public String getType();

	public String getParam();

	public String getName();
	
	public boolean validate(int jinghun);
	
	public boolean validate(long var);
}
