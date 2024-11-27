import java.util.Scanner;

public class 반복문_문제예제_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		1) 구구단 중 원하는 단수 입력 받아 결과를 출력하기
		/*
		int dan = 1;
		int i = 1;
		while(true) {
			System.out.print("단수 입력(1~9) : ");
			dan = scan.nextInt();
			if(dan < 1 || dan > 9) {
				System.out.println("1~9 사이의 정수를 입력하세요");
			}else {
				break;
			}
		}
		while(i <= 9) {
			System.out.println(dan + " * " + i + " = " + dan * i);
			i++;
		}
		*/
//		2) 1~100사이 정수 중에서 8의 배수 출력하기
		/*
		int i = 1;
		while(i <= 100) {
			if(i % 8 == 0) {
				System.out.print(i + " ");				
			}
			i++;
		}
		*/
//		3) 1~100사이 정수 중에서 4의 배수이거나 7의 배수인 정수를 출력하기
		/*
		int i = 1;
		while(i <= 100) {
			if(i % 4 == 0 || i % 7 == 0) {
				System.out.print(i + " ");				
			}
			i++;
		}
		*/
//		4) 1~100사이 정수중에서 일의 자리 수가 3 또는 6 또는 9인 정수를 출력하기
		/*
		int i = 1;
		while(i <= 100) {
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				System.out.print(i + " ");
			}
			i++;
		}
		*/
//		5) 사용자에게 문자열을 입력받아 모음의 개수를 출력하기 (a, e, i, o, u)
		/*
		System.out.print("문자열을 입력하세요");
		String str = scan.nextLine();
		int i = 0;
		int count = 0;
		while(i <= str.length() - 1) {
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'
					|| str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U') {
				count++;
			}
			i++;
		}
		System.out.println(str + "의 모음의 개수 : " + count + "개");
		*/
//		6) 사용자에게 1 ~ 9사이의 정수를 입력받아 2자리의 자연수 중 각 자리수의 합이 입력값과 동일한 수 출력하기
		//		입출력예) 6 => 15 24 33 42 51 60 
		/*
		int num = 1;
		while(true) {
			System.out.print("1~9 사이의 정수 입력 : ");
			num = scan.nextInt();
			if(num < 1 || num > 9) {
				System.out.println("1~9 사이의 정수를 입력해주세요");
			}else {
				break;
			}
		}
		int i = 10;
		int count = 0;
		while(i < 100) {
			int sum = (i / 10) + (i % 10);
			if(sum == num) {
				System.out.print(i + " ");
				count++;
			}
			i++;
		}
		System.out.println();
		System.out.println("각 자리수의 합이 " + num + "과 같은 2자리 정수의 개수 : " + count + "개");
		*/
//		7) 10부터 20까지 순서대로 출력 
		/*
		int i = 10;
		while(i <= 20) {
			System.out.print(i + " ");
			i++;
		}
		*/
//		8) 10부터 20까지 역순으로 출력 
		/*
		int i = 20;
		while(i >= 10) {
			System.out.print(i + " ");
			i--;
		}
		*/
//		9) 사용자가 입력한 5개의 정수 중 가장 큰 값을 출력하기
		/*
		int max = 0;
		int i = 1;
		while(i <= 5) {
			System.out.print("정수를 입력하세요");
			int user = scan.nextInt();
			if(user > max) {
				max = user;
			}
			i++;
		}
		System.out.println();
		System.out.println("사용자가 입력한 정수 중 가장 큰 값 : " + max);
		*/
//		10) 사용자에게 문자열 3개를 입력받아 길이값의 합을 출력하고, 가장 긴 문자열을 출력하기
		/*
		int lenthSum = 0;
		String lontStr = "";
		
		int i = 1;
		while(i <= 3) {
			System.out.print("문자열을 입력하세요 : ");
			String str = scan.nextLine();
			lenthSum += str.length();
			if(str.length() > lontStr.length()) {
				lontStr = str;
			}
			i++;
		}
		System.out.println("입력받은 문자열 길이값의 합 : " + lenthSum);
		System.out.println("가장 긴 문자열 : " + lontStr);
		*/
 	}

}
