package com.aodci.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aodci.bean.GameResult;
import com.aodci.bean.ScoreBoard;
import com.aodci.dao.GameResultDAO;
import com.aodci.db.MysqlDB;

/*
 * @qianhui
 * 比赛结果（GameResult）表的操作类
 */

public class GameResultDAOImpl implements GameResultDAO {

	// 数据库连接对象
	private Connection conn = null;
	// 数据库PrepareStatement对象
	private PreparedStatement ps = null;
	// 数据库结果集对象
	private ResultSet rs = null;
	// SQL语句
	private static String SELECT_ALL = "select * from a_gameresult order by leg";
	private static String SELECT_SINGLE = "select * from a_gameresult where id = ?";
	private static String SELECT_LEG = "select * from a_gameresult where leg = ? order by gametime";
	private static String DELETE_SINGLE = "delete from a_gameresult where id = ?";
	private static String UPDATE_SINGLE = "update a_gameresult set pname = ?,cname = ?,pgoal = ?"
			+ ",cgoal = ?,gametime = ?,field = ? where id = ?";

	private static String ADD_SQL = "insert into a_gameresult values (null,?,?,?,?,?,?,?,?)";

	@Override
	public List<GameResult> getAllGameResults() {
		// 存取取出來的GameResult表中数据
		List<GameResult> list = new ArrayList<GameResult>();
		conn = MysqlDB.getMysqlDB().getConnection();
		GameResult gr = null;
		try {
			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				gr = new GameResult();
				gr.setId(rs.getInt("id"));
				gr.setpName(rs.getString("pname"));
				gr.setcName(rs.getString("cname"));
				gr.setpGoal(rs.getInt("pgoal"));
				gr.setcGoal(rs.getInt("cgoal"));
				gr.setGameTime(rs.getString("gametime"));
				gr.setField(rs.getString("field"));
				gr.setLeg(rs.getInt("leg"));
				gr.setMsg(rs.getString("msg"));
				list.add(gr);
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
	public GameResult getSingeGameResult(int id) {
		conn = MysqlDB.getMysqlDB().getConnection();
		GameResult gr = new GameResult();
		try {
			ps = conn.prepareStatement(SELECT_SINGLE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				gr.setId(rs.getInt("id"));
				gr.setpName(rs.getString("pname"));
				gr.setcName(rs.getString("cname"));
				gr.setpGoal(rs.getInt("pgoal"));
				gr.setcGoal(rs.getInt("cgoal"));
				gr.setGameTime(rs.getString("gametime"));
				gr.setField(rs.getString("field"));
				gr.setLeg(rs.getInt("leg"));
				gr.setMsg(rs.getString("msg"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return gr;
	}

	@Override
	public void deleteGameResult(int id) {
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
	public void updateGameResult(GameResult gr) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(UPDATE_SINGLE);
			ps.setString(1, gr.getpName());
			ps.setString(2, gr.getcName());
			ps.setInt(3, gr.getpGoal());
			ps.setInt(4, gr.getcGoal());
			ps.setString(5, gr.getGameTime());
			ps.setString(6, gr.getField());
			ps.setInt(7, gr.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void addGameResult(GameResult gr) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(ADD_SQL);
			ps.setString(1, gr.getpName());
			ps.setString(2, gr.getcName());
			ps.setInt(3, gr.getpGoal());
			ps.setInt(4, gr.getcGoal());
			ps.setString(5, gr.getGameTime());
			ps.setString(6, gr.getField());
			ps.setInt(7, gr.getLeg());
			ps.setString(8, gr.getMsg());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public List<GameResult> getLegGameResults(int leg) {
		List<GameResult> list = new ArrayList<GameResult>();
		conn = MysqlDB.getMysqlDB().getConnection();
		GameResult gr = null;
		try {
			ps = conn.prepareStatement(SELECT_LEG);
			ps.setInt(1, leg);
			rs = ps.executeQuery();
			while (rs.next()) {
				gr = new GameResult();
				gr.setId(rs.getInt("id"));
				gr.setpName(rs.getString("pname"));
				gr.setcName(rs.getString("cname"));
				gr.setpGoal(rs.getInt("pgoal"));
				gr.setcGoal(rs.getInt("cgoal"));
				gr.setGameTime(rs.getString("gametime"));
				gr.setField(rs.getString("field"));
				gr.setLeg(rs.getInt("leg"));
				gr.setMsg(rs.getString("msg"));
				list.add(gr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return list;
	}

}
