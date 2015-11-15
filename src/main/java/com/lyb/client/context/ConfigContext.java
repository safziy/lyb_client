package com.lyb.client.context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.lyb.client.log.LogUtil;
import com.lyb.client.utils.ValidateUtils;

public class ConfigContext {
	private static class LazyHolder {
		public static final ConfigContext holder = new ConfigContext();
	}

	public static final ConfigContext getInstance() {
		return LazyHolder.holder;
	}

	private String LUA_FILE_PATH = "/src/main/resources/config/lua/";

	private Map<String, Map<String, Map<String, String>>> luaFileMap = new HashMap<String, Map<String, Map<String, String>>>();

	public void init() {
		String rootPath = System.getProperty("user.dir");
		File luaDir = new File(rootPath + LUA_FILE_PATH);
		if (luaDir.isDirectory()) {
			for (File luaFile : luaDir.listFiles()) {
				String fileName = luaFile.getName();
				luaFileMap.put(fileName, parseLua(luaFile));
			}
		}
	}

	private Map<String, Map<String, String>> parseLua(File file) {
		Map<String, Map<String, String>> fileMap = new HashMap<String, Map<String, String>>();
		try {
			StringBuilder content = new StringBuilder();
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");// 考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line);
			}
			String[] strArray = StringUtils.substringsBetween(
					content.substring(content.indexOf("{") + 1, content.lastIndexOf("}")), "{", "}");
			String[] title = removeQuot(strArray[0].split(","));
			for (int i = 1; i < strArray.length; i++) {
				String[] values = removeQuot(split(strArray[i], "\"", "\""));
				if(ValidateUtils.isNotEqual(title.length, values.length)){
					continue;
				}
				Map<String, String> map = new HashMap<String, String>();
				for (int j = 0; j < values.length; j++) {
					map.put(title[j], values[j]);
				}
				if (values.length > 0) {
					fileMap.put(values[0], map);
				}
			}
			bufferedReader.close();
			read.close();
		} catch (Exception e) {
			LogUtil.error("读取客户端lua文件时出错了! fileName=" + file.getName(), e);
		}
		return fileMap;
	}

	public Map<String, Map<String, String>> getFileMap(String fileName) {
		if (luaFileMap.containsKey(fileName)) {
			return luaFileMap.get(fileName);
		}
		return null;
	}

	public Map<String, String> getFileRow(String fileName, String key) {
		Map<String, Map<String, String>> fileMap = getFileMap(fileName);
		if (fileMap != null && fileMap.containsKey(key)) {
			return fileMap.get(key);
		}
		return null;
	}

	public String getFileValue(String fileName, String key, String title) {
		Map<String, String> row = getFileRow(fileName, key);
		if (row != null && row.containsKey(title)) {
			return row.get(title);
		}
		return null;
	}

	private String[] removeQuot(String[] strArray) {
		String[] newStrArray = new String[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			newStrArray[i] = StringUtils.remove(strArray[i], "\"");
		}
		return newStrArray;
	}

	private String[] split(String valueStr, String beginRegex, String endRegex) {
		String[] valueArr = valueStr.split("\\s*[,]\\s*");
		List<String> list = new ArrayList<String>();
		List<String> li2 = new ArrayList<String>();
		String temp = "";
		boolean begin = false;
		for (String value : valueArr) {
			li2.add(value);
			if (value.contains(beginRegex)) {
				begin = true;
			}
			if (begin) {
				temp = temp + "," + value;
			}
			if (value.endsWith(endRegex)) {
				begin = false;
			}
			if (begin == false) {
				if ("".equals(temp)) {
					list.add(value);
				} else {
					temp = temp.substring(1);
					list.add(temp);
					temp = "";
				}

			}

		}
		return list.toArray(new String[list.size()]);
	}

}
