package com.aodci.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aodci.bean.Club;
import com.aodci.dao.ClubDAO;
import com.aodci.db.MysqlDB;

/*
 * @qianhui
 * 俱乐部（club）表的操作类
 */
public class ClubDAOImpl implements ClubDAO {
	// 存取取出來的scoreboard表中数据
	private List<Club> list = new ArrayList<Club>();
	// 数据库连接对象
	private Connection conn = null;
	// 数据库PrepareStatement对象
	private PreparedStatement ps = null;
	// 数据库结果集对象
	private ResultSet rs = null;
	// SQL语句
	private static String SELECT_ALL = "select * from a_club";
	private static String SELECT_SINGLE = "select * from a_club where id = ?";
	private static String SELECT_SINGLE_NAME = "select * from a_club where cname = ?";
	private static String DELETE_SINGLE = "delete from a_club where id = ?";
	private static String DELETE_CNAME = "delete from a_club where cname = ?";
	private static String UPDATE_SINGLE = "update a_club set ctime = ?,homefield = ?,coach = ?,location = ?"
			+ ",builder = ? where id = ?";
	private static String GET_ONE = "select * from a_club where cname = ?";
	private static String INSERT_SINGLE = "insert into a_club values (null,?,?,?,?,?,?,?)";

	@Override
	public List<Club> getAllClub() {
		conn = MysqlDB.getMysqlDB().getConnection();
		Club club = null;
		try {
			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				club = new Club();
				club.setId(rs.getInt("id"));
				club.setcName(rs.getString("cname"));
				club.setCoach(rs.getString("coach"));
				club.setHomeField(rs.getString("homefield"));
				club.setcTime(rs.getString("ctime"));
				club.setLocation(rs.getString("location"));
				club.setImgurl(rs.getString("imgurl"));
				club.setBuilder(rs.getString("builder"));
				list.add(club);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public Club getSingeClub(int id) {
		Club club = null;
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(SELECT_SINGLE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				club = new Club();
				club.setId(rs.getInt("id"));
				club.setcName(rs.getString("cname"));
				club.setCoach(rs.getString("coach"));
				club.setcTime(rs.getString("ctime"));
				club.setHomeField(rs.getString("homefield"));
				club.setImgurl(rs.getString("imgurl"));
				club.setBuilder(rs.getString("builder"));
				club.setLocation(rs.getString("location"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
		return club;
	}
	@Override
	public void deleteClub(int id) {
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
	public void updateClub(Club club) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(UPDATE_SINGLE);
			ps.setString(1, club.getcTime());
			ps.setString(2, club.getHomeField());
			ps.setString(3, club.getCoach());
			ps.setString(4, club.getLocation());
			ps.setString(5, club.getBuilder());
			ps.setInt(6, club.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}

	}

	@Override
	public void addClub(Club club) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(INSERT_SINGLE);
			ps.setString(1, club.getcName());
			ps.setString(2, club.getcTime());
			ps.setString(3, club.getHomeField());
			ps.setString(4, club.getCoach());
			ps.setString(5, club.getBuilder());
			ps.setString(6, club.getImgurl());
			ps.setString(7, club.getLocation());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
	}

	@Override
	public void deleteClub(String cname) {
		conn = MysqlDB.getMysqlDB().getConnection();
		try {
			ps = conn.prepareStatement(DELETE_CNAME);
			ps.setString(1,cname );
			ps.execute();
			System.out.println("刪除成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDB.close(conn, ps, rs);
		}
	}

	@Override
	public Club getClub(String cname) {
		conn = MysqlDB.getMysqlDB().getConnection();
		Club club = new Club();
		try {
			ps = conn.prepareStatement(GET_ONE);
			ps.setString(1, cname);
			rs = ps.executeQuery();
			while(rs.next()){
				club.setId(rs.getInt("id"));
				club.setcName(rs.getString("cname"));
				club.setCoach(rs.getString("coach"));
				club.setcTime(rs.getString("ctime"));
				club.setHomeField(rs.getString("homefield"));
				club.setImgurl(rs.getString("imgurl"));
				club.setBuilder(rs.getString("builder"));
				club.setLocation(rs.getString("location"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			MysqlDB.close(conn, ps, rs);
		}
		return club;
	}
	

}
