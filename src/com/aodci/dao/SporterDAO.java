package com.aodci.dao;

import java.util.List;

import com.aodci.bean.Sporter;

public interface SporterDAO {
	// 取得所有球员信息
	public List<Sporter> getAllSporters();
	
	//根据页码取数据
	public List<Sporter> getPerPageSporters(int page);

	// 根据id取得某一个球员的信息
	public Sporter getSingleSporter(int id);

	// 根据id删除某一个球员的信息
	public void deleteSporter(int id);

	// 更新某一个球员的信息
	public void updateSporter(Sporter sporter);

	// 添加一个球员信息
	public void addSporter(Sporter sporter);
	
	//每页数据量
	public int num();
	
	//总页数
	public int pageNum();
	
	//查询球员信息
	public String getSporterName(String band);
	
	//得到球员的ID和imaname
	public Sporter getSporter(Sporter sporter);
	
	//根据俱乐部字段得到sporter
	public List<Sporter> getSporterByCName(String cname);
	
}
