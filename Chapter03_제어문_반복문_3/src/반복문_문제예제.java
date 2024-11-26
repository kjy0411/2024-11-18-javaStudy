import java.util.Scanner;

public class 반복문_문제예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//1) int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식 작성 (조건문)
		/*
		int x = 0;
		if(x > 10 && x < 20) {
		}
		*/
		//2)char형 변수 ch가 공백이고 탭이 아닐 때 true인 조건식 작성
		/*
		char ch = ' ';
		if(ch == ' ' && ch != '\t') {
			System.out.println("true");
		}
		*/
		//3)char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식 작성
		/*
		if(ch == 'x' || ch == 'X') {
			
		}
		*/
		//4)char형 변수 ch가 숫자('0' ~ '9')일 때 true인 조건식 작성
		/*
		if(ch >= '0' && ch <= '9') {
			
		}
		*/
		//5)두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오
		/*
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= 6; j++) {
				if(i + j == 6) {
					System.out.printf("[%d,%d]\n", i, j);
				}
			}
		}
		*/
		//6)사용자로부터 두개의 정수(시작,끝)를 입력받아 시작(포함)해서 끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오.
		/*
		System.out.print("시작 정수 입력 : ");
		int start = scan.nextInt();
		int end = 0;
		while(true) {
			System.out.print("끝 정수 입력 : ");
			end = scan.nextInt();
			if(end > start) {
				break;
			}
			System.out.println(start + "보다 큰 수를 입력하세요");
		}
		Long res = 1L;
		for(int i = start; i <= end; i++) {
			res *= i;
		}
		System.out.printf("%d~%d까지의 곱 : %d", start, end, res);
		*/
		//7)5~16까지의 합을 구하시오
		/*
		int sum = 0;
		for(int i = 5; i <= 16; i++) {
			sum += i;
		}
		System.out.println("5~16까지의 합 : " + sum);
		*/
		//8)3이상 4462 이하에서 짝수인 정수의 합을 구하여라.
		/*
		int sum = 0;
		for(int i = 4; i <= 4462; i += 2) {
			sum += i;
		}
		System.out.println("3이상 4462 이하에서 짝수인 정수의 합 : " + sum);
		*/
		//9)0~12까지 2의 배수, 3의 배수의 합을 구하여라.
		/*
		int sum2 = 0, sum3 = 0;
		for(int i = 0; i <= 12; i++) {
			if(i % 2 == 0) {
				sum2 +=i;
			}
			if(i % 3 == 0) {
				sum3 +=i;
			}
		}
		System.out.println("2의 배수의 합 : " + sum2);
		System.out.println("3의 배수의 합 : " + sum3);
		*/
		//10)1~100까지의 정수 중 4의 배수의 합계를 구하라
		/*
		int sum4 = 0;
		for(int i = 4; i <= 100; i += 4) {
			sum4 += i;
		}
		System.out.println("1~100까지의 정수 중 4의 배수의 합 : " + sum4);
		*/
		//11)10개의 정수를 입력받아 그 수들 중 짝수의 개수가 몇개인지 출력하는 프로그램 작성
		/*
		int res = 0;
		for(int i = 1; i <= 10; i++) {
			System.out.print("정수를 입력하세요 : ");
			int num = scan.nextInt();
			
			if(num % 2 == 0) {
				res++;
			}
		}
		System.out.println("짝수의 개수 : " + res);
		*/
		//12)10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램
		/*
		int res3 = 0, res5 = 0;
		for(int i = 1; i <= 10; i++) {
			System.out.print("정수를 입력하세요 : ");
			int num = scan.nextInt();
			
			if(num % 3 == 0) {
				res3++;
			}
			if(num % 5 == 0) {
				res5++;
			}
		}
		System.out.println("3의 배수의 개수 : " + res3);
		System.out.println("5의 배수의 개수 : " + res5);
		*/
		/* 13)다음 결과를 출력하는 프로그램 (5행10열) 
		 * 		**********
		 * 		**********
		 * 		**********
		 * 		**********
		 * 		**********
		 */
		/*
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 10; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		/* 14)다음 결과를 출력하는 프로그램
		 * 		11111
		 * 		22222
		 * 		33333
		 * 		44444
		 * 		55555
		 */
		/*
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		*/
		/* 16)다음 결과를 출력하는 프로그램
		 * 		1####
		 * 		#2###
		 * 		##3##
		 * 		###4#
		 * 		####5
		 */
		/*
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i == j) {
					System.out.print(i + " ");
				}else {
					System.out.print("# ");					
				}
			}
			System.out.println();
		}
		*/
		/* 16)다음 결과를 출력하는 프로그램
		 * 		ABCDE
		 * 		ABCDE
		 * 		ABCDE
		 * 		ABCDE
		 * 		ABCDE
		 */
		/*
		for(int i = 1; i <= 5; i++) {
			char ch = 'A';
			for(int j = 1; j <= 5; j++) {
				System.out.print(ch);
				ch++;
			}
			System.out.println();
		}
		*/
		/* 16)다음 결과를 출력하는 프로그램
		 * 		AAAAA
		 * 		BBBBB
		 * 		CCCCC
		 * 		DDDDD
		 * 		EEEEE
		 */
		/*
		char ch = 'A';
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print(ch);
			}
			ch++;
			System.out.println();
		}
		*/
		/* 
		 * ★☆☆☆★
		 * ☆★☆★☆
		 * ☆☆★☆☆
		 * ☆★☆★☆
		 * ★☆☆☆★
		 */
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i == j) {
					System.out.print("★");
				}else if(6 - i == j) {
					System.out.print("★");
				}else {
					System.out.print("☆");
				}
			}
			System.out.println();
		}
		/* 
		 * ★☆☆☆★
		 * ☆☆☆☆☆
		 * ☆☆☆☆☆
		 * ☆☆☆☆☆
		 * ★☆☆☆★
		 */
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(((i == 1 || i == 5) && (j == 1 || j == 5)))
					System.out.print("★");
				else
					System.out.print("☆");
			}
			System.out.println();
		}
		
	}

}
