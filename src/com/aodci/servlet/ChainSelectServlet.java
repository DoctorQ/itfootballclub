package com.aodci.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Sporter;
import com.aodci.service.SporterService;
import com.aodci.service.impl.SporterServiceImpl;
import com.aodci.utils.Constant;

public class ChainSelectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SporterService sporterService = new SporterServiceImpl();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String keyword = (String) req.getParameter("keyword");
		String type = (String) req.getParameter("type");
		try {
			if (type.equals("top")) {
				String json = "['" + keyword + " " + Constant.bandA + "'," + "'" + keyword + " " + Constant.bandB + "']";
				out.println(json);
			}
			if (type.equals("sub")) {
				String json = sporterService.getSporterName(keyword);
				out.println(json);
			}
			if (type.endsWith("bot")) {
				String cname = (String) req.getParameter("cname");
				String band = (String) req.getParameter("band");
				Sporter sporter = new Sporter();
				sporter.setcName(cname);
				sporter.setBand(band.substring(band.length()-1));
				sporter.setName(keyword);
				Sporter sp = sporterService.getSporter(sporter);
				String json = "['" + sp.getId() + "','" + sp.getImage() + "']";
				out.println(json);

			}
		} finally {
			out.close();
		}
	}
}