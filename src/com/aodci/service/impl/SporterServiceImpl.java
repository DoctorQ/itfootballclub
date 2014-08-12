package com.aodci.service.impl;

import java.util.List;

import com.aodci.bean.Sporter;
import com.aodci.dao.SporterDAO;
import com.aodci.dao.impl.SporterDAOImpl;
import com.aodci.service.SporterService;

public class SporterServiceImpl implements SporterService {
	private SporterDAO sporterDAO = new SporterDAOImpl();

	@Override
	public List<Sporter> getAllSporters() {
		List<Sporter> list = sporterDAO.getAllSporters();
		return list;
	}

	@Override
	public Sporter getSingleSporter(int id) {
		Sporter sporter = sporterDAO.getSingleSporter(id);
		return sporter;
	}

	@Override
	public void deleteSporter(int id) {
		sporterDAO.deleteSporter(id);

	}

	@Override
	public void updateSporter(Sporter sporter) {
		sporterDAO.updateSporter(sporter);

	}

	@Override
	public void addSporter(Sporter sporter) {
		new SporterDAOImpl().addSporter(sporter);

	}

	@Override
	public List<Sporter> getPerPageSporters(int page) {
		List<Sporter> list = sporterDAO.getPerPageSporters(page);
		return list;
	}

	@Override
	public int num() {
		int num = sporterDAO.num();
		return num;
	}

	@Override
	public int pageNum() {
		int pageNum = sporterDAO.pageNum();
		return pageNum;
	}

	@Override
	public String getSporterName(String band) {
		String json = sporterDAO.getSporterName(band);
		return json;
	}

	@Override
	public Sporter getSporter(Sporter sporter) {
		Sporter sp = sporterDAO.getSporter(sporter);
		return sp;
	}

	@Override
	public String getSporterByCName(String cname) {
		String json = null;
		StringBuilder sbBuilder = new StringBuilder();
		List<Sporter> list = sporterDAO.getSporterByCName(cname);
		sbBuilder.append("[");
		for(int i = 0;i<list.size();i++){
			sbBuilder.append("'" + list.get(i).getName() + "',");
		}
		if (sbBuilder.length() > 1)
			sbBuilder.deleteCharAt(sbBuilder.length() - 1);
		sbBuilder.append("]");
		json = sbBuilder.toString();
		return json;
	}
	
	
}
