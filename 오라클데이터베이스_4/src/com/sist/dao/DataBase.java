package com.sist.dao;
import java.util.*;
import java.sql.*;
public class DataBase {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public DataBase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {}
		
		return conn;
	}
	public void disConnection(Connection conn, PreparedStatement ps) {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
}
