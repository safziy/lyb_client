package com.lyb.client.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressUtil {
	private final static int COMPRESS_SIZE = 512;

	public static ByteBuf uncompress(final ByteBuf buffer, int compressedLength, int clientDataLength)
			throws DataFormatException {
		byte[] bytes = new byte[clientDataLength];
		Inflater decompressor = new Inflater();
		try {
			if (decompressor.needsInput()) {
				decompressor.setInput(buffer.array(), 0, compressedLength);
				int serverDataLength = decompressor.inflate(bytes);
				if (ValidateUtils.isNotEqual(clientDataLength, serverDataLength)) {
					// TODO 
//					LogUtil.error("消息解压缩长度不匹配,server actual length=" + serverDataLength + ";Client actual length="
//							+ clientDataLength);
					return null;
				}
			}
		} catch (DataFormatException e) {
			// TODO 
//			LogUtil.error("uncompress error clientdatalength=" + clientDataLength + " buffer=" + buffer.readableBytes());
		} finally {
			decompressor.end();
		}
		return Unpooled.wrappedBuffer(bytes);
	}

	public static ByteBuf compress(final ByteBuf channelBuffer) {
		ByteBuf buffer = Unpooled.buffer();
		Deflater compressor = new Deflater();
		try {
			compressor.setInput(channelBuffer.array(), 0, channelBuffer.readableBytes());
			compressor.finish();
			byte[] bytes = new byte[COMPRESS_SIZE];
			while (!compressor.finished()) {
				int compressedLength = compressor.deflate(bytes);
				buffer.writeBytes(bytes, 0, compressedLength);
			}
		} finally {
			compressor.end();
		}
		return buffer;
	}
}
