package com.lyb.client.model;

public class TargetArenaPlayer {
	private long userId;
	private String userName;
	private int transforId;
	private int level;
	private int zhanli;
	private int score;
	private int BooleanValue;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTransforId() {
		return transforId;
	}

	public void setTransforId(int transforId) {
		this.transforId = transforId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getZhanli() {
		return zhanli;
	}

	public void setZhanli(int zhanli) {
		this.zhanli = zhanli;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBooleanValue() {
		return BooleanValue;
	}

	public void setBooleanValue(int booleanValue) {
		BooleanValue = booleanValue;
	}

}