/*  
 *  배열 : 관련된 데이터를 여러개 모아서 메모리에 저장
 *  	  ---------   ---------
 *  	  1) 같은 데이터형 2) 연속적인 메모리 구조
 *  	  => 한개의 이름으로 관리
 *  		 ---------------
 *  		 배열명 => 구분자 (인덱스)
 *  	  3) 배열을 선언하면 고정적이다 => 추가/삭제가 불가능
 *  		 => 현재 배열보다는 큰 배열을 다시 생성한다(추가)
 *  			int[] arr = new int[5]; => 7
 *  			int[] arr_ext = new int[7]
 *  			=> 동적으로 생성은 가능 (메소드)
 *  		 => 현재 배열보다는 작은 배열을 다시 생성한다(삭제)
 *  	   4) 인덱스번호 => 0부터 ~
 *  		  => 배열에 저장된 갯수 => 배열명.length
 *  	   5) 배열선언 / 배열 초기화
 *  		  데이터형[] 배열명 = {1,2....};
 *  		  데이터형[] 배열명 = new 데이터형[저장개수];
 *  				-- 배열기호 => 숫자를 사용할 수 없다
 */
import java.util.Arrays;

public class 배열응용_문제예제 {

	public static void main(String[] args) {
		//4)양의 정수 10개 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하는 프로그램을 작성하라
		/*
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		System.out.println("전체 : " + Arrays.toString(arr));
		System.out.print("3의 배수 : ");
		for(int i : arr) {
			if(i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
		*/
		//5)정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라.
		/*
		int[] arr = new int[10];
		int total = 0;
		double avg = 0.0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
			total += arr[i];
		}
		avg = total/10.0;
		
		System.out.println(Arrays.toString(arr));
		System.out.printf("평균 : %.2f", avg);
		*/
		//6)int[] num = { 94, 85, 95, 88, 90 };다음 배열에서 최대값,최소값을 출력하는 프로그램을 작성하시오
		/*
		int[] num = {94, 85, 95, 88, 90};
		int max = 0, min = 100;
		for(int i : num) {
			if(max < i) {
				max = i;
			}
			if(min > i) {
				min = i;
			}
		}
		
		System.out.println(Arrays.toString(num));
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		*/
		//7)정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라.
		//예) 랜덤한 정수들 : 3 6 3 6 1 3 8 9 6 9 평균은 5.4
		/*
		int[] arr = new int[10];
		int total = 0;
		double avg = 0.0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
			total += arr[i];
		}
		avg = total/10.0;
		
		
		System.out.println(Arrays.toString(arr));
		System.out.printf("평균 : %.2f", avg);
		*/
		//8)arr 배열 중에서 인덱스가 1인 곳의 값을 출력해보자.
		//int[] arr = { 10, 20, 30, 50, 3, 60, -3 }; 
		/*
		int[] arr = {10, 20, 30, 50, 3, 60, -3};
		System.out.println(arr[1]);
		*/
		//9)arr 배열 중에서 값이 60인 곳의 인덱스를 출력해보자. 
		//int[] arr = { 10, 20, 30, 50, 3, 60, -3 };  
		/*
		int[] arr = {10, 20, 30, 50, 3, 60, -3};
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 60) {
				index = i;
				break;
			}
		}
				System.out.println("60값을 가진 인덱스 : " + index);
		*/
	}
	
}
