package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

import oracle.net.aso.f;
public class FreeBoardDAO {
	// 오라클 연결 객체
	private Connection conn;
	// 오라클 송수신 담당(송신(SQL문장)/수신(실행 결과값))
	private PreparedStatement ps;
	// 오라클 주소
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// 객체를 한번만 생성해서 재사용 (메모리 절약)
	// Connection객체수를 조절 => 50명
	// 싱글턴
	private static FreeBoardDAO dao;
	
	// => 1. 드라이버 등록
	public FreeBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	// => 2. 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 윈도우/명령프롬프트/웹/react/vue ... 상관없이
	// ---------------- 오라클에 직접 연동이 안된다 <==> 자바를 경유해 연결
	// => 3. 오라클 해제
	public void disConnection() {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	// => 4. 싱글턴
	// ================================= 필수조건
	/*
	 * Back-END : DB연동, AI
	 */
	public static FreeBoardDAO newInstance() {
		if(dao == null)
			dao = new FreeBoardDAO();
		return dao;
	}
	//  기능
	//  1. 목록 (페이징 기법) => 인라인뷰 사용
	public List<FreeBoardVO> boardListDate(int page){
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		try {
			// 1. 오라클 연결
			getConnection();
			// 2.SQL문장 제작
			String sql = "SELECT no, subject, name, regdate, hit, num "
					+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
					+ "FROM (SELECT no, subject, name, regdate, hit "
					+ "FROM freeboard ORDER BY no DESC)) "
					+ "WHERE num BETWEEN ? AND ?";
			// 페이지 나누는 방법 => 인라인뷰 => rownum
			// => rownum은 중간에 자를 수 없다
			ps = conn.prepareStatement(sql);
			int rowSize = 10;
			int start = (rowSize * page) - (rowSize - 1);
			// 1page => 1~, 2page 11~ ...
			// rownum은 1부터 시작한다
			int end = rowSize * page;
			// 1page => ~10, 2page ~20 ...
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				FreeBoardVO vo = new FreeBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			//에러 처리 => 확인
			e.printStackTrace();
		} finally {
			//오라클 닫기
			disConnection();
		}
		return list;
	}
	//  1-1. 총페이지 구하기
	public int boardTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/10.0) FROM freeboard";
			// 총페이지 구하기		 -------------------
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return total;
	}
	//  2. 상세보기 => WHERE => Primary Key값을 넘겨준다
	//	 게시물 번호 => 자동 증가
	public FreeBoardVO boardDetailData(int no) {
		FreeBoardVO vo = new FreeBoardVO();
		try {
			// 한개의 기능 수행시 => SQL문장 여러개를 한번에 처리가능
			// 서브쿼리는 SELECT
			// 연결
			getConnection();
			String sql = "UPDATE freeboard SET "
					+ "hit = hit+1 "
					+ "WHERE no = " + no;
			ps = conn.prepareStatement(sql);
			// 실행 명령
			ps.executeUpdate();
			/*  
			 *  escuteQuery() => 데이터 검색 (SELECT)
			 *  escuteUpdate() => 데이터 변경 (INSERT / UPDATE / DELETE)
			 *  ------------------------------------------------------- commit()
			 *  ----- 자바 AutoCommit()
			 */
			sql = "SELECT no, name, subject, content, regdate, hit "
					+ "FROM freeboard "
					+ "WHERE no =" + no;
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();// 한번만 수행
			// 값을 채운다
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return vo;
	}
	//  3. 글쓰기 => INSERT
	public void boardInsert(FreeBoardVO vo) {
		// 리턴형 / 매개변수
		try {
			getConnection();
			String sql = "INSERT INTO freeboard(no, name, subject, content, pwd) "
					+ "VALUES(fb_no_seq.nextval, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			// 실행 요청
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
	//  4. 수정하기 => UPDATE => 비밀번호 검사
	//  4-1 수정 데이터 읽기 (이전)
	public FreeBoardVO boardUpdateData(int no) {
		// 한개의 게시물 읽기 / 맛집 / 상품 / 영화 => PRIMARY KEY
		FreeBoardVO vo = new FreeBoardVO();
		// vo는 게시판 한개에 대한 모든 데이터를 가지고 온다
		// 한개 찾기 => VO => 중복 없는 데이터
		// 여러개 찾기 (검색) => List<VO> => 검색어 => LIKE
		try {
			getConnection();
			String sql = "SELECT no, name, subject, content FROM freeboard WHERE no = " + no;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return vo;
	}
	//  4-2 실제 수정
	public boolean boardUpdate(FreeBoardVO vo) {
		boolean bCheck = false;
		try {
			// 1. 연결
			getConnection();
			// 2. SQL => 비밀번호 읽기
			String sql = "SELECT pwd FROM freeboard WHERE no = " + vo.getNo();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd())) {
				bCheck = true;
				sql = "UPDATE freeboard SET "
						+ "name = ?, subject = ?, content = ? "
//						+ "name = '" + vo.getName() + "', subject = '" + vo.getSubject() + "', content = '" + vo.getContent()
						+ "WHERE no = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				
				// 실행
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return bCheck;
	}
	//  5. 삭제하기 => DELETE => 비밀번호 검사
	public boolean boardDelete(int no, String pwd) {
		boolean bCheck = false;
		try {
			// 1. 연결
			getConnection();
			String sql = "SELECT pwd FROM freeboard WHERE no = " + no;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();

			if(db_pwd.equals(pwd)) {
				bCheck = true;
				sql = "DELETE FROM freeboard WHERE no = " + no;
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return bCheck;
	}
	//  6. 찾기 => LIKE 문장 사용
	public List<FreeBoardVO> boardFindData(String col, String fd){
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		try {
			getConnection();
			String sql = "SELECT no, subject, name, regdate, hit "
					+ "FROM freeboard "
					+ "WHERE " + col + " LIKE '%'||?||'%'";
			//									'%홍길동%'
			// ? => setString(1, '홍길동')
			//		--------- '홍길동'
			ps = conn.prepareStatement(sql);
			ps.setString(1, fd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				FreeBoardVO vo = new FreeBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
	// 6-1
	public int boardFindCount(String col, String fd) {
		int count = 0;
		try {
			getConnection();
			String sql = "SELECT COUNT(*) "
					+ "FROM freeboard "
					+ "WHERE " + col + " LIKE '%'||?||'%'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, fd);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return count;
	}
	//  ----------------------------------- CRUD
	
	
}
