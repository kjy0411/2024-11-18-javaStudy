/*  
 *  
 */
public class 메소드_문제예제 {

	public static void main(String[] args) {
		//1) 1~10까지 출력하는 메소드를 구현하시오
//		print();
		//2)1~10까지 합을 구하는 메소드를 구현하시오
//		int sum = sum();
//		System.out.println(sum);
		//3)1~n까지 합을 구하는 메소드를 구현하시오
//		int sum = sum(100);
//		System.out.println(sum);
		//4)두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오(실수)
//		int a = 10, b = 3;
//		String div = div(a, b);
//		System.out.println(div);
		//5)문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오
//		String s = "Hello Java!";
//		String ss = upCase(s);
//		System.out.println(ss);
		//6)문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오
//		String s1 = "test";
//		String s2 = "abccba";
//		String s3 = "abcba";
//		symmetry(s1);
//		symmetry(s2);
//		symmetry(s3);
		//7)문자열을 거꾸로 출력하는 메소드를 구현하시오
//		String s = "test123";
//		revers(s);
		//8)학점을 구하는 메소드를 구현하시오
//		int score = 55;
//		System.out.println(score + "의 학점 : " + score(score));
		//9)년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
//		int year = 2024;
//		System.out.println(year + "년도는 " + (leapYear(year)?"윤년입니다":"윤년이 아닙니다"));
		//10)두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오.
//		int num1 = 80, num2 = 55;
//		max(num1, num2);
		//11)입력 받은 값이 짝수인지 홀숨인지 판별하는 메소드를 구현하시오
//		int num = 80;
//		checkEven(num);
		//12)3의 배수를 판별하는 메소드를 구현하시오
//		int num = 61;
//		check3(num);
		//13)년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
//		int year = 2024;
//		int month = 12;
//		int day = 4;
//		char week = dayWeek(year, month, day);
//		System.out.println(week);
		//14)메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 쉬를 출력하는 프로그램을 작성하세요
		int num = 257272456;
		reversNum(num);
		
	}
	//1) 1~10까지 출력하는 메소드를 구현하시오
	static void print() {
		for(int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
	}
	//2)1~10까지 합을 구하는 메소드를 구현하시오
	static int sum() {
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}
	//3)1~n까지 합을 구하는 메소드를 구현하시오
	static int sum(int a) {
		int sum = 0;
		for(int i = 1; i <= a; i++) {
			sum += i;
		}
		return sum;
	}
	//4)두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오(실수)
	/*  메소드 종료 => 메소드 안에서 return은 여러개 사용이 가능
	 *  메소드가 종료하는 시점은 return
	 *  반복문은 break;
	 *  => 메소드는 원하는 위치에서 종료가 가능하다
	 *  
	 *  => 입력이 안된 경우
	 */
	static String div(int a, int b) {
		if(b == 0)
			return "0으로 나눌 수 없다";
		
		return String.valueOf(a / (double)b);
	}
	//5)문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오
	static String upCase(String s) {
		String result = s.toUpperCase();
		return result;
	}
	//6)문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오
	static void symmetry(String s) {
		if(s.length() % 2 != 0) {
			System.out.println("문자열의 길이가 짝수여야합니다");
			return;
		}
		boolean check = true;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(s.length() - 1 - i)) {
				check = true;
			}else {
				check = false;
				break;
			}
		}
		if(check == true) {
			System.out.println("문자열" + s + "는(은) 대칭입니다.");
		}else {
			System.out.println("문자열" + s + "는(은) 대칭이 아닙니다.");
		}
	}
	//7)문자열을 거꾸로 출력하는 메소드를 구현하시오
	static void reversString(String s) {
		for(int i = s.length() - 1; i >= 0 ; i--){
			System.out.print(s.charAt(i));
		}			
	}
	//8)학점을 구하는 메소드를 구현하시오
	static char score(int a) {
		char c = 'A';
		switch(a / 10) {
			case 10:
			case 9:
				c = 'A';
				break;
			case 8:
				c = 'B';
				break;
			case 7:
				c = 'C';
				break;
			case 6:
				c = 'D';
				break;
			default :
				c = 'F';
		}
		return c;
	}
	//9)년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
	static boolean leapYear(int a) {
		boolean bCheck = false;
		if((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
			bCheck = true;
		}
		return bCheck;
	}
	//10)두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오.
	static void max(int a, int b) {
		if(a > b) {
			System.out.println(a);
		}else if(a < b) {
			System.out.println(b);
		}else if(a == b) {
			System.out.println(a + "와 " + b +"는(은) 같습니다");
		}
	}
	//11)입력 받은 값이 짝수인지 홀숨인지 판별하는 메소드를 구현하시오
	static void checkEven(int a) {
		if(a % 2 == 0) {
			System.out.println(a + "는(은) 짝수입니다");
		}else {
			System.out.println(a + "는(은) 홀수입니다");
		}
	}
	//12)3의 배수를 판별하는 메소드를 구현하시오
	static void check3(int a) {
		if(a % 3 == 0) {
			System.out.println(a + "는(은) 3의 배수입니다");
		}else {
			System.out.println(a + "는(은) 3의 배수가 아닙니다");
		}
	}
	//13)년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
	static char dayWeek(int year, int month, int day) {
		int total = (year - 1) * 365
				  + (year - 1) / 4
				  - (year - 1) / 100
				  + (year - 1) / 400;
		
		int[] lastday = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if((year % 4 == 0 && year% 100 != 0) || (year % 400 == 0)){ //윤년 조건
			lastday[1] = 29;
		}else {
			lastday[1] = 28;
		}
		
		for(int i = 0; i < month - 1; i++) {
			total += lastday[i];
		}
		
		total += day;
		
		char[] strWeek= {'일', '월', '화', '수', '목', '금', '토'};
		int week = total % 7;
		return strWeek[week];
	}
	//14)메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 쉬를 출력하는 프로그램을 작성하세요
	static void reversNum(int a) {
		String s = String.valueOf(a);
		for(int i = s.length() - 1; i >= 0 ; i--) {
			System.out.print(s.charAt(i));
		}
	}
	
}
