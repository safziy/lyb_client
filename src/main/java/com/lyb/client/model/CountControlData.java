package com.lyb.client.model;

import java.util.List;

public class CountControlData {
	private long id;
	private int currentCount;
	private int totalCount;
	private int addCount;
	private int maxAddCount;
	private List<Integer> buyCountNeedGold;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getAddCount() {
		return addCount;
	}

	public void setAddCount(int addCount) {
		this.addCount = addCount;
	}

	public int getMaxAddCount() {
		return maxAddCount;
	}

	public void setMaxAddCount(int maxAddCount) {
		this.maxAddCount = maxAddCount;
	}

	public List<Integer> getBuyCountNeedGold() {
		return buyCountNeedGold;
	}

	public void setBuyCountNeedGold(List<Integer> buyCountNeedGold) {
		this.buyCountNeedGold = buyCountNeedGold;
	}

}
