package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
	private static MemberDAO dao;
	// genie / melon
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	public static MemberDAO newInstance() {
		if(dao == null)
			dao = new MemberDAO();
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
	public void MemberInsert(MemberVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO member(id,nickname,pw,name,gender,email,address1,phone, birth) "
					+ "VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
			// no genre title poster author story avgstar serial iscp
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getNickname());
			ps.setString(3, vo.getPw());
			ps.setString(4, vo.getName());
			ps.setString(5, vo.getGender());
			ps.setString(6, vo.getEmail());
			ps.setString(7, vo.getAddress1());
			ps.setString(8, vo.getPhone());
			
			// ? 에 값을 채운다
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
}
