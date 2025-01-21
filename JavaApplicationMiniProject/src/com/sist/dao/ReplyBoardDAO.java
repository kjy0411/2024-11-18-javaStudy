package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
public class ReplyBoardDAO {
	// 연결 => 오라클
	private Connection conn;
	// 송수신 => SQL문장 전송, 결과값 받기
	private PreparedStatement ps;
	// 메모리 절약 / Connection 객체 생성 조절
	private static ReplyBoardDAO dao;
	// 오라클 연결 주소
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	//드라이버 등록 => 한번만 사용
	public ReplyBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//리플렉션 => 클래스 이름으로 메모리 할당 / 메소드 제어
			// new 역할 => 메소드명을 모르는 경우에도 호출 가능
		} catch (Exception e) {}
	}
	//싱글턴
	public static ReplyBoardDAO newInstance() {
		if(dao == null)
			dao = new ReplyBoardDAO();
		return dao;
	}
	//연결
	public void getConection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {}
	}
	//닫기
	public void disConection() {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	/////////////////////////////////// 자바에서 오라클 연동 기본 (공통)
	/////////////////////////////////// --------------- JDBC
	//JDBC 원시소스 => DBCP => ORM (MyBatis,Hibernate => JPA)
	// 기능
	// 1. 목록 출력 => 인라인뷰 => 1페이지에 10개
	// => 최신순
	// => INDEX사용 X => 추가, 수정, 삭제가 많은경우에는 INDEX 속도가 저하 => ORDEY BY를 이용
	public List<ReplyBoardVO> boardLististDate(int page){
		List<ReplyBoardVO> list = new ArrayList<ReplyBoardVO>();
		try {
			// 연결
			getConection();
			String sql = "SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD'), hit, group_tab, num  "
					+ "FROM (SELECT no, subject, name, regdate, hit, group_tab, rownum as num "
					+ "FROM (SELECT no, subject, name, regdate, hit, group_tab "
					+ "FROM replyBoard ORDER BY group_id DESC, group_step ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			int rowSize = 10;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			//실행 요청
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ReplyBoardVO vo = new ReplyBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setGroup_tab(rs.getInt(6));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// 오류 확인
			e.printStackTrace();
		} finally {
			// 연결 해제
			disConection();
		}
		return list;
	}
	// 1-1. 총페이지
	public int boardRowPage() {
		int total = 0;
		try {
			getConection();
			String sql = "SELECT COUNT(*) FROM replyBoard";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConection();
		}
		return total;
	}
	// 2. 글쓰기 => INSERT
	// 매개변수가 3개 이상 => 배열 / VO를 이용한다
	public void boardInsert(ReplyBoardVO vo) {
		try {
			getConection();
			// 새로운 그룹 생성 => 그룹번호 : group_id
			String sql = "INSERT INTO replyBoard(no, name, subject, content, pwd, group_id) "
					+ "VALUES(rb_no_seq.nextval, ?, ?, ?, ?, "
					+ "(SELECT NVL(MAX(group_id) +1, 1) FROM replyBoard))";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.executeUpdate(); // commit()을 수행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConection();
		}
	}
	// 3. 상세보기 => WHERE
	// 입고 => 재고
	public ReplyBoardVO boardDetailDate(int type,int no) {
		ReplyBoardVO vo = new ReplyBoardVO();
		try {
			// 1. 연결
			getConection();
			// 2. SQL문장 제작
			//SQL 1. 조회수 증가
			if(type == 1) {
				String sql = "UPDATE replyBoard SET "
						+ "hit = hit+1 "
						+ "WHERE no = " + no;
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			}
			// SQL 2. 상세보기 내용 읽기
			String sql = "SELECT no, name, subject, content, "
					+ "TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS'), hit "
					+ "FROM replyBoard "
					+ "WHERE no = " + no;
			ps = conn.prepareStatement(sql);
			// 한 기능을 수행할 때 => SQL은 여러개일 수 있다
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setDbday(rs.getString(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		} catch (Exception e) {
			// 복구 => 오류 체크
			e.printStackTrace();
		} finally {
			// 닫기
			disConection();
		}
		return vo;
	}
	// 4. 수정 => UPDATE
	// 4-0 기존 값 읽어오기
	public ReplyBoardVO boardUpdateDate(int no) {
		ReplyBoardVO vo = new ReplyBoardVO();
		try {
			getConection();
			String sql = "SELECT no, name, subject, content "
					+ "FROM replyBoard "
					+ "WHERE no = " + no;
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
			disConection();
		}
		return vo;
	}
	// 4-1 실제 수정
	public boolean boardUpdate(ReplyBoardVO vo) {
		boolean bCheck = false;//비밀번호 처리
		/*  
		 *  메소드 : 사용자 요청 처리 => 벤치마킹 : 메뉴, 버튼
		 *  1) 사용자 요청값을 받는다
		 *  	=> 매개변수
		 *  2) 요청처리후에 결과값
		 *  	=> 경우의 수
		 *  	1. 목록 : List<~VO>
		 *  	2. 상세보기 : ~VO
		 *  	3. 비밀번호 맞다 / 아니다 : boolean
		 *  	4. 경우의 수가 3개 이상
		 *  		String / int
		 *  		------ 알아볼 수 있게 처리
		 *  		| 로그인 처리
		 *  		=> NOID / NOPWD / OK
		 *  -------------------------------------
		 *  	자바 => 메소드 제작
		 *  		   -------- 데이터 확인 (VO)
		 *  
		 *  1. 형식 => String
		 *  	= INSERT
		 *  		=> DEFAULT가 많은 경우
		 *  		INSERT INTO table_name(컬럼, 컬럼...)
		 *  		VALUES(값...)
		 *  		=> DEFAULT가 없는 경우
		 *  		INSERT INTO table_name VALUES(값...)
		 *  		=> 날짜 / 문자 => ''
		 *  		   ---------------
		 *  		   setString(1, 값) => '값'
		 *  	= UPDATE
		 *  		UPDATE table_name SET
		 *  		컬럼=값, 컬럼=값...
		 *  		[WHERE 조건]
		 *  
		 *  	= DELETE
		 *  		DELETE FROM table_name
		 *  		WHERE 조건
		 *  	----------------------------------------- 데이터가 변경된다 => COMMIT가 필요
		 *  	= SELECT : 이미 저장된 데이터를 검색
		 *  		데이터를 읽기
		 *  		executeQuery()
		 *  	-------------------------------------------
		 *  	웹개발 => 80% => DAO/VO
		 *  	------------ 좌절감 => React => TanStack Query
		 *  								  ---------------
		 *  
		 */
		try {
			getConection();
			//1. SQL => 비밀번호
			String sql = "SELECT pwd FROM replyBoard "
					+ "WHERE no = " + vo.getNo();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd())) { // 비밀번호 일치
				bCheck = true;
				//실제 수정
				sql = "UPDATE replyBoard SET "
						+ "name = ?, subject = ?, content = ? "
						+ "WHERE no = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				//수정 실행
				ps.executeUpdate();
				// INSERT / UPDATE / DELETE가 여러개인 경우 =>  
				// SELECT : 검색 => COMMIT이 필요없다
				
			}else { // 비밀번호 불일치
				bCheck = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConection();
		}
		return bCheck;
	}
	
	// 5. 답변 => 트랜잭션
	/*  
	 *  // => 100% / INDEX / VIEW
	 *  BLOB / BFILE
	 *  GET/POST
	 *  --------- SESSION / COKKIE
	 *  --------- MVC
	 *  --------- DI / AOP / ORM
	 *  --------- Framework / Boot
	 *  try{
	 *  	getConection();연결
	 *  	conn.setAutoCommit(false); Auto commit 해제
	 *  	SQL => INSERT
	 *  	SQL => INSERT
	 *  	conn.commit()
	 *  }cathc(Exception ex){
	 *  	ex.printStackTrace();
	 *  	try{
	 *  		conn.rollback(); => SQL명령분 취소
	 *  	}cathc(Exception ex){}
	 *  } finally{
	 *  	conn.setAutoCommit(true);
	 *  	disConnection();
	 *  }
	 *  			group_id	group_step	group_tab	root	depth
	 *  AAAAA			1			0			0		  		  
	 *    => DDDDD		1			1			1		  0		  
	 *    => BBBBB		1			2			1		  		  
	 *      => CCCCC	1			3			2		  		  
	 *  ASC
	 */
	public void replyInsert(int pno, ReplyBoardVO vo) {
		try {
			getConection();
			conn.setAutoCommit(false);
			//SQL => 4개
			// 답변대상의 group_id, group_step, group_tab
			String sql = "SELECT group_id, group_step, group_tab "
					+ "FROM replyBoard "
					+ "WHERE no = " + pno;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int gi = rs.getInt(1);
			int gs = rs.getInt(2);
			int gt = rs.getInt(3);
			rs.close();
			
			// 2. SQL => group_step을 변경 => 답변의 핵심
			sql = "UPDATE replyBoard SET "
					+ "group_step=group_step+1 "
					+ "WHERE group_id = ? AND group_step > ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gs);
			ps.executeUpdate();
			
			// 3. SQL => INSERT
			sql = "INSERT INTO replyBoard(no, name, subject, content, pwd, group_id, group_step, group_tab, root) "
					+ "VALUES(rb_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.setInt(5, gi);
			ps.setInt(6, gs + 1);
			ps.setInt(7, gt + 1);
			ps.setInt(8, pno);
			ps.executeUpdate();
			
			// 4. SQL => UPDATE
			sql = "UPDATE replyBoard SET "
					+ "depth = depth+1 "
					+ "WHERE no = " + pno;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.commit();
			System.out.println("등록완료");
		} catch (Exception e) {
			// 트랜잭션을 일괄처리 => 스프링 (1파트)
			try {
				conn.rollback(); // 명령문 전체 취소
			} catch (Exception e2) {}
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true); // 원상복귀
			} catch (Exception e2) {}
			disConection();
		}
	}
	// 6. 삭제 => 트랜잭션
	public boolean replyDelete(int no, String pwd) {
		boolean bCheck = false;
		/*  
		 *  1. 비밀번호 확인
		 *  2. depth => 0? ==> delete 
		 *  		   >0? ==> update
		 *  3. depth 감소 ==> update
		 */
		try {
			getConection();
			conn.setAutoCommit(false);
			String sql = "SELECT pwd, root, dept "
					+ "FROM replyBoard "
					+ "WHERE no = " + no;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			int root = rs.getInt(2);
			int depth = rs.getInt(3);
			rs.close();
			/*  
			 *  AAAAA => 2
			 *   =>BBBBB => 1
			 *    =>CCCCC (O) => 0
			 *   =>DDDDD (O) => 0
			 *  EEEEE (O) => 0
			 */
			if(db_pwd.equals(pwd)) {
				bCheck = true;
				//삭제
				if(depth == 0) { //답변이 없는 경우
					sql = "DELETE FROM replyBoard "
							+ "WHERE no" + no;
					ps = conn.prepareStatement(sql);
					ps.executeUpdate();
				}else {// 답변이 있는 경우
					String msg = "관리자가 삭제한 게시물입니다";
					sql = "UPDATE replyBoard SET "
							+ "subject=?, content=? "
							+ "WHERE no = ?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, msg);
					ps.setString(2, msg);
					ps.setInt(3, no);
					ps.executeUpdate();
				}
				sql = "SELECT depth FROM replyBoard "
						+ "WHERE no = " + root;
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				rs.next();
				int d = rs.getInt(1);
				rs.close();
				if(d>0) {
					sql = "UPDATE replyBoard set "
							+ "depth = depth - 1 "
							+ "WHERE no = " + root;
					ps.getConnection().prepareCall(sql);
					ps.executeUpdate();
				}
				// 메소드 한개 => SQL한개만 사용하는 것은 아니다
				// DML여러개 => 트랜잭션처리
				// INSERT / UPDATE / DELETE
			}else {
				bCheck = false;
			}
			conn.commit(); // 저장
		} catch (Exception e) {
			try {
				conn.rollback(); // SQL을 실행하지 않는다
			} catch (Exception e2) {}
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {}
			disConection();
		}
		//@Trancation
		return bCheck;
	}
}
