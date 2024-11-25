// 입력 => 사칙연산
import java.util.Scanner;

public class 자바선택문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//클래스 저장
		Scanner scan = new Scanner(System.in);
		//지역변수 (stack) => 메모리, new 생성 (heep) 개발용
		//메소드 : 메소드 Area....(static)
		System.out.print("첫번째 정수 입력 : ");
		int num1 = scan.nextInt();
		//키보드를 이용해서 정수값 받기
		System.out.print("두번째 정수 입력 : ");
		int num2 = scan.nextInt();
		
		System.out.print("연산자 입력 (+, -, *, /) : ");
		
		switch(scan.next()) { //문자열, 문자
			case "+":
				System.out.println(num1 + " + " + num2 + " = " + (num1 + num1));
				break;
			case "-":
				System.out.println(num1 + " - " + num2 + " = " + (num1 - num1));
				break;
			case "*":
				System.out.println(num1 + " * " + num2 + " = " + (num1 * num1));
				break;
			case "/":
				if(num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다");
				}else {
					System.out.println(num1 + " / " + num2 + " = " + (num1 / num1));
				}
				break;
			default :
				System.out.println("연산자를 입력하세요(+, -, *, /)");
		}
	}

}
