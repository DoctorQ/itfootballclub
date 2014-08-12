package com.aodci.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.GameResult;
import com.aodci.bean.ScoreBoard;
import com.aodci.bean.ShotBoard;
import com.aodci.service.GameResultService;
import com.aodci.service.ScoreBoardService;
import com.aodci.service.ShotBoardService;
import com.aodci.service.impl.GameResultServiceImpl;
import com.aodci.service.impl.ScoreBoardServiceImpl;
import com.aodci.service.impl.ShotBoardServiceImpl;
import com.aodci.utils.StringUtils;

public class AddGameResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GameResultService gService = new GameResultServiceImpl();
		ScoreBoardService sService = new ScoreBoardServiceImpl();
		ShotBoardService sBoardService = new ShotBoardServiceImpl();
		ScoreBoard pClub = new ScoreBoard();
		ScoreBoard cClub = new ScoreBoard();
		GameResult gameResult = new GameResult();
		//System.out.println("AddGameResultServlet");
		String pname = new String(req.getParameter("pname").getBytes("iso8859-1"));
		String cname = new String(req.getParameter("cname").getBytes("iso8859-1"));
		int pgoal = Integer.parseInt(req.getParameter("pgoal"));
		int cgoal = Integer.parseInt(req.getParameter("cgoal"));
		String field = new String(req.getParameter("field").getBytes("iso8859-1"));
		int leg = Integer.parseInt(req.getParameter("leg"));
		String msg = new String(req.getParameter("msg").getBytes("iso8859-1"));
		String gametime = new String(req.getParameter("gametime").getBytes("iso8859-1"));
		//GameResult赋值
		gameResult.setpName(pname);
		gameResult.setcName(cname);
		gameResult.setpGoal(pgoal);
		gameResult.setcGoal(cgoal);
		gameResult.setLeg(leg);
		gameResult.setMsg(msg);
		gameResult.setGameTime(gametime);
		gameResult.setField(field);
		//ScoreBoard赋值
		pClub.setName(pname);
		cClub.setName(cname);
		pClub.setGain(pgoal);
		cClub.setGain(cgoal);
		pClub.setLose(cgoal);
		cClub.setLose(pgoal);
		if(pgoal > cgoal) {
			pClub.setWin(1);
			cClub.setFaith(1);
			pClub.setScore(3);
		}else if(pgoal == cgoal){
			pClub.setTie(1);
			cClub.setTie(1);
			pClub.setScore(1);
			pClub.setScore(1);
		}else{
			cClub.setWin(1);
			pClub.setFaith(1);
			cClub.setScore(3);
		}
		//System.out.println("AddGameResultServlet:"+gameResult.toString());
		gService.addGameResult(gameResult);
		sService.updateScoreBoard(pClub);
		sService.updateScoreBoard(cClub);
		if(pgoal!=0||cgoal!=0){
			List<ShotBoard> shotboards = new StringUtils().getShotBoardFromMsg(msg);
			for(ShotBoard sbi:shotboards){
				sBoardService.updateAndAdd(sbi);
			}
		}
		req.getRequestDispatcher("goAddGameResult").forward(req, resp);
	}

}
