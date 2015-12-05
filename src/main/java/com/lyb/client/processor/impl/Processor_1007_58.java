package com.lyb.client.processor.impl;

import java.util.Map;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1007_58;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 扫荡结果
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1007_58 extends IMessageProcessor<Message_1007_58> {

	@Override
	public void execute(PlayerManager playerManager, Message_1007_58 message) throws Exception {

		Map<String, String> map = ConfigContext.getInstance().getFileRow("Juqing_Guanka.lua",
				String.valueOf(message.getStrongPointId()));
		int type = Integer.parseInt(map.get("Gtype"));
		switch (type) {
		case ApplicationConstants.GUANQIA_TYPE_1:
			break;
		case ApplicationConstants.GUANQIA_TYPE_2:
			playerManager.getYXZManager().battleOver();
			break;
		default:
			break;
		}
	}
}
