/*  
 *  비교연산자 => 숫자나 논리만 비교
 *  	|	=> ""=="" => equals()
 *  	|
 *  	==	: 같다
 *  	!=	: 같지 않다
 *  	================== 오라클 : =, <> => JavaScript : ===, !==
 *  	<	: 작다
 *  	>	: 크다
 *  	<=	: 작거나 같다
 *  	>=	: 크거나 같다
 *  
 *  	==> 결과값은 true/false ===> 조건문
 */
public class 연산자_이항연산자_비교연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(6 == 7);
		System.out.println(6 != 7);
		System.out.println(6 < 7);
		System.out.println(6 > 7);
		System.out.println(6 <= 6);
		System.out.println(6 >= 6);
		
		System.out.println("==========");
		char c = 'A';
		int a = 65;
		// char는 연산처리되면 정수로 변경
		/* 
		 * 
		 * 	'A' => 65
		 * 	'a' => 97
		 */
		System.out.println(c == a); // c => 65로 변경
		c = '0'; // 48
		a = 0;
		System.out.println((int)'A');
		System.out.println((int)'0');
		System.out.println(c == a);
		
		System.out.println((int)'+');
		System.out.println((int)'-');
		System.out.println((int)'*');
		System.out.println((int)'/');
		System.out.println((int)'%');
		// 유니코드 => 0~65535
		System.out.println((int)'길');
		
		/*for(int i = 1; i <= 65535; i++) {
			System.out.print((char)i);
			if(i % 100 != 0) {
				System.out.print(" ");
			}else {
				System.out.println();
			}
		}*/

		boolean bCheck1 = false;
		boolean bCheck2 = true;
		// => == , != (<, >, <=, >=)
		System.out.println(bCheck1 == bCheck2);
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1.equals(s2));
		
		int x = 10;
		int y = 9;
		
		System.out.println(x == y++);
		System.out.println(x == ++y);
		
		// 비교연산자 ==> 조건문, 반복문
		// ======= 로그인, 아이디 중복, 우편번호 검색, 검색처리 
	}

}
