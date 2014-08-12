package com.aodci.service.impl;

import java.util.List;

import com.aodci.bean.ShotBoard;
import com.aodci.dao.ShotBoardDAO;
import com.aodci.dao.impl.ShotBoardDAOImpl;
import com.aodci.service.ShotBoardService;

public class ShotBoardServiceImpl implements ShotBoardService {
	ShotBoardDAO sDao = new ShotBoardDAOImpl();
	@Override
	public List<ShotBoard> getShotBoard() {
		List<ShotBoard> list = sDao.getShotBoard();
		return list;
	}

	@Override
	public ShotBoard getSingleShotBoard(int id) {
		ShotBoard sb = sDao.getSingleShotBoard(id);
		return sb;
	}

	@Override
	public void deleteShotBoard(int id) {
		sDao.getSingleShotBoard(id);
	}

	@Override
	public void updateShotBoard(ShotBoard sb) {
		updateShotBoard(sb);

	}

	@Override
	public void updateAndAdd(ShotBoard sb) {
		sDao.updateAndAdd(sb);
		
	}

}
