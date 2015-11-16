package com.lyb.client.constants;

public class ApplicationConstants {
	public static final int SIZE_OF_DOUBLE = 8;
	public static final int SIZE_OF_INT = 4;
	public static final int SIZE_OF_LONG = 8;
	public static final int SIZE_OF_FLOAT = 4;
	public static final int SIZE_OF_SHORT = 2;
	public static final int SIZE_OF_BYTE = 1;
	public static final int SIZE_OF_ZERO = 0;

	public static final String BATTLE_RESULT_KEYSTORE = "AaBb&*(6)W@#2ERQ!";

	public static final int HUNDRED_THOUSAND = 100000;

	/***************************************************************
	 ************************* Work State****************************
	 ***************************************************************/
	// 未开始
	public static final byte WORK_STATE_0 = 0;
	// 正在进行中 可以继续发送消息
	public static final byte WORK_STATE_1 = 1;
	// 进入CD中了 等待CD结束
	public static final byte WORK_STATE_2 = 2;
	// 正在进行中 等待服务器返回
	public static final byte WORK_STATE_3 = 3;

	/********* 属性数据 ************/
	// 怒气
	public static final int CURR_MP = 104;
	// 战力
	public static final int ZHANLI = 105;
	// 技能战力(表里面没配)
	public static final int SKILL_ZHANLI = 200;
	// 战场移动速度
	public static final int MOVE_SPEED = 203;
	// 生命值
	public static final int MAX_HP = 1001;
	// 生命值 百分比
	public static final int MAX_HP_PER = 1002;
	// 外功攻击
	public static final int WAI_ATTACK = 1003;
	// 外功攻击百分比
	public static final int WAI_ATTACK_PER = 1004;
	// 内功攻击
	public static final int NEI_ATTACK = 1005;
	// 内功攻击百分比
	public static final int NEI_ATTACK_PER = 1006;
	// 外功防御
	public static final int WAI_DEFENSE = 1007;
	// 外功防御百分比
	public static final int WAI_DEFENSE_PER = 1008;
	// 内功防御数值
	public static final int NEI_DEFENSE = 1009;
	// 内功防御百分比
	public static final int NEI_DEFENSE_PER = 1010;
	// 当前血量
	public static final int CURR_HP = 1011;
	// 暴击
	public static final int BAOJI = 1101;
	// 暴击率
	public static final int BAOJI_PER = 1102;
	// 减伤
	public static final int HURT_REDUCE = 1103;
	// 破防(穿透)
	public static final int POFANG = 1104;
	// 治疗值(疗伤)
	public static final int ZHILIAOZHI = 1105;
	// 闪避
	public static final int SHANBI = 1106;
	// 闪避 百分比
	public static final int SHANBI_PER = 1107;
	// 抵抗(御劲)
	public static final int DIKANG = 1108;
	// 抵抗(御劲) 百分比
	public static final int DIKANG_PER = 1109;
	// 阻挡(招架)
	public static final int ZUDANG = 1110;
	// 阻挡(招架) 百分比
	public static final int ZUDANG_PER = 1111;
	// 阻挡 触发几率
	public static final int ZUDANG_RATE = 1112;
	// 吸血值
	public static final int XIXUE = 1113;
	// 吸血百分比
	public static final int XIXUE_PER = 1114;
	// 化劲
	public static final int HUAJIN = 1115;
	// 化劲百分比
	public static final int HUAJIN_PER = 1116;
	// 用于修改战斗公式的数值加成部分
	public static final int SHUZHI_JIACHENG = 1211;
	// 用于修改战斗公式的百分比加成部分
	public static final int BAIFENBI_JIACHENG = 1212;

	public static final int TENCOUNTRY_HP_PER = 900009;

	/********************************* 战队类型 *************************************/
	// 剧情战斗
	public static final int TEAM_TYPE_1 = 1;
	// 十国战队
	public static final int TEAM_TYPE_2 = 2;
	// 琅琊宝库
	public static final int TEAM_TYPE_4 = 4;
	// 竞技场攻击
	public static final int TEAM_TYPE_6 = 6;
	// 英雄志
	public static final int TEAM_TYPE_7 = 7;
	// 朝堂
	public static final int TEAM_TYPE_9 = 9;
	// 寻宝
	public static final int TEAM_TYPE_12 = 12;
	// 朝堂刺杀
	public static final int TEAM_TYPE_13 = 13;
	// 地牢
	public static final int TEAM_TYPE_14 = 14;

	/********************************* 战场类型 *************************************/
	// 普通关卡战斗
	public static final byte BATTLE_TYPE_1 = 1;
	// 竞技场
	public static final byte BATTLE_TYPE_2 = 2;
	// 十国征战
	public static final byte BATTLE_TYPE_3 = 3;
	// 新手战场
	public static final byte BATTLE_TYPE_4 = 4;
	// 东宫高手（银两副本）
	public static final byte BATTLE_TYPE_5 = 5;
	// 穆府家将（经验副本）
	public static final byte BATTLE_TYPE_6 = 6;
	// 守护战场
	public static final byte BATTLE_TYPE_7 = 7;
	// 朝堂争辩
	public static final byte BATTLE_TYPE_9 = 9;
	// 英雄志关卡战斗
	public static final byte BATTLE_TYPE_10 = 10;
	// 五行战斗
	public static final byte BATTLE_TYPE_11 = 11;
	// 寻宝战斗
	public static final byte BATTLE_TYPE_12 = 12;
	// 朝堂暗杀战场
	public static final byte BATTLE_TYPE_13 = 13;
	// 挑战玩家
	public static final byte BATTLE_TYPE_14 = 14;
	// 地牢
	public static final byte BATTLE_TYPE_15 = 15;

	/********************************** 次数控制 ***************************************/
	// 好友送花
	public static final int COUNTCONTROL_TYPE_1 = 1;
	// 竞技场
	public static final int COUNTCONTROL_TYPE_2 = 2;
	// 琅琊宝库次数
	public static final int COUNTCONTROL_TYPE_3 = 3;
	// 十国征战次数
	public static final int COUNTCONTROL_TYPE_4 = 4;
	// 朝堂争辩
	public static final int COUNTCONTROL_TYPE_5 = 5;
	// 吃体力药次数
	public static final int COUNTCONTROL_TYPE_6 = 6;
	// 五行战斗
	public static final int COUNTCONTROL_TYPE_7 = 7;
	// 帮派酒宴
	public static final int COUNTCONTROL_TYPE_8 = 8;
	// QTE引导次数
	public static final int COUNTCONTROL_TYPE_9 = 9;
	// 每天可以雇佣佣兵的总次数
	public static final int COUNTCONTROL_TYPE_10 = 10;
	// 寻宝
	public static final int COUNTCONTROL_TYPE_11 = 11;
	// 有奖竞答
	public static final int COUNTCONTROL_TYPE_12 = 12;
	// 好友送体力
	public static final int COUNTCONTROL_TYPE_13 = 13;
	// 转盘免费次数
	public static final int COUNTCONTROL_TYPE_14 = 14;
	// 地牢每日次数
	public static final int COUNTCONTROL_TYPE_15 = 15;
	
	/****************************时间冷却类型********************************************/
	// 竞技场
	public static final int TIME_TYPE_1 = 1;
	// 琅琊试炼
	public static final int TIME_TYPE_2 = 2;
	
	
	// 默认命令间隔时间
	public static final long DEFAULT_SLEEP_TIME = 3000;
	// 战斗类型命令间隔时间
	public static final long FIGHT_SLEEP_TIME = 90000;

}
