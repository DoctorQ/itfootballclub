package com.aodci.test;

import java.util.List;

import com.aodci.bean.GameResult;
import com.aodci.dao.GameResultDAO;
import com.aodci.dao.impl.GameResultDAOImpl;

public class GameResultDAOImplTest implements DAOImplTest {

	public static void main(String args[]) {
		GameResultDAOImplTest grdt = new GameResultDAOImplTest();
		// grdt.testInsert();
		// grdt.testUpdate();
		// grdt.testGetAll();
		//grdt.testGetOne();
		grdt.testDelete();
	}

	@Override
	public void testGetAll() {
		List<GameResult> list = new GameResultDAOImpl().getAllGameResults();
		for (GameResult gr : list) {
			System.out.println(gr.toString());
		}

	}

	@Override
	public void testGetOne() {
		GameResult rs = new GameResultDAOImpl().getSingeGameResult(1);
		System.out.println("---getOne:" + rs.toString());

	}

	@Override
	public void testDelete() {
		new GameResultDAOImpl().deleteGameResult(1);

	}

	@Override
	public void testUpdate() {
		GameResult rs = new GameResult();
		rs.setpName("manqian");
		rs.setcName("aserqian");
		rs.setpGoal(40);
		rs.setcGoal(30);
		rs.setGameTime("20130904");
		rs.setField("old laf");
		rs.setId(1);
		GameResultDAO gResultDAO = new GameResultDAOImpl();
		gResultDAO.updateGameResult(rs);

	}

	@Override
	public void testInsert() {
		GameResult rs = new GameResult();
		rs.setpName("man");
		rs.setcName("aser");
		rs.setpGoal(4);
		rs.setcGoal(3);
		rs.setGameTime("20130903");
		rs.setField("old");
		GameResultDAO gResultDAO = new GameResultDAOImpl();
		gResultDAO.addGameResult(rs);
	}

}
