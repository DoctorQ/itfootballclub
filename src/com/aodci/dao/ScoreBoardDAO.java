package com.aodci.dao;

import java.util.List;

import com.aodci.bean.ScoreBoard;

public interface ScoreBoardDAO {
	// 取得积分榜表中所有数据
	public List<ScoreBoard> getScoreBoard();

	// 根据id取得某一对的积分数据
	public ScoreBoard getSingleScoreBoard(int id);
	
	// 根据name取得某一对的积分数据
	public ScoreBoard getSingleScoreBoard(String name);

	// 根据id删除积分榜某一队的数据
	public void deleteScoreBoard(int id);

	// 更新积分榜数据
	public void updateScoreBoard(ScoreBoard sb);
	
	//添加积分榜数据
	public void addScoreBoard(ScoreBoard sb);
	
	//根据名称删除
	public void deleteScoreBoard(String cname);
}
