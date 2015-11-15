package com.lyb.client.message.handler;


public class LongMessageParameterHandler extends AbstractMessageParameterHandler {

	private long min;
	private long max;

	public LongMessageParameterHandler(String name, String type, String param) {
		super(name, type, param);
		String[] params = param.split("\\|");
		this.min = "*".equals(params[0]) ? Long.MIN_VALUE : new Long(params[0]);
		this.max = "*".equals(params[1]) ? Long.MAX_VALUE : new Long(params[1]);
	}

	public long getMin() {
		return min;
	}

	public void setMin(long min) {
		this.min = min;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public boolean validate(long var) {
		if (var < this.min || var > this.max) {
			return false;
		}
		return true;
	}

}
