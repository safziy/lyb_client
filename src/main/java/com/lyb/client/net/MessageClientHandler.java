package com.lyb.client.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.lyb.client.log.LogUtil;
import com.lyb.client.message.IMessage;
import com.lyb.client.model.Client;
import com.lyb.client.processor.IMessageProcessor;
import com.lyb.client.processor.ProcessorContainer;

public class MessageClientHandler extends ChannelInboundHandlerAdapter {

	private Client client;

	public MessageClientHandler(Client client) {
		this.client = client;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		client.setChannel(ctx.channel());
		client.connect();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		IMessage message = (IMessage) msg;
		IMessageProcessor<?> processor = ProcessorContainer.getInstance().getEntity(
				"Processor_" + message.getMessageKey());
		if (processor == null) {
			LogUtil.error("Processor 不存在 Processor_" + message.getMessageKey());
			return;
		}
		try {
			processor.exec(client.getPlayerManager(), message);
		} catch (Exception e) {
			LogUtil.error("Processor 执行错误", e);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LogUtil.error("Unexpected exception from downstream." + cause);
	}

}
