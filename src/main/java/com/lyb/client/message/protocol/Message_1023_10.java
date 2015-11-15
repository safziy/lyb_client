package com.lyb.client.message.protocol;

import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.segment.IDArray;
import com.lyb.client.message.protocol.segment.MailArray;
import com.lyb.client.net.Data;
import com.lyb.client.utils.DummyUtils;

/**
 * 返回 邮箱邮件
 *
 * @author codeGenerator
 * 
 */
public class Message_1023_10 implements IMessage {

	private static int MAIN = 1023;
	private static int SUB = 10;
	private static String MESSAGE_KEY = DummyUtils.getCompositeKey(1023, 10);

	private MailArray mailArray;
	private IDArray iDArray;


	public static Message_1023_10 create() {
		return new Message_1023_10();
	}

	/**
	 * @return the mailArray
	 */
	public MailArray getMailArray() {
		return mailArray;
	}

	/**
	 * @param mailArray
	 *            the mailArray to set
	 */
	public void setMailArray(MailArray mailArray) {
		this.mailArray = mailArray;
	}

	/**
	 * @return the iDArray
	 */
	public IDArray getIDArray() {
		return iDArray;
	}

	/**
	 * @param iDArray
	 *            the iDArray to set
	 */
	public void setIDArray(IDArray iDArray) {
		this.iDArray = iDArray;
	}


	/**
	 * 编码
	 */
	@Override
	public void encode(Data data) {
		mailArray.encode(data);
		iDArray.encode(data);
	}
	
	/**
	 * 解码
	 */
	@Override
	public void decode(Data data) {
		mailArray = MailArray.create();
		mailArray.decode(data);
		iDArray = IDArray.create();
		iDArray.decode(data);
	}

	@Override
	public boolean validate() {
		if (!mailArray.validate()) {
			return false;
		}
		if (!iDArray.validate()) {
			return false;
		}
		return true;
	}

	@Override
	public int getMain() {
		return MAIN;
	}

	@Override
	public int getSub() {
		return SUB;
	}

	@Override
	public String getMessageKey() {
		return MESSAGE_KEY;
	}
	
	public String toString() {
		StringBuilder bb = new StringBuilder();
		bb.append("mailArray:").append(mailArray.toString()).append(", ");
		bb.append("iDArray:").append(iDArray.toString());
		return bb.toString();	
	}
}