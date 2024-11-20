/*  
 *  &&	||
 *  
 *  (조건) && (조건)	==> 범위, 기간 안에 있는 경우 ==> 직렬 연산
 *  =====    =====		a >= 1 && a <= 100 // 1~100 사이인 경우 true
 *    |		   |
 *    =========
 *    	  |
 *    	결과값 => true/false
 *    
 *  (조건) || (조건)	==> 범위, 기간 밖에 있는 경우 ==> 병렬 연산
 *  =====    =====		a < 1 || a > 100 // 1~100 사이가 아닌 경우 true
 *    |		   |
 *    =========
 *    	  |
 *    	결과값 => true/false
 *    
 *   조건		   &&		조건
 *  ------------------------
 *  true				true	=> true
 *  ------------------------
 *  true				false	=> false
 *  ------------------------
 *  false				true	=> false
 *  ------------------------
 *  false				false	=> false
 *  ------------------------
 *  
 *   조건		   ||		조건
 *  ------------------------
 *  true				true	=> true
 *  ------------------------
 *  true				false	=> true
 *  ------------------------
 *  false				true	=> true
 *  ------------------------
 *  false				false	=> false
 *  ------------------------
 *  
 *  int x = 10;
 *  int y = 9;
 *  
 *  x < y && x == ++y; ==> false
 *  x = 10;
 *  y = 9;	// &&연산에서 앞에 조건이 false일 경우 뒤에 조건은 연산하지 않기 때문 => 효율적인 연산
 *  
 *  || 앞에 조건 ==> true
 *  x<y || x=++y ==> true
 *  
 */

import java.io.FileReader;

public class 연산자_이항연산자_논리연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 9;
		
		/*
		boolean bCheck = x < y && x == ++ y;
		boolean bCheck = x > y && x == ++ y;
		*/
		//boolean bCheck = x < y || x == ++ y;
		boolean bCheck = x > y || x == ++ y;
		System.out.println(bCheck);
		System.out.println(x);
		System.out.println(y);
		
		// && ==> 예약일, 체크인
		// || ==> 유효성 검사
		/* 
		 *  국어, 영어, 수학 입력 => 총점, 평균
		 *  => int kor = 입력
		 *     int eng = 입력
		 *     int math = 입력
		 *     
		 *     int total = kor + eng + math
		 *     double avg = total/3.0
		 *     
		 *  문자열 입력
		 *  ==> ABKBA
		 *  
		 *  =>연산자 : 산술연산자
		 *  38page
		 *  41page => 증가연산자 ++
		 *  43page => 감소연산자 --
		 *  44page => 비교연산자 ==, !=, <, >, <=, >=
		 *  45page => 논리연산자 &&
		 *  47page => 논리연산자 ||
		 */
		try {
  			FileReader f = new FileReader("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
