package com.lyb.client.model;

import java.util.LinkedList;
import java.util.List;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.message.IMessage;

public class PlayerWork {
	private InnerWork innerWork;

	public PlayerWork() {
		this.state = ApplicationConstants.WORK_STATE_0;
	}

	public PlayerWork(InnerWork innerWork) {
		this();
		this.innerWork = innerWork;
	}

	// 状态
	private byte state;
	// 需要发送的消息
	private List<IMessage> messages = new LinkedList<IMessage>();
	// 描述
	private String desc;
	// 停顿时间 默认1s
	private long microseconds = ApplicationConstants.DEFAULT_SLEEP_TIME;
	// 激活的时间
	private long activateTime;

	public void work() {
		if (innerWork != null) {
			innerWork.work();
		}
	}
	
	public boolean checkActiveTime() {
		long currentTime = System.currentTimeMillis();
		if(currentTime >= activateTime){
			return true;
		}
		return false;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<IMessage> getMessages() {
		return messages;
	}

	public long getMicroseconds() {
		return microseconds;
	}

	public void setMicroseconds(long microseconds) {
		this.microseconds = microseconds;
	}

	public long getActivateTime() {
		return activateTime;
	}

	public void setActivateTime(long activateTime) {
		this.activateTime = activateTime;
	}

}
