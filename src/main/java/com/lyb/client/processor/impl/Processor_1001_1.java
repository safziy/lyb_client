package com.lyb.client.processor.impl;

import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_1001_1;
import com.lyb.client.processor.IMessageProcessor;
import com.lyb.client.utils.ValidateUtils;

/**
 * 返回 对应的错误码
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1001_1 extends IMessageProcessor<Message_1001_1> {

	@Override
	public void execute(PlayerManager playerManager, Message_1001_1 message) throws Exception {
		int errorCode = message.getErrorCode();
		String desc = ConfigContext.getInstance().getFileValue("Tishi_Cuowuma.lua", String.valueOf(errorCode), "desc1");
		if (ValidateUtils.isNull(desc)) {
			desc = "未知错误码";
		}
		LogUtil.error("客户端返回了错误码!   errorCode=" + errorCode + "   " + desc);
	}
}
