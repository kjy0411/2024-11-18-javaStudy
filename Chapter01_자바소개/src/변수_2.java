// 초기값 => 데이터를 저장하는 방법
/* 	자바에서 사용하는 표현법
 *  
 *  1. 정수
 *     byte/short/int => 숫자 사용 (범위만 초가하지 않는다)
 *     숫자표현
 *     	10		=> 10진법
 *     	012		=> 8진법
 *     	날짜
 *     	 => 2024-09-20	(시간)
 *     	    	 == 8진법상에서 에러
 *     	0x12	=> 16진법
 *     long표현
 *     	10L , 10l
 *     	---------
 *     실수형
 *     	10.5 => double
 *      10.5F, 10.5f => float
 *     문자형
 *     	한글자만 저장이 가능
 *     	'A'
 *     	"" => 문자열 => 여러개 문자 사용이 가능 "ABCD...."
 *     논리형
 *     	true/false
 *     
 *     데이터 저장 방법
 *     1) 명시적 초기화
 *     	  int a = 10;
 *     2) 입력을 받아서 초기화
 *     3) 난수발생
 *     
 *     변수 선언
 *     선언과 동시에 값을 저장
 *     	데이터형 변수명 = 값;
 *     
 *     선언 
 *     	데이터형 변수명;
 *     값을 저장
 *     	변수명 = 값;
 *     
 *     ***변수 선언만 하고 사용 => error 발생 (초기화를 해줄것)
 *     
 */
public class 변수_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//정수
		byte byteVal = 127; //-128~127
		short shortVal = 32767; //-32768~-32767
		int intVal = 2140000000;
		long longVal = 30000000000L; //long표현
		
		longVal = 100;
		System.out.println(longVal);
		long a = 100;// 100L
		System.out.println(a);
		
		int b = 'A';
		System.out.println(b);
		
		char c = 65;
		//'A' = 65, 'a' = 98, '0' = 48
		
		boolean boo = false;
		System.out.println(boo); //조건문 => 제어문
		
		float f = 10.5f;
		System.out.println(f);
		double d = 10.5f;
		System.out.println(d);
		//왼쪽에 있는 데이터형이 크거나 같아야 저장이 가능하다
		/* 
		 * 데이터는 선언된 데이터형을 따라간다
		 * 
		 * byte = byte
		 * short = byte, short
		 * int = byte, short, int
		 * long = byte, short, int, long
		 * float = byte, short, int, long, float
		 * double = byte, short, int, long, float, double
		 * 
		 * 자동 형변환
		 * 
		 * (int)10.5 => 10
		 * (double)10 => 10.0
		 * (int)'A' => 65
		 * (char)65 => 'A'
		 * (double)'A' => 65.0
		 * (float)'A' => 65.0f
		 */
		// 10/(double)3 = 3.333333
		System.out.println(10/3);
		System.out.println(10/(double)3);
		
	}

}
