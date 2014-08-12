package com.aodci.service.impl;

import java.util.List;

import com.aodci.bean.GameResult;
import com.aodci.dao.GameResultDAO;
import com.aodci.dao.impl.GameResultDAOImpl;
import com.aodci.service.GameResultService;

public class GameResultServiceImpl implements GameResultService {
	GameResultDAO gameResultDAO = new GameResultDAOImpl();
	@Override
	public List<GameResult> getAllGameResults() {
		List<GameResult> list = gameResultDAO.getAllGameResults();
		return list;
	}

	@Override
	public GameResult getSingeGameResult(int id) {
		GameResult gameResult = gameResultDAO.getSingeGameResult(id);
		return gameResult;
	}

	@Override
	public void deleteGameResult(int id) {
		gameResultDAO.deleteGameResult(id);

	}

	@Override
	public void updateGameResult(GameResult gr) {
		gameResultDAO.updateGameResult(gr);
	}

	@Override
	public void addGameResult(GameResult gr) {
		gameResultDAO.addGameResult(gr);
	}

	@Override
	public List<GameResult> getLegGameResults(int leg) {
		List<GameResult> list = gameResultDAO.getLegGameResults(leg);
		return list;
	}

}
