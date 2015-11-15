package com.lyb.client.message.handler;


public class IntMessageParameterHandler extends AbstractMessageParameterHandler {

	private int min;
	private int max;

	public IntMessageParameterHandler(String name,String type, String param) {
		super(name, type, param);
		String[] params = param.split("\\|");
		this.min = "*".equals(params[0]) ? Integer.MIN_VALUE : new Integer(params[0]);
		this.max = "*".equals(params[1]) ? Integer.MAX_VALUE : new Integer(params[1]);
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public boolean validate(int var) {
		if (var < this.min || var > this.max) {
			return false;
		}
		return true;
	}
	
}
