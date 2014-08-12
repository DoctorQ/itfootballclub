package com.aodci.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Club;
import com.aodci.service.impl.ClubServiceImpl;

public class UpdateClubServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String ctime = new String(req.getParameter("ctime").getBytes("iso8859-1"));
		String coach = new String(req.getParameter("coach").getBytes("iso8859-1"));
		String location = new String(req.getParameter("location").getBytes("iso8859-1"));
		String homefield = new String(req.getParameter("homefield").getBytes("iso8859-1"));
		String builder = new String(req.getParameter("builder").getBytes("iso8859-1"));
		Club club = new Club();
		club.setId(id);
		club.setBuilder(builder);
		club.setCoach(coach);
		club.setcTime(ctime);
		club.setHomeField(homefield);
		club.setLocation(location);
		new ClubServiceImpl().updateClub(club);
		req.getRequestDispatcher("listClub").forward(req, resp);
		System.out.println("UpdateClubServlet:"+club.toString());
	}

}
