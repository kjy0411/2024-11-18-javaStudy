//  대문자 변환 => toUpperCase()
/*  
 *  함수 : funtion
 *  메소드 : method
 *  ---------------- 기능상으로는 동일
 *  class종속
 *  C/C++/Python => funtion(함수)
 *  Java/Kotlin => method
 *  
 *  String data = "Hello Java"
 *  data.replace('a','b') => Hello jbvb
 *  replace(문자, 문자)
 *  		---  ---
 *  		old  new
 *  
 *  String data = "Hello Java"
 *  data.replace("Java","Oracle") => Hello Oracle
 *  replace(문자열, 문자열)
 *  		----  ----
 *  		old   new
 */
import java.util.Scanner;

public class 문자열_8 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		String name = "Hong Gil Dong";
		System.out.println(name.toUpperCase());
		System.out.println(name.toLowerCase());
		// Upper / Lower => 오라클
		// 데이터 관리 => 자바 + 오라클 => JSP에서 HTML로 변환
		*/
		String data = "Hello Java";
		System.out.println(data.replace('a', 'b'));
		System.out.println(data.replace("Java", "Oracle"));
		
		/*  오라클 연동
		 *  이미지, 줄거리, 내용
		 * 	|, &, '' => 오라클에서 첨부할 수 없다
		 *  & => replace
		 *  & => Scanner
		 *  || => 문자열 결합
		 *  문자열 => ''
		 */
		
	}
	
}
