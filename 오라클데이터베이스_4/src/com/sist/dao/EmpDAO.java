package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
/*  
 *  오라클 / 자바 / 자바스크립트 / HTML / CSS
 *  -----------------------------------
 *    |		|		|		----------- <iframe>, ThymeLeaf
 *    |		|		|
 *    |		|	function
 *    |	Class / Method
 *  PROCEDURE
 *  => 반복 : 반복 제거
 *  
 */
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private DataBase db = new DataBase();
	private static EmpDAO dao;
	
	// 싱글턴
	public static EmpDAO newInstance() {
		if(dao == null)
			dao = new EmpDAO();
		return dao;
	}
	
	// 기능 => 전체 목록 출력
	public List<EmpVO> empListData(){
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = db.getConnection();
			String sql = "SELECT empno, ename, job, hiredate, dname, loc "
					+ "FROM emp JOIN dept "
					+ "ON emp.deptno = dept.deptno";
			// 오라클에서 실행 => 실행되는 SQL
			// => 자바에서 SQL문장 오류를 감지할 수 없다 => 오류를 처리하기 어렵다 (문자열)
			/*  
			 *  SELECT empno, ename, job, hiredate, dname, loc
			 *  FROM emp NATURE JOIN dept
			 *  
			 *  SELECT empno, ename, job, hiredate, dname, loc
			 *  FROM emp JOIN dept USING(deptno)
			 */
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.disConnection(conn, ps);
		}
		return list;
	}
	// 상세보기 => EmpVO(사원 한명에 대한 모든 정보를 저장)
	// ------ 무조건 중복이 없는 데이터를 전송
	// 게시물번호 / 사번 / 영화번호 ...
	// 문자열 => ID => 회원가입 (아이디중복 / 우편번호)
	public EmpVO empDetailData(int empno) {
		EmpVO vo = new EmpVO();
		try {
			conn = db.getConnection();
			String sql = "SELECT e1.empno, e1.ename, e1.job, NVL(e2.ename, '없음'), e1.hiredate, e1.sal, e1.comm, dname, loc, grade "
					+ "FROM emp e1, emp e2, dept, salgrade "
					+ "WHERE e1.mgr = e2.empno(+) "
					+ "AND e1.deptno = dept.deptno "
					+ "AND e1.sal BETWEEN losal AND hisal "
					+ "AND e1.empno = " + empno;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setMname(rs.getString(4));
			vo.setHiredate(rs.getDate(5));
			vo.setSal(rs.getInt(6));
			vo.setComm(rs.getInt(7));
			vo.getDvo().setDname(rs.getString(8));
			vo.getDvo().setLoc(rs.getString(9));
			vo.getSvo().setGrade(rs.getInt(10));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.disConnection(conn, ps);
		}
		return vo;
	}
	// 검색 => 조인
	//이름 / 입사일 / 직위 / 부서명 / 근무지
	public List<EmpVO> empFindData(String col, String fd){
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. 연결
			conn = db.getConnection();
			// 2. sql문장
			String sql = "SELECT empno, ename, job, hiredate, dname, loc "
					+ "FROM emp, dept "
					+ "WHERE emp.deptno = dept.deptno "
					+ "AND " + col + " LIKE '%'||?||'%'";
			// 무조건 => 조건이 있는 경우 AND
			// ? => setString(1,fd) => ''
			ps = conn.prepareStatement(sql);
			// 실행 요청전에 ?값을 채운다
			ps.setString(1, fd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.disConnection(conn, ps);
		}
		return list;
	}
}
