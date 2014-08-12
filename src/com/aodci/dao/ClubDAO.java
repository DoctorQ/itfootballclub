package com.aodci.dao;

import java.util.List;

import com.aodci.bean.Club;

public interface ClubDAO {
	// 取得所有俱乐部数据
	public List<Club> getAllClub();

	// 根据id取得单个俱乐部的详细信息
	public Club getSingeClub(int id);

	// 根据id删除俱乐部
	public void deleteClub(int id);
	
	//根据名称删除
	public void deleteClub(String cname);

	// 更新俱乐部信息
	public void updateClub(Club club);
	
	//添加一个俱乐部
	public void addClub(Club club);
	
	//通过name获取巨俱乐部
	public Club getClub(String cname);
	
	

}
