/*  
 *  산술연산자 => 프로그램에서 가장 많이 사용하는 연산자
 *  =======
 *  	+, -, *, /, %
 *  	
 *  	*** 형변환 => 데이터형이 다른 경우에 연산처리
 *  				큰 데이터형으로 변경
 *  	10 + 20.5
 *  	==
 *  	10.0 => 자동 변경
 *  
 *  	'A' + 10
 *  	===
 *  	65 + 10 => 75
 *  	*** char는 연산처리가 되면 무조건 int 변경
 *  	*** int이하 데이터형이 연산되면 => int의 결과값이 나온다
 *  		=> 산술규칙
 *  		byte b1 = 10
 *  		byte b2 = 20
 *  		b1 + b2 = int
 *  
 *  	+ : 덧셈, 문자열 결합
 *  		2 + 10 => 12
 *  		2 + "10" => 210
 *  		"10" + 2 => 102
 *  		
 * 		- : 마이너스 기능
 * 			long - int => long	
 * 			int - int => int
 * 			char - char => int
 * 			byte - byte - char = int
 * 			
 * 		* : 곱하기
 * 		double * int => double
 * 		char * char = int
 * 
 * 		/ : 나누기
 * 			1) 0으로 나누면 오류 발생 // 10 / 0 => 오류
 * 			2) 정수 / 정수 = 정수
 * 			   =============== 오라클 : 정수 / 정수 = 정수
 * 							   자바스크립트 : 정수 / 정수 = 실수
 * 							   파이썬 : 정수 / 정수 = 실수
 * 							  		  정수 // 정수 = 정수
 * 
 * 		% : 나머지
 * 			5 % 2 => 1
 * 			=> 부호(-, +) => 왼쪽 부호를 따라간다
 * 
 * 			-5 * -2 => 10
 * 			-5 / -2 => 2
 * 
 * 			-5 % -2 => -1
 */
public class 연산자_이항연산자_산술연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-5*-2);
		System.out.println(-5/-2);
		System.out.println(-5%-2);
	}

}
