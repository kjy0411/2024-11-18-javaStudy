package com.sist.main;
/*  
 *  자바에서 지원하는 라이브러리
 *  			 -------- 프로그램에 필요한 클래스를 모아서 개발시에 사용이 가능하게 한다
 *  => 라이브러리 중심 => 조립
 *  => Scanner / System / String 
 *  
 *  => 많이 사용하는 라이브러리
 *  	1) 자바에서 지원
 *  		java.lang = 9
 *  		**Object
 *  		  System
 *  		**String
 *  		  StringBuffer
 *  		  Math
 *  		  Wrapper : 데이터형을 클래스화
 *  		  -------
 *  		***	=> Integer
 *  		*** => Double
 *  			=> Boolean
 *  			=> Byte
 *  			=> Float
 *  		***	=> Long
 *  			...
 *  		java.util = 10
 *  			=> Scanner
 *  			=> Date / Calendar
 *  			=> Collection
 *  			   ---------- 배열대체
 *  			   List / Set / Map
 *  			   ---------- interface
 *  			   List : ***ArrayList, Vector, LinkedList, Stack
 *  											  |
 *  											Queue
 *  				Set : treeSet / ***HashSet : 중복없는 데이터
 *  				Map : ***HashMap / Hashtable
 *  		java.io = 11
 *  			=> FileReader / FileWriter
 *  			=> InputStream / OutputStream
 *  			=> BufferReader / BufferedWriter
 *  			=> BufferedInputStream / BufferedOutputStream
 *  			=> 입출력 : 파일 / 메모리 / 네트워크
 *  			=> ~Stream, Reader/Writer
 *  			   -------	-------------
 *  				1byte	  2byet(한글포함)
 *  				  | 네트워크 , 파일 업로드 / 다운로드
 *  			=> File
 *  		java.sql = 12
 *  			=> Connection
 *  			=> Statement
 *  			=> ResultSet
 *  		java.sql = 12
 *  		---------------------
 *  		java.net
 *  			=> URL / ServerSocket / Socket
 *  		java.text
 *  			=> SimpleDateFormat / MessageFormat / Decimal
 *  		java.lang.reflet
 *  			=> 리플렉션 => 메소드 / 클래스 / 변수 / 생성자
 *  		*** Annotation, 열거형
 *  			----------
 *  		J2SE
 *  		웹 라이브러리 : JSP / Servlet / Spring => 2차 자바
 *  		J2EE
 *  		J2ME (X) => Kotlin => Dart(Flutter)
 *  		---------------------
 *  		javax.swing(X) => 1차때 한번만 사용
 *  		--------------------- 1.0
 *  		=> javax.http
 *  		=> javax.servlet.http
 *  		--------------------- 2.0
 *  		=> org.springframework
 *  
 *  		java / Oracle / JSP / Spring / Spring-Boot
 *  				| MyBatis / JAP
 *  				| Oracle / MySQL (MariaDB)
 *  		------------------------------------------- Back
 *  		HTML / CSS / JavaScript => TypeScript
 *  		-----------------------
 *  						|
 *  					  JQuery / VueJS / ReactJS / NodeJS / NextJS
 *  		1. 데이터 분석 : 파이썬 (넘파일, 판다스, Matplotlib)
 *  					  Spring <==> 파이썬
 *  									|
 *  								  Django
 *  		2. 검색엔진 : ElasticSearch : CRUD / 검색
 *  		3. 
 *  
 *  
 *  	2) 외부업체 지원 : Jsoup / lombok / Spring
 *  		=> mvnrepository.com
 *  		=> simple
 *  	3) 사용자 정의 : 잘만들어진 클래스 / 자주 사용하는 클래스
 *  		=> .jar
 *  		=> 1차 => JSP (MVC => Spring형식)
 *  	===================================================
 *  	9장
 *  		java.lang패키지
 *  		1) import를 생략할 수 있다 => 자동 추가
 *  		   => 가장 많이 사용 라이브러리 (String, System)
 *  		2) 대표 클래스
 *  		   = Object : 모든 클래스의 상위 클래스
 *  					  --------- Object 상속을 받는다
 *  			 public class A extends Object
 *  							------- 생략이 가능
 *  		   = 모든 클래스에서 사용하는 기능 (메소드)
 *  		   = toString() : 객체 주소
 *  			 => 명시적 / 묵시적
 *  				A a = new A();
 *  				=> System.out.println(a.toString())
 *  				=> System.out.println(a)
 *  			 => 자주 사용이 된다 => 객체의 값이 정상적으로 처리되었는지 확인할때 사용
 *  			 => 객체를 문자열화 시킨다
 *  		   = clone() : 객체를 복제할 경우
 *  			 => 객체 복사
 *  				- 얕은 복사 => 같은 주소를 이용
 *  				  ------- Call By Reference
 *  				- 깊은 복사 => clone => 새로운 메모리에 저장
 *  				  ------- 게임 (아바타) => prototype
 *  		   = finalize() : 소멸자 => 메모리 해제시에 자동 호출된다
 *  			 ---------- System.gc() : 바로 회수
 *  						프로그램 종료시에 회수
 *  		   = equals() => 객체 비교 => 재정의(오버라이딩)
 *  		   = hashCode() => 비교
 */
class Student
{
	private String name;
	private String phone;
	private String address;
	
	// 접근 가능 => 메소드
	public Student(String name, String phone, String address) {
		// 지역변수 / 매개변수
		/*  
		 *  1. 지역변수, 매개변수 찾기
		 *  2. 멤버변수
		 *  ** 지역변수 우선순위
		 */
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public void print() {
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + address);
		System.out.println("전화 : " + phone);
	}
	
	@Override
	public String toString() {
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + address);
		System.out.println("전화 : " + phone);
		return super.toString();
	}
}
public class 라이브러리_1 {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동", "010-1111-1111", "서울");
		Student s2 = new Student("심청이", "010-2222-2222", "경기");
		//객체 출력시에 toString()을 호출한다
//		s1.print();
		System.out.println(s1); //메모리 주소 => 묵시적
//		s2.print();
		System.out.println(s2.toString()); // => 명시적
	}

}
