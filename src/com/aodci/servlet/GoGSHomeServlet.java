package com.aodci.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.GameResult;
import com.aodci.service.impl.GameResultServiceImpl;

public class GoGSHomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int leg = 1;
		List<GameResult> list = new GameResultServiceImpl().getLegGameResults(leg);
		if(list!=null){
			req.setAttribute("list", list);
			req.getRequestDispatcher("desk/gameresult/listGameResult.jsp").forward(req, resp);
		}
	}
}
