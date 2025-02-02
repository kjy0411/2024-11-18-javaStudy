package com.sist.dao;
import java.util.*;
import java.sql.*;

public class NovelDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
	private static NovelDAO dao;
	// genie / melon
	public NovelDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	public static NovelDAO newInstance() {
		if(dao == null)
			dao = new NovelDAO();
		return dao;
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr_4", "happy");
		} catch (Exception e) {}
	}
	public void disConnection() {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	
	public void novelInsert(NovelVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO novel "
					+ "VALUES(?,?,?,?,?,?,round(?, 2),?,?)";
			// no genre title poster author story avgstar serial iscp
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ps.setString(2, vo.getGenre());
			ps.setString(3, vo.getTitle());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getAuthor());
			ps.setString(6, vo.getStory());
			ps.setDouble(7, vo.getAvgstar());
			ps.setString(8, vo.getSerial());
			ps.setString(9, vo.getIscp());
			
			// ? 에 값을 채운다
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
}
