/*  10개의 할파벳을 추출
 *  사용자가 입력 => 몇번째 위치하고 있는지 확인
 *  A C D F Z H O P Q K
 *  ==> D => 3번째 위치하고 있다 ==> index 구하는 방법
 * 			 => 크롤링 (웹에서 데이터 수집)
 *  A ~ Z 사이 => 입력 => 몇번째
 */

import java.util.Scanner;

public class 반복문_10 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("알파벳을 입력(대문자) : ");
		char c = scan.next().charAt(0);
		
		System.out.println("c="+c);
		
		System.out.println("몇번째 위치 : " + (c-64));
		
		int index = 1;
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			if(ch == c) {
				break; // 종료
			}
			index++;
		}
		System.out.println(c + "는(은) " + index + "번째 위치하고 있습니다");
	}

}
