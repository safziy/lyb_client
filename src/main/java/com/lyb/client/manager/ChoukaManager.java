package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.lyb.client.config.ConfigContainer;
import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.protocol.Message_6_3;
import com.lyb.client.message.protocol.segment.ItemIdArray;
import com.lyb.client.message.protocol.segment.ItemIdArray.ItemIdArrayItem;
import com.lyb.client.model.InnerWork;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.utils.ValidateUtils;

public class ChoukaManager {
	private PlayerManager playerManager;

	private Map<Integer, Integer> calMap = new HashMap<Integer, Integer>();

	public ChoukaManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		if (ConfigContainer.getInstance().getConfig().isSilverEmploy()) {
			innerCheck();
		}
	}

	public void innerCheck() {
		PlayerWork work = new PlayerWork(new InnerWork() {
			@Override
			public void work() {
				check();
			}
		});
		work.setDesc("检查是否自动抽卡");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void check() {
		int itemCount = playerManager.getItemManager().getItemCountByItemId(ApplicationConstants.ITEM_ID_1009002);
		if (itemCount >= 10 || playerManager.getPlayerData().getSilver() >= 200000) {
			innerCheck();

			Message_6_3 message_6_3 = new Message_6_3();
			message_6_3.setByteType(1);
			message_6_3.setCount(10);
			PlayerWork work = new PlayerWork();
			work.getMessages().add(message_6_3);
			work.setDesc("开始银两抽卡");
			playerManager.getWorkQueue().offerFirst(work);
		}
	}

	public void calc(ItemIdArray itemIdArray) {
		for (ItemIdArrayItem item : itemIdArray.list()) {
			DummyUtils.mergeMapData(calMap, item.getItemId(), item.getCount());
		}
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, Integer> entry : calMap.entrySet()) {
			Map<String, String> map = ConfigContext.getInstance().getFileRow("Daoju_Daojubiao.lua",
					String.valueOf(entry.getKey()));
			if (ValidateUtils.isNull(map) || map.size() <= 0) {
				continue;
			}
			sb.append(map.get("name")).append("*").append(entry.getValue()).append("  ");
		}
		LogUtil.info("抽卡的统计结果==>  " + sb.toString());
	}

}
