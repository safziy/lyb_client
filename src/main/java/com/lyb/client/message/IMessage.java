package com.lyb.client.message;


public interface IMessage extends IMessageEncoder {

	int getMain();

	int getSub();

	public String getMessageKey();
}
