package com.lyb.client.processor.impl;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;
import com.lyb.client.message.protocol.segment.UserItemArray.UserItemArrayItem;
import com.lyb.client.model.ItemData;

/**
 * 返回 同步背包所有数据
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1009_1 extends IMessageProcessor<Message_1009_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1009_1 message) throws Exception {
		for (UserItemArrayItem item : message.getUserItemArray().list()) {
			long userItemId = item.getUserItemId();
			int itemId = item.getItemId();
			int count = item.getCount();
			int place = item.getPlace();
			int isUsing = item.getIsUsing();
			if(count <= 0){
				playerManager.getItemManager().getItemDataMap().remove(userItemId);
			}else{
				ItemData itemData = new ItemData(userItemId, itemId, count, isUsing, place);
				playerManager.getItemManager().getItemDataMap().put(userItemId, itemData);
			}
		}
	}
}
