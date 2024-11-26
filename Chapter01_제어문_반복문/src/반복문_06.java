/*  
 *  반복문 -> for
 *  1. 형식 => 65page
 *     for(초기식;조건식;증감식)
 *     {
 *     		반복 수행 문장
 *     }
 *     
 *     => 향상된 for => for-each : JDK 1.5
 *     				  -------- 배열 / Collection
 *     				  -------- 웹에서 주로 사용
 *     				  VueJS/ReactJS
 *     					|	  |
 *     				  Vuex	Redux
 *     						  |
 *     						React - Query => 개인프로그램
 *     					    ============= nextjs
 *     						  | => MSA
 *     	프로젝트
 *     	1. 자바 => 자바 정리 (네트워크, 데이터베이스)
 *     	2. 웹 데이터베이스 활용 / JSP사용 / MVC구조
 *     	3. 웹 Spring 관련 내용 습득, 데이터베이스 고급
 *     	4. 웹 (개인프로젝트) => 신기술
 *  2. 동작 순서
 *  			   | false => 종료
 *  		  1	   2	4
 *  	for(초기식;조건식;증감식)
 *  			   | true 
 *  			 3. 반복 수행 문장 => 4으로 이동
 *  	1 => 초기식은 한번만 수행
 *  	조건식을 만족하지 않을때까지 2=>3=>4=>2를 반복
 *  3. 프로그램 구현 방법
 *     순서
 *     1) 변수 설정
 *     2) 변수 초기화 => 난수 / 명시적 / 입력값
 *     3) 제어문을 이용해서 사용자 요청 값을 추출
 *     		=> 데이터베이스 안에 있는 데이터 추출
 *     4) 결과값을 출력
 *     
 *  for
 *  	무한루프 : 종료가 없는 상태
 *  	------ for(;;) => while(true)
 *  	** 1~10까지 출력 for/while/do~while
 *  	** 프로그램의 단점 => 정답이 없다 / 오라클 :SQL문장이 틀리다
 *  
 */
import java.io.*;
public class 반복문_06 {
	
	public static void main(String[] args) throws Exception {
		FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
		StringBuffer sb= new StringBuffer();
		int i = 0; //문자읽기
		while((i=fr.read())!=-1) {//-1 EOF(파일 끝)
			sb.append((char)i);
		}
		fr.close();
		System.out.println(sb.toString());
	}

}
