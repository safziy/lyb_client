package com.lyb.client.processor.impl;

import com.lyb.client.context.ConfigContext;
import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1004_1;
import com.lyb.client.message.protocol.segment.StrongPointArray.StrongPointArrayItem;
import com.lyb.client.model.YXZData;
import com.lyb.client.processor.IMessageProcessor;
import com.lyb.client.utils.ValidateUtils;

/**
 * 返回 关卡数据
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1004_1 extends IMessageProcessor<Message_1004_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1004_1 message) throws Exception {
		boolean isStrongPoint = false;
		for (StrongPointArrayItem item : message.getStrongPointArray().list()) {
			int strongPointId = item.getStrongPointId();
			int type = Integer.valueOf(ConfigContext.getInstance().getFileValue("Juqing_Guanka.lua",
					String.valueOf(strongPointId), "Gtype"));
			if (ValidateUtils.isEqual(type, 1)) {
				if (item.getStarLevel() >= 3) {
					playerManager.getStrongPointManager().getNfsSet().remove(item.getStrongPointId());
				} else {
					playerManager.getStrongPointManager().getNfsSet().add(item.getStrongPointId());
				}
				isStrongPoint = true;
			} else if (ValidateUtils.isEqual(type, 2)) {
				YXZData yxzData = new YXZData();
				yxzData.setId(item.getStrongPointId());
				yxzData.setStrongPointId(item.getStrongPointId());
				yxzData.setCount(item.getCount());
				yxzData.setTotalCount(item.getTotalCount());
				yxzData.setStarLevel(item.getStarLevel());
				yxzData.setState(item.getState());
				playerManager.getYXZManager().getYxzDataMap().put(yxzData.getId(), yxzData);
			}
		}
		if (isStrongPoint) {
			playerManager.getStrongPointManager().checkAndPreFight();
		}
	}
}
