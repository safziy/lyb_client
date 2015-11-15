package com.lyb.client.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.Message_7_20;
import com.lyb.client.message.protocol.Message_7_59;
import com.lyb.client.message.protocol.segment.BattleGeneralArray;
import com.lyb.client.message.protocol.segment.BattleGeneralArray.BattleGeneralArrayItem;
import com.lyb.client.message.protocol.segment.BufArray;
import com.lyb.client.message.protocol.segment.GeneralStateArray;
import com.lyb.client.message.protocol.segment.TargetStateArray;
import com.lyb.client.message.protocol.segment.UnitPropertyArray.UnitPropertyArrayItem;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.utils.MathUtils;
import com.lyb.client.utils.ValidateUtils;
import com.safziy.commom.utils.SignUtils;

public class BattleManager {
	private PlayerManager playerManager;

	@SuppressWarnings("unused")
	private int currentBattleId;
	private int currentBattleFiledId;

	public BattleManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void battle(int battleId, int battleFieldId, long randomSeed, BattleGeneralArray battleGeneralArray) {
		currentBattleId = battleId;
		currentBattleFiledId = battleFieldId;

		PlayerWork work = new PlayerWork();
		work.setDesc("战场结束");
		String type = ConfigContext.getInstance().getFileValue("Zhandoupeizhi_Zhanchangpeizhi.lua",
				String.valueOf(battleFieldId), "type");
		if (ValidateUtils.isEqual(Integer.valueOf(type), ApplicationConstants.BATTLE_TYPE_3)) {
			// 十国需要回传血量
			work.getMessages().add(battleResult(battleId, battleGeneralArray));
		}
		// 战场结束验证
		work.getMessages().add(battleCheck(battleId, randomSeed));
		playerManager.getWorkQueue().offerFirst(work);

	}

	private IMessage battleResult(int battleId, BattleGeneralArray battleGeneralArray) {
		Message_7_59 message_7_59 = new Message_7_59();
		message_7_59.setBattleId(battleId);
		GeneralStateArray generalStateArray = new GeneralStateArray();
		for (BattleGeneralArrayItem item : battleGeneralArray.list()) {
			if (ValidateUtils.isNotEqual(item.getUserId(), playerManager.getPlayerData().getUserId())) {
				continue;
			}
			int maxHP = 0;
			for (UnitPropertyArrayItem propertyItem : item.getUnitPropertyArray().list()) {
				if (ValidateUtils.isEqual(propertyItem.getPropertyKey(), ApplicationConstants.MAX_HP)) {
					maxHP = propertyItem.getPropertyValue();
				}
			}
			generalStateArray.addData(item.getBattleUnitID(), MathUtils.randomGetInt(1, maxHP),
					MathUtils.randomGetInt(100, 1000));
		}
		message_7_59.setGeneralStateArray(generalStateArray);
		message_7_59.setTargetStateArray(new TargetStateArray());
		return message_7_59;
	}

	private IMessage battleCheck(int battleId, long randomSeed) {
		Message_7_20 message = new Message_7_20();
		message.setParam(battleId);
		message.setParam2(3);
		message.setParam3(1);
		StringBuilder result = new StringBuilder();
		result.append(battleId).append(ApplicationConstants.BATTLE_RESULT_KEYSTORE)
				.append(playerManager.getPlayerData().getUserId()).append(1);
		message.setParamStr1(SignUtils.MD5(result.toString()));
		BufArray bufArray = new BufArray();
		Random random = new Random(randomSeed);
		Map<Integer, Integer> randomMap = new HashMap<Integer, Integer>();
		for (int i = 1; i <= 1000; i++) {
			randomMap.put(i, random.nextInt(ApplicationConstants.HUNDRED_THOUSAND));
		}
		for (int i = 0; i < 5; i++) {
			int index = random.nextInt(999);
			bufArray.addData(index, randomMap.get(index));
		}
		message.setBufArray(bufArray);
		return message;
	}

	public void battleOver() {
		String type = ConfigContext.getInstance().getFileValue("Zhandoupeizhi_Zhanchangpeizhi.lua",
				String.valueOf(currentBattleFiledId), "type");
		switch (Byte.valueOf(type)) {
		case ApplicationConstants.BATTLE_TYPE_2:
			playerManager.getArenaManager().battleOver();
			break;
		case ApplicationConstants.BATTLE_TYPE_3:
			playerManager.getTenCountryManager().battleOver();
			break;
		case ApplicationConstants.BATTLE_TYPE_10:
			playerManager.getYXZManager().battleOver();
			break;
		default:
			break;
		}
		currentBattleId = 0;
		currentBattleFiledId = 0;
	}

}
