package com.lyb.client.model;

public class ItemData {
	private long userItemId;
	private int itemId;
	private int count;
	private int isUsing;
	private int place;
	
	public ItemData(){
	}
	
	

	public ItemData(long userItemId, int itemId, int count, int isUsing, int place) {
		this.userItemId = userItemId;
		this.itemId = itemId;
		this.count = count;
		this.isUsing = isUsing;
		this.place = place;
	}



	public long getUserItemId() {
		return userItemId;
	}

	public void setUserItemId(long userItemId) {
		this.userItemId = userItemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIsUsing() {
		return isUsing;
	}

	public void setIsUsing(int isUsing) {
		this.isUsing = isUsing;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

}
