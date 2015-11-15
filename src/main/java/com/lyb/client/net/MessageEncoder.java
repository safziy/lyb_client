package com.lyb.client.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.IMessage;
import com.lyb.client.utils.CompressUtil;
import com.lyb.client.utils.ValidateUtils;

public class MessageEncoder extends MessageToByteEncoder<IMessage> {

	@Override
	protected void encode(ChannelHandlerContext ctx, IMessage msg, ByteBuf out) throws Exception {
		if (ValidateUtils.isNull(msg)) {
			out = null;
			return;
		}
		ByteBuf buf = Unpooled.buffer();
		IMessage message = (IMessage) msg;
		if (message.validate()) {
			Data data = new Data(buf);
			data.writeInt(message.getMain());
			data.writeInt(message.getSub());
			message.encode(data);
			ByteBuf dataBuffer = data.getChannelBuffer();
			// 实际包长(main+sub+数据)
			int actualPackageLength = dataBuffer.readableBytes();
			// 压缩后包长
			int packageLength = actualPackageLength;
			if (actualPackageLength > 512) {
				dataBuffer = CompressUtil.compress(dataBuffer);
				int tempLength = dataBuffer.readableBytes();
				// 长度第31位和1取或，表示这个命令压缩过，前端根据这个标识来判断是否有压缩
				packageLength = tempLength | 1 << 30;
				LogUtil.debug("encode " + " , packageLength=" + tempLength + " actualPackageLength="
						+ actualPackageLength + " 命令=" + message.getMain() + "_" + message.getSub());
			}
			ByteBuf headBuffer = Unpooled.buffer(ApplicationConstants.SIZE_OF_INT * 2);
			// 包长(压缩后+headBuffer.length)+包长(压缩前)+内容(主命令(4)+子命令(4)+数据)
			headBuffer.writeInt(packageLength + ApplicationConstants.SIZE_OF_INT * 2);
			headBuffer.writeInt(actualPackageLength);
			LogUtil.debug("发送消息[" + message.getMessageKey() + "] " + message);
			out.writeBytes(Unpooled.wrappedBuffer(headBuffer, data.getChannelBuffer()));
			return;
		}
		return;
	}
}
