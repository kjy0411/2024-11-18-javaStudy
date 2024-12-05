/*  
 *  사용자부터 단을 입력을 받아서 해당 구구단을 출력
 *  ---------------			  ----------
 *  	매개변수					리턴형 =>	자체출력	 =>	void
 *  									문자열 리턴 =>	String
 */
//프로그램 => 정답이 없다 => 요구사항에 맞게 출력
import java.util.Scanner;

public class 메소드_4 {
	/*
	//void => 자체출력
	static void gugudan(int dan) {
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + "*" + i + " = " + (dan*i));
		}
	}
	*/
	//String => 문자열 리턴
	static String gugudan(int dan) {
		String result = "";
		for(int i = 1; i < 9; i ++) {
			result += dan + "*" + i + " = " + (dan*i) + "\n";
		}
		return result;
	}
	static void process() {
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력(2~9) : ");
		int dan = scan.nextInt();
		
		//메소드 호출
		//gugudan(dan);
		String g = gugudan(dan);
		System.out.println(g);
	}
	public static void main(String[] args) {
		process();
	}
	
}
