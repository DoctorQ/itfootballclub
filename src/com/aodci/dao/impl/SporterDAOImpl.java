package com.aodci.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aodci.bean.Sporter;
import com.aodci.dao.SporterDAO;
import com.aodci.db.MysqlDB;
import com.aodci.utils.StringUtils;

/*
 * @qianhui
 * 球员（sporter）表的操作类
 */
public class SporterDAOImpl implements SporterDAO {
	// 数据库连接对象
	private Connection conn = null;
	// 数据库PrepareStatement对象
	private PreparedStatement ps = null;
	// 数据库结果集对象
	private ResultSet rs = null;
	// SQL语句
	private static String SELECT_ALL = "select * from a_sporter";
	private static String SELECT_SINGLE = "select * from a_sporter where id = ?";
	private static String DELETE_SINGLE = "delete from a_sporter where id = ?";
	private static String UPDATE_SINGLE = "update a_sporter set cname = ?,born = ?"
			+ ",country = ?,sendclub = ? ,band = ?,number = ?,role=? where id = ?";
	private static String ADD_SQL = "insert into a_sporter values (null,?,?,?,?,?,?,?,?,?)";
	private static String NUM_SQL = "select count(*) as num from a_sporter";
	private static String PerPage_NUM = "select * from a_sporter limit ?,?";
	private static String SELECT_SPORTER = "select * from a_sporter where cname = ? and band = ?";
	private static String SELECT_ID = "select * from a_sporter where cname = ? and band = ? and name = ?";
	private static String SELECT_CNAME = "select * from a_sporter where cname = ? and band = 'A'";
	private static int perPage = 10;

	@Override
	public List<Sporter> getAllSporters() {
		List<Sporter> list = new ArrayList<Sporter>();
		conn = MysqlDB.getMysqlDB().getConnection();
		Sporter sporter = null;
		try {
			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				sporter = new Sporter();
				sporter.setName(rs.getString("name"));
				sporter.setcName(rs.getString("cname"));
				sporter.setBorn(rs.getString("born"));
				sporter.setCountry(rs.getString("country"));
				sporter.setSendClub(rs.getString("sendclub"));
				sporter.setBand(rs.getString("band"));
				sporter.setImage(rs.getString("imgname"));
				sporter.setNumber(rs.getInt("number"));
				sporter.setRole(rs.getString("role"));
				sporter.setId(rs.getInt("id"));
				list.add(sporter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public Sporter getSingleSporter(int id) {
		Sporter sporter = new Sporter();
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(SELECT_SINGLE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				sporter.setName(rs.getString("name"));
				sporter.setcName(rs.getString("cname"));
				sporter.setBorn(rs.getString("born"));
				sporter.setCountry(rs.getString("country"));
				sporter.setSendClub(rs.getString("sendclub"));
				sporter.setBand(rs.getString("band"));
				sporter.setImage(rs.getString("imgname"));
				sporter.setNumber(rs.getInt("number"));
				sporter.setRole(rs.getString("role"));
				sporter.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return sporter;
	}

	@Override
	public void deleteSporter(int id) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(DELETE_SINGLE);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void updateSporter(Sporter sporter) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(UPDATE_SINGLE);
			ps.setString(1, sporter.getcName());
			ps.setString(2, sporter.getBorn());
			ps.setString(3, sporter.getCountry());
			ps.setString(4, sporter.getSendClub());
			ps.setString(5, sporter.getBand());
			ps.setInt(6, sporter.getNumber());
			ps.setString(7, sporter.getRole());
			ps.setInt(8, sporter.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void addSporter(Sporter sporter) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(ADD_SQL);
			ps.setString(1, sporter.getName());
			ps.setString(2, sporter.getcName());
			ps.setString(3, sporter.getBorn());
			ps.setString(4, sporter.getCountry());
			ps.setString(5, sporter.getSendClub());
			ps.setString(6, sporter.getBand());
			ps.setString(7, sporter.getImage());
			ps.setInt(8, sporter.getNumber());
			ps.setString(9, sporter.getRole());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	public int num() {
		int num = 0;
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(NUM_SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	public int pageNum() {
		int pageNum = 0;
		int num = num();
		pageNum = (num + perPage - 1) / perPage;
		return pageNum;
	}

	@Override
	public List<Sporter> getPerPageSporters(int page) {
		List<Sporter> list = new ArrayList<Sporter>();
		conn = MysqlDB.getMysqlDB().getConnection();
		Sporter sporter = null;
		try {
			ps = conn.prepareStatement(PerPage_NUM);
			ps.setInt(1, (page - 1) * perPage);
			ps.setInt(2, page * perPage);
			rs = ps.executeQuery();
			while (rs.next()) {
				sporter = new Sporter();
				sporter.setName(rs.getString("name"));
				sporter.setcName(rs.getString("cname"));
				sporter.setBorn(rs.getString("born"));
				sporter.setCountry(rs.getString("country"));
				sporter.setSendClub(rs.getString("sendclub"));
				sporter.setNumber(rs.getInt("number"));
				sporter.setRole(rs.getString("role"));
				sporter.setId(rs.getInt("id"));
				list.add(sporter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public String getSporterName(String bandcname) {
		String json = null;
		StringBuilder sbBuilder = new StringBuilder();
		StringUtils sUtils = new StringUtils();
		sUtils.splitString(bandcname);
		String cname = sUtils.getCname();
		String band = sUtils.getBand();
		conn = MysqlDB.getMysqlDB().getConnection();
		sbBuilder.append("[");
		try {
			ps = conn.prepareStatement(SELECT_SPORTER);
			ps.setString(1, cname);
			ps.setString(2, band);
			rs = ps.executeQuery();
			while (rs.next()) {
				sbBuilder.append("'" + rs.getString("name") + "',");
			}
			if (sbBuilder.length() > 1)
				sbBuilder.deleteCharAt(sbBuilder.length() - 1);
			sbBuilder.append("]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		json = sbBuilder.toString();
		return json;
	}

	@Override
	public Sporter getSporter(Sporter sporter) {
		Sporter sb = new Sporter();
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(SELECT_ID);
			ps.setString(1, sporter.getcName());
			ps.setString(2, sporter.getBand());
			ps.setString(3, sporter.getName());
			rs = ps.executeQuery();
			while(rs.next()){
				sb.setId(rs.getInt("id"));
				sb.setImage(rs.getString("imgname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MysqlDB.close(conn, ps, rs);
		}
		return sb;
	}

	@Override
	public List<Sporter> getSporterByCName(String cname) {
		List<Sporter> list = new ArrayList<Sporter>();
		conn = MysqlDB.getMysqlDB().getConnection();
		Sporter sporter = null;
		try {
			ps = conn.prepareStatement(SELECT_CNAME);
			ps.setString(1, cname);
			rs = ps.executeQuery();
			while(rs.next()){
				sporter = new Sporter();
				sporter.setName(rs.getString("name"));
				list.add(sporter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MysqlDB.close(conn, ps, rs);
		}
		return list;
	}

}
