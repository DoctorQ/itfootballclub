package com.aodci.test;

import java.util.List;

import com.aodci.bean.Sporter;
import com.aodci.dao.impl.SporterDAOImpl;

public class SporterDAOImplTest implements DAOImplTest {

	@Override
	public void testGetAll() {
		List<Sporter> list = new SporterDAOImpl().getAllSporters();
		for (Sporter sporter : list) {
			System.out.println(sporter.toString());
		}

	}

	@Override
	public void testGetOne() {
		Sporter sporter = new SporterDAOImpl().getSingleSporter(1);
		System.out.println("one: --" + sporter.toString());
	}

	@Override
	public void testDelete() {
		new SporterDAOImpl().deleteSporter(1);

	}

	@Override
	public void testUpdate() {
		Sporter sporter = new Sporter();
		sporter.setName("messikk");
		sporter.setcName("baceljj");
		sporter.setCountry("agentingjj");
		sporter.setBorn("1989-12-03");
		sporter.setId(1);
		new SporterDAOImpl().updateSporter(sporter);

	}

	@Override
	public void testInsert() {
		Sporter sporter = new Sporter();
		sporter.setName("messi");
		sporter.setcName("bacel");
		sporter.setCountry("agenting");
		sporter.setBorn("1989-12-03");
		new SporterDAOImpl().addSporter(sporter);
	}
	public void testNum(){
		int num = new SporterDAOImpl().num();
		System.out.println("total:"+num);
	}
	public void testJson(){
		String json = new SporterDAOImpl().getSporterName("Manchester United A");
		System.out.println(json);
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		SporterDAOImplTest sbdi = new SporterDAOImplTest();
		// sbdi.testInsert();
		// sbdi.testUpdate();
		// sbdi.testGetOne();
		// sbdi.testGetAll();
		//sbdi.testDelete();
		//sbdi.testNum();
		sbdi.testJson();
	}

}
