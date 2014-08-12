package com.aodci.test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;

import com.aodci.bean.ScoreBoard;
import com.aodci.dao.ScoreBoardDAO;
import com.aodci.dao.impl.ScoreBoardDAOImpl;
import com.aodci.utils.ComparatorUtils;

public class ScoreBoardDAOImpleTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// new ScoreBoardDAOImpleTest().testScoreBoardSelectAll();
		// new ScoreBoardDAOImpleTest().testGetSingleScoreBoard();
		// new ScoreBoardDAOImpleTest().testDeleteSingleScoreBoard();
		new ScoreBoardDAOImpleTest().testUpdateScoreBoard();
	}

	/*
	 * 测试ScoreBoard类中的getScoreBoard（）方法是否正确
	 */
	public void testScoreBoardSelectAll() {
		ScoreBoardDAO sbd = new ScoreBoardDAOImpl();
		List<ScoreBoard> list = sbd.getScoreBoard();
		ComparatorUtils cUtils = new ComparatorUtils();
		Collections.sort(list, cUtils);
		for (ScoreBoard sb : list) {
			System.out.println(sb.toString());
		}
	}

	public void testGetSingleScoreBoard() {
		ScoreBoard sb = new ScoreBoardDAOImpl().getSingleScoreBoard(1);
		System.out.println(sb.toString());
	}

	public void testDeleteSingleScoreBoard() {
		new ScoreBoardDAOImpl().deleteScoreBoard(2);
	}

	public void testUpdateScoreBoard() {
		ScoreBoard sb = new ScoreBoard();
		sb.setName("Arsenal");
		sb.setGain(13);
		sb.setLose(7);
		sb.setFaith(1);
		sb.setWin(5);
		sb.setTie(0);
		sb.setId(3);
		sb.setScore(5 * 3 + 0 * 1);
		ScoreBoardDAO sbd = new ScoreBoardDAOImpl();
		ScoreBoard sb1 = sbd.getSingleScoreBoard(sb.getId());
		System.out.println("update before ---" + sb1.toString());
		sbd.updateScoreBoard(sb);
		sb1 = sbd.getSingleScoreBoard(sb.getId());
		System.out.println("update after ---" + sb1.toString());
	}
}
