/*  
 *  달력
 *  1. 년/월/일 입력
 *  2. 요일 구하기
 *  3. 달력 출력
 *  4. 조립
 */
import java.util.Scanner;

public class 메소드응용_2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//1. 년/월/일 입력
		System.out.print("년도 입력 : ");
		int year = scan.nextInt();

		System.out.print("월 입력 : ");
		int month = scan.nextInt();
//		
//		System.out.print("일 입력 : ");
//		int day = scan.nextInt();
		
		//요일 출력
		String[] strWeek = {"일", "월", "화", "수", "목", "금", "토"};
		//요일 구하기
		//1. ~전년도까지 총 날수
		int total = (year - 1) * 365
					+ (year - 1) / 4
					- (year - 1) / 100
					+ (year - 1) / 400;
		//2. 올해의 전달까지 총 날수
		int[] lastday = {31, 28, 31, 30, 31, 30,
						 31, 31, 30, 31, 30, 31};
		//윤년조건
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			lastday[1] = 29;
		}else {
			lastday[1] = 28;
		}
		for(int i = 0; i < month - 1; i++) {
			total += lastday[i];
		}
		//3. +1
		total++;
		
		//요일 구하기
		int week = total % 7; //0(일) ~ 6(토)
		
		//출력
		System.out.println(year+"년도 " + month + "월");
		for(int i = 0; i < strWeek.length; i++) {
			if(i == 0) {
				System.err.print(strWeek[i] + "\t");				
			}else {
				System.out.print(strWeek[i] + "\t");				
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		for(int i = 1; i <= lastday[month - 1]; i++) {
			if(i == 1) {
				//해당 요일까지 공백 출력
				for(int j = 0; j < week; j++) {
					System.out.print("\t");
				}
			}
			if(week == 0) {
				System.err.printf("%2d\t", i);
			}else {
				
				System.out.printf("%2d\t", i);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			week++;
			if(week > 6) {
				week = 0;
				System.out.println();
			}
		}
	}
	
}
