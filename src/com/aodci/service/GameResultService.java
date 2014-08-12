package com.aodci.service;

import java.util.List;

import com.aodci.bean.GameResult;

public interface GameResultService {
	// 取得所有比賽結果
	public List<GameResult> getAllGameResults();

	// 根据id查找比赛结果
	public GameResult getSingeGameResult(int id);
	
	//根据leg取得比赛结果
	public List<GameResult> getLegGameResults(int leg);

	// 根据id删除比赛结果
	public void deleteGameResult(int id);

	// 更新比赛结果
	public void updateGameResult(GameResult gr);
	
	//添加比赛结果
	public void addGameResult(GameResult gr);

}
