package com.sist.dao;
import java.util.*;
import java.sql.*;
public class MusicDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static MusicDAO dao;
	// genie / melon
	public MusicDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	public static MusicDAO newInstance() {
		if(dao == null)
			dao = new MusicDAO();
		return dao;
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {}
	}
	public void disConnection() {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	// 크롤링 데이터 추가
	public void genieMusicInsert(MusicVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO genie_music "
						+ "VALUES((SELECT NVL(MAX(mno)+1,1) FROM genie_music),"
						+ "?, ?, ?, ?, ?, ?, ?, ?, 0)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getCno());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getSinger());
			ps.setString(4, vo.getAlbum());
			ps.setString(5, vo.getPostre());
			ps.setInt(6, vo.getIdcrement());
			ps.setString(7, vo.getState());
			ps.setString(8, vo.getKey());
			// youtube => 2번
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
}
