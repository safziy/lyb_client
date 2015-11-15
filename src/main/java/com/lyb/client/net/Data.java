package com.lyb.client.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.utils.ValidateUtils;



/**
 * 业务层的数据包装区 业务消息的read和write都会被封装到Message中
 * 
 * @author Peter Lee
 * 
 */
public class Data {

	private ByteBuf cb;

	/**
	 * 写入
	 * 
	 * @param size
	 */
	public Data() {
		cb = Unpooled.buffer();
	}

	/**
	 * 读出
	 * 
	 * @param cb
	 */
	public Data(ByteBuf cb) {
		this.cb = cb;
	}

	public String getString() {
		int s = cb.readInt();

		if (cb.readableBytes() < s) {
			throw new RuntimeException("getString 没有可以读取的数据 " + cb.readableBytes() + "  " + s);
		}

		if (s <= 0)
			return "";

		byte[] bytes = new byte[s];

		cb.readBytes(bytes);

		return new String(bytes, CharsetUtil.UTF_8);
	}

	public int getInt() {

		if (cb.readableBytes() < ApplicationConstants.SIZE_OF_INT) {
			throw new RuntimeException("getInt 没有可以读取的数据 " + cb.readableBytes() + "  ");
		}

		return cb.readInt();
	}

	public long getLong() {

		if (cb.readableBytes() < ApplicationConstants.SIZE_OF_LONG) {
			throw new RuntimeException("getLong 没有可以读取的数据 " + cb.readableBytes() + "  ");
		}

		return cb.readLong();
	}

	public float getFloat() {

		if (cb.readableBytes() < ApplicationConstants.SIZE_OF_FLOAT) {
			throw new RuntimeException("getFloat 没有可以读取的数据 " + cb.readableBytes() + "  ");
		}

		return cb.readFloat();
	}

	public double getDouble() {

		if (cb.readableBytes() < ApplicationConstants.SIZE_OF_DOUBLE) {
			throw new RuntimeException("getDouble 没有可以读取的数据 " + cb.readableBytes() + "  ");
		}

		return cb.readDouble();
	}

	public short getShort() {

		if (cb.readableBytes() < ApplicationConstants.SIZE_OF_SHORT) {
			throw new RuntimeException("getShort 没有可以读取的数据 " + cb.readableBytes() + "  ");
		}

		return cb.readShort();
	}

	public byte getByte() {

		if (cb.readableBytes() < ApplicationConstants.SIZE_OF_BYTE) {
			throw new RuntimeException("getByte 没有可以读取的数据 " + cb.readableBytes() + "  ");
		}

		return cb.readByte();
	}

	public void writeString(String str) {
		if (ValidateUtils.isNotNullAndMoreThanZero(str)) {

			byte[] strBytes = str.getBytes(CharsetUtil.UTF_8);
			cb.writeInt(strBytes.length);
			cb.writeBytes(strBytes);

		} else {
			cb.writeInt(0);
		}

	}

	public void writeByteArray(final byte[] data) {
		if (ValidateUtils.isNotNull(data) && data.length > 0) {
			cb.writeInt(data.length);
			cb.writeBytes(data);
		} else {
			cb.writeInt(0);
		}
	}

	public void writeChannelBuffer(ByteBuf channelBuffer) {
		if (ValidateUtils.isNotNull(channelBuffer) && channelBuffer.readableBytes() > 0) {
			cb.writeInt(channelBuffer.readableBytes());
			cb.writeBytes(channelBuffer);
		} else {
			cb.writeInt(0);
		}
	}

	public void writeInt(int i) {
		cb.writeInt(i);
	}

	public void writeLong(long l) {
		cb.writeLong(l);
	}

	public void writeFloat(float f) {
		cb.writeFloat(f);
	}

	public void writeDouble(double d) {
		cb.writeDouble(d);
	}

	public void writeShort(short s) {
		cb.writeShort(s);
	}

	public void writeShortArray(short[] sa) {
		if (ValidateUtils.isNotNull(sa) && sa.length > 0) {
			cb.writeInt(sa.length);

			for (int i = 0; i < sa.length; i++) {
				cb.writeShort(sa[i]);
			}
		}
	}

	public void writeByte(byte b) {
		cb.writeByte(b);
	}

	public ByteBuf getChannelBuffer() {
		return cb;
	}

}
