package com.aodci.service;

import java.util.List;

import com.aodci.bean.ShotBoard;

public interface ShotBoardService {
	// 取得射手榜中的所有数据
	public List<ShotBoard> getShotBoard();

	// 根据取得单个射手的数据
	public ShotBoard getSingleShotBoard(int id);

	// 根据id删除射手的数据
	public void deleteShotBoard(int id);

	// 更新射手的数据
	public void updateShotBoard(ShotBoard sb);
	
	//更新添加
	public void updateAndAdd(ShotBoard sb);
		
}
