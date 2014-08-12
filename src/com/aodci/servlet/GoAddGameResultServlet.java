package com.aodci.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Club;
import com.aodci.bean.GameResult;
import com.aodci.dao.impl.ClubDAOImpl;
import com.aodci.dao.impl.GameResultDAOImpl;

public class GoAddGameResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GoAddGameResultServlet");
		List<Club> list = new ClubDAOImpl().getAllClub();
		if (list != null) {
			req.setAttribute("list", list);
			req.getRequestDispatcher("back/gameresult/addGameResult.jsp").forward(req, resp);
		}
	}

}
