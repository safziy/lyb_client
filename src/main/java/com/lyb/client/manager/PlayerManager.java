package com.lyb.client.manager;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

import com.lyb.client.config.ConfigContainer;
import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.IMessage;
import com.lyb.client.message.protocol.Message_1_6;
import com.lyb.client.message.protocol.Message_2_1;
import com.lyb.client.message.protocol.Message_2_11;
import com.lyb.client.message.protocol.Message_2_13;
import com.lyb.client.message.protocol.Message_2_7;
import com.lyb.client.message.protocol.Message_9_15;
import com.lyb.client.model.Client;
import com.lyb.client.model.PlayerData;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.model.RoleMessage;
import com.lyb.client.utils.ValidateUtils;
import com.safziy.commom.utils.TimeUtils;

public class PlayerManager {
	private Client client;

	private PlayerData playerData;

	private TenCountryManager tenCountryManager;
	private StrongPointManager strongPointManager;
	private CountControlManager countControlManager;
	private DataAccumulateManager dataAccumulateManager;
	private BattleManager battleManager;
	private YXZManager yxzManager;
	private HeroManager heroManager;
	private ItemManager itemManager;
	private TeamManager teamManager;
	private ArenaManager arenaManager;
	private TimeManager timeManager;
	private AnswerManager answerManager;
	private ShilianManager shilianManager;
	private XunbaoManager xunbaoManager;
	private ChaotangManager chaotangManager;
	private DilaoManager dilaoManager;
	private ChoukaManager choukaManager;
	private ChatManager chatManager;
	private ActivityManager activityManager;
	private ZhixianManager zhixianManager;

	private Deque<PlayerWork> workQueue = new ConcurrentLinkedDeque<PlayerWork>();

	public PlayerManager(Client client) {
		this.client = client;
		this.playerData = new PlayerData();
		playerData.setHearBeatTime(System.currentTimeMillis());
		tenCountryManager = new TenCountryManager(this);
		strongPointManager = new StrongPointManager(this);
		countControlManager = new CountControlManager(this);
		dataAccumulateManager = new DataAccumulateManager(this);
		yxzManager = new YXZManager(this);
		heroManager = new HeroManager(this);
		itemManager = new ItemManager(this);
		teamManager = new TeamManager(this);
		battleManager = new BattleManager(this);
		arenaManager = new ArenaManager(this);
		timeManager = new TimeManager(this);
		answerManager = new AnswerManager(this);
		shilianManager = new ShilianManager(this);
		xunbaoManager = new XunbaoManager(this);
		chaotangManager = new ChaotangManager(this);
		dilaoManager = new DilaoManager(this);
		choukaManager = new ChoukaManager(this);
		chatManager = new ChatManager(this);
		activityManager = new ActivityManager(this);
		zhixianManager = new ZhixianManager(this);
	}

	public void write(IMessage message) {
		client.write(message);
	}

	/**
	 * 登陆游戏服务器 获取角色信息
	 */
	public void login() {
		Message_2_11 message_2_11 = new Message_2_11();
		message_2_11.setOrigainalServerId(client.getServerId());
		message_2_11.setPlatformId(client.getPlatformId());
		message_2_11.setKey(client.getAccount());
		message_2_11.setPwd(client.getPassword());
		// String dcStr =
		// "install_key=3b81401b-f1e1-49ed-a8a9-c0d7cf242ac9&mac=C0EEFB0760E2&udid=2195a60013127174&gameversion=1.1.177
		// &clienttype=A0001&clientversion=4.3&channel_id=0&networktype=wifi&clientpixel=1920x1080
		// &serial_number=19786d06&android_id=2195a60013127174&google_aid=2195a60013127174&location=cn
		// &src=lan_test&equipment=nocrack&carrier=&idfa=&simulator=0&WifiMac=&BootTime=0&unique_key=langyabang_androidcn_prod";

		String dcStr = "install_key=E59AE64D-C290-4EAB-A430-D1C1504F9AE3&mac=020000000000&udid=06C9584A-B8FD-4990-9170-7484BB01DCB3&gameversion=1.4.20&clienttype=iPhone8_1&clientversion=9.1&channel_id=FJM_TEST_CCCCC&networktype=WIFI&clientpixel=1334*750&serial_number=&android_id=&google_aid=&location=cn&src=apple&equipment=nocrack&carrier=中国电信&idfa=02ACBB9F-8E41-4915-AC60-2FA0295CDC1D&simulator=0&WifiMac=a46c2a681aef&BootTime=0&unique_key=langyabang_ioscn_prod";
		message_2_11.setDCParamStr(dcStr);
		write(message_2_11);
	}

	/**
	 * 请求角色登陆认证
	 */
	public void authentication() {
		Iterator<RoleMessage> it = playerData.getRoleList().iterator();
		if (it.hasNext()) {
			RoleMessage role = it.next();
			Message_2_1 message = new Message_2_1();
			message.setUserName("");
			message.setOrigainalServerId(role.getOrigainalServerId());
			write(message);
		} else {
			createRole();
		}
	}

	/**
	 * 请求创建角色
	 */
	public void createRole() {

	}

	/**
	 * 请求初始化客户端
	 */
	public void initClient() {
		Message_2_7 message = new Message_2_7();
		write(message);
	}

	/**
	 * 初始化客户端完成
	 */
	public void initClientComplete() {
		Message_2_13 message = new Message_2_13();
		write(message);
	}

	public void initAllWork() {
		// 来一波银两抽卡
		// choukaManager.initWork();
		// 来刷一波广告
		// chatManager.initWork();

		// 答题
		answerManager.initWork();
		// 十国
		tenCountryManager.initWork();
		// 竞技场
		arenaManager.initWork();
		// 地牢
		dilaoManager.initWork();
		// 试练
		shilianManager.initWork();
		// 朝堂
		chaotangManager.initWork();
		// 寻宝
		xunbaoManager.initWork();
		// 关卡
		strongPointManager.initWork();
		// 英雄志
		yxzManager.initWork();
		// 支线
		zhixianManager.initWork();
		// 活动
		activityManager.initWork();
		
		
	}

	public void work() {

		initAllWork();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (workQueue.size() > 0) {
					PlayerWork work = workQueue.pollFirst();
					switch (work.getState()) {
					case ApplicationConstants.WORK_STATE_0:
					case ApplicationConstants.WORK_STATE_1:
						LogUtil.info(work.getDesc());
						for (IMessage message : work.getMessages()) {
							write(message);
						}
						work.work();
						break;
					case ApplicationConstants.WORK_STATE_2:
						if (work.checkActiveTime()) {
							LogUtil.info(work.getDesc());
							for (IMessage message : work.getMessages()) {
								write(message);
							}
							work.work();
						} else {
							workQueue.offerLast(work);
						}
						break;
					case ApplicationConstants.WORK_STATE_3:
						break;
					default:
						break;
					}
					// 检查报活
					checkHearbBeat();
					try {
						Thread.sleep(work.getMicroseconds());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	protected void checkHearbBeat() {
		long currentTime = System.currentTimeMillis();
		if (TimeUtils.getIntervalMinutes(currentTime, playerData.getHearBeatTime()) >= 4) {
			playerData.setHearBeatTime(currentTime);
			LogUtil.info("发送玩家在线心跳");
			Message_1_6 message_1_6 = new Message_1_6();
			write(message_1_6);
		}
	}

	public Deque<PlayerWork> getWorkQueue() {
		return workQueue;
	}

	public PlayerData getPlayerData() {
		return playerData;
	}

	public TenCountryManager getTenCountryManager() {
		return tenCountryManager;
	}

	public StrongPointManager getStrongPointManager() {
		return strongPointManager;
	}

	public CountControlManager getCountControlManager() {
		return countControlManager;
	}

	public DataAccumulateManager getDataAccumulateManager() {
		return dataAccumulateManager;
	}

	public YXZManager getYXZManager() {
		return yxzManager;
	}

	public HeroManager getHeroManager() {
		return heroManager;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public TeamManager getTeamManager() {
		return teamManager;
	}

	public BattleManager getBattleManager() {
		return battleManager;
	}

	public ArenaManager getArenaManager() {
		return arenaManager;
	}

	public TimeManager getTimeManager() {
		return timeManager;
	}

	public AnswerManager getAnswerManager() {
		return answerManager;
	}

	public ShilianManager getShilianManager() {
		return shilianManager;
	}

	public XunbaoManager getXunbaoManager() {
		return xunbaoManager;
	}

	public ChaotangManager getChaotangManager() {
		return chaotangManager;
	}

	public DilaoManager getDilaoManager() {
		return dilaoManager;
	}

	public ChoukaManager getChoukaManager() {
		return choukaManager;
	}

	public ChatManager getChatManager() {
		return chatManager;
	}

	public ActivityManager getActivityManager() {
		return activityManager;
	}
	
	public ZhixianManager getZhixianManager() {
		return zhixianManager;
	}

	public boolean checkCanBuyTili() {
		if (ValidateUtils.isFalse(ConfigContainer.getInstance().getConfig().isAutoBuyTili())) {
			return false;
		}
		int remainCount = getCountControlManager().getRemainCount(ApplicationConstants.COUNTCONTROL_TYPE_6, 0);
		int needGold = Integer.parseInt(ConfigContext.getInstance().getFileValue("Shangdian_Shangdianwupin.lua",
				String.valueOf(3000024), "price"));
		if (remainCount > 0 && getPlayerData().getGold() >= needGold) {
			return true;
		}
		return false;
	}

	public void buyTili() {
		int remainCount = getCountControlManager().getRemainCount(ApplicationConstants.COUNTCONTROL_TYPE_6, 0);
		int needGold = Integer.parseInt(ConfigContext.getInstance().getFileValue("Shangdian_Shangdianwupin.lua",
				String.valueOf(3000024), "price"));
		if (remainCount > 0 && getPlayerData().getGold() >= needGold) {
			Message_9_15 message_9_15 = new Message_9_15();
			message_9_15.setID(3000024);

			PlayerWork work = new PlayerWork();
			work.getMessages().add(message_9_15);
			work.setDesc("购买并使用饺子");
			workQueue.offerFirst(work);
		}
	}

}
