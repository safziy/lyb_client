package com.lyb.client.processor.impl;

import java.util.Map;

import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1003_9;
import com.lyb.client.message.protocol.segment.UserCountControlArray.UserCountControlArrayItem;
import com.lyb.client.model.CountControlData;
import com.lyb.client.processor.IMessageProcessor;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 次数控制
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1003_9 extends IMessageProcessor<Message_1003_9> {

	@Override
	public void execute(PlayerManager playerManager, Message_1003_9 message) throws Exception {
		for (UserCountControlArrayItem item : message.getUserCountControlArray().list()) {
			long id = item.getID();
			Map<String, String> map = ConfigContext.getInstance().getFileRow("Cishukongzhi_Cishukongzhi.lua",
					String.valueOf(id));
			if (map == null) {
				LogUtil.error("服务器返回了一个客户端不存在的次数控制! id=" + id);
				continue;
			}
			String type = map.get("type");
			String param = map.get("parameter");
			String key = DummyUtils.getCompositeKey(type, param);

			CountControlData countControlData = new CountControlData();
			countControlData.setId(id);
			countControlData.setCurrentCount(item.getCurrentCount());
			countControlData.setTotalCount(item.getTotalCount());
			countControlData.setAddCount(item.getAddCount());
			countControlData.setMaxAddCount(item.getMaxAddCount());
			countControlData.setBuyCountNeedGold(DummyUtils.convertContentToList(Integer.class,
					item.getBuyCountNeedGold()));
			playerManager.getCountControlManager().getCountControlMap().put(key, countControlData);
		}
	}
}
