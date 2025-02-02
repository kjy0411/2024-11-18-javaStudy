package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class ReviewDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
	private static ReviewDAO dao;
	// genie / melon
	public ReviewDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	public static ReviewDAO newInstance() {
		if(dao == null)
			dao = new ReviewDAO();
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
	
	public void ReviewInsert(ReviewVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO review(rno,no,up,down,star,content,regdate,id) "
					+ "VALUES(?,?,?,?,?,?,TO_DATE(?, 'YYYY-MM-dd'),?)";
//			private int rno, no, up, down;
//			private double star;
//			private String id, content;
//			private Date regdate;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getRno());
			ps.setInt(2, vo.getNo());
			ps.setInt(3, vo.getUp());
			ps.setInt(4, vo.getDown());
			ps.setDouble(5, vo.getStar());
			ps.setString(6, vo.getContent());
			ps.setString(7, vo.getStrRegdate());
			ps.setString(8, vo.getId());
			
			// ? 에 값을 채운다
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
}
