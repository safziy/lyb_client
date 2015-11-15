package com.lyb.client.model;

import java.util.LinkedList;
import java.util.List;

public class ArenaData {
	private int count;
	private int season;
	private int remainSeconds;
	private int ranking;
	private int score;
	private List<TargetArenaPlayer> targetPlayers = new LinkedList<TargetArenaPlayer>();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getRemainSeconds() {
		return remainSeconds;
	}

	public void setRemainSeconds(int remainSeconds) {
		this.remainSeconds = remainSeconds;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<TargetArenaPlayer> getTargetPlayers() {
		return targetPlayers;
	}

	public void setTargetPlayers(List<TargetArenaPlayer> targetPlayers) {
		this.targetPlayers = targetPlayers;
	}

	public void addTargetPlayer(long userId, String userName, int level, int transforId, int score, int zhanli,
			int booleanValue) {
		TargetArenaPlayer innerTargetPlayer = new TargetArenaPlayer();
		innerTargetPlayer.setUserId(userId);
		innerTargetPlayer.setUserName(userName);
		innerTargetPlayer.setLevel(level);
		innerTargetPlayer.setTransforId(transforId);
		innerTargetPlayer.setScore(score);
		innerTargetPlayer.setZhanli(zhanli);
		innerTargetPlayer.setBooleanValue(booleanValue);
		targetPlayers.add(innerTargetPlayer);
	}

}
