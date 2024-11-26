import java.util.Scanner;

public class 반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// 1~100 사이의 정수 추출
		int com = (int)(Math.random()*100) + 1;
		while(true) {
			System.out.print("1~100 사이의 정수 입력 : ");
			int user = scan.nextInt();
			if(user < 0 || user > 100) {
				System.out.println("잘못된 입력입니다!!");
				continue;//처음 화면으로 이동
			}
			if(com>user) {
				System.out.println("입력한 수보다 큰 수를 입력하세요!!");
			}else if(com<user) {
				System.out.println("입력한 수보다 작은 수를 입력하세요!!");				
			}else {
				System.out.println("정답입니다!!");
				break; // 프로그램 종료
			}
			
		}
	}

}
