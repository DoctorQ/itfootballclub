package com.aodci.test;

import java.util.List;

import com.aodci.bean.ShotBoard;
import com.aodci.dao.ShotBoardDAO;
import com.aodci.dao.impl.ShotBoardDAOImpl;

public class ShotBoardDAOImplTest implements DAOImplTest {

	public static void main(String args[]) {
		ShotBoardDAOImplTest sbdi = new ShotBoardDAOImplTest();
		//sbdi.testInsert();
		//sbdi.testUpdate();
		//sbdi.testGetOne();
		//sbdi.testGetAll();
		sbdi.testDelete();
	}

	@Override
	public void testGetAll() {
		List<ShotBoard> list = new ShotBoardDAOImpl().getShotBoard();
		for (ShotBoard sb : list) {
			System.out.println(sb.toString());
		}
	}

	@Override
	public void testGetOne() {
		ShotBoard sb = new ShotBoardDAOImpl().getSingleShotBoard(1);
		System.out.println(sb.toString());

	}

	@Override
	public void testDelete() {
		new ShotBoardDAOImpl().deleteShotBoard(1);

	}

	@Override
	public void testUpdate() {
		ShotBoard sb = new ShotBoard();
		sb.setName("messiqian");
		sb.setCname("bacelqiab");
		sb.setGoals(500);
		sb.setId(1);
		ShotBoardDAO sbd = new ShotBoardDAOImpl();
		sbd.updateShotBoard(sb);
	}

	@Override
	public void testInsert() {
		ShotBoard sb = new ShotBoard();
		sb.setName("messi");
		sb.setCname("bacel");
		sb.setGoals(50);
		ShotBoardDAO sbd = new ShotBoardDAOImpl();
		sbd.insertShotBoard(sb);

	}

}
