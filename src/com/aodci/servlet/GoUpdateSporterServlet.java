package com.aodci.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Club;
import com.aodci.bean.Sporter;
import com.aodci.service.impl.ClubServiceImpl;
import com.aodci.service.impl.SporterServiceImpl;

public class GoUpdateSporterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Sporter sporter = new SporterServiceImpl().getSingleSporter(id);
		List<Club> list = new ClubServiceImpl().getAllClub();
		if(sporter != null && list!=null) {
			System.out.println("GoUpdateSporterServlet:"+ sporter.toString());
			req.setAttribute("list", list);
			req.setAttribute("sporter", sporter);
			req.getRequestDispatcher("back/sporter/updateSporter.jsp").forward(req, resp);
		}
	}

}
