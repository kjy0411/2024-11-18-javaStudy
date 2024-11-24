  import java.util.Scanner;

public class 자바제어문_예제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//9
		System.out.print("정수 입력 : ");
		int num1 = scan.nextInt();
		System.out.printf("%d는(은) " + (num1 > 0 ? "양수입니다" : (num1 < 0 ? "음수입니다" : "0입니다") ), num1);
		
		System.out.println();
		
		//10
		System.out.print("정수 입력 : ");
		int num2 = scan.nextInt();
		System.out.printf("%d는(은) " + (num2 % 3 == 0 ? "3의 배수입니다" : "3의 배수가 아닙니다"), num2);
		
		System.out.println();
		
		//11
		System.out.print("2자리 정수 입력 : ");
		int num3 = scan.nextInt();
		if((num3 < 10) || (num3 > 99)) {
			System.out.println("2자리 정수가 아닙니다");
		}
		if((num3 >= 10) && (num3 <= 99)) {
			if((num3 / 10) == (num3 % 10)) {
				System.out.println("10의자리와 1의자리가 같습니다");
			}
			if((num3 / 10) != (num3 % 10)) {
				System.out.println("10의자리와 1의자리가 같지 않습니다");
			}
		}
		
		System.out.println(); 
		
		//12
		System.out.print("1~12 사이의 정수 입력 : ");
		int num4 = scan.nextInt();
		if(!((num4 >= 1) && (num4 <= 12))) {
			System.out.println("잘못된 입력");
		}
		if(((num4 >= 1) && (num4 <= 12))) {
			if(((num4 >= 3) && (num4 <= 5))) {
				System.out.println("봄");
			}
			if(((num4 >= 6) && (num4 <= 8))) {
				System.out.println("여름");
			}
			if(((num4 >= 9) && (num4 <= 11))) {
				System.out.println("가을");
			}
			if(num4 == 12 || num4 == 1|| num4 == 2) {
				System.out.println("겨울");
			}
		}
		
	}

}
