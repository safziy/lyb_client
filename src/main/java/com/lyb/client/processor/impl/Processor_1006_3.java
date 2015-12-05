package com.lyb.client.processor.impl;

import java.util.Map;

import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1006_3;
import com.lyb.client.message.protocol.segment.ItemIdArray.ItemIdArrayItem;
import com.lyb.client.processor.IMessageProcessor;
import com.lyb.client.utils.ValidateUtils;

/**
 * 返回 抽卡牌
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1006_3 extends IMessageProcessor<Message_1006_3> {

	@Override
	public void execute(PlayerManager playerManager, Message_1006_3 message) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (ItemIdArrayItem item : message.getItemIdArray().list()) {
			Map<String, String> map = ConfigContext.getInstance().getFileRow("Daoju_Daojubiao.lua",
					String.valueOf(item.getItemId()));
			if(ValidateUtils.isNull(map) || map.size() <= 0){
				continue;
			}
			sb.append(map.get("name")).append("*").append(item.getCount()).append("  ");
		}
		LogUtil.info("抽卡的结果==>  " + sb.toString());
		playerManager.getChoukaManager().calc(message.getItemIdArray());
	}
}
