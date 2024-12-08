package com.sist;
/*  
 *  메소드 형식
 *  static 리턴형 메소드명(매개변수...) => 선언부
 *  {
 *  	=> 구현부 => 메모리에 저장
 *  }
 *  
 *  static 리턴형 메소드명(매개변수...); => 메모리에 저장이 안된다
 *  => 추상메소드 : 설계단
 *  
 */
import java.util.Scanner;
import java.io.*;
public class 메소드_1 {
	static String movieDate="";
	/*  
	 *  예외처리
	 *  	=> 예외 복구 : try-catch(복구)
	 *  	=> 예외 회피 : => 컴파일러에 예외 알림
	 *  => 프로그램을 유지
	 */
	static {//실행시에 자동 인식
		try {//정상 수행
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i = 0; // 단점 => char(X), int
			StringBuffer sb = new StringBuffer();
			while((i = fr.read()) != -1){// -1 EOF
				sb.append((char)i);
			}
			movieDate = sb.toString();
			fr.close();
		} catch (Exception ex) {// 에러 발생 => 복구 / 에러 출력
			
		}//예외처리 
	}
	//화면에 출력 => 결과값이 없다 ==> void
	static void menu() {
		System.out.println("===== Menu =====");
		System.out.println("1. 영화 목록");
		System.out.println("2. 영화 상세");
		System.out.println("3. 영화 검색(명화명)");
		System.out.println("4. 영화 검색(출연진)");
		System.out.println("5. 종료");
		System.out.println("================");
		
	}
	static void movieList(int page) {
		String[] movie = movieDate.split("\n");
		int i = 0;//for 횟수
		int j = 0;//20개씩
		final int ROWSIZE = 20;//시작점
		int pagecnt = (page * ROWSIZE) - ROWSIZE;//
		for(String s : movie) {
			//System.out.println(s);
			if(j < 20 && i >= pagecnt) {
				String[] md = s.split("\\|");
				System.out.println(md[0] + "." + md[1]);
				j++;
			}
			i++;
		}
	}
	//상세보기 => 데이터
	static void movieDetail(int moiveNo) {
		String[] movie = movieDate.split("\n");
		//영화 정보 전체 => \n
		
		for(String s : movie) {
			//영화 한개 => 정보 => \n
			String[] info = s.split("\\|");
			//info[0] => String
			/*  String => int : parseInt()
			 *  int => String : valueOf()
			 */
			if(info[0].equals(String.valueOf(moiveNo))) {
				System.out.println("영화명 : " + info[1]);
				System.out.println("장르 : " + info[2]);
				System.out.println("출연 : " + info[4]);
				System.out.println("개봉일 : " + info[5]);
				System.out.println("등급 : " + info[6]);
				System.out.println("감독 : " + info[7]);
				break;
			}
		}
	}
	//영화명으로 찾기
	static void titleFind(String mn) {
		String[] movie = movieDate.split("\n");
		
		for(String s : movie) {
			String[] info = s.split("\\|");
			
			if(info[1].contains(mn)) {
				System.out.println(info[1] + "(" + info[4] + ")");
			}
		}
	}
	//출연진으로 찾기
	static void actorFind(String actor) {
		String[] movie = movieDate.split("\n");
		
		for(String s : movie) {
			String[] info = s.split("\\|");
			if(info[4].contains(actor)) {
				System.out.println(info[1] + "(" + info[4] + ")");
			}
		}
	}
	//조립 ==> 다른 클래스에서 연결해서 사용이 가능
	//다른 클래스 연결해서 사용 . 재사용
	static void process() {
//		System.out.println(movieDate);
		Scanner scan = new Scanner(System.in);
		while(true) {
			menu();
			System.out.print("메뉴 선택 : ");
			int m = scan.nextInt();

			if(m == 5) {
				System.out.println("프로그램 종료");
				break;
			}else if(m == 1) {
				System.out.print("페이지 입력(1~97) : ");
				int page = scan.nextInt();
				movieList(page);
			}else if(m == 2) {
				System.out.print("영화 선택(1~1938) : ");
				int movieNo = scan.nextInt();
				movieDetail(movieNo);
			}else if(m == 3) {
				System.out.print("영화 제목 검색 : ");
				String mn = scan.next();
				titleFind(mn);
			}else if(m == 4) {
				System.out.print("영화 출연 검색 : ");
				String actor = scan.next();
				actorFind(actor);
			}
		}
	}
	public static void main(String[] args) {
		process(); //가급적 main에서 코딩하지 않는다
	}
}
