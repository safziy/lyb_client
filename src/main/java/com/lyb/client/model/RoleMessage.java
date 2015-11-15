package com.lyb.client.model;

/**
 * 服务器返回的角色信息
 * 
 * @author safziy
 *
 */
public class RoleMessage {
	/**
	 * Id
	 */
	private int id;
	/**
	 * 角色名
	 */
	private String userName;
	/**
	 * 职业名
	 */
	private int career;
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 原始服务器Id
	 */
	private int origainalServerId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getOrigainalServerId() {
		return origainalServerId;
	}

	public void setOrigainalServerId(int origainalServerId) {
		this.origainalServerId = origainalServerId;
	}

}
