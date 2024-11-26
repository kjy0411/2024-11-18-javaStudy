// 사용자로부터 값을 받아서 => 해당 구구단을 출력

import java.util.Scanner;

public class 반복문_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력(2~9) : ");
		int dan = scan.nextInt();
		
		System.out.println("====== 요청 결과값 ======");
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
	}

}
