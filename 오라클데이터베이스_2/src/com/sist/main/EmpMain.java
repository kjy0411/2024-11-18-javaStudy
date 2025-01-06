package com.sist.main;
import java.util.*;
import java.sql.*;
public class EmpMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String ename = scan.next();
		
		//오라클 연결후 데이터 읽기 => 출력
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection conn = DriverManager.getConnection(url, "hr", "happy");
			String sql = "SELECT ename, job, sal, hiredate "
					+ "FROM emp "
//					+ "WHERE ename = UPPER('" + ename + "')";
//					+ "WHERE LOWER(ename) = '" + ename + "'";
					+ "WHERE ename = '" + ename.toUpperCase() + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println("이름 : " + rs.getString(1));
			System.out.println("직위 : " + rs.getString(2));
			System.out.println("급여 : " + rs.getInt(3));
			System.out.println("입사일 : " + rs.getDate(4));
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
