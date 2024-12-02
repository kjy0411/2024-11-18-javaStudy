/*  => 변수 => 배열 
 *  => 연산처리 / 제어문 => 사용자 요청 => 메소드
 *  ------------------------------------- 클래스 구성요소
 *  객체지향언어 => 자바 시작(5장)
 *  사용자 정의 데이터형
 *  1. 정수를 입력받아서 ==> 2진법 출력		10 ==> 0000 0000 0000 1010
 *  16bit => 2byte => 32767
 */

import java.util.Scanner;

public class 배열_생성_03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("0~32767사이 정수 입력 : ");
		int num = scan.nextInt();
//		System.out.println(Integer.toBinaryString(num));
		// 저장공간 0,1 => 16개
		int[] binary = new int[16];
		// 앞에서부터 ==> index = 0 , 뒤에서부터 ==> index = 15
		// index = 0 ==> 0부터 출력	FIFO => Queue
		// index = 0 ==> 15부터 출력	LIFO => Stack
		int index = 15;
		
		//요청 처리 ==> 제어문 / 연산자
		while(true) {
			binary[index] = num % 2;
			num /= 2;
			
			if(num == 0) {
				break;
			}
			index--;
		}
		// 출력
		for(int i = 0; i < binary.length; i++) {
			if(i % 4 == 0 && i != 0) {
				System.out.print(" ");
			}
			System.out.print(binary[i] + " ");
		}
		while(true) {
			
		}
	}
	
}
                                                                                               