package com.lyb.client.processor;

import java.util.List;
import java.util.Map;

import org.nutz.resource.Scans;

import com.google.common.collect.Maps;
import com.lyb.client.log.LogUtil;

public abstract class AbstractContainer<T> {
	private Map<String, T> cacheMap = Maps.newHashMap();

	public AbstractContainer(String pack) {
		List<Class<?>> clazzs = Scans.me().scanPackage(pack);
		for (Class<?> clazz : clazzs) {
			try {
				if (clazz.toString().contains("$"))
					continue;
				@SuppressWarnings("unchecked")
				T ins = (T) clazz.newInstance();
				if (!cacheMap.containsKey(ins.getClass().getSimpleName())) {
					cacheMap.put(ins.getClass().getSimpleName(), ins);
				} else {
					LogUtil.info(ins.getClass().getSimpleName() + " 被重复定义...");
				}
			} catch (InstantiationException e) {
				LogUtil.error("实例化" + clazz.getSimpleName() + "错误", e);
			} catch (IllegalAccessException e) {
				LogUtil.error("非法访问" + clazz.getSimpleName() + "错误", e);
			}
		}
	}

	public T getEntity(String key) {
		return cacheMap.get(key);
	}
}
