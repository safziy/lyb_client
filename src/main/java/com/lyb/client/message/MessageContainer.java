package com.lyb.client.message;

import com.lyb.client.processor.AbstractContainer;


public class MessageContainer extends AbstractContainer<IMessage> {

	private static MessageContainer instance = new MessageContainer();
	
	private MessageContainer() {
		super("com.lyb.client.message.protocol");
	}

	public static MessageContainer getInstance() {
		return instance;
	}
}
