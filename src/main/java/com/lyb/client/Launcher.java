package com.lyb.client;

import com.lyb.client.context.ConfigContext;
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
		} catch (Exception e) {
			e.printStackTrace();
		}

//		 String serverIp = "127.0.0.1";
//		 Client client = new Client(serverIp, 1, "f555", "0");
		
		String serverIp = "119.29.25.197";
//		String serverIp = "119.29.27.206";
//		String serverIp = "119.29.119.47";
		Client client = new Client(serverIp, 100, "safziy", "mysafziy");
		client.start();
	}

}
