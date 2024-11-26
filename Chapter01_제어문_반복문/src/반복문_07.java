// 무한루프
/*  
 *  컴퓨터 => 난수 : 1 ~ 100 사이의 정수 추출
 *  => 맞추는 게임 => 힌트 : UP / DOWN
 *  난수 => 58
 *  사용자 입력 > 50 => UP
 *  사용자 입력 > 60 => DOWN
 *  사용자 입력 > 58 => 정답
 *  
 */

import java.util.Scanner;

public class 반복문_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자 입력
		Scanner scan = new Scanner(System.in);
		//임의의 수 추출
		int com = (int)(Math.random()*100) + 1;
		
		for(;;) { // for문의 무한루프
			System.out.println("1 ~ 100 사이의 정수 입력 : ");
			int user = scan.nextInt();
			
			//힌트
			if(com > user) {
				System.out.println("큰 정수 입력!!");
			}else if(com < user) {
				System.out.println("작은 정수 입력!!");				
			}else {
				System.out.println("정답입니다!!");
				System.exit(0); //프로그램 종료
			}
		}
	}

}
