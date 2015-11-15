package com.lyb.client.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.IMessage;
import com.lyb.client.message.MessageContainer;
import com.lyb.client.utils.CompressUtil;
import com.lyb.client.utils.DummyUtils;
import com.lyb.client.utils.ValidateUtils;

public class MessageDecoder extends ByteToMessageDecoder {
	private final static int COMPRESS_TAG = 1 << 30;

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// 如果buffer内的长度小于 SIZE_OF_INT ,继续等填充
		if (in.readableBytes() < ApplicationConstants.SIZE_OF_INT * 2) {
			return;
		}
		// 标记当前的位置以便后面如果读不到再resetReaderIndex回来
		in.markReaderIndex();
		int packageLength = in.readInt() - ApplicationConstants.SIZE_OF_INT * 2;
		// 压缩前的长度
		int actualPackageLength = in.readInt();
		// 压缩后的长度
		int compressLength = packageLength & 0xffffff;
		boolean isCompress = false;
		// 压缩标记
		if (ValidateUtils.isEqual(packageLength & COMPRESS_TAG, COMPRESS_TAG)) {
			isCompress = true;
			packageLength = compressLength;
		}
		int len = in.readableBytes();
		if (len < packageLength) {
			in.resetReaderIndex();
			return;
		}

		if (packageLength <= 0 || packageLength > 10240) {
			LogUtil.error("message总长度超多 " + 10240 + " , 其长度为 " + packageLength + " 系统移除此Channel , channelId ="
					+ ctx.channel());
			ctx.close();
			return;
		}
		ByteBuf dataBuffer = in.readBytes(packageLength);
		if (isCompress) {
			// 先解压
			dataBuffer = CompressUtil.uncompress(dataBuffer, dataBuffer.readableBytes(), actualPackageLength);
			if (ValidateUtils.isNull(dataBuffer)) {
				LogUtil.error("消息解压失败,packageLength=" + packageLength + " actualPackageLength=" + actualPackageLength);
				return;
			}
		}

		// 获取主命令
		int main = dataBuffer.readInt();
		// 获取子命令
		int sub = dataBuffer.readInt();
		LogUtil.debug("decode " + " , packageLength=" + packageLength + " actualPackageLength=" + actualPackageLength
				+ " 命令=" + main + "_" + sub);
		try {
			if (actualPackageLength - ApplicationConstants.SIZE_OF_INT * 2 < 0) {
				LogUtil.error("封包格式长度小于  " + ApplicationConstants.SIZE_OF_INT + " , 其长度为 " + actualPackageLength
						+ " 系统移除此Channel , channelId =" + ctx.channel() + " main=" + main + " sub=" + sub);
				ctx.close();
				return;
			}
			ByteBuf channelBuffer = dataBuffer.readBytes(actualPackageLength - ApplicationConstants.SIZE_OF_INT
					- ApplicationConstants.SIZE_OF_INT);
			Data data = new Data(channelBuffer);
			IMessage message = MessageContainer.getInstance().getEntity(
					"Message_" + DummyUtils.getCompositeKey(main, sub));

			if (message != null) {
				message.decode(data);
				if (message.validate()) {
					LogUtil.debug("Receive [" + StringUtils.rightPad(DummyUtils.getCompositeKey(main, sub), 8) + "]"
							+ message);
					out.add(message);
					return;
				} else {
					LogUtil.warn("消息接口[" + DummyUtils.getCompositeKey(main, sub) + "]验证不通过... " + message);
					return;
				}
			} else {
				LogUtil.warn("消息接口[" + DummyUtils.getCompositeKey(main, sub) + "]没有实现...");
				return;
			}
		} catch (Exception e) {
			LogUtil.error("解析命令异常 Processor_" + main + "_" + sub, e);
		}

		return;
	}
}
