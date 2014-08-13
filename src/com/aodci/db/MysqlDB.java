package com.aodci.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * aodci
 * @author qianhui
 *
 */

public class MysqlDB {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/aodci";
	private static final String DBUSER = "root";
	private static final String DBPASSWROD = "";
	private static MysqlDB mysqlDB = null;
	Connection conn = null;
	/*
	 * 加载mysql的驱动
	 */
	private MysqlDB() {
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/* 利用单例模式
	 * 取得mysql的实例
	 */
	public static MysqlDB getMysqlDB() {
		if (mysqlDB == null) {
			mysqlDB = new MysqlDB();
		}
		return mysqlDB;
	}
	/*
	 * 得到connection
	 */
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWROD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/*
	 * 关闭connection,preparestatement,resultset
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
