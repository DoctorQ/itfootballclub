package com.aodci.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Club;
import com.aodci.dao.ClubDAO;
import com.aodci.service.impl.ClubServiceImpl;

public class GoUpdateClubServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		Club club = new ClubServiceImpl().getSingeClub(id);
		if (club != null) {
			req.setAttribute("club", club);
			req.getRequestDispatcher("back/club/updateClub.jsp").forward(req, resp);
		}
	}

}
