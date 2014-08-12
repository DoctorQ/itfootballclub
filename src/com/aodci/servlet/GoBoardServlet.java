package com.aodci.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.ScoreBoard;
import com.aodci.bean.ShotBoard;
import com.aodci.service.impl.ScoreBoardServiceImpl;
import com.aodci.service.impl.ShotBoardServiceImpl;

public class GoBoardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ScoreBoard> sbs = new ScoreBoardServiceImpl().getScoreBoard();
		List<ShotBoard> shotBoards = new ShotBoardServiceImpl().getShotBoard();
		
		if(sbs!=null&&shotBoards!=null){
			req.setAttribute("sbs", sbs);
			req.setAttribute("shotBoards", shotBoards);
			req.getRequestDispatcher("desk/board/board.jsp").forward(req, resp);
		}
	}

}
