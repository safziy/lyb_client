package com.lyb.client.processor;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.IMessage;

public abstract class IMessageProcessor<T extends IMessage> {

	@SuppressWarnings("unchecked")
	public void exec(PlayerManager playerManager, IMessage message) {
		try {
			execute(playerManager, (T) message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void execute(PlayerManager playerManager, T message) throws Exception;
}
