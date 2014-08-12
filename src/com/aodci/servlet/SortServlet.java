package com.aodci.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.aodci.bean.ScoreBoard;
import com.aodci.service.ScoreBoardService;
import com.aodci.service.impl.ScoreBoardServiceImpl;

public class SortServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		ScoreBoardService sbsBoardService = new ScoreBoardServiceImpl();
		List<ScoreBoard> list = sbsBoardService.getScoreBoard();
		if (list != null) {
			session.setAttribute("list", list);
			System.out.println("out---------------------------------------------------------------------------");
			req.getRequestDispatcher("desk/club/clubhome.jsp").forward(req, resp);
		}
	}
}
