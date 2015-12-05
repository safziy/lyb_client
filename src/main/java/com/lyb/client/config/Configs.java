package com.lyb.client.config;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "configs")
public class Configs {
	@Element(name = "auto_buy_tili")
	private boolean autoBuyTili;
	@Element(name = "xyz_quick_battle")
	private boolean xyzQuickBattle;
	@Element(name = "dilao_refresh")
	private boolean dilaoRefresh;
	
	
	@Element(name = "chouka_yingliang")
	private boolean silverEmploy;

	public boolean isAutoBuyTili() {
		return autoBuyTili;
	}

	public boolean isXyzQuickBattle() {
		return xyzQuickBattle;
	}
	
	public boolean isDilaoRefresh() {
		return dilaoRefresh;
	}
	
	public boolean isSilverEmploy() {
		return silverEmploy;
	}

}
