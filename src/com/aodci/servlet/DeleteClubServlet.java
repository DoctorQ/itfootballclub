package com.aodci.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.service.impl.ClubServiceImpl;
import com.aodci.service.impl.ScoreBoardServiceImpl;

public class DeleteClubServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  cname = new String(req.getParameter("cname").getBytes("iso8859-1"));
		System.out.println("DeleteClubServlet,cname:"+cname);
		new ClubServiceImpl().deleteClub(cname);
		new ScoreBoardServiceImpl().deleteScoreBoard(cname);
		req.getRequestDispatcher("listClub").forward(req, resp);
		System.out.println("挑转");
		
	}

}
