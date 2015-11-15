package com.lyb.client.utils;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.math.RandomUtils;

public class MathUtils {

	/**
	 * 从min到max随机，包括min跟max
	 * 
	 * @param min
	 * @param max
	 * @return
	 */

	public static int randomGetInt(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("maxValue must > minValue");
		} else if (min == max) {
			return min;
		} else {
			int interval = max - min + 1;
			int value = min + RandomUtils.nextInt(interval);
			return value;
		}
	}

	public static boolean randomGetBoolean() {
		return RandomUtils.nextBoolean();
	}

	/**
	 * 从collection中随机一个出来
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 */

	public static <T> T randomGetFromCollection(Collection<T> collection) {

		if (collection.size() == 0) {
			return null;
		}

		int endIndex = randomGetInt(1, collection.size());
		int i = 0;
		for (T t : collection) {
			i++;
			if (i == endIndex) {
				return t;
			}
		}
		return null;
	}

	/**
	 * 从一个List中随机得到几个值
	 */
	public static <T> List<T> randomGetListFromCollection(Collection<T> collection, int count) {

		if (ValidateUtils.isNotNull(collection) && collection.size() > 0) {
			List<T> copyList = new LinkedList<T>(collection);

			Collections.shuffle(copyList);

			return new LinkedList<T>(copyList.subList(0, Math.min(count, collection.size())));
		} else {
			return new LinkedList<T>();
		}
	}

	/**
	 * 从一个List中必须得到几个值,可以重复
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T> List<T> mustRandomGetListFromCollection(Collection<T> collection, int count) {
		List<T> randomList = new LinkedList<T>();

		if (collection.size() == 0) {
			return randomList;
		}

		List<T> list = new ArrayList<T>(collection);

		for (int i = 0; i < count; i++) {
			randomList.add(list.get(MathUtils.randomGetInt(0, list.size() - 1)));
		}
		return randomList;
	}

	public static <T> T randomGetFromList(List<T> list) {
		if (list.size() == 0) {
			return null;
		}
		int targetIndex = randomGetInt(0, list.size() - 1);

		return list.get(targetIndex);
	}

	public static <T> T mustRandomGetFromRandomMap(Map<T, Integer> randomMap) {
		if (ValidateUtils.isNull(randomMap)) {
			return null;
		}
		int totalRate = 0;
		for (int rate : randomMap.values()) {
			totalRate += rate;
		}

		if (totalRate != MathUtils.HUNDRED_THOUSAND) {
			randomMap = trimRateMap(randomMap, MathUtils.HUNDRED_THOUSAND);
		}

		return trulyRandomFromRandomMap(randomMap);
	}

	/**
	 * 从随机map中随机得到一项的K,其中map的value表示此项出现的几率,如果随机值落在此几率内就返回对应的K,如果都没有落在此map定义的范围中
	 * ，则返回 null
	 */
	public static <T> T randomGetFromRandomMap(Map<T, Integer> randomMap) {
		if (ValidateUtils.isNull(randomMap)) {
			return null;
		}
		int totalRate = 0;
		for (Map.Entry<T, Integer> entry : randomMap.entrySet()) {
			totalRate += entry.getValue();
			if (totalRate > MathUtils.HUNDRED_THOUSAND) {
				break;
			}
		}
		if (totalRate > MathUtils.HUNDRED_THOUSAND) {
			randomMap = trimRateMap(randomMap, MathUtils.HUNDRED_THOUSAND);
			// LogUtil.debug(LogCategory.CONFIG_LOG,
			// "random rate > HUNDRED_THOUSAND stack="
			// + LogUtil.createCurrentThreadStack());
		}
		return trulyRandomFromRandomMap(randomMap);
	}

	private static <T> T trulyRandomFromRandomMap(Map<T, Integer> randomMap) {
		int randomGuality = MathUtils.randomGetIntFromHundredThousand();
		int beginIndex = 0;
		for (Map.Entry<T, Integer> entry : randomMap.entrySet()) {
			if (randomGuality > beginIndex && randomGuality <= beginIndex + entry.getValue()) {
				return entry.getKey();
			} else {
				beginIndex += entry.getValue();
			}
		}
		return null;
	}

	/**
	 * 从一个map中随机几个，可能会得到重复的
	 * 
	 * @param <T>
	 * @param randomMap
	 * @param count
	 * @return
	 */
	public static <T> Set<T> randomGetFromRandomMap(Map<T, Integer> randomMap, int count) {
		Set<T> set = new HashSet<T>();
		if (randomMap.size() < count) {
			return set;
		}
		while (set.size() != count) {
			T t = randomGetFromRandomMap(randomMap);
			if (ValidateUtils.isNotNull(t)) {
				set.add(t);
			}
		}
		return set;
	}

	/**
	 * 从一个map中随机几个，不会得到重复的
	 * 
	 * @param <T>
	 * @param randomMap
	 * @param count
	 * @return
	 */
	public static <T> Set<T> randomGetNoRepeatFromRandomMap(Map<T, Integer> randomMap, int count) {
		Set<T> set = new HashSet<T>();
		if (randomMap.size() < count) {
			return set;
		}
		Map<T, Integer> tempMap = new HashMap<T, Integer>();
		tempMap.putAll(randomMap);
		while (set.size() != count) {
			T t = mustRandomGetFromRandomMap(tempMap);
			if (ValidateUtils.isNotNull(t)) {
				set.add(t);
				tempMap.remove(t);
			}
		}
		return set;
	}

	/**
	 * 从随机map中随机得到一项的K,其中map的value表示此项出现的几率,如果随机值落在此几率内就返回对应的K,如果都没有落在此map定义的范围中
	 * ，则返回 null
	 */
	public static <T> T randomGetFromRandomMap(Map<T, Integer> randomMap, float adjustedFactor) {
		if (adjustedFactor != 1) {

			Map<T, Integer> afterAdditionMap = new HashMap<T, Integer>();
			for (Map.Entry<T, Integer> entry : randomMap.entrySet()) {
				int newRate = Math.round(entry.getValue() * adjustedFactor);
				afterAdditionMap.put(entry.getKey(), newRate);
			}

			return randomGetFromRandomMap(afterAdditionMap);

		} else {
			return randomGetFromRandomMap(randomMap);
		}

	}

	/**
	 * 检查并且重新生成随机Map
	 * 主要对于随机值总和>MathUtils.HUNDRED_THOUSAND的重新生成随机值,注意此方法会改变输入参数中Map中的value
	 * 
	 * @param <T>
	 * @param randomMap
	 * @return
	 */
	private static <T> Map<T, Integer> trimRateMap(Map<T, Integer> randomMap, int requireTotalRate) {
		int currentTotalRate = 0;
		Map<T, Integer> newRandomMap = new HashMap<T, Integer>();

		for (Map.Entry<T, Integer> entry : randomMap.entrySet()) {
			currentTotalRate += entry.getValue();
		}

		int index = 0;
		int lastIndex = randomMap.size() - 1;
		int totalAllocateRate = 0;
		float factor = requireTotalRate / (float) currentTotalRate;
		for (Map.Entry<T, Integer> entry : randomMap.entrySet()) {
			if (index == lastIndex) {
				newRandomMap.put(entry.getKey(), Math.max(requireTotalRate - totalAllocateRate, 0));
			} else {
				int allocateRate = Math.round(entry.getValue() * factor);
				totalAllocateRate += allocateRate;
				newRandomMap.put(entry.getKey(), allocateRate);
			}
			index++;
		}
		return newRandomMap;
	}

	public static void main(String[] args) {
		System.out.println(ceil(0));
	}

	public static String percent(double p1, double p2) {
		if (p2 == 0)
			return "0.0%";

		String str;
		double p3 = p1 / p2;
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);
		str = nf.format(p3);
		return str;
	}

	/**
	 * 从1到100000中随机得到一个值
	 */
	public static int randomGetIntFromHundredThousand() {
		return MathUtils.randomGetInt(1, HUNDRED_THOUSAND);
	}

	/**
	 * 一百
	 */
	public static final int HUNDRED = 100;
	/**
	 * 一千
	 */
	public static final int THOUSAND = 1000;

	/**
	 * 一万
	 */
	public static final int TEN_THOUSAND = 10000;

	/**
	 * 十万
	 */
	public static final int HUNDRED_THOUSAND = 100000;

	/**
	 * 千万
	 */
	public static final int TEN_MILLION = 10000000;

	public static byte NOT_HAVE_RANDOM_VALUE = -1;

	/**
	 * 检查是否发生
	 * 
	 * @param value
	 * @return
	 */
	public static boolean checkHappen(int value) {
		return randomGetIntFromHundredThousand() <= value;
	}

	/**
	 * 检查是否发生 以一万为底
	 */
	public static boolean checkHappenByTenThousand(int value) {
		return MathUtils.randomGetInt(1, TEN_THOUSAND) <= value;
	}

	/**
	 * 从随机map中随机得到一项的K,其中map的value表示此项出现的几率,如果随机值落在此几率内就返回对应的K,如果都没有落在此map定义的范围中
	 * ，则返回 null, addition是对几率的加成, addition按几率分配
	 */
	public static <T> T randomFromMapByAverageAddition(Map<T, Integer> randomMap, float addition) {
		if (ValidateUtils.isNull(randomMap)) {
			return null;
		}

		int additionInt = Math.round(MathUtils.HUNDRED_THOUSAND * addition);
		if (additionInt > 0) {
			// 取到所有的概率总和
			int calcTotalRate = 0;
			for (Map.Entry<T, Integer> entry : randomMap.entrySet()) {
				calcTotalRate += entry.getValue();
			}

			// 按照比率分配
			if (calcTotalRate > 0) {
				Map<T, Integer> newRandomMap = new HashMap<T, Integer>();
				for (Map.Entry<T, Integer> entry : randomMap.entrySet()) {
					int rate = entry.getValue();
					int newRate = rate + Math.round(rate / (float) calcTotalRate * additionInt);
					newRandomMap.put(entry.getKey(), newRate);
				}
				randomMap = newRandomMap;
			}
		}

		return randomGetFromRandomMap(randomMap);

	}

	public static boolean between(int min, int max, int checkValue) {
		if (checkValue >= min) {
			if (checkValue <= max) {
				return true;
			}
		}
		if (checkValue <= min) {
			if (checkValue >= max) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 计算最大公约数
	 * 
	 * @return
	 */
	public static int gcd(int value1, int value2) {
		if (value1 < value2) {
			int tempValue = value1;
			value1 = value2;
			value2 = tempValue;
		}
		while (value1 % value2 != 0) {
			int tempValue = value2;
			value2 = value1 % value2;
			value1 = tempValue;
		}
		return value2;
	}

	/**
	 * 除以100000，向上取整(不考虑小数位数)
	 * 
	 * @param value
	 * @return
	 */
	public static long ceil(long value) {
		if (value <= 0) {
			return 0;
		}
		if (value <= HUNDRED_THOUSAND) {
			return 1;
		}
		return (long) Math.ceil(value / (double) HUNDRED_THOUSAND);
	}

}
