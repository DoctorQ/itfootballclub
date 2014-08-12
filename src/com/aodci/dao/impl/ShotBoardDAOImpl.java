package com.aodci.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aodci.bean.ShotBoard;
import com.aodci.dao.ShotBoardDAO;
import com.aodci.db.MysqlDB;

/*
 * @qianhui
 * 射手榜（ShotBoard）表的操作类
 */
public class ShotBoardDAOImpl implements ShotBoardDAO {
	// 数据库连接对象
	private Connection conn = null;
	// 数据库PrepareStatement对象
	private PreparedStatement ps = null;
	// 数据库结果集对象
	private ResultSet rs = null;
	// SQL语句
	private static String SELECT_ALL = "select * from a_shotboard order by goals desc";
	private static String SELECT_SINGLE = "select * from a_shotboard where id = ?";
	private static String DELETE_SINGLE = "delete from a_shotboard where id = ?";
	private static String UPDATE_SINGLE = "update a_shotboard set name =  ?,cname = ?,goals = goals+?"
			+ " where id = ?";
	private static String UPDATE_ADD = "insert into a_shotboard values (null,?,?,?,?) ON DUPLICATE KEY UPDATE goals=goals+?";
	private static String ADD_SQL = "insert into a_shotboard values (null,?,?,?,?) ON DUPLICATE KEY UPDATE goals=goals+?";

	@Override
	public List<ShotBoard> getShotBoard() {
		List<ShotBoard> list = new ArrayList<ShotBoard>();
		ShotBoard sb = null;
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				sb = new ShotBoard();
				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setCname(rs.getString("cname"));
				sb.setGoals(rs.getInt("goals"));
				sb.setCc(rs.getString("cc"));
				list.add(sb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MysqlDB.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public ShotBoard getSingleShotBoard(int id) {
		ShotBoard sb = new ShotBoard();
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(SELECT_SINGLE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setCname(rs.getString("cname"));
				sb.setGoals(rs.getInt("goals"));
				sb.setCc(rs.getString("cc"));
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
	public void deleteShotBoard(int id) {
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
	public void updateShotBoard(ShotBoard sb) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(UPDATE_SINGLE);
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getCname());
			ps.setInt(3, sb.getGoals());
			ps.setInt(4, sb.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void insertShotBoard(ShotBoard sb) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(ADD_SQL);
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getCname());
			ps.setInt(3, sb.getGoals());
			ps.setString(4, sb.getCc());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void updateAndAdd(ShotBoard sb) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(UPDATE_ADD);
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getCname());
			ps.setInt(3, sb.getGoals());
			ps.setString(4, sb.getCc());
			ps.setInt(5, sb.getGoals());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		
	}

}
