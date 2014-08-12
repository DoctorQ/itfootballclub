package com.aodci.service.impl;

import java.util.Collections;
import java.util.List;

import com.aodci.bean.ScoreBoard;
import com.aodci.dao.ScoreBoardDAO;
import com.aodci.dao.impl.ScoreBoardDAOImpl;
import com.aodci.service.ScoreBoardService;
import com.aodci.utils.ComparatorUtils;

public class ScoreBoardServiceImpl implements ScoreBoardService {
	private ScoreBoardDAO sbd = new ScoreBoardDAOImpl();

	@Override
	public List<ScoreBoard> getScoreBoard() {
		List<ScoreBoard> list = sbd.getScoreBoard();
		if (list != null) {
			ComparatorUtils cUtils = new ComparatorUtils();
			Collections.sort(list, cUtils);
		}
		return list;
	}

	@Override
	public ScoreBoard getSingleScoreBoard(int id) {
		ScoreBoard sb = sbd.getSingleScoreBoard(id);
		return sb;
	}

	@Override
	public void deleteScoreBoard(int id) {
		deleteScoreBoard(id);

	}

	@Override
	public void updateScoreBoard(ScoreBoard sb) {
		sbd.updateScoreBoard(sb);
	}

	@Override
	public void addScoreBoard(ScoreBoard sb) {
		sbd.addScoreBoard(sb);
		
	}

	@Override
	public void deleteScoreBoard(String cname) {
		sbd.deleteScoreBoard(cname);
	}

	@Override
	public ScoreBoard getSingleScoreBoard(String name) {
		ScoreBoard sb = sbd.getSingleScoreBoard(name);
		return sb;
	}

}
