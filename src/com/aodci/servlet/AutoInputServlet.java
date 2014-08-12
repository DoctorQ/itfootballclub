package com.aodci.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.aodci.bean.Club;
import com.aodci.bean.GameResult;
import com.aodci.bean.Sporter;
import com.aodci.service.impl.ClubServiceImpl;
import com.aodci.service.impl.GameResultServiceImpl;
import com.aodci.service.impl.SporterServiceImpl;
import com.aodci.utils.StringUtils;

public class AutoInputServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String flag = (String) req.getParameter("flag");
		String keyword = (String) req.getParameter("keyword");
		try {
			if (flag.equals("pname")) {
				Club club = new ClubServiceImpl().getClub(keyword);
				String json = "['"+club.getHomeField()+"']";
				out.println(json);
			}
			if(flag.equals("sportname")){
				String json = new SporterServiceImpl().getSporterByCName(keyword);
				out.println(json);
			}
			if(flag.equals("score")){
				String json = null;
				StringUtils su = new StringUtils();
				String pname = req.getParameter("pname");
				String cname = req.getParameter("cname");
				System.out.println("主队:"+pname+",客队:"+cname+",进球信息"+keyword);
				int pn = su.getSubNumber(keyword, pname);
				int cn = su.getSubNumber(keyword, cname);
				json = "['"+pn+"','"+cn+"']";
				out.println(json);	
			}
			if(flag.equals("leg")){
				int leg = Integer.parseInt(keyword);
				List<GameResult> list = new GameResultServiceImpl().getLegGameResults(leg);
				if(list!=null){
					JSONArray json = JSONArray.fromObject(list);
					//System.out.println(json.toString());
					out.println(json.toString());
				}	
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}
