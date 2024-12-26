package com.sist.dao;
/*
 *   Collection 
 *   -----------
 *      => 단순 목록 : ArrayList 
 *                   => 수정 / 삭제 => 속도가 느리다 
 *                   => 가변형 
 *   1. 목록 => 페이지 나누기 => ArrayList
 *   2. 상세보기 => MusicVO 
 *                => 버튼 클릭 => 동영상 실행 
 *   3. 검색 => ArrayList
 *   4. 게시판 => LinkedList 
 *               => 수정 / 삭제 => 빠르다 
 *   5. 구매 => Map 
 *               => 두개 저장 
 *   6. 찜하기 => Set
 *               => 한사람당 1개만 
 *   => 프로젝트 : 크롤링 => 오라클 
 *   ------------------------------------
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.sist.vo.*;
public class MusicDAO {
    // 연결 객체 
	private Connection conn; 
	// SQL문장 전송 객체
	private PreparedStatement ps;
	// URL을 등록 
	private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
	
	// 싱글턴 => 열기 / 닫기 
	private static MusicDAO dao;
	// => ArrayList
	// 1. 드라이버 등록 => 한번만 등록  
	public MusicDAO()
	{
		try
		{
			// ojdbc8.jar => 자바에서 지원(X) => 오라클에서 지원
			// mvnrepository.com 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException ex) {}
	}
	// 2. 오라클 연결 
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			// 오라클 => conn hr/happy
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// 3. 오라클 닫기 
	public void disConnection()
	{
		try
		{
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
		}catch(Exception ex){}
	}
	/*
	 *    DAO는 사용자당 1개만 사용이 가능하게 만든다 
	 *    -----------------------------------
	 *    => 싱글턴 
	 */
	/*
	 *   디자인 패턴 
	 *    => 싱글턴 => static 
	 *    => 팩토리 패턴 => Map
	 *    ---------------------------
	 *    => MV 패턴 => JSP(Java+HTML)
	 *                       |    |
	 *                     Model View 
	 *       -------
	 *    => MVC패턴 
	 *       -------
	 *    => Observer
	 *    => prototype 
	 *    
	 *    문법 => 형식 
	 *    응용 
	 *    디자인패턴 / 알고리즘 
	 *    
	 */
	public static MusicDAO newInstance()
	{
		if(dao==null)
			dao=new MusicDAO();
		return dao;
	}
	//////////////////////////// 데이터베이스 사용시 공통 기반 
	// 4. 뮤직 목록 출력 
	// 5. 뮤직 상세보기 
	// 6. 뮤직 검색 
	// DAO => 공용 (웹, 윈도우 , 애플리케이션)
	
	public List<MusicVO> musicFindData(String fd)
	{
		List<MusicVO> list=new ArrayList<MusicVO>();
		try
		{
			// 1. 오라클 연결 
			getConnection();
			// 2. 오라클로 전송할 문장 
			String sql="SELECT mno,title,singer,album,poster "
					  +"FROM genie_music "
					  +"WHERE title LIKE '%'||?||'%'";
			          // contains() => LIKE => REGEXP_LIKE
			// 3. sql을 전송 
			ps=conn.prepareStatement(sql);
			// 4. ?에 값을 채운다 
			ps.setString(1, fd);
			// 5. 실행후에 결과값을 가지고 온다 
			ResultSet rs=ps.executeQuery();
			// 6. List에 값을 채운다 
			while(rs.next()) // 처음부터 마지막까지 읽어온다 
			{
				// 한줄씩 읽어온다 
				MusicVO vo=new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSinger(rs.getString(3));
				vo.setAlbum(rs.getString(4));
				vo.setPoster(rs.getString(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			// 에러 확인 => 복구 
			ex.printStackTrace();
		}
		finally
		{
			// 정상수행 / 에러 발생 => 무조건 수행 => 서버닫기 
			disConnection();
		}
		return list;
	}
	//동영상 키
	public String getKey(int mno) {
		String key = "";
		try {
			//1. 연결
			getConnection();
			//2. SQL문장 제작
			String sql = "SELECT DISTINCT key FROM genie_music"
					+ "WHERE mno=" + mno;
			//3. 오라클로 SQL전송
			ps = conn.prepareStatement(sql);
			//4. 실행후에 결과값 받기
			ResultSet rs = ps.executeQuery();
			//5. 값을 채워서 대기
			rs.next();
			
			rs.close();
		} catch (Exception e) {
			//에러 확인
			e.printStackTrace();
		} finally {
			//연결 닫기
			disConnection();
		}
		return key;
	}
}





