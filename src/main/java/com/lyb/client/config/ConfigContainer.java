package com.lyb.client.config;


public class ConfigContainer {
	private static class LazyHolder {
		public static final ConfigContainer holder = new ConfigContainer();
	}

	public static final ConfigContainer getInstance() {
		return LazyHolder.holder;
	}

	private Configs configs;

	public Config getConfig(){
		return configs.getConfig();
	}
	
	public int getSleepTime() {
		return configs.getSleepTime();
	}

	public int getBattleTime() {
		return configs.getBattleTime();
	}

	public void setConfigs(Configs configs) {
		this.configs = configs;
	}

}
