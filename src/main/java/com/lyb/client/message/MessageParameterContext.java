package com.lyb.client.message;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.lyb.client.message.handler.IMessageParameterHandler;
import com.lyb.client.message.handler.IntMessageParameterHandler;
import com.lyb.client.message.handler.LongMessageParameterHandler;
import com.lyb.client.message.handler.ShortMessageParameterHandler;
import com.lyb.client.message.handler.StringMessageParameterHandler;
import com.lyb.client.utils.XMLConfigReader;

public class MessageParameterContext {
	private String messageParametersConfigFile = "/config/message/messageParameters.xml";

	private Map<String, ShortMessageParameterHandler> shortParameterMap = new HashMap<String, ShortMessageParameterHandler>();
	private Map<String, IntMessageParameterHandler> intParameterMap = new HashMap<String, IntMessageParameterHandler>();
	private Map<String, LongMessageParameterHandler> longParameterMap = new HashMap<String, LongMessageParameterHandler>();

	private Map<String, StringMessageParameterHandler> stringParameterMap = new HashMap<String, StringMessageParameterHandler>();

	private static MessageParameterContext INSTANCE = new MessageParameterContext();

	public static MessageParameterContext getInstance() {
		return INSTANCE;
	}

	public void init() throws Exception {
		initMessageParameters();
		XMLConfigReader configReader = new XMLConfigReader();
		InputStream inputStream = this.getClass().getResourceAsStream(messageParametersConfigFile);
		configReader.load(inputStream);

		List<Element> paramElements = configReader.getMultiElement("//params/param");
		for (Element paramElement : paramElements) {
			String paramName = paramElement.attributeValue("name");
			if (intParameterMap.containsKey(paramName) || longParameterMap.containsKey(paramName)) {
				throw new IllegalArgumentException("存在重复的Params->" + paramName);
			}
			String handler = paramElement.attributeValue("handler");
			String def = handler.trim().replaceAll("(.+)\\|.+\\|.+", "$1");
			String param = handler.trim().replaceAll(".+\\|(.+\\|.+)", "$1");
			if ("short".equals(def)) {
				shortParameterMap.put(paramName, new ShortMessageParameterHandler(paramName, def, param));
			}
			if ("int".equals(def)) {
				intParameterMap.put(paramName, new IntMessageParameterHandler(paramName, def, param));
			}
			if ("long".equals(def)) {
				longParameterMap.put(paramName, new LongMessageParameterHandler(paramName, def, param));
			}
			if ("string".equals(def)) {
				stringParameterMap.put(paramName, new StringMessageParameterHandler(paramName, "String", param));
			}
		}

	}

	public static void main(String[] args) throws Exception {
		MessageParameterContext.getInstance().init();
	}

	public void initMessageParameters() {
		registerHandlerClass("sequence", IntMessageParameterHandler.class);
	}

	public void registerHandler(String handlerName, IMessageParameterHandler handler) {
		if (intParameterMap.containsKey(handlerName)) {
			throw new IllegalArgumentException("handler name is already registered, handlerName = " + handlerName);
		}

	}

	public void registerHandlerClass(String type, Class<? extends IMessageParameterHandler> handlerClass) {
	}

	public ShortMessageParameterHandler getShortMessageParameterHandler(String name) {
		return this.shortParameterMap.get(name);
	}

	public IntMessageParameterHandler getIntMessageParameterHandler(String name) {
		return this.intParameterMap.get(name);
	}

	public LongMessageParameterHandler getLongMessageParameterHandler(String name) {
		return this.longParameterMap.get(name);
	}

	public IMessageParameterHandler getMessageParameterHandler(String name) {
		if (intParameterMap.containsKey(name)) {
			return intParameterMap.get(name);
		}
		if (longParameterMap.containsKey(name)) {
			return longParameterMap.get(name);
		}
		if (stringParameterMap.containsKey(name)) {
			return stringParameterMap.get(name);
		}
		return null;
	}

}
