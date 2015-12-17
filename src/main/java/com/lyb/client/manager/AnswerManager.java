package com.lyb.client.manager;

import java.util.Map;

import com.lyb.client.constants.ApplicationConstants;
import com.lyb.client.context.ConfigContext;
import com.lyb.client.log.LogUtil;
import com.lyb.client.message.protocol.Message_29_10;
import com.lyb.client.message.protocol.Message_29_11;
import com.lyb.client.message.protocol.Message_29_8;
import com.lyb.client.message.protocol.Message_29_9;
import com.lyb.client.model.PlayerWork;
import com.lyb.client.utils.MathUtils;
import com.lyb.client.utils.ValidateUtils;

public class AnswerManager {
	private PlayerManager playerManager;

	private int currentCount;
	private int totalCount;
	private int score;
	private int isAward;
	private long currentQuestionId;

	public AnswerManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void initWork() {
		openView();
	}

	public void openView() {
		Message_29_8 message_29_8 = new Message_29_8();
		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_29_8);
		work.setDesc("打开答题界面");
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void beginAnswer() {
		if (totalCount < 15) {
			question();
		} else if (ValidateUtils.isEqual(totalCount, 15) && ValidateUtils.isEqual(isAward, 0)) {
			takeAward();
		} else {
			LogUtil.info("今天的答题活动已经参加完了");
		}
	}

	public void question() {
		PlayerWork work = new PlayerWork();
		work.getMessages().add(new Message_29_9());
		work.setDesc("请求题目");
//		work.setMicroseconds(MathUtils.randomGetInt(15, 26) * 1000);
		if (MathUtils.checkHappen(5000)) {
			work.setMicroseconds(MathUtils.randomGetInt(3, 7) * 1000);
		} else {
			work.setMicroseconds(MathUtils.randomGetInt(3, 5) * 1000);
		}
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void answer(long questionId) {
		this.currentQuestionId = questionId;
		try {
			Map<String, String> map = ConfigContext.getInstance().getFileRow("Shili_Jinbangtimingtiku.lua",
					String.valueOf(this.currentQuestionId));
			LogUtil.info("题目: " + map.get("title") + "  选项1: " + map.get("answer1") + "  选项2: " + map.get("answer2")
					+ "  选项3: " + map.get("answer3") + "  选项4: " + map.get("answer4"));
		} catch (Exception e) {

		}
		Message_29_10 message_29_10 = new Message_29_10();
		message_29_10.setValue(1);

		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_29_10);
		work.setDesc("答题发送答案");
		work.setMicroseconds(ApplicationConstants.DEFAULT_SLEEP_TIME);
		playerManager.getWorkQueue().offerFirst(work);
	}

	public void answerResult(int score, int value) {
		this.totalCount++;
		if (score > this.score) {
			this.score = score;
			this.currentCount++;
			LogUtil.info("题目答对了 当前分数: " + this.score + "  已答对: " + this.currentCount + "  已答 " + this.totalCount
					+ "/15");
		} else {
			LogUtil.info("题目答错了 当前分数: " + this.score + "  已答对: " + this.currentCount + "  已答 " + this.totalCount
					+ "/15");
		}

		beginAnswer();
	}

	public void takeAward() {
		Message_29_11 message_29_11 = new Message_29_11();
		PlayerWork work = new PlayerWork();
		work.getMessages().add(message_29_11);
		work.setDesc("开始领取答题的奖励");
		playerManager.getWorkQueue().offerFirst(work);
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getIsAward() {
		return isAward;
	}

	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}

	public long getCurrentQuestionId() {
		return currentQuestionId;
	}

	public void setCurrentQuestionId(long currentQuestionId) {
		this.currentQuestionId = currentQuestionId;
	}

}
