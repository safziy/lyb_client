package com.lyb.client.manager;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.message.protocol.Message_11_3;
import com.lyb.client.message.protocol.segment.ChatContentArray;
import com.lyb.client.model.InnerWork;
import com.lyb.client.model.PlayerWork;
import com.safziy.commom.utils.TimeUtils;

public class ChatManager {
	private PlayerManager playerManager;

	public ChatManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		innerCheck();
	}

	public void innerCheck() {
		PlayerWork work = new PlayerWork(new InnerWork() {
			@Override
			public void work() {
				innerCheck();
				chat();
			}
		});
		work.setActivateTime(System.currentTimeMillis() + 90 * TimeUtils.ONE_SECONDS_MICROSECONDS);
		work.setDesc("检查是否发送聊天信息");
		work.setState(ApplicationConstants.WORK_STATE_2);
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void chat() {
		// 2015-12-09 20:35:41,226 INFO MESSAGE_PROCESSOR_LOG |814619091
		// decodeAndCheck 中 processKey is 11_3 _pass data={
		// MainType->1:UserName->:UserId->0:ChatContentArray->[{
		// ParamStr1->ffffff:ParamStr3->:Type->1:ParamStr2->:ParamStr4->asdfasdf
		// }]:SubType->1 }

		Message_11_3 message_11_3 = new Message_11_3();
		message_11_3.setMainType(1);
		message_11_3.setSubType(1);
		message_11_3.setUserId(0);
		message_11_3.setUserName("");
		ChatContentArray chatContentArray = new ChatContentArray();
		chatContentArray.addData(1, "ffffff", "", "", "金陵第一帮 招收V3以上活跃玩家 要求进群改名  QQ:416104934");
		message_11_3.setChatContentArray(chatContentArray);

		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_11_3);
		work.setDesc("发送帮派招人信息");

		playerManager.getWorkQueue().offerFirst(work);
	}

}
