/*  
 * 	문자열 분리 / 자르기 / 변경 / 찾기
 * 	= charAt(int index)
 * 	Hello Java
 * 	0123456789
 * 	charAt(6)
 */

import java.util.Scanner;

public class 문자열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		/*
		String data = "Hello Java";
		System.out.println("첫번째 문자 : " + data.charAt(0));
		System.out.println("마지막 문자 : " + data.charAt(data.length() - 1));
		*/
		
		// 사용자의 문자열 입력값을 받아서 => a나 A가 몇개인지 확인
		/*
		
		System.out.print("문자열 입력 : ");
		String data = scan.nextLine();
		
		int count = 0;
		for(int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			if(ch == 'a' || ch == 'A') {
				count++;
			}
		}
		// 지역변수 => {}변수 => {}이 종료하면 사라지는 변수 => i, ch
		System.out.println("a 또는 A의 개수 : " + count + "개");
		*/
		// 사용자의 문자열 입력을 받아서 좌우 대칭 여부를 확인
		// ABBC
		String data = "";
		while(true) {
			System.out.println("문자열 입력 : ");
			data = scan.nextLine();
			if(data.length()%2==0) {
				break;
			}else {
				System.out.println("문자 갯수가 짝수이여야 합니다");
			}
		}
		
		boolean bCheck = true;
		int j = data.length() - 1;
		for(int i = 0; i< data.length() / 2; i++) {
			char s = data.charAt(i);
			char e = data.charAt(j);
			//System.out.println("start : " + s +", end : " + e);
			if(s != e) {
				bCheck = false;
				break;
			}
			j--;
		}
		System.out.println("====== 결과값 ======");
		if(bCheck == true) {
			System.out.println(data + "는(은) 좌우 대칭입니다");
		}else {
			System.out.println(data + "는(은) 좌우 대칭이 아닙니다");			
		}
	}

}
