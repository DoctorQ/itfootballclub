package com.aodci.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Club;
import com.aodci.service.impl.ClubServiceImpl;

public class GoSearchSporterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Club> list = new ArrayList<Club>();
		list = new ClubServiceImpl().getAllClub();
		if (list != null) {
			req.setAttribute("clubs", list);
			req.getRequestDispatcher("back/sporter/searchSporter.jsp").forward(
					req, resp);
		}
	}

}
