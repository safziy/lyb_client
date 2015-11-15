package com.lyb.client.lua;

public class LuaConfigContainer {
	private static class LazyHolder {
		public static final LuaConfigContainer holder = new LuaConfigContainer();
	}

	public static final LuaConfigContainer getInstance() {
		return LazyHolder.holder;
	}
	
	public void init(){
		
	}
}
