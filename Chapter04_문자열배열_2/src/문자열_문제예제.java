import java.util.Arrays;

public class 문자열_문제예제 {

	public static void main(String[] args) {
		// 1-1) (1차배열)1번 학생 100점 2번 학생 90점 3번학생 85점이다. 점수를 score 배열 변수에 저장하 고 1) 아래와 같이
		// 출력하시오.
		/*
		1번 학생 : 100점  
		2번 학생 : 90점  
		3번 학생 : 85점  
		*/
		/*
		int[] score = {100, 90, 85};
		for(int i = 0; i < score.length; i++) {
			System.out.println((i + 1) + "번 학생 : " + score[i]);
		}
		// 1-2) 학생들의 총점을 출력하시오.
		int total = 0;
		for(int i = 0; i < score.length; i++) {
			total += score[i];
		}
		System.out.println("총점 : " + total);
		*/
		// 2. 1월달 사원(1번부터 5번사원)의 실적이 50 45 35 12 70 이다. (실적 0~100)
		// 2-1) 사번별 실적을 출력하시오
		// 사원(1) 50..
		/*
		int[] arr = {50, 45, 35, 12, 70};
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("사원(%d) %d\n", i + 1, arr[i]);
		}
		// 2-2) 1월 실적의 총점과 평균을 출력하시오.
		int total = 0;
		double avg = 0.0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		avg = total / (double)arr.length;
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f", avg);
		System.out.println();
		// 2-3) 실적이 제일 큰 사원의 사번과 실적, 작은 사원의 사번과 실적을 출력하시오.
		int max = 0, min = 100, maxi = 0, mini = 0;
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				maxi = i + 1;
			}
			if(min > arr[i]) {
				min = arr[i];
				mini = i + 1;
			}
		}
		System.out.printf("실적이 제일 큰 사원\n사번 : %d\n실적 : %d\n", maxi, max);
		System.out.printf("실적이 제일 작은 사원\n사번 : %d\n실적 : %d\n", mini, min);
		*/
		// 3) 크기가 10인 정수형 배열을 생성하고 여기에 0부터 9까지의 값으로 배열을 채우는 프로그램 만들기
		/*
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		System.out.println(Arrays.toString(arr));
		*/
		// 4) 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
		/*
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for(int num : arr) {
			sum += num;
		}
		 
		System.out.println("sum="+sum); // 결과 : sum=150
		*/
		
		//5) 1~100사이의 정수를 10개 저장하고  
		//정수형 변수 evenTotal 에 배열 내의 데이터 짝수 합 계산하여 저장
		//정수형 변수 oddTotal 에 배열 내의 데이터 홀수 합 계산하여 저장
		/*
		int[] arr = new int[10];
		int evenTotal = 0, oddTotal = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		for(int num : arr) {
			if(num % 2 == 0) {
				evenTotal += num;
			}else if(num % 2 == 1) {
				oddTotal += num;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("짝수형 정수의 합 : " + evenTotal);
		System.out.println("홀수형 정수의 합 : " + oddTotal);
		*/
		//6) 0~9사이의 난수를 100개 발생해서 빈도를 구해서 출력하시오 
		/*
		int[] arr = new int[100];
		int[] count = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10);
			count[arr[i]]++;
		}
		for(int i = 0; i < count.length; i++) {
			System.out.println(i + "의 개수 : " + count[i]);
		}
		*/
		//7) 임의의 문자 5개를 저장하고 정렬해서 출력하시오 
		
		char[] arr = new char[5];
		//저장
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char)((int)(Math.random()*26) + 65);
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		//ASE 정렬 ==> 선택정렬
		//라이브러리 Arrays.sort(arr); => 정렬
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 1 + i; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					char tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println("오름차순 정렬 후 : " + Arrays.toString(arr));
		
		//DESC 정렬 ==> 버블정렬
		//라이브러리에 없다 => Arrays.sort(arr);를 역순으로 출력 또는 오버라이딩
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j] < arr[j+1]) {
					char tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println("내림차순 정렬 후 : " + Arrays.toString(arr));
		
	}

}
