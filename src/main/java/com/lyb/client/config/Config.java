package com.lyb.client.config;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "config", strict = false)
public class Config {
	@Attribute(name = "name", required = true)
	private String name;
	@Attribute(name = "serverIp", required = true)
	private String serverIp;
	@Attribute(name = "platform", required = true)
	private int platformId;
	@Attribute(name = "account", required = true)
	private String account;
	@Attribute(name = "password", required = true)
	private String password;

	@Element(name = "auto_buy_tili", required = false)
	private boolean autoBuyTili;

	// 英雄志
	@Element(name = "auto_xyz", required = false)
	private boolean autoXYZ;
	@Element(name = "xyz_quick_battle", required = false)
	private boolean xyzQuickBattle;

	// 关卡
	@Element(name = "auto_strongpoint", required = false)
	private boolean autoStrongpoint;

	// 寻宝
	@Element(name = "auto_xunbao", required = false)
	private boolean autoXunbao;
	@Element(name = "xunbao_reset", required = false)
	private boolean xunbaoReset;

	// 朝堂
	@Element(name = "auto_chaotang", required = false)
	private boolean autoChaotang;
	@Element(name = "chaotang_mobai", required = false)
	private boolean chaotangMobai;

	// 试练
	@Element(name = "auto_shilian", required = false)
	private boolean autoShilian;

	// 答题
	@Element(name = "auto_answer", required = false)
	private boolean autoAnswer;

	// 地牢
	@Element(name = "auto_dilao", required = false)
	private boolean autoDilao;
	@Element(name = "dilao_reset", required = false)
	private boolean dilaoReset;
	@Element(name = "dilao_refresh_count", required = false)
	private int dilaoRefreshCount;
	@Element(name = "dilao_diff", required = false)
	private boolean dilaoDiff;

	// 竞技场
	@Element(name = "auto_arena", required = false)
	private boolean autoArena;

	// 十国
	@Element(name = "auto_shiguo", required = false)
	private boolean autoShiguo;
	
	// 银两抽卡
	@Element(name = "auto_chouka_yingliang", required = false)
	private boolean silverEmploy;

	public String getName() {
		return name;
	}

	public String getServerIp() {
		return serverIp;
	}

	public int getPlatformId() {
		return platformId;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAutoBuyTili() {
		return autoBuyTili;
	}

	public boolean isXyzQuickBattle() {
		return xyzQuickBattle;
	}

	public boolean isAutoShilian() {
		return autoShilian;
	}

	public boolean isSilverEmploy() {
		return silverEmploy;
	}

	public boolean isAutoXYZ() {
		return autoXYZ;
	}

	public boolean isAutoStrongpoint() {
		return autoStrongpoint;
	}

	public boolean isAutoXunbao() {
		return autoXunbao;
	}

	public boolean isXunbaoReset() {
		return xunbaoReset;
	}

	public boolean isAutoChaotang() {
		return autoChaotang;
	}

	public boolean isAutoAnswer() {
		return autoAnswer;
	}

	public boolean isAutoDilao() {
		return autoDilao;
	}

	public boolean isDilaoReset() {
		return dilaoReset;
	}

	public int getDilaoRefreshCount() {
		return dilaoRefreshCount;
	}

	public boolean isAutoArena() {
		return autoArena;
	}

	public boolean isAutoShiguo() {
		return autoShiguo;
	}

	public boolean isDilaoDiff() {
		return dilaoDiff;
	}
	
	public boolean isChaotangMobai() {
		return chaotangMobai;
	}

}
