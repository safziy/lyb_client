package com.lyb.client.message;

import com.lyb.client.net.Data;

/**
 * 参数
 * 
 * 
 * @date 2013-5-21
 */
public interface IMessageEncoder {

	/**
	 * encode数据
	 * 
	 * @param data
	 */
	void encode(Data data);

	/**
	 * decode数据
	 * 
	 * @param data
	 */
	void decode(Data data);

	/**
	 * 验证数据
	 */
	boolean validate();
}
