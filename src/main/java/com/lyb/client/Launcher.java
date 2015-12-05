package com.lyb.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;

import com.lyb.client.config.ConfigContainer;
import com.lyb.client.config.Configs;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.model.Client;

public class Launcher {

	public static void main(String[] args) {
		bootstrap();
	}

	private static void bootstrap() {
		try {
			MessageParameterContext.getInstance().init();
			ConfigContext.getInstance().init();
			readConfig();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

//		String serverIp = "127.0.0.1";
//		Client client = new Client(serverIp, 1, "f555", "0");

		// String serverIp = "119.29.27.206";
		// String serverIp = "119.29.119.47";
		// 22服 - 廷尉府
		String serverIp = "119.29.25.197";
		Client client = new Client(serverIp, 100, "safziy", "mysafziy");
		client.start();
	}

	private static void readConfig() throws Exception {
		String classBinPath = Launcher.class.getResource("/").getPath();
		File file = new File(classBinPath + "config.xml");
		Serializer ser = new Persister();
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			InputNode inputNode = NodeBuilder.read(in);
			Configs configs = ser.read(Configs.class, inputNode, false);
			ConfigContainer.getInstance().setConfigs(configs);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					LogUtil.error("close FileInputStream fail", e);
				}
			}
		}
	}

}
