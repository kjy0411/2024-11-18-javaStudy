package com.sist.main;
import java.util.*;
import java.io.*;
import java.sql.*;
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String driver, url, username, password;
	
	public EmpDAO() {
		// properties 파일 읽기
		
		try {
			// 키 = 값 ==> MAP형식
			// 키가 중복되면 안된다
			// 보안용 => 서버주소 / 데이터베이스 주소...
			// MyBatis / Spring => 자동 처리
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:\\javaDev\\javaStudy\\Chapter11_IO라이브러리_5\\src\\com\\sist\\main\\db.properties"));
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			// 보안용 => 데이터베이스, 네트워크서버
			// 드라이버 설치
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 연결
	// => 위탁
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {}
	}
	public void disConnection() {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	public List<Emp> empListData() {
		List<Emp> list = new ArrayList<Emp>();
		try {
			getConnection();
			String sql = "SELECT empno,ename,job FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				list.add(emp);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
}
