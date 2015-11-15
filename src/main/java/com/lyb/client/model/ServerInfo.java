package com.lyb.client.model;

import java.util.List;

public class ServerInfo {
	private int serverId;
	private String serverName;
	private String serverIp;
	private List<String> tags;
	private String status;

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ServerInfo [serverId=" + serverId + ", serverName=" + serverName + ", serverIp=" + serverIp + ", tags="
				+ tags + ", status=" + status + "]";
	}

}
