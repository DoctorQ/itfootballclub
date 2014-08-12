package com.aodci.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.map.StaticBucketMap;

import com.aodci.bean.ScoreBoard;
import com.aodci.dao.ScoreBoardDAO;
import com.aodci.db.MysqlDB;

/*
 * @qianhui
 * 积分（ScoreBoard）表操作类
 */
public class ScoreBoardDAOImpl implements ScoreBoardDAO {
	// 数据库连接对象
	private Connection conn = null;
	// 数据库PrepareStatement对象
	private PreparedStatement ps = null;
	// 数据库结果集对象
	private ResultSet rs = null;
	// SQL语句
	private static String SELECT_ALL = "select * from a_scoreboard order by score desc";
	private static String SELECT_SINGLE = "select * from a_scoreboard where id = ?";
	private static String SELECT_NAME = "select * from a_scoreboard where name = ?";
	private static String DELETE_SINGLE = "delete from a_scoreboard where id = ?";
	private static String DELETE_SQL = "delete from a_scoreboard where name = ?";
	private static String UPDATE_SINGLE = "update a_scoreboard set win = win+?,faith = faith+?,tie = tie+?" + ",score = score+?,gain = gain+?,lose = lose+? where name = ?";
	private static String ADD_SQL = "insert into a_scoreboard values (null,?,?,?,?,?,?,?,?)";

	/*
	 * 该方法取得数据库表a_scoreboard中所有顺序，并且按score排序
	 */
	@Override
	public List<ScoreBoard> getScoreBoard() {// 存取取出來的scoreboard表中数据
		List<ScoreBoard> list = new ArrayList<ScoreBoard>();
		conn = MysqlDB.getMysqlDB().getConnection();
		ScoreBoard sb = null;
		try {
			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				sb = new ScoreBoard();
				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setWin(rs.getInt("win"));
				sb.setFaith(rs.getInt("faith"));
				sb.setTie(rs.getInt("tie"));
				sb.setScore(rs.getInt("score"));
				sb.setGain(rs.getInt("gain"));
				sb.setLose(rs.getInt("lose"));
				sb.setImageUrl(rs.getString("imageurl"));
				list.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public ScoreBoard getSingleScoreBoard(int id) {
		conn = MysqlDB.getMysqlDB().getConnection();
		ScoreBoard sb = null;
		try {
			ps = conn.prepareStatement(SELECT_SINGLE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				sb = new ScoreBoard();
				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setWin(rs.getInt("win"));
				sb.setFaith(rs.getInt("faith"));
				sb.setTie(rs.getInt("tie"));
				sb.setScore(rs.getInt("score"));
				sb.setGain(rs.getInt("gain"));
				sb.setLose(rs.getInt("lose"));
				sb.setImageUrl(rs.getString("imageurl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return sb;
	}

	@Override
	public void deleteScoreBoard(int id) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(DELETE_SINGLE);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void updateScoreBoard(ScoreBoard sb) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(UPDATE_SINGLE);
			ps.setInt(1, sb.getWin());
			ps.setInt(2, sb.getFaith());
			ps.setInt(3, sb.getTie());
			ps.setInt(4, sb.getScore());
			ps.setInt(5, sb.getGain());
			ps.setInt(6, sb.getLose());
			ps.setString(7, sb.getName());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void addScoreBoard(ScoreBoard sb) {
//		System.out.println("ScoreBoardDAOImpl->addScoreBoard");
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(ADD_SQL);
			ps.setString(1, sb.getName());
			ps.setInt(2, sb.getWin());
			ps.setInt(3, sb.getFaith());
			ps.setInt(4, sb.getTie());
			ps.setInt(5, sb.getScore());
			ps.setInt(6, sb.getGain());
			ps.setInt(7, sb.getLose());
			ps.setString(8, sb.getImageUrl());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void deleteScoreBoard(String cname) {
		// TODO Auto-generated method stub
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(DELETE_SQL);
			ps.setString(1, cname);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
	}

	@Override
	public ScoreBoard getSingleScoreBoard(String name) {
		conn = MysqlDB.getMysqlDB().getConnection();
		ScoreBoard sb = null;
		try {
			ps = conn.prepareStatement(SELECT_NAME);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				sb = new ScoreBoard();
				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setWin(rs.getInt("win"));
				sb.setFaith(rs.getInt("faith"));
				sb.setTie(rs.getInt("tie"));
				sb.setScore(rs.getInt("score"));
				sb.setGain(rs.getInt("gain"));
				sb.setLose(rs.getInt("lose"));
				sb.setImageUrl(rs.getString("imageurl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return sb;
	}

}
