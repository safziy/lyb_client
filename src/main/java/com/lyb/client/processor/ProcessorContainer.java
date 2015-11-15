package com.lyb.client.processor;


public class ProcessorContainer extends AbstractContainer<IMessageProcessor<?>> {

	private static ProcessorContainer instance = new ProcessorContainer();
	
	private ProcessorContainer() {
		super("com.lyb.client.processor.impl");
	}

	public static ProcessorContainer getInstance() {
		return instance;
	}
}
