package com.sist.dao;

import java.sql.*;

public class Dept extends DataBase{
	//driverConfig(), gerConnection() => 그냥 사용가능, 필요시 수정가능
	//listPrint(), findPrint() => 반드시 오버라이딩
	@Override
	public void listPrint() {
		driverConfig();
		Connection conn = getConnection();
		try {
			//오라클 전송
			String sql = "SELECT * FROM dept";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(
					rs.getInt(1) + " " +
					rs.getString(2) + " " +
					rs.getString(3)
				);
			}
		} catch (Exception ex) {}
	}

	@Override
	public void findPrint() {
		
	}
	
}
