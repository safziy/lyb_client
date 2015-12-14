package com.lyb.client.config;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.lyb.client.utils.ValidateUtils;

@Root(name = "configs")
public class Configs {
	@Element(name = "config-name")
	private String configName;
	@ElementList(inline = true)
	private List<Config> configList;
	
	public Config getConfig(){
		for (Config config : configList) {
			if(ValidateUtils.isEqual(config.getName(), configName)){
				return config;
			}
		}
		return null;
	}
	

}
