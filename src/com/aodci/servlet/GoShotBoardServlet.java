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

public class GoShotBoardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ShotBoard> shotBoards = new ShotBoardServiceImpl().getShotBoard();
		if(shotBoards!=null){
			req.setAttribute("shotBoards", shotBoards);
			req.getRequestDispatcher("desk/board/shotboard.jsp").forward(req, resp);
		}
	}

}
