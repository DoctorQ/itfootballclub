package com.aodci.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Club;
import com.aodci.bean.Sporter;
import com.aodci.service.impl.SporterServiceImpl;

public class SearchSporterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Sporter sporter = new SporterServiceImpl().getSingleSporter(id);
		System.out.println(sporter.toString());
		if(sporter!=null){
			req.setAttribute("sporter", sporter);
			req.getRequestDispatcher("desk/sporter/sportermes.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
		
		
	}

}
