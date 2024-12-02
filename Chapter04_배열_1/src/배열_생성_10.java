/*  
 *  중복없는 난수 => 3개 발생 (1~9)
 *  ==========================
 *  사용자 입력
 *  3자리 입력 => 맞추는 프로그램 : 숫자 야구 게임
 *  힌트
 *  	컴퓨터 : 369
 *  	사용자 : 123 => 0S-1B
 *  	사용자 : 346 => 1S-1B
 *  	3S => 종료
 */

import java.util.Arrays;
import java.util.Scanner;

public class 배열_생성_10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//컴퓨터가 중복없는 난수 3자리 발생
		int[] com = new int[3]; // {0, 0, 0}
		int[] user = new int[3];// {0, 0, 0}
		
		//초기화
		for(int i = 0; i < com.length; i++) {
			com[i] = (int)(Math.random()*9) + 1;
			for(int j = 0; j < i; j ++) {
				if(com[i] == com[j]) {
					i--;
					break;
				}
			}
		}
		//난수와 사용자 입력 비교
		while(true){
			System.out.print("세자리 정수를 입력하세요 : ");
			int input = scan.nextInt();
			
			if(input < 100 || input > 999) {
				System.out.println("잘못된 입력입니다!!");
				continue; //처음부터 다시 실행
			}
			
			// 세자리 정수 입력 => 656/100 => 3
			user[0] = input / 100;
			user[1] = (input % 100) / 10;
			user[2] = input % 10;
			
			if(user[0] == user[1] ||
			   user[0] == user[2] ||
			   user[1] == user[2]) {
				System.out.println("중복된 수는 사용할 수 없습니다!!");
				continue; // 처음부터 다시 입력
			}
			
			// 문제 발생 ==> 0을 제외
			if(user[0] == 0 || user[0] == 0 || user[1] == 0) {
				System.out.println("0은 사용할 수 없습니다!!");
				continue;
			}
			//오류처리 => 조건문 역할 : 오류를 방지 => if를 사용한다
			
			//힌트
			int s = 0, b = 0;
			for(int i = 0; i < com.length; i++) {
				for(int j = 0; j < user.length; j++) {
					if(com[i] == user[j]) { // 같은 수가 있다면
						if(i == j) { // 같은 자리면 s++
							s++;
						}else { // 다른 자리면 b++
							b++;
						}
					}
				}
			}
			System.out.printf("Number:%d, result : %dS-%dB\n", input, s, b);
			if(s == 3) {
				System.out.println("Game Over!!");
				break;
			}
		}
		/*
		while(true) {
			int s = 0;
			int b = 0;
			//사용자 입력
			for(int i = 0; i < user.length; i++) {
				System.out.print("1~9 사이의 중복되지 않은 정수 입력 : ");
				user[i] = scan.nextInt();
				if(user[i] < 1 || user[i] > 9) {
					i--;
					System.out.println("1~9 사이의 중복되지 않은 정수를 입력해주세요");
					continue;
				}
					for(int j = 0; j < i; j ++) {
						if(user[i] == user[j]) {
							i--;
							System.out.println("1~9 사이의 중복되지 않은 정수를 입력해주세요");
							break;
						}
					}
					
			}
			//비교
			for(int i = 0; i < com.length; i++) {
				for(int j = 0; j < user.length; j++) {
					if(com[i] == user[j]) {
						if(i == j) {
							s++;
						}else {
							b++;
						}
					}
				}
			}
			//힌트
			System.out.printf("%dS-%dB\n", s, b);
			//종료여부 확인
			if(s == 3) {
				System.out.print("종료하겠습니까? y/n");
				char c = scan.next().charAt(0);
				if(c == y){
					break;
				}
			}
		}
		System.out.println(Arrays.toString(com));
		System.out.println(Arrays.toString(user));
		*/
	}

}
