package com.aodci.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aodci.bean.Sporter;
import com.aodci.service.impl.SporterServiceImpl;

public class UpdateSporterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Sporter sporter = new Sporter();
		int id = Integer.parseInt(req.getParameter("sporterid"));
		String cname = new String(req.getParameter("clubname").getBytes("iso8859-1"));
		String born = new String(req.getParameter("sporterborn").getBytes("iso8859-1"));
		String country = new String(req.getParameter("sportercountry").getBytes("iso8859-1"));
		String sendclub = new String(req.getParameter("sportersendclub").getBytes("iso8859-1"));
		String band = new String(req.getParameter("sporterband").getBytes("iso8859-1"));
		int number = Integer.parseInt(req.getParameter("sporternumber"));
		String role = new String(req.getParameter("sporterrole").getBytes("iso8859-1"));

		sporter.setId(id);
		sporter.setcName(cname);
		sporter.setBorn(born);
		sporter.setCountry(country);
		sporter.setSendClub(sendclub);
		sporter.setBand(band);
		sporter.setNumber(number);
		sporter.setRole(role);
		System.out.println("UpdateSporterServlet:" + sporter.toString());
		new SporterServiceImpl().updateSporter(sporter);
		req.getRequestDispatcher("listSporter").forward(req, resp);

	}

}
