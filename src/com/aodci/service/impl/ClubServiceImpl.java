package com.aodci.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.aodci.bean.Club;
import com.aodci.dao.ClubDAO;
import com.aodci.dao.impl.ClubDAOImpl;
import com.aodci.service.ClubService;

public class ClubServiceImpl implements ClubService {
	private ClubDAO clubDAO = new ClubDAOImpl();

	@Override
	public List<Club> getAllClub() {
		List<Club> list = new ArrayList<Club>();
		list = clubDAO.getAllClub();
		return list;
	}

	@Override
	public Club getSingeClub(int id) {
		Club club = clubDAO.getSingeClub(id);
		return club;
	}

	@Override
	public void deleteClub(int id) {
		// TODO Auto-generated method stub
		clubDAO.deleteClub(id);
	}

	@Override
	public void updateClub(Club club) {
		clubDAO.updateClub(club);

	}

	@Override
	public void addClub(Club club) {
		// TODO Auto-generated method stub
		clubDAO.addClub(club);
	}

	@Override
	public void deleteClub(String cname) {
		clubDAO.deleteClub(cname);
		
	}

	@Override
	public Club getClub(String cname) {
		Club club = clubDAO.getClub(cname);
		return club;
	}

}
