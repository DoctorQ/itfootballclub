package com.aodci.test;

import java.util.List;

import com.aodci.bean.Club;
import com.aodci.dao.ClubDAO;
import com.aodci.dao.impl.ClubDAOImpl;

public class ClubDAOImplTest implements DAOImplTest{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClubDAOImplTest tt = new ClubDAOImplTest();
		//tt.testGetAll();
		//tt.testGetOne();
		//tt.testDelete();
		//tt.testUpdate();
		tt.testInsert();
	}

	@Override
	public void testGetAll() {
		// TODO Auto-generated method stub
		List<Club> list = new ClubDAOImpl().getAllClub();
		for(Club bClub : list){
			System.out.println(bClub.toString());
		}
		
	}

	@Override
	public void testGetOne() {
		Club bClub = new ClubDAOImpl().getSingeClub(3);
		System.out.println(bClub.toString());
		
	}

	@Override
	public void testDelete() {
		new ClubDAOImpl().deleteClub(3);
		
	}

	@Override
	public void testUpdate() {
		Club bClub = new Club();
		bClub.setCoach("魔力鸟");
		bClub.setcName("切尔西");
		bClub.setcTime("19050310");
		bClub.setBuilder("亨利-安古斯图斯-米尔斯");
		bClub.setHomeField("斯坦福桥");
		bClub.setImgurl("images/chelsea.png");
		bClub.setLocation("北伦敦");
		bClub.setId(4);
		ClubDAO cd = new ClubDAOImpl();
		Club a = cd.getSingeClub(4);
		System.out.println(a.toString());
		cd.updateClub(bClub);
		a = cd.getSingeClub(4);
		System.out.println(a.toString());	
	}

	@Override
	public void testInsert() {
		Club bClub = new Club();
		bClub.setcName("曼联");
		bClub.setcTime("18780101");
		bClub.setHomeField("老特拉福德");
		bClub.setImgurl("images/manchesterunited.png");
		bClub.setLocation("曼彻斯特");
		bClub.setCoach("莫耶斯");
		System.out.println(bClub.toString());
		new ClubDAOImpl().addClub(bClub);
		
	}
	
}
