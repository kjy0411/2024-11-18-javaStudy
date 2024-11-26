/*
 *    선택문 / 반복문 
 *    = 선택문 
 *      switch(정수/문자/문자열)
 *      {
 *        case 값: 값 => 정수 1 2 , 문자 => '+' , 문자열 => ""
 *           실행 문장 
 *           break; => 종료 
 *        case 값: ... 순서가 없다 , 중복된 값은 사용할 수 없다 
 *        default: 생략이 가능 , 필요시에만 사용 
 *      }
 *      ** 실행하면 자동으로 case로 부터 시작 break가 있는 곳까지 출력 
 *      int no=3;
 *      switch(no)
 *      {
 *        case 1:
 *          문장 1
 *        case 2:
 *          문장 2
 *        case 3: ==> 출력 시작 위치 => 문장 3,4
 *          문장 3
 *          break; => 종료 
 *        case 4:
 *          문장 4
 *          break;
 *        default:
 *          문장 5
 *      }
 *      => 다중조건문을 간결하게 표현 
 *      => 범위 지정이 많다 => 다중 조건문 
 *    1)	100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D, 60점 이하면 F를 출력하라 (switch~case 사용)
 
      2)	 정수 2개와 연산자(+,-,*,/)를 입력 받아 사칙 연산하는 
             프로그램을 만들어라 (switch~case 사용) 

      3)	 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)

      4)	 5,10,15,20,25,30,35,40,45,50을 출력하는 프로그램을 만들어라 (for 사용)
             for(int i=5;i<=50;i+=5)
             {
                
                System.out.print(i+"")
             }
      5)	 B,D,F,H,J,L,N을 출력하는 프로그램을 작성하라 (for 사용)
             for(char c='B';c<='N';c+=2)
             {
                System.out.print(c+" ")
             }
      6)	 한 개의 정수를 입력 받아 1부터 입력 받은 정수까지의 합을 출력하라

      7)	 1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라
 
      8)	 1-2+3-4+5-6+7-8+9-10 계산 값을 for문을 이용하여 출력하라 

      9)	 1~10 사이의 숫자 중 3의 배수를 제외하고 출력하라

 */
import java.util.Scanner;
// C/C++ => include , c# => using , python import => from
// => 라이브러리 , 사용자 정의 클래스 (다른 폴더에 있는 경우)
//                              ------- 패키지 
/*
 *    자바의 기본 형식 
 *    package 위치 지정 => 한번만 사용이 가능 
 *    import ... => 여러번 사용이 가능 
 *    => 모든 프로그램은 main을 한개 이상을 가지고 있어야 한다 
 *    public class ClassName => ClassName.java
 *    {
 *       =================
 *        멤버변수 => 전역변수
 *       =================
 *        생성자 () => 멤버변수 초기화 
 *       =================
 *        사용자 정의 메소드
 *       =================
 *        main() => 
 *       =================
 *    } 
 *    class ClsName1
 *    {
 *    }
 *    
 *    
 */
public class 제어문_문제풀이 {
    // static public 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D, 60점 이하면 F를 출력하라 (switch~case 사용)
	    Scanner scan=new Scanner(System.in);
//	    System.out.print("점수 입력:");
//	    int score=scan.nextInt();
//	    
//	    // 100만점 => 오류처리 
//	    switch(score/10) //최대한 => case문장을 줄여서 사용 
//	    {
//	    case 10: case 9:
//	    	System.out.println("A학점");
//	    	break;
//	    case 8:
//	    	System.out.println("B학점");
//	    	break;
//	    case 7:
//	    	System.out.println("C학점");
//	    	break;
//	    case 6:
//	    	System.out.println("D학점");
//	    	break;
//	    default :
//	    	System.out.println("F학점");
//	   }  ctrl+/   ctrl+/ 
	 
	   /*
	    *    정수 2개와 연산자(+,-,*,/)를 입력 받아 사칙 연산하는 
             프로그램을 만들어라 (switch~case 사용) 
	    */
//	    System.out.print("첫번째 정수 입력:");
//	    int num1=scan.nextInt();
//	    System.out.print("두번째 정수 입력:");
//	    int num2=scan.nextInt();
//	    
//	    System.out.print("연산자 입력(+,-,*,/):");
//	    switch(scan.next())
//	    {
//	    case "+":
//	    	System.out.printf("%d + %d = %d\n",num1,num2,num1+num2);
//	    	break;
//	    case "-":
//	    	System.out.println(num1+"-"+num2+"="+(num1-num2));
//	    	break;
//	    case "*":
//	    	System.out.print(num1+"*"+num2+"="+(num1*num2)+"\n");
//	    	break;
//	    case "/":
//	    	if(num2==0)
//	    		System.out.println("0으로 나눌 수 없다");
//	    	else
//	    		System.out.println(num1+"/"+num2+"="
//	    	        +(num1/(double)num2));	// 소수점 출력
//	    	break;
//	    }
	    // 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)
//	    int sum=0;//누적변수 
//	    for(int i=2;i<=100;i+=2)
//	    {
//	    	sum+=i;
//	    }
//	    System.out.println(sum);
//	    for(int i=5;i<=50;i+=5)
//        {
//	       if(i>45) // 50뒤에는 ,를 사용하지 않는다  
//	    	   System.out.print(i);
//	       else
//               System.out.print(i+",");
//       }
	    // 6)	 한 개의 정수를 입력 받아 1부터 입력 받은 정수까지의 합을 출력하라
//        System.out.print("정수 입력:");
//        int sum=0;
//        int num=scan.nextInt();
//        for(int i=1;i<=num;i++)
//        {
//        	sum+=i;
//        }
//        System.out.println("sum="+sum);
	    //  7)	 1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라
//	    for(int i=1;i<=30;i++)
//	    {
//	    	if(i%2==0)
//	    	{
//	    		// 02 04 06
//	    		System.out.printf("%2d\t",i);// 명령프롬프트 
//	    		if(i%3==0) // 3개를 출력하고 다음 줄에 출력한다
//	    			System.out.println();
//	    	}
//	    }
	    //  8)	 1-2+3-4+5-6+7-8+9-10 계산 값을 for문을 이용하여 출력하라 
        int sum=0;
        for(int i=1;i<=10;i++)
        {
        	if(i%2==0)
        		sum-=i;
        	else
        		sum+=i;
        }
        System.out.println("sum="+sum);
	    //  9)	 1~10 사이의 숫자 중 3의 배수를 제외하고 출력하라
        for(int i=1;i<=10;i++)
        {
        	if(i%3!=0)
        		System.out.print(i+" ");
        }
        /*
         *   for : 반복횟수가 지정된 경우 주로 for을 사용하는 경향이 있다 
         *   => 초기식 : 시작점 => 한번만 수행 
         *   => 조건식 : 끝점 => true:반복문장 실행/false:for을 종료
         *   => 증감식 : 횟수지정 => i++ , i+=2....
         *                             ===== 2씩 증가 (복합 대입 연산자)
         *   사용처) 
         *          목록출력 : 출력 형식 => 데이터값은 틀릴 수 있다
         *          페이징 기법 => 1~10
         *          쿠키 읽기 / 세션 읽기 
         *   형식)
         *            i=1   i<=10  i++
         *        for(초기식;조건식;증가식)
         *           반복 실행 문장  
         */
	    
	}

}