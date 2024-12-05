/*  
 *  숫자 야구게임	=> 절차적 언어 (main)
 *  	|		=> 메소드형식 변환
 *  	|		=> 객체지향 프로그램으로 변환
 *   1. 3개 정수 추출 => 중복 없는 1~9사이 정수 추출	
 *   2. 사용자 입력
 *   3. 비교
 *   4. 힌트
 *   => 문자열 1S-2B ...
 *   => S : ○
 *   	B : ○○
 *   5. 종료 여부 확인
 */

import java.util.Arrays;
import java.util.Scanner;

public class 메소드응용_1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//1. 중복없는 난수 발생 => 3개 정수(1~9)
		int[] com = new int[3];	// 3개의 정수를 저장하는 공간
		//				=> 변수 여러개 => 배열
		for(int i = 0; i < com.length; i++) {
			com[i] = (int)(Math.random() * 9) + 1;
			//double random()
			for(int j = 0; j < i; j++) {//중복 여부 검사
				if(com[i] == com[j]) {
					i--;	//중복된 정수를 받았으면 새로운 정수를 다시 받는다
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(com));
		
		int[] user = new int[3];
		while(true) {
			//2. 사용자 입력
			System.out.print("세자리 정수를 입력하세요>>");
			int input = scan.nextInt();
			
			//오류 처리 => 유효성 검사
			if(input < 100 || input > 999) {
				System.out.println("세자리 정수만 입력해야 됩니다!!");
				//처음으로 이동
				continue;
				/*  
				 *  continue 사용시
				 *  for = 증가식으로 이동
				 *  while = 조건식으로 이동
				 *  => 특정 구간을 제외할때 사용
				 *  => 웹에서는 사용빈도가 적다
				 */
			}
			//3자리 정수 => 나눠서 배열에 저장
			user[0] = input / 100;
			user[1] = (input % 100) / 10;
			user[2] = input % 10;
			// 코딩테스트 => 화폐매수 구하기 14850
			// 오류처리 ==> 중복된 수가 없어야된다 / 0을 사용할 수 없다
			if(user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
				System.out.println("중복된 숫자는 사용할 수 없습니다!!");
				//처음부터 다시 시작
				continue;
			}
			if(user[0] == 0 || user[1] == 0 || user[2] == 0) {
				System.out.println("0은 사용할 수 없습니다!!");
				continue;
			}
			
			//3. 비교
			int s = 0, b = 0;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(com[i] == user[j]) {//같은 숫자가 있을 때
						if(i == j) {//같은 자리
							s++;
						}else {//다른 자리
							b++;
						}
					}
				}
			}
			
			//4. 힌트 제공
			System.out.println("Input Number : " + input);
			System.out.println("==== 전광판 ====");
			System.out.print("S : ");
			for(int i = 0; i < s; i++) {
				System.out.print("●");
			}
			System.out.println();
			System.out.print("B : ");
			for(int i = 0; i < b; i++) {
				System.out.print("○");
			}
			System.out.println("\n==============");
			//System.out.println("Input Number : " + input + ", Result : " + s + "S-" + b + "B");
			//System.out.printf("Input Number:%d, Result : %dS-%dB", input, s, b);
			
			//5. 종료 여부 확인
			if(s == 3) {
				System.out.println("Game Over!!");
				break; // 반복을 중단
			}
		}
		
	}
	
}
