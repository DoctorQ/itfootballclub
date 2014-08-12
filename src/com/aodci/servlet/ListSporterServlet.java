package com.aodci.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Sporter;
import com.aodci.service.SporterService;
import com.aodci.service.impl.SporterServiceImpl;

public class ListSporterServlet extends HttpServlet {
	private int page = 1;
	private int pageNum = 0;
	private int num = 0;
	private SporterService sporterService = new SporterServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int page2 = 0;
		String page1 = (String) req.getParameter("page");
		if (page1 != null) {
			page2 = Integer.parseInt(page1);
		}
		pageNum = sporterService.pageNum();
		if (page2 > pageNum)
			page2 = pageNum;
		if (page2 < 1)
			page2 = 1;
		page = page2;
		num = sporterService.num();
		List<Sporter> list = sporterService.getPerPageSporters(page);

		if (list != null) {
			req.setAttribute("list", list);
			req.setAttribute("page", page);
			req.setAttribute("pageNum", pageNum);
			req.getRequestDispatcher("back/sporter/listSporter.jsp").forward(
					req, resp);
		}

	}

}
