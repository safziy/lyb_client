package com.lyb.client.message.codegenerator;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.lyb.client.message.MessageParameterContext;
import com.lyb.client.message.handler.IMessageParameterHandler;
import com.lyb.client.utils.XMLConfigReader;

public class MessageCodeGenerator {

	private String messageParametersSequenceConfigFile = "/config/message/messageParameterSequence.xml";
	private String messageParametersConfigFile = "/config/message/messageParameters.xml";

	private static MessageCodeGenerator INSTANCE = new MessageCodeGenerator();

	public static MessageCodeGenerator getInstance() {
		return INSTANCE;
	}

	public void arrayGenerator() throws Exception {

		XMLConfigReader configReader = new XMLConfigReader();
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(messageParametersConfigFile);
			configReader.load(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
			return;
		}
		List<Element> paramElements = configReader.getMultiElement("//params/param");
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Element paramElement : paramElements) {
			String handler = paramElement.attributeValue("handler");
			String className = paramElement.attributeValue("name");
			if ("array".equals(handler)) {
				Element sequence = paramElement.element("sequence");
				String vars = sequence.getStringValue();
				if (vars != null && !vars.equals("")) {
					String[] varArray = vars.trim().split(",");
					for (int i = 0; i < varArray.length; i++) {
						String var = varArray[i];
						IMessageParameterHandler paHandler = MessageParameterContext.getInstance()
								.getMessageParameterHandler(var);
						if (paHandler != null) {
							String varName = paHandler.getName();
							String def = paHandler.getType();
							Map<String, String> map = new HashMap<String, String>();
							map.put("name", varName.substring(0, 1).toLowerCase() + var.substring(1));
							map.put("def", def);
							map.put("handlerName", varName);
							map.put("methedName", varName.substring(0, 1).toUpperCase() + varName.substring(1));
							list.add(map);
						} else {
							// 嵌套的array
							Map<String, String> map = new HashMap<String, String>();
							map.put("name", var.substring(0, 1).toLowerCase() + var.substring(1));
							map.put("def", var);
							map.put("methedName", var);
							list.add(map);
						}

					}
				}
				// 将变量传入模版
				VelocityContext context = new VelocityContext();
				context.put("name", className);
				context.put("varList", list);
				// log类生成
				VelocityUtil.generateClass("segmentClassTemplate.vm", context, "/src/main/java/com/lyb/client/message/protocol/segment",
						className, "message/codegenerator");
				list.clear();
			}
		}
	}

	public void generator(boolean isServer) throws Exception {
		XMLConfigReader configReader = new XMLConfigReader();
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(messageParametersSequenceConfigFile);
			configReader.load(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
			return;
		}
		List<Element> paramElements = configReader.getMultiElement("//parametersSequence/param");
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Element paramElement : paramElements) {
			String main = paramElement.attributeValue("main");
			String sub = paramElement.attributeValue("sub");
			String varStr = paramElement.getStringValue();
			if (varStr != null && !varStr.equals("")) {
				String[] varArray = varStr.trim().split(",");
				for (int i = 0; i < varArray.length; i++) {
					String var = varArray[i];
					IMessageParameterHandler handler = MessageParameterContext.getInstance()
							.getMessageParameterHandler(var);
					if (handler != null) {
						String name = handler.getName();
						String def = handler.getType();
						Map<String, String> map = new HashMap<String, String>();
						map.put("name", name.substring(0, 1).toLowerCase() + var.substring(1));
						map.put("def", def);
						map.put("handlerName", name);
						map.put("methedName", name.substring(0, 1).toUpperCase() + name.substring(1));
						list.add(map);
					} else {
						// 嵌套的array
						Map<String, String> map = new HashMap<String, String>();
						map.put("name", var.substring(0, 1).toLowerCase() + var.substring(1));
						map.put("def", var);
						map.put("methedName", var);
						list.add(map);
					}
				}
			}
			// 将变量传入模版
			VelocityContext context = new VelocityContext();
			context.put("main", main);
			context.put("sub", sub);
			context.put("varList", list);
			context.put("desc", paramElement.attributeValue("desc"));
			// log类生成
			VelocityUtil.generateClass("messageClassTemplate.vm", context, "/src/main/java/com/lyb/client/message/protocol/",
					"Message_" + main + "_" + sub, "message/codegenerator");

			generatorProcess(isServer, main, sub, context);

			list.clear();
		}
	}

	public void generatorProcess(boolean isServer, String main, String sub, VelocityContext context) {
		File processor = new File("src/yh/processor/impl/Processor_" + main + "_" + sub + ".java");
		if (isServer && !(main.length() == 4 || main.startsWith("100"))) {
			if (!processor.exists()) {
				VelocityUtil.generateClass("processorClassTemplate.vm", context, "/src/main/java/com/lyb/client/processor/impl/", "Processor_"
						+ main + "_" + sub, "message/codegenerator");
			}
		} else if (!isServer && (main.length() == 4 || main.startsWith("100"))) {
			if (!processor.exists()) {
				VelocityUtil.generateClass("processorClassTemplate.vm", context, "/src/main/java/com/lyb/client/processor/impl/", "Processor_"
						+ main + "_" + sub, "message/codegenerator");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		MessageParameterContext.getInstance().init();
		// 生成参数类
		MessageCodeGenerator.getInstance().arrayGenerator();
		// 生成processor类
		boolean isServer = false;// 是否是服务端
		MessageCodeGenerator.getInstance().generator(isServer);
		// UserSceneDataArray array = UserSceneDataArray.create();
		// array.addData(1, 100, 100, 1000000001, "ni", 1002, 1001, 1001, 1000,
		// 1, 0, "", 0);
		// Message_1007_100 message = Message_1007_100.create();
		// message.setUserSceneDataArray(array);
		// LogUtil.systemErr(message.validate() + "");
		// message.encode(new Data());
		// LogUtil.systemErr(message.toString());
	}
}
