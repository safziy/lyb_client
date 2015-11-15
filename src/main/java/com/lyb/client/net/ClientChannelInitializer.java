package com.lyb.client.net;

import com.lyb.client.model.Client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
	private Client client;
	
	public ClientChannelInitializer(Client client){
		this.client = client;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast("decoder", new MessageDecoder());
		ch.pipeline().addLast("encoder", new MessageEncoder());
		ch.pipeline().addLast("handler", new MessageClientHandler(client));
	}

}
