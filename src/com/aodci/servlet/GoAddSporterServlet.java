package com.aodci.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aodci.bean.Club;
import com.aodci.bean.Sporter;
import com.aodci.service.impl.ClubServiceImpl;
import com.aodci.service.impl.SporterServiceImpl;

public class GoAddSporterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Club> list = new ArrayList<Club>();
		List<Sporter> list2 = new ArrayList<Sporter>();
		list2 = new SporterServiceImpl().getAllSporters();
		list = new ClubServiceImpl().getAllClub();
		System.out.println(list2.size());
		if(list != null) {
			req.setAttribute("snum", list2.size());
			req.setAttribute("list", list);
			req.getRequestDispatcher("back/sporter/addSporter.jsp").forward(req, resp);
		}
		
	}

}
