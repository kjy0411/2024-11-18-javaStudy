import java.util.Scanner;

public class 메소드응용_2_변경 {
	
	public static void main(String[] args) {
		process();
	}
	static void process() {
//		Scanner scan = new Scanner(System.in);

		int year = input("년도");
		int month = input("월");
		
		while(true) {
			int week = getWeek(year, month);
			int lastday = getLastDay(year, month);
			
			print(year, month, week, lastday);
			
			/*
			System.out.println();
			
			System.out.println("==================================================");
			System.out.print("이전(<) 검색(O) 종료(X) (>)다음 : ");
			char c = scan.next().charAt(0);
			System.out.println("==================================================");
			
			if(c == '<') {
				month--;
				if(month < 1) {
					year--;
					month = 12;
				}
			}else if(c == '>') {
				month++;
				if(month > 12) {
					year++;
					month = 1;
				}
			}else if(c == 'O' || c == 'o') {
				year = input("년도");
				month = input("월");
			}else {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			*/
			break;
		}
		
	}
	static int input(String msg) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print(msg + " 입력 : ");
		int num = scan.nextInt();
		
		return num;
	}
	static int getWeek(int year, int month) {
		int total = (year - 1) * 365
					+ (year - 1) / 4
					- (year - 1) / 100
					+ (year - 1) / 400;
		
		int[] lastday = {31, 28, 31, 30, 31, 30,
						 31, 31, 30, 31, 30, 31};
		
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			lastday[1] = 29;
		}else {
			lastday[1] = 28;
		}
		for(int i = 0; i < month - 1; i++) {
			total += lastday[i];
		}
		
		total++;
		
		
		int week = total % 7; //0(일) ~ 6(토)
		return week;
	}
	static int getLastDay(int year, int month) {
		int[] lastday = {31, 28, 31, 30, 31, 30,
				 31, 31, 30, 31, 30, 31};
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			lastday[1] = 29;
		}else {
			lastday[1] = 28;
		}
		return lastday[month - 1];
	}
	static void print(int year, int month, int week, int lastday) {
		String[] strWeek = {"일", "월", "화", "수", "목", "금", "토"};
		
		System.out.println(year+"년도 " + month + "월");
		for(int i = 0; i < strWeek.length; i++) {
			System.out.print(strWeek[i] + "\t");				
		}
		System.out.println();
		for(int i = 1; i <= lastday; i++) {
			if(i == 1) {
				//해당 요일까지 공백 출력
				for(int j = 0; j < week; j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t", i);
			week++;
			if(week > 6) {
				week = 0;
				System.out.println();
			}
		}
	}
}
