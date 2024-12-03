/*  
 *  변수 => 데이터를 모아서 관리 => 배열 / 클래스
 *  연산자 / 제어문
 *  => 연산자 응용 => 제어문
 *  => 제어문 응용 => 배열
 *  => 배열 응용 => 메소드
 *  => 메소드 => 클래스
 *  => 클래스 => 라이브러리
 *  ------------------------------------
 *  => 처리하는 기능이 많은 경우 => 소스코딩이 많다
 *  						  ----------- 조립
 *  
 *  1) 문자열 => 웹, 윈도우 프로그램은 대부분 문자열로 만들어진다
 *  		   가장 많이 사용되는 데이터
 *  		   문자 여러개를 모아서 저장
 *  		   -------- char[] => String
 *  2) String : 일반 데이터형 / 클래스형
 *  	사용하는 방법
 *  	= 일반 데이터형 (가장 많이 사용)
 *  	  String 변수명 = "";
 *  	= 클래스형
 *  	  String 변수명 = new String("저장 데이터", "UTF-8");
 *  	  ------------------------- 한글변환시 주로 사용 (브라우저 => char => 1byte)
 *  3) String의 디폴트는 null (주소가 없는 상태)
 *     => 모든 클래스의 디폴트 => NullPointerExeption
 *  4) String 기능 (메소드)
 *   **String, Math, Scanner, System는 final class
 *   								  ------------ 변경을 할 수 없다(오버라이딩 불가) => 있는 그대로 사용 => 표준화
 *   **Java.lang.*안에 들어있다 => import를 생략할 수 있다
 *  = 변환
 *  	toUppecCase() : 대문자 변환
 *  		=>	메소드
 *  			결과값 : String
 *  			매개변수 : X
 *  			메소드명 : toUpperCase
 *  			기능
 *  			=> String toUpperCase() => 원형
 *  			=> String name = toUpperCase()
 *  	toLowerCase() : 소문자 변환
 *  		String toLowerCase()
 *    **valueOf() : 모든 데이터형을 문자열로 변환
 *    		String valueOf(int)
 *    		String valueOf(char)
 *    		String valueOf(double)...
 *    			   --------------- 오버로딩
 *    **replace() : 문자, 문자열 변환
 *    		String replace(char c1, char c2)
 *    						c1 => c2
 *    		String replace(String old, String new)
 *    		------ 리턴형
 *  	replaceAll() : 패턴을 이용한 문자열 변환
 *  				   --------- regex (정규식)
 *  		String replaceAll(String regex, String change)
 *  						  ------------
 *  = 문자열 분해
 *    **substring() : 문자를 자르는 경우
 *    		String substring(int begin)
 *    		String substring(int begin, int end)
 *    									======= end-1
 *    **split() : 단어별로 나눠서 배열에 저장
 *    		String[] split(String regex)
 *  
 *  = 비교 => 주로 if문에서 사용
 *    **equals() : 같은 경우에 true (==)
 *    		boolean equals(String s)
 *  	startsWith() : 시작하는 문자열이 같은 경우
 *    		boolean startsWith(String s)
 *  	endsWith() : 끝나는 문자열이 같은 경우
 *    		boolean endsWith(String s)
 *    **contains() : 포함된 문자열
 *    		boolean contains(String s)
 *  	
 *  = 위치 찾기
 *    **indexOf() : 처음부터 찾기 : 문자/문자열
 *    		int indexOf(char c)
 *    		int indexOf(String s)
 *  	lastIndexOf() : 끝에서부터 찾기
 *    		int lastIndexOf(char c)
 *    		int lastIndexOf(String s)
 *  
 *  = 문자열 결합
 *  	concat() : 문자열 결합
 *  		String concar(String s)
 *  	+ : 문자열 결합
 *  
 *  = 기타
 *    **trim() : 좌우의 공백 제거
 *    		String trim()
 *  	charAt() : 문자의 위치 => 문자 읽기
 *  		char charAt(int index)
 *  					어떤값 => 결과값
 *  					매개변수  리턴형
 *  				사용자 요청값 => 매개변수
 *  				처리 = > 결과값
 *  	toCharArray() : String을 char[]로 변경
 *  		char[] toCharArray()
 *  => 문자열 배열
 *  형식)
 *  	String[] arr = {"", "", "", "", ""} => 명시적 초기화
 *  	String[] arr = split()
 *  	-------------------------------------------------
 *  
 */
import java.util.Scanner;

public class 문자열배열_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//배열 선언 => 선언과 동시에 초기화
		String[] names = {"홍길동", "심청이", "박문수", "이순신", "강감찬"};
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		/*  
		 *  정수 : nextInt()
		 *  실수 : nextDouble()
		 *  문자열 : next() => 공백이 있는 경우 => nextLine()
		 *  논리형 : nextBoolean()
		 */
		
		//출력
		for(String n : names) {
//			if(n.equals(name)) {//equals 같은 경우 / 대소문자 구분
								//equalsIgnoreCase 대소문자 구분없이 처리
			if(n.contains(name)) {
				System.out.print(n + " ");
			}
		}
	}
	
}
