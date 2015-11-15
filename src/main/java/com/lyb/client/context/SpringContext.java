package com.lyb.client.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.safziy.commom.service.log.LogUtil;

public class SpringContext {
	private static class LazyHolder {
		public static final SpringContext holder = new SpringContext();
	}

	public static final SpringContext getInstance() {
		return LazyHolder.holder;
	}

	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;

	public void init() {
		LogUtil.info("com.safziy.service.context.SpringContext  init ");
		this.applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
