package com.lyb.client.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import com.lyb.client.log.LogUtil;
import com.lyb.client.model.ServerInfo;
import com.safziy.commom.http.HttpRequester;

public class ServerListUtils {
	public static List<ServerInfo> getAllServer() {
		List<ServerInfo> list = new LinkedList<ServerInfo>();
		try {
			String result = HttpRequester.getInstance().doPost(
					"http://partition.cn.happyelements.com/queryAllServerConfig?app_id=7900109606",
					new HashMap<String, Object>());
			JSONObject json = new JSONObject(result);
			if (ValidateUtils.isFalse(json.has("ret")) || ValidateUtils.isNotEqual(json.getInt("ret"), 1)) {
				return list;
			}
			JSONObject data = (JSONObject) json.get("data");
			JSONObject area01 = (JSONObject) data.get("area01");
			JSONObject servers = (JSONObject) area01.get("servers");

			for (Object key : servers.keySet()) {
				JSONObject server = (JSONObject) servers.get((String) key);
				ServerInfo serverInfo = new ServerInfo();
				serverInfo.setServerId(server.getInt("id"));
				serverInfo.setServerName(server.getString("name"));
				serverInfo.setServerIp(server.getString("canvasUrl"));
				serverInfo.setTags(DummyUtils.convertContentToList(String.class, server.getString("tags")));
				serverInfo.setStatus(server.getString("status"));
				list.add(serverInfo);
			}
			Collections.sort(list, new Comparator<ServerInfo>() {
				@Override
				public int compare(ServerInfo o1, ServerInfo o2) {
					return o1.getServerId() - o2.getServerId();
				}
			});
		} catch (Exception e) {
			LogUtil.error("获取服务器列表时发生了异常", e);
			return list;
		}
		return list;
	}
	
	public static void main(String[] args) {
		try {
			HttpRequester.getInstance().start();
			for (ServerInfo serverInfo : getAllServer()) {
				System.out.println(serverInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
