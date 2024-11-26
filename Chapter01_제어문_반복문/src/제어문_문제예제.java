import java.util.Scanner;

public class 제어문_문제예제 {

	public static void main(String[] args) {
		//1) 100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D, 60점 이하면 F를 출력하라 (switch~case 사용)
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int score = scan.nextInt();
		int a = score / 10;
		switch(a) {
			case 10 : case 9 :{
				System.out.println("A등급 입니다");
				break;
			}
			case 8 :{
				System.out.println("B등급 입니다");
				break;
			}
			case 7 : {
				System.out.println("C등급 입니다");
				break;
			}
			case 6 : {
				System.out.println("D등급 입니다");
				break;
			}
			default :{
				System.out.println("F등급 입니다");
			}
		}
		
		//2) 정수 2개와 연산자(+,-,*,/)를 입력 받아 사칙 연산하는 프로그램을 만들어라 (switch~case 사용) 
		
		System.out.print("정수 입력 : ");
		int num1 = scan.nextInt();
		
		System.out.print("+,-,*,/ 입력 : ");
		char op = scan.next().charAt(0);
		
		System.out.print("정수 입력 : ");
		int num2 = scan.nextInt();
		
		System.out.println();
		
		switch(op) {
			case '+' : {
				System.out.println(num1 + " + " + num2 + " = " + (num1 + num2) );
				break;
			}
			case '-' : {
				System.out.println(num1 + " - " + num2 + " = " + (num1 - num2) );
				break;
			}
			case '*' : {
				System.out.println(num1 + " * " + num2 + " = " + (num1 * num2) );
				break;
			}
			case '/' : {
				if(num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다");
				}else {
					System.out.println(num1 + " / " + num2 + " = " + (num1 / num2) );					
				}
				break;
			}
		}
		
		//3) 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)
		
		int sum3 = 0;
		for(int i = 2; i <= 100; i+=2) {
			sum3 += i;
		}
		System.out.println("2+4+6+....100까지의 정수의 합 : " + sum3);
		
		//4) 5,10,15,20,25,30,35,40,45,50을 출력하는 프로그램을 만들어라 (for 사용)
		
		for(int i = 5; i <= 50; i += 5) {
			System.out.print(i + " ");
		}
		for(int i = 1; i <= 10; i++){
			System.out.print(i*5 + " ");
		}
		
		//5) B,D,F,H,J,L,N을 출력하는 프로그램을 작성하라 (for 사용)
		
		for(char c = 'B'; c <= 'N'; c += 2) {
			System.out.print(c + " ");
		}
		
		//6) 한 개의 정수를 입력 받아 1부터 입력 받은 정수까지의 합을 출력하라
		
		System.out.print("정수를 입력하세요");
		int num = scan.nextInt();
		int sum6 = 0;
		for(int i = 1; i <= num; i ++) {
			sum6 += i;
		}
		System.out.println("1 ~ " + num + "까지의 합 : " + sum6);
		
		//7) 1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라
		
		int count = 0;
		for(int i = 1; i <= 30; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
				count++;
			}
			if(count == 3) {
				System.out.println();
				count = 0;
			}
		}
		
		//8) 1-2+3-4+5-6+7-8+9-10 계산 값을 for문을 이용하여 출력하라
		
		int res = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 != 0) {
				res += i;
			}else {
				res -= i;
			}
		}
		System.out.println("1-2+3-4+5-6+7-8+9-10 계산 값 : " + res);
		
		//9)1~10 사이의 숫자 중 3의 배수를 제외하고 출력하라
		
		for(int i = 1; i <= 10; i++) {
			if(i % 3 != 0) {
				System.out.print(i + " ");
			}
		}
		
	}

}
