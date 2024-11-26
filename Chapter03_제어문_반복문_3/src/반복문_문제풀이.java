/*
 *   1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식 작성 (조건문)
                     =====================
                     x<=10 && x>=20
     2. char형 변수 ch가 공백이고 탭이 아닐 때 true인 조건식 작성
                  ======================
                    ch==' ' || ch!='\t'
     3. char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식 작성
                  ====================
                     ch=='X' || ch=='x'
     4. char형 변수 ch가 숫자('0' ~ '9')일 때 true인 조건식 작성
                  =======================
                  ch=='0' && ch=='9'
     5. 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 
        출력하는 프로그램을 작성하시오

     6. 사용자로부터 두개의 정수(시작,끝)를 입력받아 시작(포함)해서 
        끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오
     7. 5~16까지의 합을 구하시오
     8. 3이상 4462 이하에서 짝수인 정수의 합을 구하여라.
     9. 0~12까지 2의 배수, 3의 배수의 합을 구하여라
     10. 1~100까지의 정수 중 4의 배수의 합계를 구하라
     11. 10개의 정수를 입력받아 그 수들 중 짝수의 개수가 몇개인지 출력하는 프로그램 작성
     12. 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램
     13. **********          
         **********           
         **********
         **********
         **********
     14. 1 1 1 1 1          
         2 2 2 2 2          
         3 3 3 3 3          
         4 4 4 4 4         
         5 5 5 5 5
         
         int k=1;
         for(int i=1;i<=5;i++)
         {
            for(int j=1;j<=5;j++)
            {
               System.out.print(k);
            }
            k++;
            System.out.println();
         }
     15. 1 # # # #         
         # 2 # # #          
         # # 3 # #          
         # # # 4 #          
         # # # # 5
         
         for(int i=1;i<=5;i++)
         {
            for(int j=1;j<=5;j++)
            {
              if(i==j)
               System.out.print(j);
              else
               System.out.print('#');
            }
            
            System.out.println();
         }
     16. A B C D E        
         A B C D E          
         A B C D E          
         A B C D E          
         A B C D E
         
         
         for(int i=1;i<=5;i++)
         {
            char ch='A';
            for(int j=1;j<=5;j++)
            {
               System.out.print(ch++);
            }
           
            System.out.println();
         }
     17. A A A A A               
         B B B B B               
         C C C C C
         D D D D D
         E E E E E
         
         char ch='A';
         for(int i=1;i<=5;i++)
         {
            
            for(int j=1;j<=5;j++)
            {
               System.out.print(ch);
            }
            ch++;
            System.out.println();
         }
 */
import java.util.Scanner;
public class 반복문_문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        Scanner scan=new Scanner(System.in);
//        System.out.print("1' 정수 입력:");
//        int start=scan.nextInt();
//        int end=0;
//        while(true)
//        {
//           System.out.print("2' 정수 입력:");
//           end=scan.nextInt();
//           if(end>start)
//        	   break;
//        }
//        int gop=1;
//        for(int i=start;i<=end;i++)
//        {
//        	gop*=i;
//        }
//        System.out.println("결과값:"+gop);
//		  5. 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 
//        출력하는 프로그램을 작성하시오
		  /*
		   *   2차 for => 중첩 for => 이중 for 
		   *   
		   *   형식)            |false => 종료
		   *            1     2    7
		   *       for(초기식;조건식;증가식) => 줄수 
		   *       {          | true
		   *                     false명 7번 이동 
		   *               3     4    6
		   *          for(초기식;조건식;증가식) => 실제 반복수행 문장 
		   *          {          | true
		   *               반복실행문장 5
		   *            
		   *          }
		   *       }
		   *       
		   *       for(int i=1;i<=3;i++)
		   *       {
		   *       ----------------------------
		   *          for(int j=1;j<=3;j++)
		   *          {
		   *          
		   *          }
		   *        ---------------------------
		   *       }
		   *       
		   *       i=1 => j=1,2,3
		   *       i=2 => j=1,2,3
		   *       i=3 => j=1,2,3
		   *       i=4 => 종료 
		   */
//           for(int i=1;i<=6;i++)
//           {
//        	   for(int j=1;j<=6;j++)
//        	   {
//        		   if(i+j==12)
//        		   {
//        			   System.out.println("["+i+","+j+"]");
//        		   }
//        	   }
//           }
//        6. 사용자로부터 두개의 정수(시작,끝)를 입력받아 시작(포함)해서 
//        끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오
//		  Scanner scan=new Scanner(System.in);
//		  System.out.print("첫번째 정수 입력:");
//		  int start=scan.nextInt();
//		  int end=0;
//		  // 오류 처리 
//		  while(true)
//		  {
//		     System.out.print("두번째 정수 입력:");
//		     end=scan.nextInt();
//		     if(start<end)
//		    	 break;
//		  }
//		  /*
//		   *    초기값 ------- 1
//		   *    while(조건식) --- 2
//		   *    {
//		   *      실행문장 ---3 
//		   *      증가식 ---4 ==> 2번 이동 
//		   *                    | true => 3번 수행 
//		   *                    | false => 종료 
//		   *    }
//		   *    ============= for문과 유사
//		   *    
//		   *    => 반복횟수가 없는 경우 주로 사용 
//		   *    while(true)
//		   *    {
//		   *        실행문장 
//		   *        조건 => 종료
//		   *    }
//		   */
//		  int gop=1;
//		  for(int i=start;i<=end;i++)
//		  {
//			  gop*=i;
//		  }
//		  System.out.println(start+"~"+end+"까지 곱:"+gop);
        //7. 5~16까지의 합을 구하시오
//		int sum=0;// 누적변수 
//		for(int i=5;i<=16;i++)
//		{
//			sum+=i;
//		}
//		System.out.println("sum="+sum);
		
        //8. 3이상 4462 이하에서 짝수인 정수의 합을 구하여라.
//		int even=0;
//		for(int i=3;i<=4462;i++)
//		{
//			if(i%2==0) // 짝수라면 
//				even+=i;
//		}
//		System.out.println("even="+even);
        //9. 0~12까지 2의 배수, 3의 배수의 합을 구하여라
//		int a2=0,a3=0;
//		for(int i=0;i<=12;i++)
//		{
//			if(i%2==0)
//				a2+=i;
//			if(i%3==0)
//				a3+=i;
//		}
//		System.out.println("2의 배수합:"+a2);
//		System.out.println("3의 배수합:"+a3);
        //10. 1~100까지의 정수 중 4의 배수의 합계를 구하라
//		int sum=0;
//		for(int i=0;i<=100;i++)
//		{
//			if(i%4==0)
//				sum+=i;
//		}
//		System.out.println("sum="+sum);
        //11. 10개의 정수를 입력받아 그 수들 중 짝수의 개수가 몇개인지 출력하는 프로그램 작성
//		int count=0;
//		for(int i=1;i<=10;i++)
//		{
//			int num=(int)(Math.random()*100)+1;
//			System.out.print(num+" ");
//			if(num%2==0)
//				count++;
//		}
//		System.out.println("count="+count);
        //12. 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램
//		int cnt3=0,cnt5=0;
//		for(int i=0;i<10;i++)
//		{
//			int num=(int)(Math.random()*100)+1;
//			System.out.print(num+" ");
//			if(num%3==0)
//				cnt3++;
//			if(num%5==0)
//				cnt5++;
//		}
//		System.out.println("\n3의 배수 갯수:"+cnt3);
//		System.out.println("5의 배수 갯수:"+cnt5);
//		Scanner scan=new Scanner(System.in);
//		System.out.print("정수 입력:");
//		int num=scan.nextInt();
		
//		for(int i=1;i<=5;i++)
//		{
//			for(int j=1;j<=10;j++)
//			{
//				System.out.print("★");
//			}
//			System.out.println();
//		}
		
		int k=1;
        for(int i=1;i<=5;i++)
        {
           for(int j=1;j<=5;j++)
           {
              System.out.print(k);
           }
           k++;
           System.out.println();
        }
        System.out.println();
        for(int i=1;i<=5;i++)
        {
           for(int j=1;j<=5;j++)
           {
             if(i==j)
              System.out.print(j);
             else
              System.out.print('#');
           }
           
           System.out.println();
        }
        System.out.println();
        
        char ch='A';
        for(int i=1;i<=5;i++)
        {
           
           for(int j=1;j<=5;j++)
           {
              System.out.print(ch++);
           }
          
           System.out.println();
        }
        
        System.out.println();
        ch='A';
        for(int i=1;i<=5;i++)
        {
           
           for(int j=1;j<=5;j++)
           {
              System.out.print(ch);
           }
           ch++;
           System.out.println();
        }
        
        /*
         *   ★☆☆☆★
         *   ☆☆☆☆☆
         *   ☆☆☆☆☆
         *   ☆☆☆☆☆
         *   ★☆☆☆★
         *   
         *   
         */
        for(int i=1;i<=5;i++)
        {
           for(int j=1;j<=5;j++)
           {
        	  if((i==1 && j==1)||(i==5 && j==1)
        		 ||	(i==1 && j==5)||(i==5 && j==5) 
        	    )
                System.out.print("★");
        	  else
        		System.out.print("☆");
           }
           System.out.println();
        }
	}

}