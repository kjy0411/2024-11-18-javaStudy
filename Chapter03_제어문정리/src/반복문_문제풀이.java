/*
 *   1. 구구단 중 원하는 단수 입력 받아 결과를 출력하기
     2. 1~100사이 정수 중에서 8의 배수 출력하기
     3.  1~100사이 정수 중에서 4의 배수이거나 7의 배수인 정수를 출력하기
     4. 1~100사이 정수중에서 일의 자리 수가 3 또는 6 또는 9인 정수를 
        출력하기
     5. 사용자에게 문자열을 입력받아 모음의 개수를 출력하기 (a, e, i, o, u)
     6. 사용자에게 1 ~ 9사이의 정수를 입력받아 2자리의 자연수 중 각 자리수의 합이 입력값과 동일한 수 출력하기
        입출력예) 6 => 15 24 33 42 51 60 
     7. 10부터 20까지 순서대로 출력 
     8. 10부터 20까지 역순으로 출력 
     9. 사용자가 입력한 5개의 정수 중 가장 큰 값을 출력하기
     10. 사용자에게 문자열 3개를 입력받아
         길이값의 합을 출력하고, 가장 긴 문자열을 출력하기
 */
import java.util.Scanner;
public class 반복문_문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 1. 구구단 중 원하는 단수 입력 받아 결과를 출력하기
		 /*
		  *    초기값 1
		  *    while(조건식 2)
		  *    {
		  *       반복 실행문장 3 
		  *       증가식 4
		  *    }
		  *    => 
		  *    for(초기값;조건식;증가식)
		  *    {
		  *       반복 실행문장
		  *    }
		  *    
		  */
		Scanner scan=new Scanner(System.in);
		//System.out.print("단 입력:");
		//int dan=scan.nextInt();
//		int i=1;
//		while(i<=9)
//		{
//			System.out.println(dan+"*"+i+"="+dan*i);
//			i++;
//		}
//		for(int i=1;i<=9;i++)
//		{
//			System.out.println(dan+"*"+i+"="+dan*i);
//		}
//	     2. 1~100사이 정수 중에서 8의 배수 출력하기
		 int i=1;
		 while(i<=100)
		 {
			 if(i%8==0)// 8의 배수라면 
				 System.out.print(i+" ");
			 i++;
		 }
		 System.out.println();
//	     3.  1~100사이 정수 중에서 4의 배수이거나 7의 배수인 정수를 출력하기
		 i=1;
		 while(i<=100)
		 {
			 if(i%4==0 || i%7==0) // 4의 배수이거나 7의 배수
				 System.out.print(i+" ");
			 i++;
		 }
		 System.out.println();
//	     4. 1~100사이 정수중에서 일의 자리 수가 3 또는 6 또는 9인 정수를 
//	        출력하기
		 i=1;
		 while(i<=100)
		 {
			 if(i%10==3|| i%10==6 || i%10==9)// 일의 자리 수가 3 또는 6 또는 9
				 System.out.print(i+" ");
			 i++;
		 }
		 System.out.println();
//	     5. 사용자에게 문자열을 입력받아 모음의 개수를 출력하기 (a, e, i, o, u)
//		 int j=0;
//		 int a=0,e=0,k=0,o=0,u=0;
//		 System.out.print("문자열 입력:");
//		 String str=scan.nextLine();
//		 while(j<str.length())
//		 {
//			 char c=str.charAt(j);
//			 if(c=='a')
//				 a++;
//			 else if(c=='e')
//				 e++;
//			 else if(c=='i')
//				 k++;
//			 else if(c=='o')
//				 o++;
//			 else if(c=='u')
//				 u++;
//			 
//			 j++;
//		 }
//		 System.out.println("모음 갯수:"+(a+e+k+o+u));
//	     6. 사용자에게 1 ~ 9사이의 정수를 입력받아 2자리의 자연수 중 각 자리수의 합이 입력값과 동일한 수 출력하기
//	        입출력예) 6 => 15 24 33 42 51 60 
//		    System.out.print("정수 입력(1~9):");
//		    int num=scan.nextInt();
//		    i=10;
//		    while(i<=99)
//		    {
//		    	int a=i/10;// 앞자리  15/10 => 1
//		    	int b=i%10;// 뒷자리  15/10 => 5  => 1+5=6
//		    	if(a+b==num)
//		    		System.out.print(i+" ");
//		    	i++;
//		    }
//	     7. 10부터 20까지 순서대로 출력 
		 i=10;
		 while(i<=20)
		 {
			 System.out.print(i+" ");
			 i++;
		 }
//	     8. 10부터 20까지 역순으로 출력 
		 System.out.println();
		 i=20;
		 while(i>=10)
		 {
			 System.out.print(i+" ");
			 i--;
		 }
		 System.out.println();
		 // 문자열을 입력을 받아서 => 꺼꾸로 출력 
		 // 이미지를 꺼꾸로 출력하는 프로그램을 작성 => byte[] 
//		 System.out.print("문자열 입력:");
//		 String str=scan.nextLine();
//		 i=str.length()-1;
//		 while(i>=0)
//		 {
//			 System.out.print(str.charAt(i));
//			 i--;
//		 }
//	     9. 사용자가 입력한 5개의 정수 중 가장 큰 값을 출력하기
//		 i=1;
//		 int max=0;
//		 while(i<=5)
//		 {
//			 int num=(int)(Math.random()*100)+1;
//			 System.out.print(num+" ");
//			 if(max<num)
//				 max=num;
//			 i++;
//		 }
//		 System.out.println("최대값:"+max);
//	     10. 사용자에게 문자열 3개를 입력받아
//	         길이값의 합을 출력하고, 가장 긴 문자열을 출력하기
//		i=1;
//		int sum=0;
//		String strMax="";
//		int max=0;
//		while(i<=3)
//		{
//			System.out.print("문자열 입력:");
//			String str=scan.nextLine();
//			sum+=str.length();
//			if(max<str.length())
//			{
//				strMax=str;
//			}
//			
//			i++;
//		}
//		System.out.println("총 문자열 길이:"+sum);
//		System.out.println("긴 문자열 출력:"+strMax);
	}

}