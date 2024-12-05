/*
   1) 1~10까지 출력하는 메소드를 구현하시오
   2) 1~10까지 합을 구하는 메소드를 구현하시오
   3) 1~n까지 합을 구하는 메소드를 구현하시오
   4) 두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오(실수)
   5) 문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오
   6) 문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오
   7) 문자열을 거꾸로 출력하는 메소드를 구현하시오
   // 12-05
   8) 학점을 구하는 메소드를 구현하시오
   9) 년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
   10. 두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오.
   11. 입력 받은 값이 짝수인지 홀숨인지 판별하는 메소드를 구현하시오
   12. 3의 배수를 판별하는 메소드를 구현하시오
   13. 년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
   14. 메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 쉬를 출력하는 프로그램을 작성하세요

 */

import java.text.ChoiceFormat;

public class 메소드_문제풀이1 {
    // 1) 1~10까지 출력하는 메소드를 구현하시오
	// 매개변수 (X) , 리턴형 (X)
	static void print()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.print(i+" ");
		}
	}
	// 2) 1~10까지 합을 구하는 메소드를 구현하시오
	static int print2()
	{
		int sum=0;
		for(int i=1;i<=10;i++)
		{
			sum+=i;
		}
		return sum;
	}
	
	// 3) 1~n까지 합을 구하는 메소드를 구현하시오 => n
	// 사용자가 요청한 값 (n) => 매개변수
	static int print3(int n)
	{
		int sum=0;
		for(int i=1;i<=n;i++)
		{
			sum+=i;
		}
		return sum;
	}
	// 4) 두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오(실수)
	static String print4(int a,int b)
	{
		if(b==0)
			return "0으로 나눌수 없다";// B가 0이면 종료
		
		return String.valueOf(a/(double)b);
		
		// 메소드 종료 => 메소드안에서 return은 여러개 사용이 가능 
		/*
		 *   메소드가 종료하는 시점은 return 
		 *   반복문은 break
		 *   => 메소드는 원하는 위치에서 종료가 가능하다 
		 *   
		 *   => 입력이 안된 경우
		 */
	}
	// 5) 문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오
	static void change(String s)
	{
		// 자체에서 처리 => 영역에서 출력 abcD ==> ABCD
		//s=s.toUpperCase();
		String ss="";
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(c>='A' && c<='Z')
			{
				ss+=(char)(c+32);  // a=97 , A=65 => 32
			}
			else
				ss+=c;
		}
		System.out.println(ss);
		/*
		 *   for(int i=0;i<s.lenght;i++)
		 *   {
		 *      char c=s.charAt(i);
		 *      if(c>='a' && c<='z')
		 *      {
		 *         c=(char)(c-32)
		 *      }
		 *   }
		 */
	}
	static String change2(String s)
	{
		return s.toUpperCase();
	}
	// 7) 문자열을 거꾸로 출력하는 메소드를 구현하시오
	static void reverse(String s)
	{
		// 거꾸로 출력하는 라이브러리 
		//new StringBuilder(s).reverse()
		//System.out.println(new StringBuilder(s).reverse());
	    for(int i=s.length()-1;i>=0;i--)
	    {
	    	System.out.print(s.charAt(i));
	    }
	    System.out.println();
	}
	// 6) 문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오
	/*
	 *   경우의 수 : 3개 
	 *   
	 */
	// 국어점수 , 영어점수 , 수학점수 입력 => 총점/평균 출력 
	// (X) 0~100 
	
	static String change3(String s)
	{
		// 오류 체크 
		if(s.length()%2!=0)
			return "문자열 갯수가 짝수이여야 합니다";
		
		String res="";// 둘중에 한개만 전송 
		boolean bCheck=true;
		/*
		 *    A B B B
		 *    -     -
		 *      - -
		 */
		for(int i=0;i<s.length()/2;i++)
		{
			char start=s.charAt(i);
			char end=s.charAt(s.length()-1-i);
			if(start!=end)
			{
				bCheck=false;
				break;
			}
		}
		if(bCheck==true)
			res="좌우대칭 입니다";
		else
			res="좌우대칭이 아닙니다";
		
		return res;
		
	}
	// 8) 학점을 구하는 메소드를 구현하시오
	static void hakjum(int kor)
	{
		char c='A';
		switch(kor/10)
		{
		case 10: case 9:
			c='A';
			break;
		case 8:
			c='B';
			break;
		case 7:
			c='C';
			break;
		case 6:
			c='D';
			break;
		default:
			c='F';
		}
		System.out.println("학점:"+c);
	}
	// java.text => DecimalFormat => 1,000,000,000
	//              SimpleDateFormat => 날짜변환 
	//              ChoiceFormat => 값 선택
	//              MessageFormat => 오라클 Insert
	static void hakjum2(int kor)
	{
		double[] limit={50,60,70,80,90};
		String[] grade={"F","D","C","B","A"};
		// F => 50~59 , D=> 60~69 ....
		ChoiceFormat cf=new ChoiceFormat(limit, grade);
		System.out.println(cf.format(kor));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hakjum(90);
		hakjum2(59);
		String ss=change3("ABCCBA");
		System.out.println(ss);// sysout Ctrl+Space
		reverse("ABCDEFG");
		change("abcDEFgh");
		String s=change2("abcDEFgh");
		System.out.println(s);
        print();
        int hap=print2();
        System.out.println("\n1~10까지의 합:"+hap);
        hap=print3(1000);
        System.out.println("1~100까지의 합:"+hap);
        String d=print4(10, 3);
        // Infinity => 0으로 나눈 경우에 


        System.out.println(d);
	}

}